package com.example.tradeservice.dto;

import com.example.tradeservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID id;
    private String name;
    private Boolean isEnabled;
    private String is_supported;

    public static CustomerDTO toUserDTO(final Customer customer) {
        Objects.requireNonNull(customer);
        return null;
    }
}
