package pl.edu.pk.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.utils.DataTimeUtil;

@Entity
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private VisitType visitType;
	
    @ManyToOne(optional=false)
    @JoinColumn(name="patient_id", referencedColumnName="user_id")
	private User patient;
	
    @ManyToOne(optional=false)
    @JoinColumn(name="doctor_id", referencedColumnName="user_id")
	private User doctor;
	
	private String medicalComment;
	
	private LocalDateTime date;
	
    @ManyToOne
    @JoinColumn(name="room_id", referencedColumnName="roomNumber")
	private Room room;
	
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VisitType getVisitType() {
		return visitType;
	}

	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getMedicalComment() {
		return medicalComment;
	}

	public void setMedicalComment(String medicalComment) {
		this.medicalComment = medicalComment;
	}

	public LocalDateTime getDateAsDate() {
		return date;
	}
	
	public String getDate() {
		return DataTimeUtil.getString(date);
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
