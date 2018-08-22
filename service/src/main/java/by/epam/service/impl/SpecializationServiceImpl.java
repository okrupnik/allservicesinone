package by.epam.service.impl;

import by.epam.dao.DAOFactory;
import by.epam.dao.SpecializationDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;
import by.epam.service.SpecializationService;
import by.epam.service.exception.ServiceException;

public class SpecializationServiceImpl implements SpecializationService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	SpecializationDAO spicializationDAO = daoFactory.getSpecializationDAO();

	@Override
	public Specialization showSpecialization(final String activitie, final String locale) throws ServiceException {
		Specialization specialization = null;

		if (!activitie.isEmpty()) {
			switch (activitie) {
			case ServiceConstant.TRUCKING_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationTruckingEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationTruckingRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.REPAIR_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationRepairEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationRepairRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.COURIER_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationCourierEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationCourierRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.CLEANING_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationCleaningEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationCleaningRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.COMPUTER_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationComputerEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationComputerRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.EVENTS_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationEventsEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationEventsRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.DESIGN_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationDesignEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationDesignRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.PHOTO_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationPhotoEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationPhotoRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.WEB_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationWebEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationWebRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.INSTALL_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationInstallEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationInstallRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.BEAUTY_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationBeautyEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationBeautyRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.LEGAL_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationLegalEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationLegalRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.EDUCATION_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationEducationEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationEducationRu(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Невозможно найти специализацию");
					}
				}
				break;
			case ServiceConstant.REPAIR_TRANCPORT_PARAM_NAME:
				if (locale.equals(ServiceConstant.LOCALE_EN_PARAM_NAME)) {
					try {
						specialization = spicializationDAO.showSpecializationRepairTransportEn(activitie);
						checkSpecialization(specialization, locale);
					} catch (DAOException e) {
						throw new ServiceException("Impossible to find specialization");
					}
				} else {
					try {
						specialization = spicializationDAO.showSpecializationRepairTransportRu(activitie);
						checkSpecialization(specialization, locale);
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

	@Override
	public void checkSpecialization(Specialization specialization, final String locale) throws ServiceException {
		if (specialization == null) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Невозможно перейти на страницу создания заказа");
			} else {
				throw new ServiceException("Impossible to move on the page of creating order");
			}

		}
	}
}
