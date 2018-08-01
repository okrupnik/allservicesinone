package by.epam.domain.customer;

public class LegalCustomerInfo {
	
	private String name;
	private String surname;
	private String requisites;
	private String copyRegistration;
	
	public LegalCustomerInfo() {
		
	}

	public LegalCustomerInfo(String name, String surname, String requisites, String copyRegistration) {
		this.name = name;
		this.surname = surname;
		this.requisites = requisites;
		this.copyRegistration = copyRegistration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRequisites() {
		return requisites;
	}

	public void setRequisites(String requisites) {
		this.requisites = requisites;
	}

	public String getCopyRegistration() {
		return copyRegistration;
	}

	public void setCopyRegistration(String copyRegistration) {
		this.copyRegistration = copyRegistration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copyRegistration == null) ? 0 : copyRegistration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((requisites == null) ? 0 : requisites.hashCode());
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
		LegalCustomerInfo other = (LegalCustomerInfo) obj;
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
		if (requisites == null) {
			if (other.requisites != null)
				return false;
		} else if (!requisites.equals(other.requisites))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}	
	
}
