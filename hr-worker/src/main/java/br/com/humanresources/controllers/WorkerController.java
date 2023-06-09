package br.com.humanresources.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.humanresources.models.Worker;
import br.com.humanresources.services.WorkerService;
import lombok.AllArgsConstructor;

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
}
