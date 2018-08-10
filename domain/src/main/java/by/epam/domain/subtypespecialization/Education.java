package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class Education {
	
	private final String typeEducation;

	public String getTypeEducation() {
		return typeEducation;
	}

	private Education(Builder builder) {
		this.typeEducation = builder.typeEducation;
	}

	public static class Builder {
		private String typeEducation;

		public Builder setTypeEducation(String typeEducation) {
			this.typeEducation = typeEducation;
			return this;
		}
		
		public Education build() {
			return new Education(this);
		}
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
