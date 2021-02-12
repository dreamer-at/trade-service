package com.example.tradeservice.util.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TrUtils {

    public static Optional<Currency> getCurrencyInstance(String code) {
        return Currency.getAvailableCurrencies().stream().filter(
                c -> c.getCurrencyCode().equalsIgnoreCase(code))
                .findAny();
    }

    public static long countBusinessDaysBetween(LocalDate startDate, LocalDate endDate,
                                                List<LocalDate> holidays) {
        Predicate<LocalDate> isHoliday = holidays::contains;
        Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(daysBetween)
                .filter(isHoliday.or(isWeekend).negate())
                .count();
    }
}
