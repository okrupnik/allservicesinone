package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;

public interface SpecializationDAO {
	
	Specialization showSpecialization(String activitie, String sqlRequestLang, String specializationLang, String subSpecializationLang) throws DAOException;
	
	Specialization showSpecializationRepairEn(final String activitie) throws DAOException;
	Specialization showSpecializationRepairRu(final String activitie) throws DAOException;
	Specialization showSpecializationTruckingEn(final String activitie) throws DAOException;
	Specialization showSpecializationTruckingRu(final String activitie) throws DAOException;
	Specialization showSpecializationCourierEn(final String activitie) throws DAOException;
	Specialization showSpecializationCourierRu(final String activitie) throws DAOException;
	Specialization showSpecializationCleaningEn(final String activitie) throws DAOException;
	Specialization showSpecializationCleaningRu(final String activitie) throws DAOException;
	Specialization showSpecializationComputerEn(final String activitie) throws DAOException;
	Specialization showSpecializationComputerRu(final String activitie) throws DAOException;
	Specialization showSpecializationEventsEn(final String activitie) throws DAOException;
	Specialization showSpecializationEventsRu(final String activitie) throws DAOException;
	Specialization showSpecializationDesignEn(final String activitie) throws DAOException;
	Specialization showSpecializationDesignRu(final String activitie) throws DAOException;
	Specialization showSpecializationPhotoEn(final String activitie) throws DAOException;
	Specialization showSpecializationPhotoRu(final String activitie) throws DAOException;
	Specialization showSpecializationWebEn(final String activitie) throws DAOException;
	Specialization showSpecializationWebRu(final String activitie) throws DAOException;
	Specialization showSpecializationInstallEn(final String activitie) throws DAOException;
	Specialization showSpecializationInstallRu(final String activitie) throws DAOException;
	Specialization showSpecializationBeautyEn(final String activitie) throws DAOException;
	Specialization showSpecializationBeautyRu(final String activitie) throws DAOException;
	Specialization showSpecializationLegalEn(final String activitie) throws DAOException;
	Specialization showSpecializationLegalRu(final String activitie) throws DAOException;
	Specialization showSpecializationEducationEn(final String activitie) throws DAOException;
	Specialization showSpecializationEducationRu(final String activitie) throws DAOException;
	Specialization showSpecializationRepairTransportEn(final String activitie) throws DAOException;
	Specialization showSpecializationRepairTransportRu(final String activitie) throws DAOException;


}
