package com.example.tradeservice.model;

import com.example.tradeservice.model.reference.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseOperation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    protected LocalDateTime updatedDate;

    @Column(name = "is_enabled")
    private Boolean is_enabled;

    @Column(name = "trade_date")
    private Date tradeDate;

    @Column(name = "amount1")
    private BigDecimal amount1;

    @Column(name = "amount2")
    private BigDecimal amount2;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "premium")
    private Double premium;

    @Column(name = "premium_date")
    private Date premiumDate;

    @Column(name = "exercise_start_date")
    private Date exerciseStartDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ccy_pair_type")
    private CcyPairType ccyPair;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type")
    private ProductType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "style_type")
    private StyleType style;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direction_type")
    private DirectionType direction;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "strategy_type")
    private StrategyType strategy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_ccy_type")
    private PayCcyType payCcy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premium_ccy_type")
    private PremiumCcyType premiumCcy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premium_type")
    private PremiumType premiumType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_entity")
    private LegalEntity legalEntity;
}
