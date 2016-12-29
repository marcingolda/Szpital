package pl.edu.pk.bean.enums;

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
}
