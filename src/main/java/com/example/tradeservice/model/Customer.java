package com.example.tradeservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "customer", schema = "org")
public class Customer extends BaseEntity {

    @Builder.Default
    private Boolean isSupported = false;
}
