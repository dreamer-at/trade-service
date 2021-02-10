package com.example.tradeservice.service;

import com.example.tradeservice.dto.RequestCheckDTO;

import java.util.List;

public interface OperationService {
    RequestCheckDTO checkOperation(RequestCheckDTO dto);

    List<RequestCheckDTO> checkAllOperation(RequestCheckDTO dto);

    RequestCheckDTO  valueDateCannotBeBeforeTradeDate(RequestCheckDTO dto);

    RequestCheckDTO  valueDateCannotFallOnWeekendOrNonWorkingDayForCurrency(RequestCheckDTO dto);

    RequestCheckDTO  ifTheCounterpartyIsOneOfTheSupportedOnes(RequestCheckDTO dto);

    RequestCheckDTO  validateCurrenciesIfTheyAreValidISOCodes(RequestCheckDTO dto);

    RequestCheckDTO  validateTheValueDateAgainstTheProductType(RequestCheckDTO dto);
}
