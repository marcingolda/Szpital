package pl.edu.pk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pk.bean.User;
import pl.edu.pk.repository.UserRepository;
import pl.edu.pk.utils.MyUtil;

@Service
public class UserService implements Crud <User>{
	@Autowired
	UserRepository repository;

	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public User getById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<User> getAll() {
		return MyUtil.iterableToList(repository.findAll());
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}



}
