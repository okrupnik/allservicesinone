package by.epam.dao;

import by.epam.dao.impl.SQLOrderDAO;
import by.epam.dao.impl.SQLSpecializationDAO;
import by.epam.dao.impl.SQLUserDAO;

public class DAOFactory {
	
private static final DAOFactory instance = new DAOFactory();
	
	private static final UserDAO userDAO = new SQLUserDAO();
	private static final OrderDAO orderDAO = new SQLOrderDAO();
	private static final SpecializationDAO specializationDAO = new SQLSpecializationDAO();

	private DAOFactory() {	
	}
	
	public static DAOFactory getInstance() {		
		return instance;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public SpecializationDAO getSpecializationDAO() {
		return specializationDAO;
	}
}
