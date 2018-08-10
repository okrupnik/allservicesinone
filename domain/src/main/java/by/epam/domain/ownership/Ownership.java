package by.epam.domain.ownership;

import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class Ownership {
	
	private final String formOwnership;

	public String getFormOwnership() {
		return formOwnership;
	}
	
	private Ownership(Builder builder) {
		this.formOwnership = builder.formOwnership;
	}

	public static class Builder {
		private String formOwnership;

		public Builder setFormOwnership(String formOwnership) {
			this.formOwnership = formOwnership;
			return this;
		}
		
		public Ownership build() {
			return new Ownership(this);
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formOwnership == null) ? 0 : formOwnership.hashCode());
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
		Ownership other = (Ownership) obj;
		if (formOwnership == null) {
			if (other.formOwnership != null)
				return false;
		} else if (!formOwnership.equals(other.formOwnership))
			return false;
		return true;
	}
	
}
