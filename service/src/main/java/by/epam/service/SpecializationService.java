package by.epam.service;

import by.epam.domain.specialization.Specialization;
import by.epam.service.exception.ServiceException;

public interface SpecializationService {
	
	Specialization showSpecialization(String activitie, String locale) throws ServiceException;
	
	void checkSpecialization(Specialization specialization, String locale) throws ServiceException;

}
