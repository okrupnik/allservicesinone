package by.epam.service;

import java.util.List;

import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

/**
 * The interface that implements business logic and СRUD operations with {@link Offering} objects.
 *  
 * @author Oleg Krupnik
 *
 */
public interface OfferingService {
	
	/**
	 * Getting all offering the specific order
	 * 
	 * @param idOrder The id of order, offerings of which need to get
	 * @param page The number of the current page that displays the list of offerings for order
	 * @param locale  The current locale the user has selected
	 * @return The list of all offerings for order
	 * @throws ServiceException If there are errors during the getting of offerings
	 */
	List<Offering> getAllOfferingForOrder(String idOrder, String page, String locale) throws ServiceException;
	
	/**
	 * Selecting specific user by username on the concrete order
	 * 
	 * @param username The name of user who is selected for the order
	 * @param idOrder The id of order, for which was selected user
	 * @param locale The current locale the user has selected
	 * @return True if user was selected successfully, false if not
	 * @throws ServiceException If there are errors during the selecting user for order
	 */ 
	boolean selectPerformerForOrder(String username, String idOrder, String locale) throws ServiceException;
	
	/**
	 * Add offering on the concrete order for specific user
	 * 
	 * @param user The user who add offering on the order
	 * @param idOrder The id of order, for which need to add offering
	 * @param description The description of offering
	 * @param locale The current locale the user has selected
	 * @return True if offering was added successfully, false if not
	 * @throws ServiceException If there are errors during the adding offering for order
	 */
	boolean addOfferfingToOrder(User user, String idOrder, String description, String locale) throws ServiceException;
	
	/**
	 * To receive a list of offerings a particular user
	 * 
	 * @param user The user whose offerings we want to receive
	 * @param page The number of the current page that displays the list of user offerings
	 * @param locale The current locale the user has selected
	 * @return The list of specific user offerings
	 * @throws ServiceException If there are errors during the getting of the list offering
	 */
	List<Offering> getOfferingsOfUser(User user, String page, String locale) throws ServiceException;
	
	/**
	 * Changing information of offering
	 * 
	 * @param idOffering The id of offering which need to change
	 * @param description The description of offering
	 * @param locale The current locale the user has selected
	 * @return True if offering was changed successfully, false if not
	 * @throws ServiceException If there are errors during the editing of offering
	 */
	boolean edit(String idOffering, String description, String locale) throws ServiceException;
	
	/**
	 * To receive a list of offerings a particular user for admin
	 * 
	 * @param user The user whose offerings we want to receive
	 * @param page The number of the current page that displays the list of user offerings
	 * @param locale The current locale the user has selected
	 * @return The list of specific user offerings
	 * @throws ServiceException If there are errors during the getting of the list offering
	 */
	List<Offering> getOfferingsOfUserByAdmin(User user, String page, String locale) throws ServiceException;
	
	/**
	 * Deleting the specific offering by idOffering
	 * 
	 * @param idOffering The id of offeiring,  which need to delete
	 * @param locale The current locale the user has selected
	 * @return if offering was delete successfully, false if not
	 * @throws ServiceException If there are errors during the deleting of offering
	 */
	boolean delete(String idOffering, String locale) throws ServiceException;
}
