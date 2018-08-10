package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class CleaningAndHelp {

	private final String typeCleaningAndHelp;

	public String getTypeCleaningAndHelp() {
		return typeCleaningAndHelp;
	}

	private CleaningAndHelp(Builder builder) {
		this.typeCleaningAndHelp = builder.typeCleaningAndHelp;
	}

	public static class Builder {
		private String typeCleaningAndHelp;

		public Builder setTypeCleaningAndHelp(String typeCleaningAndHelp) {
			this.typeCleaningAndHelp = typeCleaningAndHelp;
			return this;
		}
		
		public CleaningAndHelp build() {
			return new CleaningAndHelp(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeCleaningAndHelp == null) ? 0 : typeCleaningAndHelp.hashCode());
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
		CleaningAndHelp other = (CleaningAndHelp) obj;
		if (typeCleaningAndHelp == null) {
			if (other.typeCleaningAndHelp != null)
				return false;
		} else if (!typeCleaningAndHelp.equals(other.typeCleaningAndHelp))
			return false;
		return true;
	}
}
