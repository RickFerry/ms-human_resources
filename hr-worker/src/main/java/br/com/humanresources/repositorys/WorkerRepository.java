package br.com.humanresources.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.humanresources.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
