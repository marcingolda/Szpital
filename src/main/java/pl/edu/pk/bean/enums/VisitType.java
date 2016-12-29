package pl.edu.pk.bean.enums;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

//TODO Zrobić większą listę
public enum VisitType {
	KONSULTACJA_INTERNISTA("Konsultacja internisty"),
	KONSULTACJA_PEDIATRA("Konsultacja pediatryczna"),
	BADANIE_USG("Badanie USG");
	
	private String description;
	
	private VisitType(String description){
		this.description = description;
	}
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
        return description;
    }
	
	public static List<String> getAllAsStringList(){
		return EnumSet.allOf(VisitType.class)
				.stream()
				.map(t -> t.getDescription())
				.collect(Collectors.toList());
	}
}
