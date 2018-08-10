package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class CourierService {

	private final String typeCourierService;

	public String getTypeCourierService() {
		return typeCourierService;
	}

	private CourierService(Builder builder) {
		this.typeCourierService = builder.typeCourierService;
	}

	public static class Builder {
		private String typeCourierService;

		public Builder setTypeCourierService(String typeCourierService) {
			this.typeCourierService = typeCourierService;
			return this;
		}
		
		public CourierService build() {
			return new CourierService(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeCourierService == null) ? 0 : typeCourierService.hashCode());
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
		CourierService other = (CourierService) obj;
		if (typeCourierService == null) {
			if (other.typeCourierService != null)
				return false;
		} else if (!typeCourierService.equals(other.typeCourierService))
			return false;
		return true;
	}
}
