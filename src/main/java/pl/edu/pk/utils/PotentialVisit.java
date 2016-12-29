package pl.edu.pk.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.pk.bean.Room;
import pl.edu.pk.bean.User;

public class PotentialVisit {
	
	private LocalDateTime date;
	private User doctor;
	private Room room;
	
	public PotentialVisit(LocalDateTime date, User doctor, Room room) {
		super();
		this.date = date;
		this.doctor = doctor;
		this.room = room;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getDoctor() {
		return doctor;
	}
	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	@Autowired
	public String toString(){
		return DataTimeUtil.getString(date) + " - " + doctor.getFirst_name() + " " + doctor.getLast_name();
	}
}
