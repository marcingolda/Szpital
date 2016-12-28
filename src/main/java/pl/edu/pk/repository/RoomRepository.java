package pl.edu.pk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.pk.bean.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {

}
