package by.epam.domain.customer;

import by.epam.domain.ownership.Ownership;

public class Customer {	
	
	private Ownership ownership;
	private NaturalCustomerInfo naturalCustomerInfo;
	private LegalCustomerInfo legalCustomerInfo;
	private CompanyCustomerInfo companyCustomerInfo;
	
	public Customer() {
		
	}		

	public Customer(Ownership ownership) {
		this.ownership = ownership;
	}

	public Customer(Ownership ownership, NaturalCustomerInfo naturalCustomerInfo) {
		this.ownership = ownership;
		this.naturalCustomerInfo = naturalCustomerInfo;
	}

	public Customer(Ownership ownership, LegalCustomerInfo legalCustomerInfo) {
		this.ownership = ownership;
		this.legalCustomerInfo = legalCustomerInfo;
	}

	public Customer(Ownership ownership, CompanyCustomerInfo companyCustomerInfo) {
		this.ownership = ownership;
		this.companyCustomerInfo = companyCustomerInfo;
	}

	public NaturalCustomerInfo getNaturalCustomerInfo() {
		return naturalCustomerInfo;
	}

	public void setNaturalCustomerInfo(NaturalCustomerInfo naturalCustomerInfo) {
		this.naturalCustomerInfo = naturalCustomerInfo;
	}

	public LegalCustomerInfo getLegalCustomerInfo() {
		return legalCustomerInfo;
	}

	public void setLegalCustomerInfo(LegalCustomerInfo legalCustomerInfo) {
		this.legalCustomerInfo = legalCustomerInfo;
	}

	public CompanyCustomerInfo getCompanyCustomerInfo() {
		return companyCustomerInfo;
	}

	public void setCompanyCustomerInfo(CompanyCustomerInfo companyCustomerInfo) {
		this.companyCustomerInfo = companyCustomerInfo;
	}

	public Ownership getOwnership() {
		return ownership;
	}

	public void setOwnership(Ownership ownership) {
		this.ownership = ownership;
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
