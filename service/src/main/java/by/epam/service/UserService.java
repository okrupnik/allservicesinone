package by.epam.service;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface UserService {

	User create(User user, Customer customer, String locale) throws DAOException;

	User create(User user, Performer performer, String locale) throws DAOException;

	User logination(String login, String password, String locale) throws ServiceException;

	User checkLoginUser(String login, String locale) throws ServiceException;

	Customer getCustomer(String login, String locale) throws DAOException;
	
	Performer getPerformer(String login, String locale) throws DAOException;
	
	boolean editCustomer(Customer customer, String locale) throws DAOException;
	
	boolean editPerformer(Performer performer, String locale) throws DAOException;
	
	User delete(String login, String locale) throws ServiceException;
}
