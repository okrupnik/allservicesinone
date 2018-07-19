package by.epam.domain.subtypespecialization;

public class BeautyAndHealth {
	
	private String typeBeautyAndHealth;

	public BeautyAndHealth() {
		
	}

	public BeautyAndHealth(String typeBeautyAndHealth) {
		this.typeBeautyAndHealth = typeBeautyAndHealth;
	}

	public String getTypeBeautyAndHealth() {
		return typeBeautyAndHealth;
	}

	public void setTypeBeautyAndHealth(String typeBeautyAndHealth) {
		this.typeBeautyAndHealth = typeBeautyAndHealth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeBeautyAndHealth == null) ? 0 : typeBeautyAndHealth.hashCode());
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
		BeautyAndHealth other = (BeautyAndHealth) obj;
		if (typeBeautyAndHealth == null) {
			if (other.typeBeautyAndHealth != null)
				return false;
		} else if (!typeBeautyAndHealth.equals(other.typeBeautyAndHealth))
			return false;
		return true;
	}

}
