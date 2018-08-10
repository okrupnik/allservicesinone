package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class TruckingIndustry {

	private final String typeTrucking;

	public String getTypeTrucking() {
		return typeTrucking;
	}

	private TruckingIndustry(Builder builder) {
		this.typeTrucking = builder.typeTrucking;
	}

	public static class Builder {
		private String typeTrucking;

		public Builder setTypeTrucking(String typeTrucking) {
			this.typeTrucking = typeTrucking;
			return this;
		}
		
		public TruckingIndustry build() {
			return new TruckingIndustry(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeTrucking == null) ? 0 : typeTrucking.hashCode());
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
		TruckingIndustry other = (TruckingIndustry) obj;
		if (typeTrucking == null) {
			if (other.typeTrucking != null)
				return false;
		} else if (!typeTrucking.equals(other.typeTrucking))
			return false;
		return true;
	}
	
	
}
