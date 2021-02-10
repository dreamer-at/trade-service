--org
CREATE SCHEMA ref;
ALTER SCHEMA ref OWNER TO postgres;

CREATE TABLE ref.ccy_pair_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_ccy_pair_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.ccy_pair_type
    OWNER TO postgres;

CREATE TABLE ref.product_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_product_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.product_type
    OWNER TO postgres;

CREATE TABLE ref.style_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_style_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.style_type
    OWNER TO postgres;

CREATE TABLE ref.direction_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_direction_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.direction_type
    OWNER TO postgres;

CREATE TABLE ref.strategy_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_strategy_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.strategy_type
    OWNER TO postgres;

CREATE TABLE ref.pay_ccy_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_pay_ccy_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.pay_ccy_type
    OWNER TO postgres;

CREATE TABLE ref.premium_ccy_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_premium_ccy_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.premium_ccy_type
    OWNER TO postgres;

CREATE TABLE ref.premium_type
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_premium_type
        PRIMARY KEY (id)
);
ALTER TABLE ref.premium_type
    OWNER TO postgres;

CREATE TABLE ref.legal_entity
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_ref_legal_entity
        PRIMARY KEY (id)
);
ALTER TABLE ref.legal_entity
    OWNER TO postgres;


--org
CREATE SCHEMA org;
ALTER SCHEMA org OWNER TO postgres;

CREATE TABLE org.customer
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,
    is_supported BOOLEAN      NOT NULL DEFAULT FALSE,

    CONSTRAINT pk_org_customer
        PRIMARY KEY (id)
);
ALTER TABLE org.customer
    OWNER TO postgres;

CREATE TABLE org.trader
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name         VARCHAR(255) NOT NULL,

    CONSTRAINT pk_org_trader
        PRIMARY KEY (id)
);
ALTER TABLE org.trader
    OWNER TO postgres;

CREATE TABLE org.operation
(
    id                UUID         NOT NULL,
    updated_date      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tradeDate         TIMESTAMP    NOT NULL,
    amount1           NUMERIC      NOT NULL,
    amount2           NUMERIC      NOT NULL,
    rate              DECIMAL      NOT NULL,
    deliveryDate      TIMESTAMP    NOT NULL,
    expiryDate        TIMESTAMP    NOT NULL,
    premium           DECIMAL      NOT NULL,
    premiumDate       TIMESTAMP    NOT NULL,
    exerciseStartDate TIMESTAMP    NOT NULL,
    customer_id       UUID         NOT NULL,
    trader_id         UUID         NOT NULL,
    ccy_pair_type     UUID         NOT NULL,
    product_type      UUID         NOT NULL,
    style_type        UUID         NOT NULL,
    direction_type    UUID         NOT NULL,
    strategy_type     UUID         NOT NULL,
    pay_ccy_type      UUID         NOT NULL,
    premium_ccy_type  UUID         NOT NULL,
    premium_type      UUID         NOT NULL,
    legal_entity      UUID         NOT NULL,


    CONSTRAINT pk_org_operation
        PRIMARY KEY (id),
    CONSTRAINT fk_org_customer_id
        FOREIGN KEY (customer_id)
            REFERENCES org.customer (id),
    CONSTRAINT fk_org_trader_id
        FOREIGN KEY (trader_id)
            REFERENCES org.trader (id),
    CONSTRAINT fk_ref_ccy_pair_type_id
        FOREIGN KEY (ccy_pair_type)
            REFERENCES ref.ccy_pair_type (id),
    CONSTRAINT fk_ref_product_type
        FOREIGN KEY (product_type)
            REFERENCES ref.product_type (id),
    CONSTRAINT fk_ref_style_type
        FOREIGN KEY (style_type)
            REFERENCES ref.style_type (id),
    CONSTRAINT fk_ref_direction_type
        FOREIGN KEY (direction_type)
            REFERENCES ref.direction_type (id),
    CONSTRAINT fk_ref_strategy_type
        FOREIGN KEY (strategy_type)
            REFERENCES ref.strategy_type (id),
    CONSTRAINT fk_ref_pay_ccy_type
        FOREIGN KEY (pay_ccy_type)
            REFERENCES ref.pay_ccy_type (id),
    CONSTRAINT fk_ref_premium_ccy_type
        FOREIGN KEY (premium_ccy_type)
            REFERENCES ref.premium_ccy_type (id),
    CONSTRAINT fk_ref_premium_type
        FOREIGN KEY (premium_type)
            REFERENCES ref.premium_type (id),
    CONSTRAINT fk_ref_legal_entity
        FOREIGN KEY (legal_entity)
            REFERENCES ref.legal_entity (id)
);
ALTER TABLE org.operation
    OWNER TO postgres;


/*CREATE TABLE org.base_reference
(
    id           UUID         NOT NULL,
    updated_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ccyPair      VARCHAR(255) DEFAULT NULL,
    type         VARCHAR(255) DEFAULT NULL,
    style        VARCHAR(255) DEFAULT NULL,
    direction    VARCHAR(255) DEFAULT NULL,
    strategy     VARCHAR(255) DEFAULT NULL,
    payCcy       VARCHAR(255) DEFAULT NULL,
    premiumCcy   VARCHAR(255) DEFAULT NULL,
    premiumType  VARCHAR(255) DEFAULT NULL,
    legalEntity  VARCHAR(255) DEFAULT NULL,

    CONSTRAINT pk_org_base_reference
        PRIMARY KEY (id)
);
ALTER TABLE org.base_reference
    OWNER TO postgres;*/