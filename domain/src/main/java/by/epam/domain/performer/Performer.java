package by.epam.domain.performer;

import by.epam.domain.ownership.Ownership;

public class Performer {
	
	private String requisites;
	private Ownership ownership;
	private LegalPerformerInfo legalPerformerInfo;
	private CompanyPerformerInfo companyPerformerInfo;
	
	public Performer() {
		
	}	

	public Performer(String requisites, Ownership ownership) {
		this.requisites = requisites;
		this.ownership = ownership;
	}

	public Performer(String requisites, Ownership ownership,
			LegalPerformerInfo legalPerformerInfo) {
		this.requisites = requisites;
		this.ownership = ownership;
		this.legalPerformerInfo = legalPerformerInfo;
	}

	public Performer(String requisites, Ownership ownership,
			CompanyPerformerInfo companyPerformerInfo) {
		this.requisites = requisites;
		this.ownership = ownership;
		this.companyPerformerInfo = companyPerformerInfo;
	}

	public String getRequisites() {
		return requisites;
	}

	public void setRequisites(String requisites) {
		this.requisites = requisites;
	}

	public LegalPerformerInfo getLegalPerformerInfo() {
		return legalPerformerInfo;
	}

	public void setLegalPerformerInfo(LegalPerformerInfo legalPerformerInfo) {
		this.legalPerformerInfo = legalPerformerInfo;
	}

	public CompanyPerformerInfo getCompanyPerformerInfo() {
		return companyPerformerInfo;
	}

	public void setCompanyPerformerInfo(CompanyPerformerInfo companyPerformerInfo) {
		this.companyPerformerInfo = companyPerformerInfo;
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
		result = prime * result + ((companyPerformerInfo == null) ? 0 : companyPerformerInfo.hashCode());
		result = prime * result + ((legalPerformerInfo == null) ? 0 : legalPerformerInfo.hashCode());
		result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
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
		if (companyPerformerInfo == null) {
			if (other.companyPerformerInfo != null)
				return false;
		} else if (!companyPerformerInfo.equals(other.companyPerformerInfo))
			return false;
		if (legalPerformerInfo == null) {
			if (other.legalPerformerInfo != null)
				return false;
		} else if (!legalPerformerInfo.equals(other.legalPerformerInfo))
			return false;
		if (ownership == null) {
			if (other.ownership != null)
				return false;
		} else if (!ownership.equals(other.ownership))
			return false;
		if (requisites == null) {
			if (other.requisites != null)
				return false;
		} else if (!requisites.equals(other.requisites))
			return false;
		return true;
	}	
	
}
