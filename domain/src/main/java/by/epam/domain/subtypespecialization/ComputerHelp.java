package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class ComputerHelp {

	private final String typeComputerHelp;

	public String getTypeComputerHelp() {
		return typeComputerHelp;
	}
	
	private ComputerHelp(Builder builder) {
		this.typeComputerHelp = builder.typeComputerHelp;
	}

	public static class Builder {
		private String typeComputerHelp;

		public Builder setTypeComputerHelp(String typeComputerHelp) {
			this.typeComputerHelp = typeComputerHelp;
			return this;
		}
		
		public ComputerHelp build() {
			return new ComputerHelp(this);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeComputerHelp == null) ? 0 : typeComputerHelp.hashCode());
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
		ComputerHelp other = (ComputerHelp) obj;
		if (typeComputerHelp == null) {
			if (other.typeComputerHelp != null)
				return false;
		} else if (!typeComputerHelp.equals(other.typeComputerHelp))
			return false;
		return true;
	}
}
