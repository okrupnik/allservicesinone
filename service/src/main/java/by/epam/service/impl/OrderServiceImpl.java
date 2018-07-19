package by.epam.service.impl;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.OrderService;
import by.epam.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {

	@Override
	public Order create(Order order, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrder(User user, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderCustomer(Customer customer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderPerformer(Performer performer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offering> showOrderOffering(Order order, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(Order order, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
