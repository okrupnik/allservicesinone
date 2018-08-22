package by.epam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.dao.DAOFactory;
import by.epam.dao.OrderDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.OrderService;
import by.epam.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {
	
	public Map<String, String> errorOfCreating = new HashMap<>();
	public Map<String, String> tempDataForError = new HashMap<>();
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	OrderDAO orderDAO = daoFactory.getOrderDAO();

	@Override
	public Order create(User user, Order order, String locale) throws ServiceException {
		errorOfCreating.replaceAll((k, v) -> null);
		errorOfCreating.clear();
		tempDataForError.replaceAll((k, v) -> null);
		tempDataForError.clear();
		
		if (order.getTitle().isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.TITLE_ORDER_PARAM_NAME, "Вы не ввели заголовок");
			} else {
				errorOfCreating.put(ServiceConstant.TITLE_ORDER_PARAM_NAME, "The title is empty");
			}
		}
		
		if (!order.getDescription().isEmpty()) {
			tempDataForError.put(ServiceConstant.DESCRIPTION_ORDER_PARAM_NAME, order.getDescription());
		}
		
		if (!order.getAddress().isEmpty()) {
			tempDataForError.put(ServiceConstant.ADDRESS_ORDER_PARAM_NAME, order.getAddress());
		}
				
		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				order = orderDAO.create(user, order);
				if (order == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания заказа, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating order, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания заказа");
				} else {
					throw new ServiceException("Error of creating order");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы заполнили не все данные");
			} else {
				throw new ServiceException("You did not complete all the data");
			}
		}
		
		return order;
	}

	@Override
	public List<Order> showOrder(final User user, final String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderCustomer(final Customer customer, final String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderPerformer(final Performer performer, final String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offering> showOrderOffering(final Order order, final String locale) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(final Order order, final String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
