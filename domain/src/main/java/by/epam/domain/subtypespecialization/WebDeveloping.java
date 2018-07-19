package by.epam.domain.subtypespecialization;

public class WebDeveloping {

	private String typeWebDeveloping;

	public WebDeveloping() {
		
	}

	public WebDeveloping(String typeWebDeveloping) {
		this.typeWebDeveloping = typeWebDeveloping;
	}

	public String getTypeWebDeveloping() {
		return typeWebDeveloping;
	}

	public void setTypeWebDeveloping(String typeWebDeveloping) {
		this.typeWebDeveloping = typeWebDeveloping;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeWebDeveloping == null) ? 0 : typeWebDeveloping.hashCode());
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
		WebDeveloping other = (WebDeveloping) obj;
		if (typeWebDeveloping == null) {
			if (other.typeWebDeveloping != null)
				return false;
		} else if (!typeWebDeveloping.equals(other.typeWebDeveloping))
			return false;
		return true;
	}

}
