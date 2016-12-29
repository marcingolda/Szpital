package pl.edu.pk.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTimeUtil {
	public static String getString(LocalDateTime time){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return time.format(formatter); // "1986-04-08 12:30"
	}

}
