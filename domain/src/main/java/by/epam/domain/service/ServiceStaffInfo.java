package by.epam.domain.service;

import by.epam.domain.user.Role;
import by.epam.domain.user.Role.Builder;

public class ServiceStaffInfo {

	private final String name;
	private final String surname;
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	private ServiceStaffInfo(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
	}

	public static class Builder {
		private String name;
		private String surname;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setSurname(String surname) {
			this.surname = surname;
			return this;
		}
		
		public ServiceStaffInfo build() {
			return new ServiceStaffInfo(this);
		}
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		ServiceStaffInfo other = (ServiceStaffInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
