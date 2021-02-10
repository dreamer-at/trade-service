/*
  * Test data for database.
*/
SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE OR REPLACE FUNCTION bytea_import(p_path TEXT, p_result OUT BYTEA)
    LANGUAGE plpgsql AS
$$
DECLARE
    l_oid OID;
BEGIN
    SELECT lo_import(p_path) INTO l_oid;
    SELECT lo_get(l_oid) INTO p_result;
    PERFORM lo_unlink(l_oid);
END;
$$;

DO
$BODY$
    DECLARE
        /*
          Customer test data
        */
        customer_1_uuid         uuid             := uuid_generate_v4();
        customer_2_uuid         uuid             := uuid_generate_v4();
        customer_3_uuid         uuid             := uuid_generate_v4();
        customer_4_uuid         uuid             := uuid_generate_v4();
        /*
          Trader test data
        */
        trader_1_uuid           uuid             := uuid_generate_v4();
        trader_2_uuid           uuid             := uuid_generate_v4();
        trader_3_uuid           uuid             := uuid_generate_v4();
        trader_4_uuid           uuid             := uuid_generate_v4();
        /*
          All reference test data
        */
        ccy_pair_type_1_uuid    uuid             := uuid_generate_v4();
        ccy_pair_type_1         varchar(255)     := 'EURUSD';
        product_type_1_uuid     uuid             := uuid_generate_v4();
        product_type_2_uuid     uuid             := uuid_generate_v4();
        product_type_3_uuid     uuid             := uuid_generate_v4();
        product_type_1          varchar(255)     := 'Spot';
        product_type_2          varchar(255)     := 'VanillaOption';
        product_type_3          varchar(255)     := 'Forward';
        style_type_1_uuid       uuid             := uuid_generate_v4();
        style_type_2_uuid       uuid             := uuid_generate_v4();
        style_type_1            varchar(255)     := 'EUROPEAN';
        style_type_2            varchar(255)     := 'AMERICAN';
        direction_type_1_uuid   uuid             := uuid_generate_v4();
        direction_type_2_uuid   uuid             := uuid_generate_v4();
        direction_type_1        varchar(255)     := 'BUY';
        direction_type_2        varchar(255)     := 'SELL';
        strategy_type_1_uuid    uuid             := uuid_generate_v4();
        strategy_type_1         varchar(255)     := 'CALL';
        pay_ccy_type_1_uuid     uuid             := uuid_generate_v4();
        pay_ccy_type_1          varchar(255)     := 'USD';
        premium_ccy_type_1_uuid uuid             := uuid_generate_v4();
        premium_ccy_type_1      varchar(255)     := 'USD';
        premium_type_1_uuid     uuid             := uuid_generate_v4();
        premium_type_1          varchar(255)     := '%USD';
        legal_entity_1_uuid     uuid             := uuid_generate_v4();
        legal_entity_1          varchar(255)     := 'CSZurich';


        /*
         Operation reference test data
        */
        operation_1_uuid        uuid             := uuid_generate_v4();
        tradeDate_1             date             := current_date;
        amount_1                numeric          := 100000.22;
        amount_2                numeric          := 220000.22;
        rate_1                  double precision := 2.2;
        deliveryDate_1          date             := current_date;
        expiryDate_1            date             := current_date;
        premium_1               double precision := 0.20;
        premiumDate_1           date             := current_date;
        exerciseStartDate_1     date             := current_date;


    BEGIN
        INSERT INTO org.customer(id, name, is_supported)
        VALUES (customer_1_uuid, 'PLUTO1', true),
               (customer_2_uuid, 'PLUTO2', true),
               (customer_3_uuid, 'PLUTO3', false),
               (customer_4_uuid, 'PLUTO4', false);

        INSERT INTO org.trader(id, name)
        VALUES (trader_1_uuid, 'Johann Baumfiddler'),
               (trader_2_uuid, 'Johann Sebastian'),
               (trader_3_uuid, '"B.J." Blazkowicz'),
               (trader_4_uuid, 'Doomguy');

        INSERT INTO ref.ccy_pair_type(id, name)
        VALUES (ccy_pair_type_1_uuid, ccy_pair_type_1);

        INSERT INTO ref.product_type(id, name)
        VALUES (product_type_1_uuid, product_type_1),
               (product_type_3_uuid, product_type_2),
               (product_type_2_uuid, product_type_3);

        INSERT INTO ref.style_type(id, name)
        VALUES (style_type_1_uuid, style_type_1),
               (style_type_2_uuid, style_type_2);

        INSERT INTO ref.direction_type(id, name)
        VALUES (direction_type_1_uuid, direction_type_1),
               (direction_type_2_uuid, direction_type_2);

        INSERT INTO ref.strategy_type(id, name)
        VALUES (strategy_type_1_uuid, strategy_type_1);

        INSERT INTO ref.pay_ccy_type(id, name)
        VALUES (pay_ccy_type_1_uuid, pay_ccy_type_1);

        INSERT INTO ref.premium_ccy_type(id, name)
        VALUES (premium_ccy_type_1_uuid, premium_ccy_type_1);

        INSERT INTO ref.premium_type(id, name)
        VALUES (premium_type_1_uuid, premium_type_1);

        INSERT INTO ref.legal_entity(id, name)
        VALUES (legal_entity_1_uuid, legal_entity_1);


        INSERT INTO org.operation(id, trade_date, amount1, amount2, rate, delivery_date, expiry_date, premium,
                                  premium_date, exercise_start_date, customer_id, trader_id, ccy_pair_type,
                                  product_type, style_type, direction_type, strategy_type, pay_ccy_type,
                                  premium_ccy_type, premium_type, legal_entity)
        VALUES (operation_1_uuid, tradeDate_1, amount_1, amount_2, rate_1, deliveryDate_1, expiryDate_1,
                premium_1, premiumDate_1, exerciseStartDate_1, customer_4_uuid, trader_4_uuid, ccy_pair_type_1_uuid,
                product_type_2_uuid, style_type_1_uuid, direction_type_1_uuid, strategy_type_1_uuid,
                pay_ccy_type_1_uuid, premium_ccy_type_1_uuid, premium_type_1_uuid, legal_entity_1_uuid);
    END;
$BODY$ LANGUAGE plpgsql;