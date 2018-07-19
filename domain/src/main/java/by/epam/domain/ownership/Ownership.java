package by.epam.domain.ownership;

public class Ownership {
	
	private String formOwnership;

	public Ownership() {

	}

	public Ownership(String formOwnership) {
		this.formOwnership = formOwnership;
	}

	public String getFormOwnership() {
		return formOwnership;
	}

	public void setFormOwnership(String formOwnership) {
		this.formOwnership = formOwnership;
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
