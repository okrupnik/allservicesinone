package by.epam.dao;

import java.util.List;

import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;

public interface OfferingDAO {
	
	Offering create(final Offering offering) throws DAOException;
	List<Offering> showOffering() throws DAOException;
	List<Offering> showOfferingPerformer(final Performer performer) throws DAOException;
	List<Offering> shorOfferingOrder(final Order order) throws DAOException;
	Offering delete(final Offering offering) throws DAOException;

}
