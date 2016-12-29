package pl.edu.pk.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pk.bean.User;
import pl.edu.pk.bean.Visit;
import pl.edu.pk.repository.VisitRepository;
import pl.edu.pk.utils.MyUtil;

@Service
public class VisitService implements Crud <Visit>{

	@Autowired
	VisitRepository repository;
	
	@Override
	public void save(Visit visit) {
		repository.save(visit);
	}

	@Override
	public Visit getById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Visit> getAll() {
		return MyUtil.iterableToList(repository.findAll());
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}
	
	public List<Visit> getPlannedPatientVisits(User user){
		LocalDateTime now = LocalDateTime.now();
		return getAll()
				.stream()
				.filter(v -> (v.getPatient().equals(user) && v.getDateAsDate().isAfter(now) && v.isActive()))
				.collect(Collectors.toList());
	}
	
	public List<Visit> getPlannedDoctorVisits(User user){
		LocalDateTime now = LocalDateTime.now();
		return getAll()
				.stream()
				.filter(v -> (v.getDoctor().equals(user) && v.getDateAsDate().isAfter(now) && v.isActive()))
				.collect(Collectors.toList());
	}

	public List<Visit> getArchivedPatientVisits(User user){
		LocalDateTime now = LocalDateTime.now();
		return getAll()
				.stream()
				.filter(v -> (v.getPatient().equals(user) && (v.getDateAsDate().isBefore(now) || !v.isActive())))
				.collect(Collectors.toList());
	}
	
	public List<Visit> getArchivedDoctorVisits(User user){
		LocalDateTime now = LocalDateTime.now();
		return getAll()
				.stream()
				.filter(v -> (v.getDoctor().equals(user) && (v.getDateAsDate().isBefore(now) || !v.isActive())))
				.collect(Collectors.toList());
	}
}
