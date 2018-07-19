package by.epam.domain.subtypespecialization;

public class InstallAndRepairEquipment {
	
	private String typeInstallAndRepairEquipment;

	public InstallAndRepairEquipment() {
		
	}

	public InstallAndRepairEquipment(String typeInstallAndRepairEquipment) {
		this.typeInstallAndRepairEquipment = typeInstallAndRepairEquipment;
	}

	public String getTypeInstallAndRepairEquipment() {
		return typeInstallAndRepairEquipment;
	}

	public void setTypeInstallAndRepairEquipment(String typeInstallAndRepairEquipment) {
		this.typeInstallAndRepairEquipment = typeInstallAndRepairEquipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((typeInstallAndRepairEquipment == null) ? 0 : typeInstallAndRepairEquipment.hashCode());
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
		InstallAndRepairEquipment other = (InstallAndRepairEquipment) obj;
		if (typeInstallAndRepairEquipment == null) {
			if (other.typeInstallAndRepairEquipment != null)
				return false;
		} else if (!typeInstallAndRepairEquipment.equals(other.typeInstallAndRepairEquipment))
			return false;
		return true;
	}

}
