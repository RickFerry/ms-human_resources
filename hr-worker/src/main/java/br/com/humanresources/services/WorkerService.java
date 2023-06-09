package br.com.humanresources.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.humanresources.models.Worker;
import br.com.humanresources.repositorys.WorkerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkerService {

	private WorkerRepository workerRepository;

	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	public Worker findOne(Long id) {
		return workerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Worker with id: " + id + " not found."));
	}
}
