package by.epam.domain.order;

import java.time.LocalDate;
import java.util.List;

import by.epam.domain.performer.Performer;

public class Order {

	private int idOrder;
	private String title;
	private int idSpecialization;
	private String specialization;
	private String activitieSpecialization;
	private String description;	
	private String status;
	private String subtypeSpecialization;
	private LocalDate endDate;	
	private LocalDate dateOfCreating;
	private String address;
	private String attachment;
	private String usernamePerformer;
	private Performer performer;
	private List<Offering> offeringList;
		
	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIdSpecialization() {
		return idSpecialization;
	}

	public void setIdSpecialization(int idSpecialization) {
		this.idSpecialization = idSpecialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubtypeSpecialization() {
		return subtypeSpecialization;
	}

	public void setSubtypeSpecialization(String subtypeSpecialization) {
		this.subtypeSpecialization = subtypeSpecialization;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getDateOfCreating() {
		return dateOfCreating;
	}

	public void setDateOfCreating(LocalDate dateOfCreating) {
		this.dateOfCreating = dateOfCreating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getUsernamePerformer() {
		return usernamePerformer;
	}

	public void setUsernamePerformer(String usernamePerformer) {
		this.usernamePerformer = usernamePerformer;
	}

	public Performer getPerformer() {
		return performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}
	
	public String getActivitieSpecialization() {
		return activitieSpecialization;
	}

	public void setActivitieSpecialization(String activitieSpecialization) {
		this.activitieSpecialization = activitieSpecialization;
	}

	public List<Offering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(List<Offering> offeringList) {
		this.offeringList = offeringList;
	}

	private Order(Builder builder) {
		this.idOrder = builder.idOrder;
		this.title = builder.title;
		this.idSpecialization = builder.idSpecialization;
		this.specialization = builder.specialization;
		this.activitieSpecialization = builder.activitieSpecialization;
		this.description = builder.description;
		this.status = builder.status;
		this.subtypeSpecialization = builder.subtypeSpecialization;
		this.endDate = builder.endDate;
		this.dateOfCreating = builder.dateOfCreating;
		this.address = builder.address;
		this.attachment = builder.attachment;
		this.usernamePerformer = builder.usernamePerformer;
		this.performer = builder.performer;
		this.offeringList = builder.offeringList;
	}

	public static class Builder {
		private int idOrder;
		private String title;
		private int idSpecialization;
		private String specialization;
		private String activitieSpecialization;
		private String description;	
		private String status;
		private String subtypeSpecialization;
		private LocalDate endDate;	
		private LocalDate dateOfCreating;
		private String address;
		private String attachment;
		private String usernamePerformer;
		private Performer performer;	
		private List<Offering> offeringList;
				
		public Builder setIdOrder(int idOrder) {
			this.idOrder = idOrder;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setIdSpecialization(int idSpecialization) {
			this.idSpecialization = idSpecialization;
			return this;
		}

		public Builder setSpecialization(String specialization) {
			this.specialization = specialization;
			return this;
		}

		public Builder setActivitieSpecialization(String activitieSpecialization) {
			this.activitieSpecialization = activitieSpecialization;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setStatus(String status) {
			this.status = status;
			return this;
		}

		public Builder setSubtypeSpecialization(String subtypeSpecialization) {
			this.subtypeSpecialization = subtypeSpecialization;
			return this;
		}

		public Builder setEndDate(LocalDate endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder setDateOfCreating(LocalDate dateOfCreating) {
			this.dateOfCreating = dateOfCreating;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setAttachment(String attachment) {
			this.attachment = attachment;
			return this;
		}

		public Builder setUsernamePerformer(String usernamePerformer) {
			this.usernamePerformer = usernamePerformer;
			return this;
		}
		
		public Builder setPerformer(Performer performer) {
			this.performer = performer;
			return this;
		}

		public Builder setOffering(List<Offering> offeringList) {
			this.offeringList = offeringList;
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activitieSpecialization == null) ? 0 : activitieSpecialization.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((dateOfCreating == null) ? 0 : dateOfCreating.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idOrder;
		result = prime * result + idSpecialization;
		result = prime * result + ((offeringList == null) ? 0 : offeringList.hashCode());
		result = prime * result + ((performer == null) ? 0 : performer.hashCode());
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subtypeSpecialization == null) ? 0 : subtypeSpecialization.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((usernamePerformer == null) ? 0 : usernamePerformer.hashCode());
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
		Order other = (Order) obj;
		if (activitieSpecialization == null) {
			if (other.activitieSpecialization != null)
				return false;
		} else if (!activitieSpecialization.equals(other.activitieSpecialization))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (dateOfCreating == null) {
			if (other.dateOfCreating != null)
				return false;
		} else if (!dateOfCreating.equals(other.dateOfCreating))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (idOrder != other.idOrder)
			return false;
		if (idSpecialization != other.idSpecialization)
			return false;
		if (offeringList == null) {
			if (other.offeringList != null)
				return false;
		} else if (!offeringList.equals(other.offeringList))
			return false;
		if (performer == null) {
			if (other.performer != null)
				return false;
		} else if (!performer.equals(other.performer))
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subtypeSpecialization == null) {
			if (other.subtypeSpecialization != null)
				return false;
		} else if (!subtypeSpecialization.equals(other.subtypeSpecialization))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (usernamePerformer == null) {
			if (other.usernamePerformer != null)
				return false;
		} else if (!usernamePerformer.equals(other.usernamePerformer))
			return false;
		return true;
	}	
}