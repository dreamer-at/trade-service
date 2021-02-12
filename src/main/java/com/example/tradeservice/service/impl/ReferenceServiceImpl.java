package com.example.tradeservice.service.impl;

import com.example.tradeservice.model.reference.CcyPairType;
import com.example.tradeservice.model.reference.CurrencyHolidayType;
import com.example.tradeservice.model.reference.StyleType;
import com.example.tradeservice.repository.CcyPairTypeRepository;
import com.example.tradeservice.repository.CurrencyHolidayTypeRepository;
import com.example.tradeservice.repository.ProductTypeRepository;
import com.example.tradeservice.repository.StyleTypeRepository;
import com.example.tradeservice.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

    private final CurrencyHolidayTypeRepository currencyHolidayTypeRepository;
    private final CcyPairTypeRepository ccyPairTypeRepository;
    private final ProductTypeRepository productTypeRepository;
    private final StyleTypeRepository styleTypeRepository;

    @Override
    public CurrencyHolidayType findFirstByCurrencyAndHolidayDateAndIsEnabledTrue(
            final String currency, final LocalDate holidayDate) {
        return currencyHolidayTypeRepository.
                findFirstByCurrencyAndHolidayDateAndIsEnabledTrue(currency, holidayDate);
    }

    @Override
    public List<CurrencyHolidayType> findAllByCurrencyAndIsEnabledTrue(String currency) {
        return currencyHolidayTypeRepository.findAllByCurrencyAndIsEnabledTrue(currency);
    }

    @Override
    public boolean existsByCcyPairType(final String name) {
        return ccyPairTypeRepository.existsByName(name);
    }

    @Override
    public boolean existsByProductName(final String name) {
        return productTypeRepository.existsByName(name);
    }

    @Override
    public CcyPairType findFirstCcyPairTypeByName(final String name) {
        return ccyPairTypeRepository.findByName(name);
    }

    @Override
    public boolean existsStyleTypeByName(final String name) {
        return styleTypeRepository.existsByName(name);
    }
}
