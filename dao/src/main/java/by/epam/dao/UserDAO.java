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

	User create(User user, Customer customer) throws DAOException;

	User create(User user, Performer performer) throws DAOException;

	User checkUser(String login, String password) throws DAOException;

	User checkLoginUser(String login) throws DAOException;

	Customer getCustomer(String login) throws DAOException;	

	Performer getPerformer(String login) throws DAOException;

	boolean editCustomer(Customer customer) throws DAOException;

	boolean editPerformer(Performer performer) throws DAOException;
	
	User delete(String login) throws DAOException;
}
