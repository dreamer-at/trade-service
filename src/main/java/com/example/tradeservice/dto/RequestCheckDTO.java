package com.example.tradeservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class RequestCheckDTO {
    private String customer;
    private String ccyPair;
    private String type;
    private String style;
    private String direction;
    private String strategy;
    private Date tradeDate;
    private List<BigDecimal> amount;
    private Double rate;
    private Date deliveryDate;
    private Date expiryDate;
    private String payCcy;
    private String premium;
    private String premiumCcy;
    private String premiumType;
    private Date premiumDate;
    private String legalEntity;
    private String trader;
}
