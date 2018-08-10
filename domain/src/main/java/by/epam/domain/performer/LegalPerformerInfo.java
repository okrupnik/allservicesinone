package by.epam.domain.performer;

import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class LegalPerformerInfo {
	
	private final String name;
	private final String surname;	
	private final String copyRegistration;
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCopyRegistration() {
		return copyRegistration;
	}

	private LegalPerformerInfo(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.copyRegistration = builder.copyRegistration;
	}

	public static class Builder {
		private String name;
		private String surname;	
		private String copyRegistration;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setSurname(String surname) {
			this.surname = surname;
			return this;
		}
		public Builder setCopyRegistration(String copyRegistration) {
			this.copyRegistration = copyRegistration;
			return this;
		}
		
		public LegalPerformerInfo build() {
			return new LegalPerformerInfo(this);
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copyRegistration == null) ? 0 : copyRegistration.hashCode());
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
		LegalPerformerInfo other = (LegalPerformerInfo) obj;
		if (copyRegistration == null) {
			if (other.copyRegistration != null)
				return false;
		} else if (!copyRegistration.equals(other.copyRegistration))
			return false;
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
