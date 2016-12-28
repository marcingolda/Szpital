package pl.edu.pk.bean;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import pl.edu.pk.bean.enums.VisitType;

@Entity
@Table(name = "room")
public class Room {
	@Id
	private int roomNumber;
	
	@NotNull
	private VisitType roomType;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public VisitType getRoomType() {
		return roomType;
	}

	public void setRoomType(VisitType roomType) {
		this.roomType = roomType;
	}

	
}
