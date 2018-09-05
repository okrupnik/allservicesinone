package by.epam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.dao.DAOFactory;
import by.epam.dao.OrderDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.order.Order;
import by.epam.domain.page.PageDetail;
import by.epam.domain.user.User;
import by.epam.service.OrderService;
import by.epam.service.exception.ServiceException;

public class OrderServiceImpl implements OrderService {
	
	public Map<String, String> errorOfCreating = new HashMap<>();
	public Map<String, String> tempDataForError = new HashMap<>();
	public Map<String, Integer> pagesDetails = new HashMap<>();	
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	OrderDAO orderDAO = daoFactory.getOrderDAO();

	public OrderServiceImpl() {
	}

	public OrderServiceImpl(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order create(final User user, Order order, final String locale) throws ServiceException {
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
		
		if (order.getDescription() != null && !order.getDescription().isEmpty()) {
			tempDataForError.put(ServiceConstant.DESCRIPTION_ORDER_PARAM_NAME, order.getDescription());
		}
		
		if (order.getAddress() != null && !order.getAddress().isEmpty()) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrderOfUser(final User user, final String page, final String locale) throws ServiceException {
		List<Order> orderList = null;
		int currentPage = 1;
		int noOfRecords = 0;
		int noOfPages = 0;		
		int recordsPerPage = 4;
		
		try {
			if(page != null) {
				currentPage = Integer.parseInt(page);
			}
			orderList = orderDAO.getAllOrderOfUser(user, (currentPage-1)*recordsPerPage, recordsPerPage);
			noOfRecords = orderDAO.getNoOfRecords();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			pagesDetails.put(ServiceConstant.NO_OF_PAGES_PARAM_NAME, noOfPages);
			pagesDetails.put(ServiceConstant.CURRENT_PAGE_PARAM_NAME, currentPage);
			PageDetail.setPagesDetails(pagesDetails);
			if (orderList.isEmpty() || orderList == null) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Список пуст");
				} else {
					throw new ServiceException("Orders list is empty");
				}
			}
		} catch (DAOException e) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Невозможно получить список заданий, попробуйте позже");
			} else {
				throw new ServiceException("Impossible to get users list, try it later");
			}
		}
		
		return orderList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order getOrder(final String orderId, final String locale) throws ServiceException {		
		Order order = null;
		
		if(orderId != null && !orderId.isEmpty()) {
			try {
				order = orderDAO.getOrder(Integer.parseInt(orderId));
			} catch (NumberFormatException | DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка редактирования заказа");
				} else {
					throw new ServiceException("Error of editing order");
				}	
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Заказ не найден");
			} else {
				throw new ServiceException("The order is not found");
			}
		}
		
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editOrder(final Order order, final String locale) throws ServiceException {
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
		
		if (order.getDescription() != null && !order.getDescription().isEmpty()) {
			tempDataForError.put(ServiceConstant.DESCRIPTION_ORDER_PARAM_NAME, order.getDescription());
		}
		
		if (order.getAddress() != null && !order.getAddress().isEmpty()) {
			tempDataForError.put(ServiceConstant.ADDRESS_ORDER_PARAM_NAME, order.getAddress());
		}
				
		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (orderDAO.editOrder(order)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка изменения заказа");
					} else {
						throw new ServiceException("Error of changing order");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка изменения заказа");
				} else {
					throw new ServiceException("Error of changing order");
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
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(final String idOrder, final String locale) throws ServiceException {
		
		if (idOrder != null && !idOrder.isEmpty()) {
			try {				
				if (orderDAO.delete(idOrder)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка удаления заказа, попробуйте позже");
					} else {
						throw new ServiceException("Error of deleting order, try it later");
					}
				}	
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка удаления заказа");
				} else {
					throw new ServiceException("Error of deleting order");
				}	
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Заказ не найден");
			} else {
				throw new ServiceException("The order is not found");
			}	
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrdersOfUsers(final String page, final String locale) throws ServiceException {
		
		List<Order> orderList = null;
		int currentPage = 1;
		int noOfRecords = 0;
		int noOfPages = 0;		
		int recordsPerPage = 4;
		
		try {
			if(page != null) {
				currentPage = Integer.parseInt(page);
			}
			orderList = orderDAO.getAllOrdersOfUsers((currentPage-1)*recordsPerPage, recordsPerPage);
			noOfRecords = orderDAO.getNoOfRecords();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			pagesDetails.put(ServiceConstant.NO_OF_PAGES_PARAM_NAME, noOfPages);
			pagesDetails.put(ServiceConstant.CURRENT_PAGE_PARAM_NAME, currentPage);
			PageDetail.setPagesDetails(pagesDetails);
			if (orderList.isEmpty() || orderList == null) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Список пуст");
				} else {
					throw new ServiceException("Orders list is empty");
				}
			}
		} catch (DAOException e) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Невозможно получить список заданий, попробуйте позже");
			} else {
				throw new ServiceException("Impossible to get users list, try it later");
			}
		}
		
		return orderList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean changeStatusOrder(String idOrder, String locale) throws ServiceException {
		if (idOrder != null && !idOrder.isEmpty()) {
			try {				
				if (orderDAO.changeStatusOrder(Integer.parseInt(idOrder))) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка изменения статуса заказа, попробуйте позже");
					} else {
						throw new ServiceException("Error of changing of status of order, try it later");
					}
				}	
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка изменения статуса заказа");
				} else {
					throw new ServiceException("Error of changing of status of order");
				}	
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Заказ не найден");
			} else {
				throw new ServiceException("The order is not found");
			}	
		}		
	}

	
}
