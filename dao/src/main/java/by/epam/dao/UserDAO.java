package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.user.User;

public interface UserDAO {
	
	User createCustomerNatural(User user) throws DAOException;
	
	User createCustomerLegal(User user) throws DAOException;
	
	User createCustomerCompany(User user) throws DAOException;
	
	User createPerformerLegal(User user) throws DAOException;
	
	User createPerformerCompany(User user) throws DAOException;

	User checkUser(String username, String password) throws DAOException;

	String checkUsername(String username) throws DAOException;
	
	boolean editAdministration(User user) throws DAOException;

	boolean editCustomerNatural(User user) throws DAOException;

	boolean editCustomerLegal(User user) throws DAOException;

	boolean editCustomerCompany(User user) throws DAOException;

	boolean editPerformerLegal(User user) throws DAOException;

	boolean editPerformerCompany(User user) throws DAOException;
	
	User getUser(String username) throws DAOException;
	
	List<User> getAllUser(int offset, int noOfRecords) throws DAOException;
	
	List<User> getAllPerformer(int offset, int noOfRecords) throws DAOException;
	
	String checkPassword(String oldPassword) throws DAOException;
	
	boolean editPassword (User user, String newPassword) throws DAOException;
	
	boolean delete(String username) throws DAOException;
	
	int getNoOfRecords() throws DAOException;
}
