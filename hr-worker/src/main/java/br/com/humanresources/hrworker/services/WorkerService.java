package br.com.humanresources.hrworker.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.humanresources.hrworker.models.Worker;
import br.com.humanresources.hrworker.repositorys.WorkerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkerService {

	private WorkerRepository workerRepository;

	@Transactional(readOnly = true)
	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Worker findOne(Long id) {
		return workerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Worker with id: " + id + " not found."));
	}

	@Transactional
	public Worker save(Worker worker) {
		return workerRepository.save(worker);
	}

	@Transactional
	public Worker update(Worker newWorker) {
		Worker worker = workerRepository.findById(newWorker.getId())
				.orElseThrow(() -> new EntityNotFoundException("Worker with id: " + newWorker.getId() + " not found."));
		BeanUtils.copyProperties(newWorker, worker, "id");
		return workerRepository.save(worker);
	}

	@Transactional
	public void delete(Long id) {
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Worker with id: " + id + " not found."));
		workerRepository.delete(worker);
	}
}
