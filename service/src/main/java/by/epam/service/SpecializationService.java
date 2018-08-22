package by.epam.service;

import by.epam.domain.specialization.Specialization;
import by.epam.service.exception.ServiceException;

public interface SpecializationService {
	
	Specialization showSpecialization(final String activitie, final String locale) throws ServiceException;
	
	void checkSpecialization(final Specialization specialization, final String locale) throws ServiceException;

}
