package com.example.tradeservice.model.reference;

import com.example.tradeservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "currency_holiday_type", schema = "ref")
public class CurrencyHolidayType extends BaseEntity {

    @Column(name = "currency")
    private String currency;

    @Column(name = "holiday_date")
    private LocalDate holidayDate;
}
