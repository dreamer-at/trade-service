package com.example.tradeservice.model.reference;

import com.example.tradeservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "legal_entity", schema = "ref")
public class LegalEntity extends BaseEntity {
}
