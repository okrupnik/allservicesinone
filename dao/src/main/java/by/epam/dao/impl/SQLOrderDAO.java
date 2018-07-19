package by.epam.dao.impl;

import java.util.List;

import by.epam.dao.OrderDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;

public class SQLOrderDAO implements OrderDAO {

	@Override
	public Order create(Order order) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrder(User user) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderCustomer(Customer customer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderPerformer(Performer performer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(Order order) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offering> showOrderOffering(Order order) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
