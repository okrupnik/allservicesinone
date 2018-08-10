package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class WebDeveloping {

	private final String typeWebDeveloping;

	public String getTypeWebDeveloping() {
		return typeWebDeveloping;
	}

	private WebDeveloping(Builder builder) {
		this.typeWebDeveloping = builder.typeWebDeveloping;
	}

	public static class Builder {
		private String typeWebDeveloping;

		public Builder setTypeWebDeveloping(String typeWebDeveloping) {
			this.typeWebDeveloping = typeWebDeveloping;
			return this;
		}
		
		public WebDeveloping build() {
			return new WebDeveloping(this);
		}
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
