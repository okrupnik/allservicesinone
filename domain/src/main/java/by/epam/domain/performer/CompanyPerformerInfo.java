package by.epam.domain.performer;

public class CompanyPerformerInfo {
	
	private String nameCompany;
	private String nameAgent;
	private String surnameAgent;	
	private String description;
	
	public CompanyPerformerInfo() {
		
	}

	public CompanyPerformerInfo(String nameCompany, String nameAgent, String surnameAgent, String description) {
		this.nameCompany = nameCompany;
		this.nameAgent = nameAgent;
		this.surnameAgent = surnameAgent;
		this.description = description;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getNameAgent() {
		return nameAgent;
	}

	public void setNameAgent(String nameAgent) {
		this.nameAgent = nameAgent;
	}

	public String getSurnameAgent() {
		return surnameAgent;
	}

	public void setSurnameAgent(String surnameAgent) {
		this.surnameAgent = surnameAgent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((nameAgent == null) ? 0 : nameAgent.hashCode());
		result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
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
		CompanyPerformerInfo other = (CompanyPerformerInfo) obj;
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
		if (surnameAgent == null) {
			if (other.surnameAgent != null)
				return false;
		} else if (!surnameAgent.equals(other.surnameAgent))
			return false;
		return true;
	}
	
}
