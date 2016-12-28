package pl.edu.pk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.pk.bean.Visit;

public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
