package br.com.humanresources.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.humanresources.hrpayroll.models.Payment;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
    
    public Payment getPaymet(Long id, Integer days){
        return new  Payment("Bob", 200.0, days);
    }
}
