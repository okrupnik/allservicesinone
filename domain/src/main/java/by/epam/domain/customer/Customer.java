package by.epam.domain.customer;

import by.epam.domain.ownership.Ownership;

public class Customer {	
	
	private String email;
	private String phoneNumber;
	private Ownership ownership;
	private NaturalCustomerInfo naturalCustomerInfo;
	private LegalCustomerInfo legalCustomerInfo;
	private CompanyCustomerInfo companyCustomerInfo;
	
	public Customer() {
		
	}		

	public Customer(String email, String phoneNumber, Ownership ownership) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.ownership = ownership;
	}

	public Customer(String email, String phoneNumber, Ownership ownership, NaturalCustomerInfo naturalCustomerInfo) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.ownership = ownership;
		this.naturalCustomerInfo = naturalCustomerInfo;
	}

	public Customer(String email, String phoneNumber, Ownership ownership, LegalCustomerInfo legalCustomerInfo) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.ownership = ownership;
		this.legalCustomerInfo = legalCustomerInfo;
	}

	public Customer(String email, String phoneNumber, Ownership ownership, CompanyCustomerInfo companyCustomerInfo) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.ownership = ownership;
		this.companyCustomerInfo = companyCustomerInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((legalCustomerInfo == null) ? 0 : legalCustomerInfo.hashCode());
		result = prime * result + ((naturalCustomerInfo == null) ? 0 : naturalCustomerInfo.hashCode());
		result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
}
