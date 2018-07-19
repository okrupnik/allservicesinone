package by.epam.domain.subtypespecialization;

public class RepairTransport {
	
	private String typeRepairTransport;

	public RepairTransport() {

	}

	public RepairTransport(String typeRepairTransport) {
		this.typeRepairTransport = typeRepairTransport;
	}

	public String getTypeRepairTransport() {
		return typeRepairTransport;
	}

	public void setTypeRepairTransport(String typeRepairTransport) {
		this.typeRepairTransport = typeRepairTransport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeRepairTransport == null) ? 0 : typeRepairTransport.hashCode());
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
		RepairTransport other = (RepairTransport) obj;
		if (typeRepairTransport == null) {
			if (other.typeRepairTransport != null)
				return false;
		} else if (!typeRepairTransport.equals(other.typeRepairTransport))
			return false;
		return true;
	}

}
