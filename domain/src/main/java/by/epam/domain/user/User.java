package by.epam.domain.user;

import by.epam.domain.customer.Customer;
import by.epam.domain.performer.Performer;
import by.epam.domain.service.ServiceStaffInfo;

public class User {
	
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
	
	public User() {

	}	

	public User(String username, String isDelete) {
		this.username = username;
		this.isDelete = isDelete;
	}
	
	public User(String username, String isDelete, Role role, Person person) {
		this.username = username;
		this.isDelete = isDelete;
		this.role = role;
		this.person = person;
	}	

	public User(String username, String isDelete, String email, String phoneNumber,
			String address, String photo, Role role, Person person, ServiceStaffInfo serviceStaffInfo) {
		this.username = username;
		this.isDelete = isDelete;		
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.serviceStaffInfo = serviceStaffInfo;
	}

	public User(String username, String password, String isDelete, String email, String phoneNumber, String address,
			String photo, Role role, Person person, ServiceStaffInfo serviceStaffInfo) {
		this.username = username;
		this.password = password;
		this.isDelete = isDelete;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.serviceStaffInfo = serviceStaffInfo;
	}

	public User(String username,String isDelete, String email, String phoneNumber,
			String address, String photo, Role role, Person person, Customer customer) {
		this.username = username;
		this.isDelete = isDelete;		
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.customer = customer;
	}

	public User(String username, String password, String isDelete, String email, String phoneNumber, String address,
			String photo, Role role, Person person, Customer customer) {
		this.username = username;
		this.password = password;
		this.isDelete = isDelete;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.customer = customer;
	}

	public User(String username, String isDelete, String email, String phoneNumber,
			String address, String photo, Role role, Person person, Performer performer) {
		this.username = username;
		this.isDelete = isDelete;		
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.performer = performer;
	}

	public User(String username, String password, String isDelete, String email, String phoneNumber, String address,
			String photo, Role role, Person person, Performer performer) {
		this.username = username;
		this.password = password;
		this.isDelete = isDelete;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photo = photo;
		this.role = role;
		this.person = person;
		this.performer = performer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ServiceStaffInfo getServiceStaffInfo() {
		return serviceStaffInfo;
	}

	public void setServiceStaffInfo(ServiceStaffInfo serviceStaffInfo) {
		this.serviceStaffInfo = serviceStaffInfo;
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
