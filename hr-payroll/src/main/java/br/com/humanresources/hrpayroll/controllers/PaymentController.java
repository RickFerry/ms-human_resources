package br.com.humanresources.hrpayroll.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.humanresources.hrpayroll.models.Payment;
import br.com.humanresources.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    
    private PaymentService paymentService;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> getPaymet(@PathVariable Long id, @PathVariable Integer days){
        return ResponseEntity.ok(paymentService.getPaymet(id, days));
    }
}
