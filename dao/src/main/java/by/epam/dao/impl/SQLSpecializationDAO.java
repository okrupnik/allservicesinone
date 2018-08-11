package by.epam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.dao.SpecializationDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;

public class SQLSpecializationDAO implements SpecializationDAO {

	private static final Logger log = LogManager.getLogger(SQLSpecializationDAO.class.getName());

	@Override
	public Specialization showSpecialization(String activitie, String sqlRequestLang, String specializationLang,
			String subSpecializationLang) throws DAOException {
		List<String> subSpecialization = new ArrayList<>();
		Specialization specialization = null;
		String description = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(sqlRequestLang);
			preparedStatement.setString(1, activitie);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				description = resultSet.getString(specializationLang);
				subSpecialization.add(resultSet.getString(subSpecializationLang));
			}
			specialization = new Specialization.Builder().setActivities(activitie).setDescription(description)
					.setSubspecialization(subSpecialization).build();
		} catch (SQLException e) {
			throw new DAOException("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			throw new DAOException("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement);
				}
			}

		}
		return specialization;
	}
	
	@Override
	public Specialization showSpecializationRepairEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.REPAIR_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.REPAIR_RU_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationTruckingEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_TRUCKING_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.TRUCKING_EN_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationTruckingRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_TRUCKING_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.TRUCKING_RU_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationCourierEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COURIER_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.COURIER_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCourierRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COURIER_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.COURIER_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCleaningEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_CLEANING_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.CLEANING_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCleaningRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_CLEANING_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.CLEANING_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationComputerEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COMPUTER_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.COMPUTER_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationComputerRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COMPUTER_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.COMPUTER_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEventsEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EVENTS_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.EVENTS_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEventsRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EVENTS_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.EVENTS_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationDesignEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_DESIGN_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.DESIGN_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationDesignRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_DESIGN_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.DESIGN_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationPhotoEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_PHOTO_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.PHOTO_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationPhotoRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_PHOTO_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.PHOTO_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationWebEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_WEB_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.WEB_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationWebRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_WEB_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.WEB_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationInstallEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_INSTALL_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.INSTALL_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationInstallRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_INSTALL_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.INSTALL_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationBeautyEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_BEAUTY_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.BEAUTY_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationBeautyRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_BEAUTY_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.BEAUTY_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationLegalEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_LEGAL_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.LEGAL_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationLegalRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_LEGAL_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.LEGAL_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEducationEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EDUCATION_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.EDUCATION_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEducationRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EDUCATION_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.EDUCATION_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairTransportEn(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_TRANSPORT_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.REPAIR_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairTransportRu(String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_TRANSPORT_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.REPAIR_TRANSPORT_RU_PARAM_NAME);
	}

}
