package by.epam.service;

import java.util.List;

import by.epam.domain.customer.Customer;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface UserService {
	
	User create(final User user, final String locale) throws ServiceException;

	User create(final User user, final Customer customer, final String locale) throws ServiceException;

	User create(final User user, final Performer performer, final String locale) throws ServiceException;

	User logination(final String username, final String password, final String locale) throws ServiceException;

	User checkUsername(final String username, final String locale) throws ServiceException;
	
	User getUser(final String username, final String locale) throws ServiceException;
	
	List<User> getAllUser(final User user, final String page, final String locale) throws ServiceException;

	Customer getCustomer(final String username, final String locale) throws ServiceException;
	
	Performer getPerformer(final String username, final String locale) throws ServiceException;
	
	boolean editUser(final User user, final String locale) throws ServiceException;
	
	boolean editCustomer(final Customer customer, final String locale) throws ServiceException;
	
	boolean editPerformer(final Performer performer, final String locale) throws ServiceException;
	
	boolean changePassword(final User user, final String oldPassword, final String newPassword, final String confirmPassword, final String locale) throws ServiceException;
	
	boolean delete(final String username, final String locale) throws ServiceException;
}
