package by.epam.domain.subtypespecialization;

public class EventAndPromotion {

	private String typeEventAndPromotion;

	public EventAndPromotion() {
		
	}

	public EventAndPromotion(String typeEventAndPromotion) {
		this.typeEventAndPromotion = typeEventAndPromotion;
	}

	public String getTypeEventAndPromotion() {
		return typeEventAndPromotion;
	}

	public void setTypeEventAndPromotion(String typeEventAndPromotion) {
		this.typeEventAndPromotion = typeEventAndPromotion;
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
