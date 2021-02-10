package com.example.tradeservice.service;

import com.example.tradeservice.dto.RequestCheckDTO;

import java.util.List;

public interface OperationService {

    Boolean checkOperation(RequestCheckDTO dto);

    List<RequestCheckDTO> checkAllOperation(RequestCheckDTO dto);

    Boolean  valueDateCannotBeBeforeTradeDate(RequestCheckDTO dto);

    Boolean  valueDateCannotFallOnWeekendOrNonWorkingDayForCurrency(RequestCheckDTO dto);

    RequestCheckDTO  ifTheCounterpartyIsOneOfTheSupportedOnes(RequestCheckDTO dto);

    RequestCheckDTO  validateCurrenciesIfTheyAreValidISOCodes(RequestCheckDTO dto);

    RequestCheckDTO  validateTheValueDateAgainstTheProductType(RequestCheckDTO dto);
}
