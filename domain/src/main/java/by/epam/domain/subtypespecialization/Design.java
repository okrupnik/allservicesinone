package by.epam.domain.subtypespecialization;

public class Design {

	private String typeDesign;

	public Design() {
		
	}

	public Design(String typeDesign) {
		this.typeDesign = typeDesign;
	}

	public String getTypeDesign() {
		return typeDesign;
	}

	public void setTypeDesign(String typeDesign) {
		this.typeDesign = typeDesign;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeDesign == null) ? 0 : typeDesign.hashCode());
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
		Design other = (Design) obj;
		if (typeDesign == null) {
			if (other.typeDesign != null)
				return false;
		} else if (!typeDesign.equals(other.typeDesign))
			return false;
		return true;
	}

}
