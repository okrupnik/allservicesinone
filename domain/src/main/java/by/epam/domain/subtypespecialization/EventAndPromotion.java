package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class EventAndPromotion {

	private final String typeEventAndPromotion;

	public String getTypeEventAndPromotion() {
		return typeEventAndPromotion;
	}

	private EventAndPromotion(Builder builder) {
		this.typeEventAndPromotion = builder.typeEventAndPromotion;
	}

	public static class Builder {
		private String typeEventAndPromotion;

		public Builder setTypeEventAndPromotion(String typeEventAndPromotion) {
			this.typeEventAndPromotion = typeEventAndPromotion;
			return this;
		}
		
		public EventAndPromotion build() {
			return new EventAndPromotion(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeEventAndPromotion == null) ? 0 : typeEventAndPromotion.hashCode());
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
		EventAndPromotion other = (EventAndPromotion) obj;
		if (typeEventAndPromotion == null) {
			if (other.typeEventAndPromotion != null)
				return false;
		} else if (!typeEventAndPromotion.equals(other.typeEventAndPromotion))
			return false;
		return true;
	}
}
