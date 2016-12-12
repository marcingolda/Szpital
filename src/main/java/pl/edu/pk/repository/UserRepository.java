package pl.edu.pk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.pk.bean.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	//Empty interface - Admire Spring magic ;)
}
