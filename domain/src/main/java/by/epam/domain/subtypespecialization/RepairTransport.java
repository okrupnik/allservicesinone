package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class RepairTransport {
	
	private final String typeRepairTransport;

	public String getTypeRepairTransport() {
		return typeRepairTransport;
	}
	
	private RepairTransport(Builder builder) {
		this.typeRepairTransport = builder.typeRepairTransport;
	}

	public static class Builder {
		private String typeRepairTransport;

		public Builder setTypeRepairTransport(String typeRepairTransport) {
			this.typeRepairTransport = typeRepairTransport;
			return this;
		}
		
		public RepairTransport build() {
			return new RepairTransport(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeRepairTransport == null) ? 0 : typeRepairTransport.hashCode());
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
		RepairTransport other = (RepairTransport) obj;
		if (typeRepairTransport == null) {
			if (other.typeRepairTransport != null)
				return false;
		} else if (!typeRepairTransport.equals(other.typeRepairTransport))
			return false;
		return true;
	}

}
