package by.epam.domain.order;

import java.time.LocalDate;

import by.epam.domain.customer.Customer;
import by.epam.domain.ownership.Ownership;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.performer.Performer.Builder;
import by.epam.domain.specialization.Specialization;

public class Order {

	private final int idOrder;
	private final String title;
	private final int idSpecialization;
	private final String description;	
	private final String status;
	private final String subtypeSpecialization;
	private final LocalDate startDate;	
	private final LocalDate dateOfCreating;
	private final String address;
	private final String attachment;
	private final Performer performer;	
		
	public int getIdOrder() {
		return idOrder;
	}

	public String getTitle() {
		return title;
	}

	public int getIdSpecialization() {
		return idSpecialization;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public String getSubtypeSpecialization() {
		return subtypeSpecialization;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getDateOfCreating() {
		return dateOfCreating;
	}

	public String getAddress() {
		return address;
	}

	public String getAttachment() {
		return attachment;
	}

	public Performer getPerformer() {
		return performer;
	}

	private Order(Builder builder) {
		this.idOrder = builder.idOrder;
		this.title = builder.title;
		this.idSpecialization = builder.idSpecialization;
		this.description = builder.description;
		this.status = builder.status;
		this.subtypeSpecialization = builder.subtypeSpecialization;
		this.startDate = builder.startDate;
		this.dateOfCreating = builder.dateOfCreating;
		this.address = builder.address;
		this.attachment = builder.attachment;
		this.performer = builder.performer;
	}

	public static class Builder {
		private int idOrder;
		private String title;
		private int idSpecialization;
		private String description;	
		private String status;
		private String subtypeSpecialization;
		private LocalDate startDate;	
		private LocalDate dateOfCreating;
		private String address;
		private String attachment;
		private Performer performer;	
				
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


		public Builder setStartDate(LocalDate startDate) {
			this.startDate = startDate;
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


		public Builder setPerformer(Performer performer) {
			this.performer = performer;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((dateOfCreating == null) ? 0 : dateOfCreating.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idOrder;
		result = prime * result + idSpecialization;
		result = prime * result + ((performer == null) ? 0 : performer.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subtypeSpecialization == null) ? 0 : subtypeSpecialization.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (idOrder != other.idOrder)
			return false;
		if (idSpecialization != other.idSpecialization)
			return false;
		if (performer == null) {
			if (other.performer != null)
				return false;
		} else if (!performer.equals(other.performer))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
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
		return true;
	}	
	
}
