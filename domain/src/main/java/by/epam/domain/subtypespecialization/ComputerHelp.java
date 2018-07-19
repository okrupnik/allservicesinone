package by.epam.domain.subtypespecialization;

public class ComputerHelp {

	private String typeComputerHelp;

	public ComputerHelp() {
		
	}

	public ComputerHelp(String typeComputerHelp) {
		this.typeComputerHelp = typeComputerHelp;
	}

	public String getTypeComputerHelp() {
		return typeComputerHelp;
	}

	public void setTypeComputerHelp(String typeComputerHelp) {
		this.typeComputerHelp = typeComputerHelp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeComputerHelp == null) ? 0 : typeComputerHelp.hashCode());
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
		ComputerHelp other = (ComputerHelp) obj;
		if (typeComputerHelp == null) {
			if (other.typeComputerHelp != null)
				return false;
		} else if (!typeComputerHelp.equals(other.typeComputerHelp))
			return false;
		return true;
	}
}
