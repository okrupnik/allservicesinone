package by.epam.dao.impl;

public class SQLRequest {
	
	public static final String CHECK_USER = "SELECT users.username, users.password, users.isDelete, users.email, users.phoneNumber, users.address, users.photo, roles.role, persons.typePerson FROM allservices.users, allservices.roles, allservices.persons WHERE roles.id=users.roles_id AND persons.id=users.persons_id AND users.username=? AND users.password=?";
	public static final String SELECT_SERVICE_STAFF = "SELECT servicestaff.name, servicestaff.surname FROM allservices.users, allservices.servicestaff WHERE users.id=servicestaff.users_id AND users.username=?";
	public static final String SELECT_CUSTOMER = "SELECT ownerships.formOwnership FROM allservices.users, allservices.customers, allservices.ownerships WHERE ownerships.id=customers.ownerships_id AND users.id=customers.users_id AND users.username=?";
	public static final String SELECT_CUSTOMER_NATURAL = "SELECT infonaturalcustomers.name, infonaturalcustomers.surname FROM allservices.infonaturalcustomers, allservices.customers, allservices.users WHERE customers.id=infonaturalcustomers.customers_id AND users.id=customers.users_id AND users.username=?";
	public static final String SELECT_CUSTOMER_LEGAL = "SELECT infolegalcustomers.name, infolegalcustomers.surname, infolegalcustomers.requisites, infolegalcustomers.copyregistration FROM allservices.infolegalcustomers, allservices.customers, allservices.users WHERE customers.id=infolegalcustomers.customers_id AND users.id=customers.users_id AND users.username=?";
	public static final String SELECT_CUSTOMER_COMPANY = "SELECT infocompanycustomers.nameCompany, infocompanycustomers.nameAgent, infocompanycustomers.surnameAgent, infocompanycustomers.requisites, infocompanycustomers.description FROM allservices.infocompanycustomers, allservices.customers, allservices.users WHERE customers.id=infocompanycustomers.customers_id AND users.id=customers.users_id AND users.username=?";
	public static final String SELECT_PERFORMER = "SELECT performers.requisites, ownerships.formOwnership FROM allservices.users, allservices.performers, allservices.ownerships WHERE ownerships.id=performers.ownerships_id AND users.id=performers.users_id AND users.username=?";
	public static final String SELECT_PERFORMER_LEGAL = "SELECT infolegalperformers.name, infolegalperformers.surname, infolegalperformers.copyRegistration FROM allservices.infolegalperformers, allservices.performers, allservices.users WHERE performers.id=infolegalperformers.performers_id AND users.id=performers.users_id AND users.username=?";
	public static final String SELECT_PERFORMER_COMPANY = "SELECT infocompanyperformers.nameCompany, infocompanyperformers.nameAgent, infocompanyperformers.surnameAgent, infocompanyperformers.description FROM allservices.infocompanyperformers, allservices.performers, allservices.users WHERE performers.id=infocompanyperformers.performers_id AND users.id=performers.users_id AND users.username=?";
	public static final String EXIST_USER = "SELECT users.username FROM allservices.users WHERE users.username=?";
	public static final String SELECT_ROLE_USER = "SELECT roles.id FROM allservices.roles, allservices.users WHERE roles.id=users.roles_id AND roles.role=?";
	public static final String SELECT_PERSON_USER = "SELECT persons.id FROM allservices.persons, allservices.users WHERE persons.id=users.persons_id AND persons.typePerson=?";
	public static final String CREATE_USER = "INSERT INTO allservices.users (users.username, users.password, users.isDelete, users.email, users.phoneNumber, users.address, users.photo, users.roles_id, users.persons_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private SQLRequest() {
	}	
}
