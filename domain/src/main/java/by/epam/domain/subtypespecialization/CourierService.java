package by.epam.domain.subtypespecialization;

public class CourierService {

	private String typeCourierService;

	public CourierService() {
		
	}

	public CourierService(String typeCourierService) {
		this.typeCourierService = typeCourierService;
	}

	public String getTypeCourierService() {
		return typeCourierService;
	}

	public void setTypeCourierService(String typeCourierService) {
		this.typeCourierService = typeCourierService;
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
