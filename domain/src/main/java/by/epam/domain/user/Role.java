package by.epam.domain.user;

public class Role {
	
	private String typeRole;

	public Role() {

	}

	public Role(String typeRole) {
		this.typeRole = typeRole;
	}

	public String getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeRole == null) ? 0 : typeRole.hashCode());
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
		Role other = (Role) obj;
		if (typeRole == null) {
			if (other.typeRole != null)
				return false;
		} else if (!typeRole.equals(other.typeRole))
			return false;
		return true;
	}
	
}
