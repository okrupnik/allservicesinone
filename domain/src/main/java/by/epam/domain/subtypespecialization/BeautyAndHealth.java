package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class BeautyAndHealth {
	
	private final String typeBeautyAndHealth;

	public String getTypeBeautyAndHealth() {
		return typeBeautyAndHealth;
	}
	
	private BeautyAndHealth(Builder builder) {
		this.typeBeautyAndHealth = builder.typeBeautyAndHealth;
	}
	
	public static class Builder {
		private String typeBeautyAndHealth;
		
		public Builder setTypeBeautyAndHealth(String typeBeautyAndHealth) {
			this.typeBeautyAndHealth = typeBeautyAndHealth;
			return this;
		}

		public BeautyAndHealth build() {
			return new BeautyAndHealth(this);
		}
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
