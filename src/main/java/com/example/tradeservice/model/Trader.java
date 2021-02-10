package com.example.tradeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "trader", schema = "org")
public class Trader extends BaseEntity {
}
