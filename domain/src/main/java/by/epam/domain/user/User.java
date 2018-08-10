package by.epam.domain.user;

import by.epam.domain.customer.Customer;
import by.epam.domain.performer.Performer;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.service.ServiceStaffInfo.Builder;

public class User {
	
	private final String username;
	private final String password;
	private final String isDelete;	
	private final String email;
	private final String phoneNumber;
	private final String address; 
	private final String photo;
	private final Role role;
	private final Person person;
	private final ServiceStaffInfo serviceStaffInfo;
	private final Customer customer;
	private final Performer performer;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public String getPhoto() {
		return photo;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public Role getRole() {
		return role;
	}

	public Person getPerson() {
		return person;
	}

	public ServiceStaffInfo getServiceStaffInfo() {
		return serviceStaffInfo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Performer getPerformer() {
		return performer;
	}
	
	private User(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.isDelete = builder.isDelete;
		this.email = builder.email;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
		this.photo = builder.photo;
		this.role = builder.role;
		this.person = builder.person;
		this.serviceStaffInfo = builder.serviceStaffInfo;
		this.customer = builder.customer;
		this.performer = builder.performer;
	}
	
	public static class Builder {
		private String username;
		private String password;
		private String isDelete;	
		private String email;
		private String phoneNumber;
		private String address; 
		private String photo;
		private Role role;
		private Person person;
		private ServiceStaffInfo serviceStaffInfo;
		private Customer customer;
		private Performer performer;
		
		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		public Builder setIsDelete(String isDelete) {
			this.isDelete = isDelete;
			return this;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		public Builder setPhoto(String photo) {
			this.photo = photo;
			return this;
		}
		public Builder setRole(Role role) {
			this.role = role;
			return this;
		}
		public Builder setPerson(Person person) {
			this.person = person;
			return this;
		}
		public Builder setServiceStaffInfo(ServiceStaffInfo serviceStaffInfo) {
			this.serviceStaffInfo = serviceStaffInfo;
			return this;
		}
		public Builder setCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}
		public Builder setPerformer(Performer performer) {
			this.performer = performer;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((performer == null) ? 0 : performer.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((serviceStaffInfo == null) ? 0 : serviceStaffInfo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (performer == null) {
			if (other.performer != null)
				return false;
		} else if (!performer.equals(other.performer))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (serviceStaffInfo == null) {
			if (other.serviceStaffInfo != null)
				return false;
		} else if (!serviceStaffInfo.equals(other.serviceStaffInfo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
