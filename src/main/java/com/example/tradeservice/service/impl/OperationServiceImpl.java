package com.example.tradeservice.service.impl;

import com.example.tradeservice.dto.RequestCheckDTO;
import com.example.tradeservice.model.Operation;
import com.example.tradeservice.model.reference.CurrencyHolidayType;
import com.example.tradeservice.repository.OperationRepository;
import com.example.tradeservice.service.CustomerService;
import com.example.tradeservice.service.OperationService;
import com.example.tradeservice.service.ReferenceService;
import com.example.tradeservice.util.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.tradeservice.util.utils.TrUtils.countBusinessDaysBetween;
import static com.example.tradeservice.util.utils.TrUtils.getCurrencyInstance;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationRepository repository;
    private final ReferenceService referenceService;
    private final CustomerService customerService;

    @Override
    public String checkOperation(final RequestCheckDTO dto) {
        if (dto.getValueDate() != null) {
            if (checkValueDateAndTradeDate(dto)) {
                valueOrCurrencyDateOnWeekend(dto);
            }
        }
        if (ifCustomerIsSupported(dto)) {
            if (validateValueDateByProductType(dto)) {
                if (validateCurrenciesByISO4217(dto)) {
                    if (validateAmericanStyle(dto)) {
                        if (expiryAndPremiumDateBeforeDeliveryDate(dto)) {
                            log.info("All checks passed successfully, Customer: '{}', Trade date: '{}' ",
                                    dto.getCustomer(), dto.getTradeDate());
                        }
                    }
                }
            }
        }
        
        saveEntity(dto);
        return "All checks passed successfully";
    }

    // TODO finish ip with static method toOperation in OperationDTO
    @Override
    public void saveEntity(final RequestCheckDTO dto) {
        Operation o = new Operation();
        // repository.save(o);
    }

    @Override
    public List<RequestCheckDTO> checkAllOperation(final RequestCheckDTO dto) {
        return null;
    }

    @Override
    public boolean checkValueDateAndTradeDate(final RequestCheckDTO dto) throws BadRequestException {
        if (dto.getValueDate().before(dto.getTradeDate())) {
            throw new BadRequestException("Value date cannot be before trade date!",
                    dto.getClass(), dto.getValueDate().toString(), dto.getTradeDate());
        }
        log.info("Validation value Date and trade Date was successful, Value date: '{}', Trade date: '{}' ",
                dto.getValueDate(), dto.getTradeDate());
        return true;
    }

    @Override
    public boolean valueOrCurrencyDateOnWeekend(final RequestCheckDTO dto) {
        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                .format(dto.getValueDate()));
        CurrencyHolidayType currencyHoliday =
                referenceService.findFirstByCurrencyAndHolidayDateAndIsEnabledTrue(
                        dto.getCcyPair(), localDate);
        Calendar weekend = Calendar.getInstance();
        weekend.setTime(dto.getValueDate());

        if (weekend.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                && weekend.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            if (currencyHoliday != null) {
                throw new BadRequestException("Value date cannot fall on weekend or non-working day for currency!",
                        dto.getClass(), dto.getValueDate().toString(), dto.getCcyPair());
            }
        }
        log.info("Validation by value date on weekend or currency holidays " +
                        "was successful, Value date: '{}', Trade date: '{}' ",
                dto.getValueDate(), dto.getTradeDate());
        return true;
    }

    @Override
    public boolean ifCustomerIsSupported(final RequestCheckDTO dto) {
        if (customerService.existsByNameAndIsSupportedIsTrue(dto.getCustomer())) {
            throw new BadRequestException("The Counterparty/Customer is one of the supported ones!",
                    dto.getClass(), dto.getCustomer(), dto.getTradeDate());
        }
        log.info("Validation Counterparty/Customer is one of the supported ones was successful" +
                        ", Value date: '{}', Trade date: '{}' ",
                dto.getValueDate(), dto.getTradeDate());
        return true;
    }

    @Override
    public boolean validateValueDateByProductType(final RequestCheckDTO dto) {
        int T_1 = 1;
        int T_2 = 2;
        LocalDate tradeDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                .format(dto.getTradeDate()));
        LocalDate valueDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                .format(dto.getValueDate()));

        List<LocalDate> holidays = referenceService.findAllByCurrencyAndIsEnabledTrue(dto.getCcyPair()).stream()
                .map(CurrencyHolidayType::getHolidayDate)
                .collect(Collectors.toList());

        // Check by spot 2 work days from trade date SPOT, FORWARD
        if (referenceService.existsByCcyPairType("EURUSD")) {
            if (dto.getValueDate() != null
                    && dto.getTradeDate() != null) {
                if (countBusinessDaysBetween(
                        tradeDate, valueDate, holidays) != T_2) {
                    throw new BadRequestException("The value date is not valid, " +
                            "since 2 business days have not passed since the transaction date!",
                            dto.getClass(), dto.getValueDate().toString(), dto.getCcyPair());
                }
            }
        }
        log.info("Validation by product type and value date was successful " +
                        ", Value date: '{}', Product type: '{}' ",
                dto.getValueDate(), dto.getType());
        return true;
    }

    @Override
    public boolean validateCurrenciesByISO4217(final RequestCheckDTO dto) {
        if (getCurrencyInstance(dto.getCcyPair().substring(0, 3)).isPresent() &&
                getCurrencyInstance(dto.getCcyPair().substring(3, 6)).isPresent()) {
            log.info("Validation validate currencies by ISO-4217 was successful " +
                            ", Trade date: '{}', Trade date: '{}' ",
                    dto.getTradeDate(), dto.getCcyPair());
            return true;
        }
        throw new BadRequestException("The currencies of operation not are valid ISO codes (ISO 4217)",
                dto.getClass(), dto.getValueDate().toString(), dto.getCcyPair());
    }

    @Override
    public boolean validateAmericanStyle(final RequestCheckDTO dto) {
        if (dto.getStyle().equals("AMERICAN")) {
            if ((dto.getExcerciseStartDate().after(dto.getTradeDate())) &&
                    dto.getExcerciseStartDate().before(dto.getExpiryDate())) {
                log.info("Validate by AMERICAN style was successful " +
                                ", Trade date: '{}', Trade date: '{}' ",
                        dto.getStyle(), dto.getExcerciseStartDate());
                return true;
            }
            throw new BadRequestException("American option style must be in addition the exercise start date, " +
                    "which has to be after the trade date but before the expiry date!",
                    dto.getClass(), dto.getValueDate().toString(), dto.getExcerciseStartDate());
        }
        log.info("Еhis operation is not American style Trade date: '{}', Trade date: '{}' ",
                dto.getStyle(), dto.getExcerciseStartDate());
        return false;
    }

    @Override
    public boolean expiryAndPremiumDateBeforeDeliveryDate(final RequestCheckDTO dto) {
        if (dto.getExpiryDate().before(dto.getDeliveryDate()) &&
                dto.getPremiumDate().before(dto.getDeliveryDate())) {
            log.info("Validate by expiry and premium date before delivery date " +
                            ", Trade date: '{}', Delivery date: '{}' ",
                    dto.getTradeDate(), dto.getDeliveryDate());
            return true;
        }
        throw new BadRequestException("Expiry date and premium date shall be before delivery date!",
                dto.getClass(), dto.getValueDate().toString(), dto.getCcyPair());
    }
}
