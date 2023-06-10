package br.com.humanresources.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.humanresources.hrpayroll.models.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
    
    @GetMapping("/{id}")
	public ResponseEntity<Worker> findOne(@PathVariable Long id);
}
