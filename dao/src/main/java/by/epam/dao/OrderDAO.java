package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;

public interface OrderDAO {

	Order create(final User user, final Order order) throws DAOException;

	List<Order> getAllOrderOfUser(final User user, final int offset, final int noOfRecords) throws DAOException;
	
	List<Order> getAllOrdersOfUsers(final int offset, final int noOfRecords) throws DAOException;
	
	Order getOrder(final int orderId) throws DAOException;
	
	boolean editOrder(final Order order) throws DAOException;

	int getNoOfRecords() throws DAOException;
	
	boolean delete(final String idOrder) throws DAOException;
}
