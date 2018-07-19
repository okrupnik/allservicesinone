package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;

public interface OrderDAO {

	Order create(Order order) throws DAOException;
	List<Order> showOrder(User user) throws DAOException;
	List<Order> showOrderCustomer(Customer customer) throws DAOException;
	List<Order> showOrderPerformer(Performer performer) throws DAOException;
	List<Offering> showOrderOffering(Order order) throws DAOException;
	Order delete(Order order) throws DAOException;
}
