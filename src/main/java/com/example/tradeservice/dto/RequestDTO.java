package com.example.tradeservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private List<RequestCheckDTO> requestCheckDTOList;


}
