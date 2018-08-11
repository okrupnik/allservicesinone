package by.epam.service.impl;

import by.epam.dao.DAOFactory;
import by.epam.dao.SpecializationDAO;
import by.epam.dao.UserDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;
import by.epam.service.SpecializationService;
import by.epam.service.exception.ServiceException;

public class SpecializationServiceImpl implements SpecializationService {

	@Override
	public Specialization showSpecialization(String activitie, String locale) throws ServiceException {
		Specialization specialization = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		SpecializationDAO spicializationDAO = daoFactory.getSpecializationDAO();

		if (!activitie.isEmpty()) {
			switch (activitie) {
			case ServiceConstant.TRUCKING_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationTruckingEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationTruckingRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.REPAIR_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationRepairEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationRepairRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.COURIER_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationCourierEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationCourierRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.CLEANING_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationCleaningEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationCleaningRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.COMPUTER_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationComputerEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationComputerRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.EVENTS_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationEventsEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationEventsRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.DESIGN_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationDesignEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationDesignRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.PHOTO_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationPhotoEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationPhotoRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.WEB_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationWebEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationWebRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.INSTALL_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationInstallEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationInstallRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.BEAUTY_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationBeautyEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationBeautyRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.LEGAL_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationLegalEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationLegalRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.EDUCATION_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationEducationEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationEducationRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.REPAIR_TRANCPORT_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationRepairTransportEn(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationRepairTransportRu(activitie);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Невозможно выбрать специализацию");
			} else {
				throw new ServiceException("Impossible to choose specialization");
			}
		}

		return specialization;
	}

}
