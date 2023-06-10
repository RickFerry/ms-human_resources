package br.com.humanresources.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.humanresources.hrpayroll.models.Payment;
import br.com.humanresources.hrpayroll.models.Worker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPaymet(Long id, Integer days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id.toString());

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new  Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
