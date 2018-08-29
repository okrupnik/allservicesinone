package by.epam.service;

import java.util.List;

import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface UserService {

	User createCustomerNatural(final User user, final String locale) throws ServiceException;

	User createCustomerLegal(final User user, final String locale) throws ServiceException;

	User createCustomerCompany(final User user, final String locale) throws ServiceException;

	User createPerformerLegal(final User user, final String locale) throws ServiceException;

	User createPerformerCompany(final User user, final String locale) throws ServiceException;

	void validateParamUser(final User user, final String locale) throws ServiceException;
	
	void validateParamUserChanging(final User user, final String locale) throws ServiceException;

	User logination(final String username, final String password, final String locale) throws ServiceException;

	User getUser(final String username, final String locale) throws ServiceException;

	List<User> getAllUser(final User user, final String page, final String locale) throws ServiceException;
	
	List<User> getAllPerformer(final String page, final String locale) throws ServiceException;

	boolean editAdministration(final User user, final String locale) throws ServiceException;

	boolean editCustomerNatural(final User user, final String locale) throws ServiceException;

	boolean editCustomerLegal(final User user, final String locale) throws ServiceException;

	boolean editCustomerCompany(final User user, final String locale) throws ServiceException;

	boolean editPerformerLegal(final User user, final String locale) throws ServiceException;

	boolean editPerformerCompany(final User user, final String locale) throws ServiceException;

	boolean changePassword(final User user, final String oldPassword, final String newPassword,
			final String confirmPassword, final String locale) throws ServiceException;

	boolean delete(final String username, final String locale) throws ServiceException;
}
