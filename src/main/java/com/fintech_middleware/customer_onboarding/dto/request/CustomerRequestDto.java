package com.fintech_middleware.customer_onboarding.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {

    private String fullName;
    private String bvn;
    private String nin;
    private String email;

}
