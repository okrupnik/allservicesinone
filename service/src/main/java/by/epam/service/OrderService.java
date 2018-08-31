package by.epam.service;

import java.util.List;

import by.epam.domain.order.Order;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

/**
 * The interface that implements business logic and СRUD operations with {@link Order} objects.
 *  
 * @author Oleg Krupnik
 *
 */
public interface OrderService {

	/**
	 * Creates a order of different customer
	 * 
	 * @param user The user who want to create an order
	 * @param order The order that the user wants to create on the entered parameters
	 * @param locale The current locale the user has selected
	 * @return The is created order
	 * @throws ServiceException If there are errors during the creation of the order
	 */
	Order create(User user, Order order, String locale) throws ServiceException;

	/**
	 * To receive a list of orders a particular user
	 * 
	 * @param user The user whose orders we want to receive
	 * @param page The number of the current page that displays the list of user orders
	 * @param locale The current locale the user has selected
	 * @return The list of specific user orders
	 * @throws ServiceException If there are errors during the getting of the list order
	 */
	List<Order> getAllOrderOfUser(User user, String page, String locale) throws ServiceException;
	
	/**
	 * To receive a list of orders all user
	 * 
	 * @param page The number of the current page that displays the list of all user orders
	 * @param locale The current locale the user has selected
	 * @return The list of all user orders
	 * @throws ServiceException If there are errors during the getting of the list order
	 */
	List<Order> getAllOrdersOfUsers(String page, String locale) throws ServiceException;

	/**
	 * To receive an order by idOrder
	 * 
	 * @param orderId The id of order, which exists in DataBase
	 * @param locale The current locale the user has selected
	 * @return The getting order
	 * @throws ServiceException If there are errors during the getting of order
	 */
	Order getOrder(String orderId, String locale) throws ServiceException;
	
	/**
	 * Changing information of order
	 * 
	 * @param order The order which need to change
	 * @param locale The current locale the user has selected
	 * @return True if information was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing of order
	 */
	boolean editOrder(Order order, String locale) throws ServiceException;
	
	/**
	 * Changing information about status of order
	 * 
	 * @param idOrder The id of order, the status of which need to change
	 * @param locale The current locale the user has selected
	 * @return True if status was changed successfully, false if not
	 * @throws ServiceException If there are errors during the changing status of order
	 */
	boolean changeStatusOrder(String idOrder, String locale) throws ServiceException;
	
	/**
	 * Deleting the specific order by idOrder
	 * 
	 * @param idOrder The id of order,  which need to delete
	 * @param locale The current locale the user has selected
	 * @return True if order was delete successfully, false if not
	 * @throws ServiceException If there are errors during the deleting of order
	 */
	boolean delete(String idOrder, String locale) throws ServiceException;

}
