package com.fintech_middleware.customer_onboarding.controller;

import com.fintech_middleware.customer_onboarding.dto.request.CustomerRequestDto;
import com.fintech_middleware.customer_onboarding.dto.response.CustomerResponseDto;
import com.fintech_middleware.customer_onboarding.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/onboard")
    public ResponseEntity<CustomerResponseDto> onboardCustomer(@Valid  @RequestBody CustomerRequestDto request) {
        return ResponseEntity.ok(customerService.onboardCustomer(request));
    }


}
