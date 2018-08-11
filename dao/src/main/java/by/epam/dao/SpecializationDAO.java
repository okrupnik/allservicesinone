package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;

public interface SpecializationDAO {
	
	Specialization showSpecialization(String activitie, String sqlRequestLang, String specializationLang, String subSpecializationLang) throws DAOException;
	
	Specialization showSpecializationRepairEn(String activitie) throws DAOException;
	Specialization showSpecializationRepairRu(String activitie) throws DAOException;
	Specialization showSpecializationTruckingEn(String activitie) throws DAOException;
	Specialization showSpecializationTruckingRu(String activitie) throws DAOException;
	Specialization showSpecializationCourierEn(String activitie) throws DAOException;
	Specialization showSpecializationCourierRu(String activitie) throws DAOException;
	Specialization showSpecializationCleaningEn(String activitie) throws DAOException;
	Specialization showSpecializationCleaningRu(String activitie) throws DAOException;
	Specialization showSpecializationComputerEn(String activitie) throws DAOException;
	Specialization showSpecializationComputerRu(String activitie) throws DAOException;
	Specialization showSpecializationEventsEn(String activitie) throws DAOException;
	Specialization showSpecializationEventsRu(String activitie) throws DAOException;
	Specialization showSpecializationDesignEn(String activitie) throws DAOException;
	Specialization showSpecializationDesignRu(String activitie) throws DAOException;
	Specialization showSpecializationPhotoEn(String activitie) throws DAOException;
	Specialization showSpecializationPhotoRu(String activitie) throws DAOException;
	Specialization showSpecializationWebEn(String activitie) throws DAOException;
	Specialization showSpecializationWebRu(String activitie) throws DAOException;
	Specialization showSpecializationInstallEn(String activitie) throws DAOException;
	Specialization showSpecializationInstallRu(String activitie) throws DAOException;
	Specialization showSpecializationBeautyEn(String activitie) throws DAOException;
	Specialization showSpecializationBeautyRu(String activitie) throws DAOException;
	Specialization showSpecializationLegalEn(String activitie) throws DAOException;
	Specialization showSpecializationLegalRu(String activitie) throws DAOException;
	Specialization showSpecializationEducationEn(String activitie) throws DAOException;
	Specialization showSpecializationEducationRu(String activitie) throws DAOException;
	Specialization showSpecializationRepairTransportEn(String activitie) throws DAOException;
	Specialization showSpecializationRepairTransportRu(String activitie) throws DAOException;


}
