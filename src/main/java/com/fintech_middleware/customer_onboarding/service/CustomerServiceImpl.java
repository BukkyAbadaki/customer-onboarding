package com.fintech_middleware.customer_onboarding.service;

import com.fintech_middleware.customer_onboarding.domain.Customer;
import com.fintech_middleware.customer_onboarding.dto.request.CustomerRequestDto;
import com.fintech_middleware.customer_onboarding.dto.response.CustomerResponseDto;
import com.fintech_middleware.customer_onboarding.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto onboardCustomer(CustomerRequestDto requestDto) {
        if (customerRepository.findByBvn(requestDto.getBvn()).isPresent()) {
            return CustomerResponseDto.builder()
                    .responseCode("002")
                    .responseMessage("BVN already exists")
                    .build();
        }

        // Check if NIN already exists
        if (customerRepository.findByNin(requestDto.getNin()).isPresent()) {
            return CustomerResponseDto.builder()
                    .responseCode("002")
                    .responseMessage("NIN already exists")
                    .build();
        }
        // Save new customer
        Customer customer = Customer.builder()
                .fullName(requestDto.getFullName())
                .bvn(requestDto.getBvn())
                .nin(requestDto.getNin())
                .email(requestDto.getEmail())
                .isVerified(true)
                .build();

        Customer saved = customerRepository.save(customer);

        // Return successful response
        return CustomerResponseDto.builder()
                .id(saved.getId())
                .fullName(saved.getFullName())
                .bvn(saved.getBvn())
                .nin(saved.getNin())
                .email(saved.getEmail())
                .responseCode("000")
                .responseMessage("Success")
                .build();

}
}
