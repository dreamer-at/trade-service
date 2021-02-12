package com.example.tradeservice.service;

import com.example.tradeservice.model.reference.CcyPairType;
import com.example.tradeservice.model.reference.CurrencyHolidayType;
import com.example.tradeservice.model.reference.StyleType;

import java.time.LocalDate;
import java.util.List;

public interface ReferenceService {

    CurrencyHolidayType findFirstByCurrencyAndHolidayDateAndIsEnabledTrue(String currency, LocalDate holidayDate);
    List<CurrencyHolidayType> findAllByCurrencyAndIsEnabledTrue(String currency);

    boolean existsByCcyPairType(String name);

    boolean existsByProductName(String name);

    CcyPairType findFirstCcyPairTypeByName(String name);

    boolean existsStyleTypeByName(String name);
}
