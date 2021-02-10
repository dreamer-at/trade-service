package com.example.tradeservice.service.impl;

import com.example.tradeservice.dto.RequestCheckDTO;
import com.example.tradeservice.service.OperationService;
import com.example.tradeservice.util.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    @Override
    public Boolean checkOperation(RequestCheckDTO dto) {
        if (valueDateCannotBeBeforeTradeDate(dto)) {
            if (valueDateCannotFallOnWeekendOrNonWorkingDayForCurrency(dto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<RequestCheckDTO> checkAllOperation(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public Boolean valueDateCannotBeBeforeTradeDate(RequestCheckDTO dto) throws BadRequestException {
        if (dto.getValueDate().before(dto.getTradeDate())) {
            throw new BadRequestException("Value date cannot be before trade date!",
                    dto.getClass(), dto.getValueDate().toString(), dto.getTradeDate());
        }
        log.info("Validation was successful, Value date: '{}', Trade date: '{}' ",
                dto.getValueDate(), dto.getTradeDate());
        return true;
    }

    @Override
    public Boolean valueDateCannotFallOnWeekendOrNonWorkingDayForCurrency(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public RequestCheckDTO ifTheCounterpartyIsOneOfTheSupportedOnes(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public RequestCheckDTO validateCurrenciesIfTheyAreValidISOCodes(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public RequestCheckDTO validateTheValueDateAgainstTheProductType(RequestCheckDTO dto) {
        return null;
    }
}
