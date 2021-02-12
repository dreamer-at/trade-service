package com.example.tradeservice.service;

import com.example.tradeservice.dto.RequestCheckDTO;

import java.util.List;

public interface OperationService {

    boolean checkOperation(RequestCheckDTO dto);

    List<RequestCheckDTO> checkAllOperation(RequestCheckDTO dto);

    boolean checkValueDateAndTradeDate(RequestCheckDTO dto);

    boolean valueOrCurrencyDateOnWeekend(RequestCheckDTO dto);

    boolean ifCustomerIsSupported(RequestCheckDTO dto);

    boolean validateValueDateByProductType(RequestCheckDTO dto);

    boolean validateCurrenciesByISO4217(RequestCheckDTO dto);

    boolean validateAmericanStyle(RequestCheckDTO dto);
}
