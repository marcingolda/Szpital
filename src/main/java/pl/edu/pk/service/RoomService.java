package pl.edu.pk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.pk.bean.Room;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.repository.RoomRepository;
import pl.edu.pk.utils.MyUtil;

@Service
public class RoomService implements Crud<Room> {
	@Autowired
	RoomRepository repository;

	@Override
	public void save(Room room) {
		repository.save(room);
	}

	@Override
	public Room getById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Room> getAll() {
		return MyUtil.iterableToList(repository.findAll());
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}
	
	public List<Room> getAllByType(VisitType visitType){
		return getAll().stream()
				.filter(r -> r.getRoomType()==visitType)
				.collect(Collectors.toList());
	}

	public boolean isNumberUnique(int roomNumber) {
		return !getAll().stream().filter(r -> r.getRoomNumber()==roomNumber).findFirst().isPresent();
	}

}
