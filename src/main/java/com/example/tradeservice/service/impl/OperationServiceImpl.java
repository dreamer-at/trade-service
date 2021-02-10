package com.example.tradeservice.service.impl;

import com.example.tradeservice.dto.RequestCheckDTO;
import com.example.tradeservice.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    @Override
    public RequestCheckDTO checkOperation(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public List<RequestCheckDTO> checkAllOperation(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public RequestCheckDTO valueDateCannotBeBeforeTradeDate(RequestCheckDTO dto) {
        return null;
    }

    @Override
    public RequestCheckDTO valueDateCannotFallOnWeekendOrNonWorkingDayForCurrency(RequestCheckDTO dto) {
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
