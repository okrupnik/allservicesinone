package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class Design {

	private final String typeDesign;

	public String getTypeDesign() {
		return typeDesign;
	}

	private Design(Builder builder) {
		this.typeDesign = builder.typeDesign;
	}

	public static class Builder {
		private String typeDesign;

		public Builder setTypeDesign(String typeDesign) {
			this.typeDesign = typeDesign;
			return this;
		}
		
		public Design build() {
			return new Design(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeDesign == null) ? 0 : typeDesign.hashCode());
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
		Design other = (Design) obj;
		if (typeDesign == null) {
			if (other.typeDesign != null)
				return false;
		} else if (!typeDesign.equals(other.typeDesign))
			return false;
		return true;
	}

}
