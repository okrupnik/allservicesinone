package by.epam.domain.subtypespecialization;

public class PhotoAndVideoService {

	private String typePhotoAndVideoService;

	public PhotoAndVideoService() {
		
	}

	public PhotoAndVideoService(String typePhotoAndVideoService) {
		this.typePhotoAndVideoService = typePhotoAndVideoService;
	}

	public String getTypePhotoAndVideoService() {
		return typePhotoAndVideoService;
	}

	public void setTypePhotoAndVideoService(String typePhotoAndVideoService) {
		this.typePhotoAndVideoService = typePhotoAndVideoService;
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
