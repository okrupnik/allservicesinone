package by.epam.domain.customer;

import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class CompanyCustomerInfo {
	
	private final String nameCompany;
	private final String nameAgent;
	private final String surnameAgent;
	private final String requisites;
	private final String description;
	
	public String getNameCompany() {
		return nameCompany;
	}

	public String getNameAgent() {
		return nameAgent;
	}

	public String getSurnameAgent() {
		return surnameAgent;
	}

	public String getRequisites() {
		return requisites;
	}

	public String getDescription() {
		return description;
	}
	
	private CompanyCustomerInfo(Builder builder) {
		this.nameCompany = builder.nameCompany;
		this.nameAgent = builder.nameAgent;
		this.surnameAgent = builder.surnameAgent;
		this.requisites = builder.requisites;
		this.description = builder.description;
	}

	public static class Builder {
		private String nameCompany;
		private String nameAgent;
		private String surnameAgent;
		private String requisites;
		private String description;
		
		public Builder setNameCompany(String nameCompany) {
			this.nameCompany = nameCompany;
			return this;
		}
		public Builder setNameAgent(String nameAgent) {
			this.nameAgent = nameAgent;
			return this;
		}
		public Builder setSurnameAgent(String surnameAgent) {
			this.surnameAgent = surnameAgent;
			return this;
		}
		public Builder setRequisites(String requisites) {
			this.requisites = requisites;
			return this;
		}
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public CompanyCustomerInfo build() {
			return new CompanyCustomerInfo(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((nameAgent == null) ? 0 : nameAgent.hashCode());
		result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
		result = prime * result + ((requisites == null) ? 0 : requisites.hashCode());
		result = prime * result + ((surnameAgent == null) ? 0 : surnameAgent.hashCode());
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
		CompanyCustomerInfo other = (CompanyCustomerInfo) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nameAgent == null) {
			if (other.nameAgent != null)
				return false;
		} else if (!nameAgent.equals(other.nameAgent))
			return false;
		if (nameCompany == null) {
			if (other.nameCompany != null)
				return false;
		} else if (!nameCompany.equals(other.nameCompany))
			return false;
		if (requisites == null) {
			if (other.requisites != null)
				return false;
		} else if (!requisites.equals(other.requisites))
			return false;
		if (surnameAgent == null) {
			if (other.surnameAgent != null)
				return false;
		} else if (!surnameAgent.equals(other.surnameAgent))
			return false;
		return true;
	}
	
}
