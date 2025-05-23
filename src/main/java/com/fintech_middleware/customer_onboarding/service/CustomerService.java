package com.fintech_middleware.customer_onboarding.service;

import com.fintech_middleware.customer_onboarding.dto.request.CustomerRequestDto;
import com.fintech_middleware.customer_onboarding.dto.response.CustomerResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerResponseDto onboardCustomer(CustomerRequestDto requestDto);

}
