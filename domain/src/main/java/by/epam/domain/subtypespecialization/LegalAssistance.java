package by.epam.domain.subtypespecialization;

public class LegalAssistance {
	
	private String typeLegalAssistance;

	public LegalAssistance() {

	}

	public LegalAssistance(String typeLegalAssistance) {
		this.typeLegalAssistance = typeLegalAssistance;
	}

	public String getTypeLegalAssistance() {
		return typeLegalAssistance;
	}

	public void setTypeLegalAssistance(String typeLegalAssistance) {
		this.typeLegalAssistance = typeLegalAssistance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeLegalAssistance == null) ? 0 : typeLegalAssistance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LegalAssistance other = (LegalAssistance) obj;
		if (typeLegalAssistance == null) {
			if (other.typeLegalAssistance != null)
				return false;
		} else if (!typeLegalAssistance.equals(other.typeLegalAssistance))
			return false;
		return true;
	}

}
