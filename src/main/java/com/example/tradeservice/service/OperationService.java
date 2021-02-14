package com.example.tradeservice.service;

import com.example.tradeservice.dto.RequestCheckDTO;

import java.util.List;

public interface OperationService {

    String checkOperation(RequestCheckDTO dto);

    String checkAllOperation(List<RequestCheckDTO> dto);

    boolean checkValueDateAndTradeDate(RequestCheckDTO dto);

    boolean valueOrCurrencyDateOnWeekend(RequestCheckDTO dto);

    boolean ifCustomerIsSupported(RequestCheckDTO dto);

    boolean validateValueDateByProductType(RequestCheckDTO dto);

    boolean validateCurrenciesByISO4217(RequestCheckDTO dto);

    boolean validateAmericanStyle(RequestCheckDTO dto);

    boolean  expiryAndPremiumDateBeforeDeliveryDate(RequestCheckDTO dto);

    void saveEntity(RequestCheckDTO dto);
}
