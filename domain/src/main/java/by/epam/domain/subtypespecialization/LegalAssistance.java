package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class LegalAssistance {
	
	private final String typeLegalAssistance;

	public String getTypeLegalAssistance() {
		return typeLegalAssistance;
	}

	private LegalAssistance(Builder builder) {
		this.typeLegalAssistance = builder.typeLegalAssistance;
	}

	public static class Builder {
		private String typeLegalAssistance;

		public Builder setTypeLegalAssistance(String typeLegalAssistance) {
			this.typeLegalAssistance = typeLegalAssistance;
			return this;
		}
		
		public LegalAssistance build() {
			return new LegalAssistance(this);
		}
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
