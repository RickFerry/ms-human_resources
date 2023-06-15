package br.com.humanresources.hrworker.controllers;

import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.humanresources.hrworker.models.Worker;
import br.com.humanresources.hrworker.services.WorkerService;
import lombok.AllArgsConstructor;

@RefreshScope
@RestController
@AllArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(workerService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findOne(@PathVariable Long id) {
		return ResponseEntity.ok(workerService.findOne(id));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Worker> save(@RequestBody Worker worker) {
		return ResponseEntity.ok(workerService.save(worker));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Worker> update(@RequestBody Worker worker) {
		return ResponseEntity.ok(workerService.update(worker));
	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		workerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
