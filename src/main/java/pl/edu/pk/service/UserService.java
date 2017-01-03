package pl.edu.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pk.bean.User;
import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.repository.UserRepository;
import pl.edu.pk.utils.MyUtil;

@Service
public class UserService implements Crud <User> {
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

	public boolean isEmailUnique(String email){
		return !getAll()
				.stream()
				.filter(u -> u.getEmail().equals(email))
				.findFirst()
				.isPresent();
	}
	
	public List<User> getAllDoctors() {
		List<User> users = getAll();
		List<User> doctors = new ArrayList<>();
		for(User user : users){
			if (user.getUserType().equals(UserType.DOCTOR)){
				doctors.add(user);
			}
		}
		return doctors;
	}
	
	public List<User> getAllDoctorsByVisitType(VisitType visitType){
		List<User> allDoctors = getAllDoctors();
		List<User> specialists = new ArrayList<>();
		for (User doctor : allDoctors){
			if (doctor.getSpecialisation().equals(visitType)){
				specialists.add(doctor);
			}
		}
		return specialists;
	}
	
	public void resolveAdminStatus(){
		if (!getAll().stream().filter(u -> u.getUserType().equals(UserType.ADMINISTRATOR)).findFirst().isPresent()){
			User admin = new User();
			admin.setFirst_name("Administrator");
			admin.setLast_name("Administrator");
			admin.setEmail("admin@test.com");
			admin.setPesel("00000000000");
			admin.setPassword("admin");
			admin.setUserType(UserType.ADMINISTRATOR);
			save(admin);
		}
	}
}
