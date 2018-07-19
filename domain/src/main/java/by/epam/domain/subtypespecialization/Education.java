package by.epam.domain.subtypespecialization;

public class Education {
	
	private String typeEducation;

	public Education() {

	}

	public Education(String typeEducation) {
		this.typeEducation = typeEducation;
	}

	public String getTypeEducation() {
		return typeEducation;
	}

	public void setTypeEducation(String typeEducation) {
		this.typeEducation = typeEducation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeEducation == null) ? 0 : typeEducation.hashCode());
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
		Education other = (Education) obj;
		if (typeEducation == null) {
			if (other.typeEducation != null)
				return false;
		} else if (!typeEducation.equals(other.typeEducation))
			return false;
		return true;
	}

}
