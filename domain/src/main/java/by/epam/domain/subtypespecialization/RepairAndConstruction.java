package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class RepairAndConstruction {
	
	private final String typeRepairAndConstruction;

	public String getTypeRepairAndConstruction() {
		return typeRepairAndConstruction;
	}

	private RepairAndConstruction(Builder builder) {
		this.typeRepairAndConstruction = builder.typeRepairAndConstruction;
	}

	public static class Builder {
		private String typeRepairAndConstruction;

		public Builder setTypeRepairAndConstruction(String typeRepairAndConstruction) {
			this.typeRepairAndConstruction = typeRepairAndConstruction;
			return this;
		}
		
		public RepairAndConstruction build() {
			return new RepairAndConstruction(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeRepairAndConstruction == null) ? 0 : typeRepairAndConstruction.hashCode());
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
		RepairAndConstruction other = (RepairAndConstruction) obj;
		if (typeRepairAndConstruction == null) {
			if (other.typeRepairAndConstruction != null)
				return false;
		} else if (!typeRepairAndConstruction.equals(other.typeRepairAndConstruction))
			return false;
		return true;
	}
}
