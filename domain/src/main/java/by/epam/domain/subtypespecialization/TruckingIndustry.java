package by.epam.domain.subtypespecialization;

public class TruckingIndustry {

	private String typeTrucking;

	public TruckingIndustry() {
		
	}

	public TruckingIndustry(String typeTrucking) {
		this.typeTrucking = typeTrucking;
	}

	public String getTypeTrucking() {
		return typeTrucking;
	}

	public void setTypeTrucking(String typeTrucking) {
		this.typeTrucking = typeTrucking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeTrucking == null) ? 0 : typeTrucking.hashCode());
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
		TruckingIndustry other = (TruckingIndustry) obj;
		if (typeTrucking == null) {
			if (other.typeTrucking != null)
				return false;
		} else if (!typeTrucking.equals(other.typeTrucking))
			return false;
		return true;
	}
	
	
}
