package by.epam.service;

import java.util.List;

import by.epam.domain.order.Offering;
import by.epam.domain.user.User;
import by.epam.service.exception.ServiceException;

public interface OfferingService {
	
	List<Offering> getAllOfferingForOrder(final String idOrder, final String page, final String locale) throws ServiceException;
	
	boolean selectPerformerForOrder(final String username, final String idOrder, final String locale) throws ServiceException;
	
	boolean addOfferfingToOrder(final User user, final String idOrder, final String locale) throws ServiceException;
}
