package by.epam.domain.user;

import by.epam.domain.user.Person.Builder;

public class Role {
	
	private final String typeRole;
	
	public String getTypeRole() {
		return typeRole;
	}

	private Role(Builder builder) {
		this.typeRole = builder.typeRole;
	}

	public static class Builder {
		private String typeRole;

		public Builder setTypeRole(String typeRole) {
			this.typeRole = typeRole;
			return this;
		}
		
		public Role build() {
			return new Role(this);
		}
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
