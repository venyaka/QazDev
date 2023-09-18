package com.veniamin.onlinewallet.controllers;

import com.veniamin.onlinewallet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("test")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("get-auth")
    public void testPayment() {
        log.info("start payment");
        paymentService.getAuthToken();
    }
}
