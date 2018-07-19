package by.epam.domain.order;

import java.time.LocalDate;

import by.epam.domain.customer.Customer;
import by.epam.domain.performer.Performer;
import by.epam.domain.specialization.Specialization;

public class Order {

	private int idOrder;
	private String title;
	private String description;
	private String attachment;
	private LocalDate startDate;
	private String status;
	private String subtypeSpecialization;
	private LocalDate dateOfCreating;
	private Customer customer;
	private Performer performer;
	private AddressOrderObject addressOrderObject;
	private Specialization specialization;

	public Order() {

	}

	public Order(String title, String description, String attachment, LocalDate startDate, String status,
			String subtypeSpecialization, LocalDate dateOfCreating, Customer customer,
			AddressOrderObject addressOrderObject, Specialization specialization) {
		this.title = title;
		this.description = description;
		this.attachment = attachment;
		this.startDate = startDate;
		this.status = status;
		this.subtypeSpecialization = subtypeSpecialization;
		this.dateOfCreating = dateOfCreating;
		this.customer = customer;
		this.addressOrderObject = addressOrderObject;
		this.specialization = specialization;
	}

	public Order(int idOrder, String title, String description, String attachment, LocalDate startDate, String status,
			String subtypeSpecialization, LocalDate dateOfCreating, Customer customer,
			AddressOrderObject addressOrderObject, Specialization specialization) {
		this.idOrder = idOrder;
		this.title = title;
		this.description = description;
		this.attachment = attachment;
		this.startDate = startDate;
		this.status = status;
		this.subtypeSpecialization = subtypeSpecialization;
		this.dateOfCreating = dateOfCreating;
		this.customer = customer;
		this.addressOrderObject = addressOrderObject;
		this.specialization = specialization;
	}

	public Order(int idOrder, String title, String description, String attachment, LocalDate startDate, String status,
			String subtypeSpecialization, LocalDate dateOfCreating, Customer customer, Performer performer,
			AddressOrderObject addressOrderObject, Specialization specialization) {
		this.idOrder = idOrder;
		this.title = title;
		this.description = description;
		this.attachment = attachment;
		this.startDate = startDate;
		this.status = status;
		this.subtypeSpecialization = subtypeSpecialization;
		this.dateOfCreating = dateOfCreating;
		this.customer = customer;
		this.performer = performer;
		this.addressOrderObject = addressOrderObject;
		this.specialization = specialization;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
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

	public LocalDate getDateOfCreating() {
		return dateOfCreating;
	}

	public void setDateOfCreating(LocalDate dateOfCreating) {
		this.dateOfCreating = dateOfCreating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Performer getPerformer() {
		return performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

	public AddressOrderObject getAddressOrderObject() {
		return addressOrderObject;
	}

	public void setAddressOrderObject(AddressOrderObject addressOrderObject) {
		this.addressOrderObject = addressOrderObject;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressOrderObject == null) ? 0 : addressOrderObject.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateOfCreating == null) ? 0 : dateOfCreating.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idOrder;
		result = prime * result + ((performer == null) ? 0 : performer.hashCode());
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
		if (addressOrderObject == null) {
			if (other.addressOrderObject != null)
				return false;
		} else if (!addressOrderObject.equals(other.addressOrderObject))
			return false;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
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
