package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;
import by.epam.domain.user.User;

/**
 * The interface that implements show different specializations {@link Specialization} with sub specializations
 *  
 * @author Oleg Krupnik
 *
 */
public interface SpecializationDAO {

	/**
	 * Obtaining specialization along with a list of sub specializations, depending on the selected locale
	 * 
	 * @param activitie The name of activity
	 * @param sqlRequestLang SQL request to get specialization
	 * @param specializationLang Description of the specialization in the chosen locale
	 * @param subSpecializationLang Description of the sub specialization in the chosen locale
	 * @return A specific specialization with a list sub specializations
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecialization(String activitie, String sqlRequestLang, String specializationLang,
			String subSpecializationLang) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A repair specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationRepairEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A repair specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationRepairRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A trucking specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationTruckingEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A trucking specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationTruckingRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A courier specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationCourierEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A courier specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationCourierRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A cleaning specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationCleaningEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A cleaning specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationCleaningRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A computer specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationComputerEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A computer specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationComputerRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A events and promotion specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationEventsEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A events and promotion specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationEventsRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A design specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationDesignEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A design specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationDesignRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A photo and video specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationPhotoEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A photo and video specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationPhotoRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A web specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationWebEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A web specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationWebRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A install specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationInstallEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A install specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationInstallRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A beauty and healty specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationBeautyEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A beauty and healty specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationBeautyRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A legal specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationLegalEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A legal specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationLegalRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A education specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationEducationEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A education specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationEducationRu(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A repair of transport specialization with it's a list sub specializations on english language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationRepairTransportEn(String activitie) throws DAOException;

	/**
	 * 
	 * @param activitie The name of activity
	 * @return A repair of transport specialization with it's a list sub specializations on russian language
	 * @throws DAOException If there are errors in obtaining specialization
	 */
	Specialization showSpecializationRepairTransportRu(String activitie) throws DAOException;

}
