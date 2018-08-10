package by.epam.domain.performer;

import by.epam.domain.ownership.Ownership;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class Performer {
	
	private final String requisites;
	private final Ownership ownership;
	private final LegalPerformerInfo legalPerformerInfo;
	private final CompanyPerformerInfo companyPerformerInfo;
	
	public String getRequisites() {
		return requisites;
	}

	public LegalPerformerInfo getLegalPerformerInfo() {
		return legalPerformerInfo;
	}

	public CompanyPerformerInfo getCompanyPerformerInfo() {
		return companyPerformerInfo;
	}

	public Ownership getOwnership() {
		return ownership;
	}
	
	private Performer(Builder builder) {
		this.requisites = builder.requisites;
		this.ownership = builder.ownership;
		this.legalPerformerInfo = builder.legalPerformerInfo;
		this.companyPerformerInfo = builder.companyPerformerInfo;
	}
	
	public static class Builder {
		private String requisites;
		private Ownership ownership;
		private LegalPerformerInfo legalPerformerInfo;
		private CompanyPerformerInfo companyPerformerInfo;
		
		public Builder setRequisites(String requisites) {
			this.requisites = requisites;
			return this;
		}
		public Builder setOwnership(Ownership ownership) {
			this.ownership = ownership;
			return this;
		}
		public Builder setLegalPerformerInfo(LegalPerformerInfo legalPerformerInfo) {
			this.legalPerformerInfo = legalPerformerInfo;
			return this;
		}
		public Builder setCompanyPerformerInfo(CompanyPerformerInfo companyPerformerInfo) {
			this.companyPerformerInfo = companyPerformerInfo;
			return this;
		}
		
		public Performer build() {
			return new Performer(this);
		}
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
