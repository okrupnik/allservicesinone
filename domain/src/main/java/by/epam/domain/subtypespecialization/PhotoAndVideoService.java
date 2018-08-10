package by.epam.domain.subtypespecialization;

import by.epam.domain.user.Person;
import by.epam.domain.user.Person.Builder;

public class PhotoAndVideoService {

	private final String typePhotoAndVideoService;

	public String getTypePhotoAndVideoService() {
		return typePhotoAndVideoService;
	}

	private PhotoAndVideoService(Builder builder) {
		this.typePhotoAndVideoService = builder.typePhotoAndVideoService;
	}

	public static class Builder {
		private String typePhotoAndVideoService;

		public Builder setTypePhotoAndVideoService(String typePhotoAndVideoService) {
			this.typePhotoAndVideoService = typePhotoAndVideoService;
			return this;
		}
		
		public PhotoAndVideoService build() {
			return new PhotoAndVideoService(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typePhotoAndVideoService == null) ? 0 : typePhotoAndVideoService.hashCode());
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
		PhotoAndVideoService other = (PhotoAndVideoService) obj;
		if (typePhotoAndVideoService == null) {
			if (other.typePhotoAndVideoService != null)
				return false;
		} else if (!typePhotoAndVideoService.equals(other.typePhotoAndVideoService))
			return false;
		return true;
	}

}
