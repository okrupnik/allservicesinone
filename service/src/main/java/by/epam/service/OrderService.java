package by.epam.service;

import java.util.List;

import by.epam.domain.order.Order;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface OrderService {

	Order create(final User user, final Order order, final String locale) throws ServiceException;

	List<Order> getAllOrderOfUser(final User user, final String page, final String locale) throws ServiceException;
	
	List<Order> getAllOrdersOfUsers(final String page, final String locale) throws ServiceException;

	Order getOrder(final String orderId, final String locale) throws ServiceException;
	
	boolean editOrder(final Order order, final String locale) throws ServiceException;
	
	boolean changeStatusOrder(final String idOrder, final String locale) throws ServiceException;
	
	boolean delete(final String idOrder, final String locale) throws ServiceException;

}
