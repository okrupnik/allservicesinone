package by.epam.domain.order;

public class AddressOrderObject {

	private String city;
	private String street;
	private String numberHouse;
	
	public AddressOrderObject() {
		
	}

	public AddressOrderObject(String city, String street, String numberHouse) {
		this.city = city;
		this.street = street;
		this.numberHouse = numberHouse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((numberHouse == null) ? 0 : numberHouse.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressOrderObject other = (AddressOrderObject) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (numberHouse == null) {
			if (other.numberHouse != null)
				return false;
		} else if (!numberHouse.equals(other.numberHouse))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
