package by.epam.service.impl;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public User create(User user, Customer customer, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user, Performer performer, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logination(String login, String password, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkLoginUser(String login, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String login, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Performer getPerformer(String login, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editCustomer(Customer customer, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPerformer(Performer performer, String locale) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User delete(String login, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
