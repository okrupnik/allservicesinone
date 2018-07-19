package by.epam.domain.subtypespecialization;

public class CleaningAndHelp {

	private String typeCleaningAndHelp;

	public CleaningAndHelp() {
		
	}

	public CleaningAndHelp(String typeCleaningAndHelp) {
		this.typeCleaningAndHelp = typeCleaningAndHelp;
	}

	public String getTypeCleaningAndHelp() {
		return typeCleaningAndHelp;
	}

	public void setTypeCleaningAndHelp(String typeCleaningAndHelp) {
		this.typeCleaningAndHelp = typeCleaningAndHelp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeCleaningAndHelp == null) ? 0 : typeCleaningAndHelp.hashCode());
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
		CleaningAndHelp other = (CleaningAndHelp) obj;
		if (typeCleaningAndHelp == null) {
			if (other.typeCleaningAndHelp != null)
				return false;
		} else if (!typeCleaningAndHelp.equals(other.typeCleaningAndHelp))
			return false;
		return true;
	}
}
