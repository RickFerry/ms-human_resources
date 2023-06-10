package br.com.humanresources.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.humanresources.hrpayroll.feignclients.WorkerFeignClient;
import br.com.humanresources.hrpayroll.models.Payment;
import br.com.humanresources.hrpayroll.models.Worker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final WorkerFeignClient workerFeignClient;

    public Payment getPaymet(Long id, Integer days){
        Worker worker = workerFeignClient.findOne(id).getBody();
        return new  Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
