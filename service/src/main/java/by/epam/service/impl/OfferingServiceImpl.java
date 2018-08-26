package by.epam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.dao.DAOFactory;
import by.epam.dao.OfferingDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.page.PageDetail;
import by.epam.domain.user.User;
import by.epam.service.OfferingService;
import by.epam.service.exception.ServiceException;

public class OfferingServiceImpl implements OfferingService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	OfferingDAO offeringDAO = daoFactory.getOfferinDAO();

	public Map<String, Integer> pagesDetails = new HashMap<>();

	@Override
	public List<Offering> getAllOfferingForOrder(final String idOrder, final String page, final String locale)
			throws ServiceException {

		List<Offering> offeringList = null;
		int currentPage = 1;
		int noOfRecords = 0;
		int noOfPages = 0;
		int recordsPerPage = 4;

		try {
			if (page != null) {
				currentPage = Integer.parseInt(page);
			}
			offeringList = offeringDAO.getAllOfferingForOrder(Integer.parseInt(idOrder),
					(currentPage - 1) * recordsPerPage, recordsPerPage);
			noOfRecords = offeringDAO.getNoOfRecords();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			pagesDetails.put(ServiceConstant.NO_OF_PAGES_PARAM_NAME, noOfPages);
			pagesDetails.put(ServiceConstant.CURRENT_PAGE_PARAM_NAME, currentPage);
			PageDetail.setPagesDetails(pagesDetails);
			if (offeringList.isEmpty() || offeringList == null) {
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

		return offeringList;
	}

	@Override
	public boolean selectPerformerForOrder(String username, String idOrder, String locale) throws ServiceException {
		if (!username.isEmpty() || username != null) {
			try {
				if (offeringDAO.selectPerformerForOrder(username, Integer.parseInt(idOrder))) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка выбора исполнителя, попробуйте позже");
					} else {
						throw new ServiceException("Error of choosing performer, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка выбора исполнителя");
				} else {
					throw new ServiceException("Error of choosing performer");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Пользователь не найден");
			} else {
				throw new ServiceException("The user is not found");
			}
		}
	}

	@Override
	public boolean addOfferfingToOrder(User user, String idOrder, String locale) throws ServiceException {
		if (!user.getUsername().isEmpty() || user.getUsername() != null) {
			try {
				if (offeringDAO.addOfferfingToOrder(user, Integer.parseInt(idOrder))) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка выбора исполнителя, попробуйте позже");
					} else {
						throw new ServiceException("Error of choosing performer, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка выбора исполнителя");
				} else {
					throw new ServiceException("Error of choosing performer");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Пользователь не найден");
			} else {
				throw new ServiceException("The user is not found");
			}
		}
	}

}
