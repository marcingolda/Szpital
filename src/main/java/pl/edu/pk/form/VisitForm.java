package pl.edu.pk.form;

import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.utils.PotentialVisit;

public class VisitForm {

	private VisitType visitType;
	
	private int potentialVisit;

	public VisitType getVisitType() {
		return visitType;
	}

	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

	public int getPotentialVisit() {
		return potentialVisit;
	}

	public void setPotentialVisit(int potentialVisit) {
		this.potentialVisit = potentialVisit;
	}

		
}
