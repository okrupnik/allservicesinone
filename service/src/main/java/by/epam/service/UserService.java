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
	
	User create(User user, String locale) throws ServiceException;

	User create(User user, Customer customer, String locale) throws ServiceException;

	User create(User user, Performer performer, String locale) throws ServiceException;

	User logination(String username, String password, String locale) throws ServiceException;

	User checkUsername(String username, String locale) throws ServiceException;

	Customer getCustomer(String username, String locale) throws ServiceException;
	
	Performer getPerformer(String username, String locale) throws ServiceException;
	
	boolean editUser(User user, String locale) throws ServiceException;
	
	boolean editCustomer(Customer customer, String locale) throws ServiceException;
	
	boolean editPerformer(Performer performer, String locale) throws ServiceException;
	
	boolean changePassword(User user, String oldPassword, String newPassword, String confirmPassword, String locale) throws ServiceException;
	
	User delete(String username, String locale) throws ServiceException;
}
