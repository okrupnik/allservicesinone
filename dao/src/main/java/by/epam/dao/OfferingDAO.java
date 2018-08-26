package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.user.User;

public interface OfferingDAO {

	Offering create(final Offering offering) throws DAOException;

	List<Offering> getAllOfferingForOrder(final int idOrder, final int offset, final int noOfRecords) throws DAOException;
	
	boolean selectPerformerForOrder(final String username, final int idOrder) throws DAOException;
	
	boolean addOfferfingToOrder(final User user, final int idOrder) throws DAOException;
	
	int getNoOfRecords() throws DAOException;

}
