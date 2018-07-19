package by.epam.domain.performer;

import by.epam.domain.ownership.Ownership;

public class Performer {
	
	private String email;
	private String phoneNumber;
	private String address;
	private String requisites;
	private Ownership ownership;
	private LegalPerformerInfo legalPerformer;
	private CompanyPerformerInfo companyPerformer;
	
	public Performer() {
		
	}	

	public Performer(String email, String phoneNumber, String address, String requisites, Ownership ownership) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.requisites = requisites;
		this.ownership = ownership;
	}

	public Performer(String email, String phoneNumber, String address, String requisites, Ownership ownership,
			LegalPerformerInfo legalPerformer) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.requisites = requisites;
		this.ownership = ownership;
		this.legalPerformer = legalPerformer;
	}

	public Performer(String email, String phoneNumber, String address, String requisites, Ownership ownership,
			CompanyPerformerInfo companyPerformer) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.requisites = requisites;
		this.ownership = ownership;
		this.companyPerformer = companyPerformer;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRequisites() {
		return requisites;
	}

	public void setRequisites(String requisites) {
		this.requisites = requisites;
	}

	public LegalPerformerInfo getLegalPerformer() {
		return legalPerformer;
	}

	public void setLegalPerformer(LegalPerformerInfo legalPerformer) {
		this.legalPerformer = legalPerformer;
	}

	public CompanyPerformerInfo getCompanyPerformer() {
		return companyPerformer;
	}

	public void setCompanyPerformer(CompanyPerformerInfo companyPerformer) {
		this.companyPerformer = companyPerformer;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((companyPerformer == null) ? 0 : companyPerformer.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((legalPerformer == null) ? 0 : legalPerformer.hashCode());
		result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((requisites == null) ? 0 : requisites.hashCode());
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
		Performer other = (Performer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (companyPerformer == null) {
			if (other.companyPerformer != null)
				return false;
		} else if (!companyPerformer.equals(other.companyPerformer))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (legalPerformer == null) {
			if (other.legalPerformer != null)
				return false;
		} else if (!legalPerformer.equals(other.legalPerformer))
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
		if (requisites == null) {
			if (other.requisites != null)
				return false;
		} else if (!requisites.equals(other.requisites))
			return false;
		return true;
	}	
	
}
