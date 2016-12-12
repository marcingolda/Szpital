package pl.edu.pk.utils;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
	public static <T> List<T> iterableToList(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
	    for (T item : iterable) {
	        list.add(item);
	    }
	    return list;
	}
}
