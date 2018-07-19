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
	
	Order create(Order order, String locale) throws ServiceException;
	List<Order> showOrder(User user, String locale) throws ServiceException;
	List<Order> showOrderCustomer(Customer customer, String locale) throws ServiceException;
	List<Order> showOrderPerformer(Performer performer, String locale) throws ServiceException;
	List<Offering> showOrderOffering(Order order, String locale) throws DAOException;
	Order delete(Order order, String locale) throws ServiceException;

}
