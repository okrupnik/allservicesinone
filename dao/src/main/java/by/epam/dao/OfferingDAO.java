package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.user.User;

public interface OfferingDAO {

	List<Offering> getAllOfferingForOrder(int idOrder, int offset, int noOfRecords) throws DAOException;
	
	boolean selectPerformerForOrder(String username, int idOrder) throws DAOException;
	
	boolean addOfferfingToOrder(User user, int idOrder, String description) throws DAOException;
	
	List<Offering> getOfferingsOfUser(User user, int offset, int noOfRecords) throws DAOException;
	
	List<Offering> getOfferingsOfUserByAdmin(User user, int offset, int noOfRecords) throws DAOException;
	
	boolean edit(int idOffering, String description) throws DAOException;
	
	boolean delete(int idOffering) throws DAOException;
	
	int getNoOfRecords() throws DAOException;

}
