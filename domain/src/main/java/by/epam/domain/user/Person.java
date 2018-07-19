package by.epam.domain.user;

public class Person {
	
	private String typePerson;

	public Person() {

	}

	public Person(String typePerson) {
		this.typePerson = typePerson;
	}

	public String getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
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
