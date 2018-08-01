package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;

public interface UserDAO {

	User create(User user) throws DAOException;
	
	User create(User user, Customer customer) throws DAOException;

	User create(User user, Performer performer) throws DAOException;

	User checkUser(String username, String password) throws DAOException;

	String checkUsername(String username) throws DAOException;

	Customer getCustomer(String username) throws DAOException;	

	Performer getPerformer(String username) throws DAOException;

	boolean editCustomer(Customer customer) throws DAOException;

	boolean editPerformer(Performer performer) throws DAOException;
	
	User delete(String username) throws DAOException;
}
