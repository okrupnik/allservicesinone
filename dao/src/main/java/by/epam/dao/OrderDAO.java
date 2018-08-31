package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;

public interface OrderDAO {
	
	Order create(User user, Order order) throws DAOException;

	List<Order> getAllOrderOfUser(User user, int offset, int noOfRecords) throws DAOException;
	
	List<Order> getAllOrdersOfUsers(int offset, int noOfRecords) throws DAOException;
	
	Order getOrder(int orderId) throws DAOException;
	
	boolean editOrder(Order order) throws DAOException;
	
	boolean changeStatusOrder(int idOrder) throws DAOException;

	int getNoOfRecords() throws DAOException;
	
	boolean delete(String idOrder) throws DAOException;
}
