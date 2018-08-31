package by.epam.service;

import java.util.List;

import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

/**
 * The interface that implements business logic and СRUD operations with {@link User} objects.
 *  
 * @author Oleg Krupnik
 *
 */
public interface UserService {

	/**
	 * Creates a user as a natural customer
	 * 
	 * @param user The customer natural who must be created
	 * @param locale The current locale the user has selected
	 * @return The created natural customer
	 * @throws ServiceException If there are errors during the creation of the user
	 */
	User createCustomerNatural(User user, String locale) throws ServiceException;

	/**
	 * Creates a user as a legal customer
	 * 
	 * @param user The customer legal who must be created
	 * @param locale The current locale the user has selected
	 * @return The created legal customer
	 * @throws ServiceException If there are errors during the creation of the user
	 */
	User createCustomerLegal(User user, String locale) throws ServiceException;

	/**
	 * Creates a user as a company customer
	 * 
	 * @param user The customer company who must be created
	 * @param locale The current locale the user has selected
	 * @return The created company customer
	 * @throws ServiceException If there are errors during the creation of the user
	 */
	User createCustomerCompany(User user, String locale) throws ServiceException;

	/**
	 * Creates a user as a legal performer
	 * 
	 * @param user The legal performer who must be created
	 * @param locale The current locale the user has selected
	 * @return The created legal performer
	 * @throws ServiceException If there are errors during the creation of the user
	 */
	User createPerformerLegal(User user, String locale) throws ServiceException;

	/**
	 * Creates a user as a company performer
	 * 
	 * @param user The company performer who must be created
	 * @param locale The current locale the user has selected
	 * @return The created company performer
	 * @throws ServiceException If there are errors during the creation of the user
	 */
	User createPerformerCompany(User user, String locale) throws ServiceException;

	/**
	 * Validation of entered parameters when creating a user
	 * 
	 * @param user The user whose settings need to check
	 * @param locale The current locale the user has selected
	 * @throws ServiceException If there are errors during the validation of parameters of the user
	 */
	void validateParamUser(User user, String locale) throws ServiceException;
	
	/**
	 * Validation of entered parameters when changing a user
	 * 
	 * @param user The user whose settings need to check
	 * @param locale The current locale the user has selected
	 * @throws ServiceException If there are errors during the validation of parameters of the user
	 */
	void validateParamUserChanging(User user, String locale) throws ServiceException;

	/**
	 * Verify user name and password when authenticating
	 * 
	 * @param username The username entered by user 
	 * @param password The password entered by user 
	 * @param locale The current locale the user has selected
	 * @return A specific user according to the username and password
	 * @throws ServiceException If there are errors during the logination of the user
	 */
	User logination(String username, String password, String locale) throws ServiceException;

	/**
	 * Getting user by username
	 * 
	 * @param username The username entered by user 
	 * @param locale The current locale the user has selected
	 * @return A specific user according to the username
	 * @throws ServiceException If there are errors during the getting of the user
	 */
	User getUser(String username, String locale) throws ServiceException;

	/**
	 * Getting all users for admin
	 * 
	 * @param user The specific user from the administration 
	 * @param page The number of the current page displayed by the administration of users
	 * @param locale The current locale the user has selected
	 * @return The list of selected users for the administration
	 * @throws ServiceException If there are errors during the getting of the list of user
	 */
	List<User> getAllUser(User user, String page, String locale) throws ServiceException;
	
	/**
	 * Getting all users of performer
	 * 
	 * @param page The number of the current page displayed to the user of the received performers
	 * @param locale The current locale the user has selected
	 * @return The list of selected performers
	 * @throws ServiceException If there are errors during the getting of the list of performer
	 */
	List<User> getAllPerformer(String page, String locale) throws ServiceException;

	/**
	 * Changing user information from the administration
	 * 
	 * @param user The user from administration who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editAdministration(User user, String locale) throws ServiceException;

	/**
	 * Changing natural customer information
	 * 
	 * @param user The natural customer  user who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editCustomerNatural(User user, String locale) throws ServiceException;

	/**
	 * Changing legal customer information
	 * 
	 * @param user The legal customer  user who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editCustomerLegal(User user, String locale) throws ServiceException;

	/**
	 * Changing company customer information
	 * 
	 * @param user The company customer  user who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editCustomerCompany(User user, String locale) throws ServiceException;

	/**
	 * Changing legal performer information
	 * 
	 * @param user The legal performer  user who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editPerformerLegal(User user, String locale) throws ServiceException;

	/**
	 * Changing company performer information
	 * 
	 * @param user The company performer  user who must be changed
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the user
	 */
	boolean editPerformerCompany(User user, String locale) throws ServiceException;

	/**
	 * Changing password of user
	 * 
	 * @param user The user whose password should to change
	 * @param oldPassword The old password of user
	 * @param newPassword The new password of user
	 * @param confirmPassword The confirmation of the new password of user
	 * @param locale The current locale the user has selected
	 * @return True if the password was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of the password of user
	 */
	boolean changePassword(User user, String oldPassword, String newPassword, String confirmPassword, String locale) throws ServiceException;

	/**
	 * Deleting user
	 * 
	 * @param username The username who need to delete
	 * @param locale The current locale the user has selected
	 * @return True if the user was deleted successfully, false if not
	 * @throws ServiceException If there are errors during the deleting of user
	 */
	boolean delete(String username, String locale) throws ServiceException;
}
