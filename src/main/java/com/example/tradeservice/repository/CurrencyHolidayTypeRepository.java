package com.example.tradeservice.repository;

import com.example.tradeservice.model.reference.CurrencyHolidayType;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyHolidayTypeRepository extends BaseRepository<CurrencyHolidayType, UUID> {

    CurrencyHolidayType findFirstByCurrencyAndHolidayDateAndIsEnabledTrue(String currency, LocalDate holidayDate);

    List<CurrencyHolidayType> findAllByCurrencyAndIsEnabledTrue(String currency);
}
