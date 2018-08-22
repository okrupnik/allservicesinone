package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;

public interface OrderDAO {

	Order create(final User user, final Order order) throws DAOException;
	List<Order> showOrder(final User user) throws DAOException;
	List<Order> showOrderCustomer(final Customer customer) throws DAOException;
	List<Order> showOrderPerformer(final Performer performer) throws DAOException;
	List<Offering> showOrderOffering(final Order order) throws DAOException;
	Order delete(final Order order) throws DAOException;
}
