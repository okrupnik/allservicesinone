package by.epam.domain.user;

public class Person {
	
	private final String typePerson;
	
	public String getTypePerson() {
		return typePerson;
	}

	private Person(Builder builder) {
		this.typePerson = builder.typePerson;
	}
	
	public static class Builder {
		private String typePerson;

		public Builder setTypePerson(String typePerson) {
			this.typePerson = typePerson;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typePerson == null) ? 0 : typePerson.hashCode());
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
		Person other = (Person) obj;
		if (typePerson == null) {
			if (other.typePerson != null)
				return false;
		} else if (!typePerson.equals(other.typePerson))
			return false;
		return true;
	}
	
}
