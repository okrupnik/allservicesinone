package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.user.User;

public interface OfferingDAO {

	List<Offering> getAllOfferingForOrder(final int idOrder, final int offset, final int noOfRecords) throws DAOException;
	
	boolean selectPerformerForOrder(final String username, final int idOrder) throws DAOException;
	
	boolean addOfferfingToOrder(final User user, final int idOrder, final String description) throws DAOException;
	
	List<Offering> getOfferingsOfUser(final User user, final int offset, final int noOfRecords) throws DAOException;
	
	boolean edit(final int idOffering, final String description) throws DAOException;
	
	boolean delete(final int idOffering) throws DAOException;
	
	int getNoOfRecords() throws DAOException;

}
