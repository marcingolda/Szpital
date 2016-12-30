package pl.edu.pk.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.pk.bean.Room;
import pl.edu.pk.bean.User;
import pl.edu.pk.bean.Visit;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.form.VisitForm;
import pl.edu.pk.service.RoomService;
import pl.edu.pk.service.UserService;
import pl.edu.pk.service.VisitService;

@Component
public class PotentialVisitUtil {
	@Autowired
	UserService userService;
	
	@Autowired
	RoomService roomServie;
	
	@Autowired
	VisitService visitServie;
	
	static LocalTime startTime = LocalTime.of(8, 0, 0);
	static LocalTime endTime = LocalTime.of(16, 0, 0);
	
	public List<PotentialVisit> getPotentialVisitList(VisitType visitype){
		return getPotentialVisitList(visitype, 5);
	}
	public List<PotentialVisit> getPotentialVisitList(VisitType visitType, int days){
		List<LocalDateTime> potentialDates = createPotentialDateList(days);
		List<User> specialists  = userService.getAllDoctorsByVisitType(visitType);
		List<Visit> visits = visitServie.getAll();
		List<Room> rooms = roomServie.getAllByType(visitType);
		List<PotentialVisit> potentialVisits = new ArrayList<>();
		
		for (LocalDateTime date : potentialDates){
			for (User doctor : specialists){
				for (Room room : rooms){
					if (isValidVisit(doctor, visits, date, room)){
						potentialVisits.add(new PotentialVisit(date, doctor, room));
						break;
					}
				}
			}
		}
		return potentialVisits;
	}
	
	private List<LocalDateTime> createPotentialDateList(int dayPeriod){
		List<LocalDateTime> dates = new ArrayList<>();
		LocalDate nowDate = LocalDate.now();
		LocalDate endDate = nowDate.plusDays(dayPeriod);
		LocalTime nowTime = LocalTime.now();
		
		if(nowTime.isBefore(startTime)){
			nowTime = startTime;
		} else if (nowTime.isAfter(endTime)){
			nowTime = startTime;
			nowDate = nowDate.plusDays(1);
		}
		
		while (nowDate.isBefore(endDate)){
			while (nowTime.isBefore(endTime)){
				dates.add(LocalDateTime.of(nowDate, nowTime));
				nowTime = nowTime.plusMinutes(30);
			}
			nowDate = nowDate.plusDays(1);
		}
		return dates;
	}
	
	private boolean isValidVisit(User doctor, List<Visit> visits, LocalDateTime date, Room room){
		for (Visit visit : visits){
			if (visit.getDoctor().equals(doctor) && visit.getDateAsDate().equals(date)){
				return false;
			}
			if (visit.getRoom().equals(room) && visit.getDateAsDate().equals(date)){
				return false;
			}
		}
		return true;
	}
	
	public Visit getVisit(List<PotentialVisit> potentialVisits, VisitForm visitForm, User patient){
		Visit visit = new Visit();
		PotentialVisit potentialVisit = potentialVisits.get(visitForm.getPotentialVisit());
		visit.setDate(potentialVisit.getDate());
		visit.setDoctor(potentialVisit.getDoctor());
		visit.setRoom(potentialVisit.getRoom());
		visit.setActive(true);
		visit.setVisitType(visitForm.getVisitType());
		visit.setPatient(patient);
		return visit;
	}
}
