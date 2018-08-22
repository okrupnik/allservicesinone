package by.epam.service;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface OrderService {
	
	Order create(final User user, final Order order, final String locale) throws ServiceException;
	List<Order> showOrder(final User user, final String locale) throws ServiceException;
	List<Order> showOrderCustomer(final Customer customer, final String locale) throws ServiceException;
	List<Order> showOrderPerformer(final Performer performer, final String locale) throws ServiceException;
	List<Offering> showOrderOffering(final Order order, final String locale) throws DAOException;
	Order delete(final Order order, final String locale) throws ServiceException;

}
