package by.epam.domain.customer;

import by.epam.domain.ownership.Ownership;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class Customer {	
	
	private final Ownership ownership;
	private final NaturalCustomerInfo naturalCustomerInfo;
	private final LegalCustomerInfo legalCustomerInfo;
	private final CompanyCustomerInfo companyCustomerInfo;
	
	public NaturalCustomerInfo getNaturalCustomerInfo() {
		return naturalCustomerInfo;
	}

	public LegalCustomerInfo getLegalCustomerInfo() {
		return legalCustomerInfo;
	}

	public CompanyCustomerInfo getCompanyCustomerInfo() {
		return companyCustomerInfo;
	}

	public Ownership getOwnership() {
		return ownership;
	}

	private Customer(Builder builder) {
		this.ownership = builder.ownership;
		this.naturalCustomerInfo = builder.naturalCustomerInfo;
		this.legalCustomerInfo = builder.legalCustomerInfo;
		this.companyCustomerInfo = builder.companyCustomerInfo;
	}

	public static class Builder {
		private Ownership ownership;
		private NaturalCustomerInfo naturalCustomerInfo;
		private LegalCustomerInfo legalCustomerInfo;
		private CompanyCustomerInfo companyCustomerInfo;
		
		public Builder setOwnership(Ownership ownership) {
			this.ownership = ownership;
			return this;
		}
		public Builder setNaturalCustomerInfo(NaturalCustomerInfo naturalCustomerInfo) {
			this.naturalCustomerInfo = naturalCustomerInfo;
			return this;
		}
		public Builder setLegalCustomerInfo(LegalCustomerInfo legalCustomerInfo) {
			this.legalCustomerInfo = legalCustomerInfo;
			return this;
		}
		public Builder setCompanyCustomerInfo(CompanyCustomerInfo companyCustomerInfo) {
			this.companyCustomerInfo = companyCustomerInfo;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyCustomerInfo == null) ? 0 : companyCustomerInfo.hashCode());
		result = prime * result + ((legalCustomerInfo == null) ? 0 : legalCustomerInfo.hashCode());
		result = prime * result + ((naturalCustomerInfo == null) ? 0 : naturalCustomerInfo.hashCode());
		result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
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
		Customer other = (Customer) obj;
		if (companyCustomerInfo == null) {
			if (other.companyCustomerInfo != null)
				return false;
		} else if (!companyCustomerInfo.equals(other.companyCustomerInfo))
			return false;
		if (legalCustomerInfo == null) {
			if (other.legalCustomerInfo != null)
				return false;
		} else if (!legalCustomerInfo.equals(other.legalCustomerInfo))
			return false;
		if (naturalCustomerInfo == null) {
			if (other.naturalCustomerInfo != null)
				return false;
		} else if (!naturalCustomerInfo.equals(other.naturalCustomerInfo))
			return false;
		if (ownership == null) {
			if (other.ownership != null)
				return false;
		} else if (!ownership.equals(other.ownership))
			return false;
		return true;
	}
	
}
