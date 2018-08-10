package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class InstallAndRepairEquipment {
	
	private final String typeInstallAndRepairEquipment;

	public String getTypeInstallAndRepairEquipment() {
		return typeInstallAndRepairEquipment;
	}

	private InstallAndRepairEquipment(Builder builder) {
		this.typeInstallAndRepairEquipment = builder.typeInstallAndRepairEquipment;
	}

	public static class Builder {
		private String typeInstallAndRepairEquipment;

		public Builder setTypeInstallAndRepairEquipment(String typeInstallAndRepairEquipment) {
			this.typeInstallAndRepairEquipment = typeInstallAndRepairEquipment;
			return this;
		}
		
		public InstallAndRepairEquipment build() {
			return new InstallAndRepairEquipment(this);
		}
		
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
