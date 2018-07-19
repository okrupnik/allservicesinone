package by.epam.domain.subtypespecialization;

public class RepairAndConstruction {
	
	private String typeRepairAndConstruction;

	public RepairAndConstruction() {
		
	}

	public RepairAndConstruction(String typeRepairAndConstruction) {
		this.typeRepairAndConstruction = typeRepairAndConstruction;
	}

	public String getTypeRepairAndConstruction() {
		return typeRepairAndConstruction;
	}

	public void setTypeRepairAndConstruction(String typeRepairAndConstruction) {
		this.typeRepairAndConstruction = typeRepairAndConstruction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeRepairAndConstruction == null) ? 0 : typeRepairAndConstruction.hashCode());
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
		RepairAndConstruction other = (RepairAndConstruction) obj;
		if (typeRepairAndConstruction == null) {
			if (other.typeRepairAndConstruction != null)
				return false;
		} else if (!typeRepairAndConstruction.equals(other.typeRepairAndConstruction))
			return false;
		return true;
	}
}
