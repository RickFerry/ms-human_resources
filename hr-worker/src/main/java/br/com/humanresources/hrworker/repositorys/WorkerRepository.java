package br.com.humanresources.hrworker.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.humanresources.hrworker.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
