package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;

public interface OfferingDAO {
	
	Offering create(Offering offering) throws DAOException;
	List<Offering> showOffering() throws DAOException;
	List<Offering> showOfferingPerformer(Performer performer) throws DAOException;
	List<Offering> shorOfferingOrder(Order order) throws DAOException;
	Offering delete(Offering offering) throws DAOException;

}
