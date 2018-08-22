package by.epam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.dao.SpecializationDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.specialization.Specialization;

public class SQLSpecializationDAO implements SpecializationDAO {

	private static final Logger log = LoggerFactory.getLogger(SQLSpecializationDAO.class.getName());

	@Override
	public Specialization showSpecialization(final String activitie, final String sqlRequestLang, final String specializationLang,
			final String subSpecializationLang) throws DAOException {
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
			log.error("Can't to get access to DataBase or get the data from table", e);
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}

		}
		return specialization;
	}
	
	@Override
	public Specialization showSpecializationRepairEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.REPAIR_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.REPAIR_RU_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationTruckingEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_TRUCKING_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.TRUCKING_EN_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationTruckingRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_TRUCKING_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.TRUCKING_RU_PARAM_NAME);		
	}

	@Override
	public Specialization showSpecializationCourierEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COURIER_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.COURIER_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCourierRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COURIER_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.COURIER_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCleaningEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_CLEANING_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.CLEANING_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationCleaningRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_CLEANING_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.CLEANING_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationComputerEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COMPUTER_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.COMPUTER_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationComputerRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_COMPUTER_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.COMPUTER_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEventsEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EVENTS_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.EVENTS_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEventsRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EVENTS_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.EVENTS_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationDesignEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_DESIGN_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.DESIGN_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationDesignRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_DESIGN_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.DESIGN_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationPhotoEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_PHOTO_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.PHOTO_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationPhotoRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_PHOTO_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.PHOTO_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationWebEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_WEB_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.WEB_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationWebRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_WEB_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.WEB_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationInstallEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_INSTALL_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.INSTALL_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationInstallRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_INSTALL_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.INSTALL_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationBeautyEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_BEAUTY_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.BEAUTY_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationBeautyRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_BEAUTY_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.BEAUTY_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationLegalEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_LEGAL_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.LEGAL_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationLegalRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_LEGAL_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.LEGAL_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEducationEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EDUCATION_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.EDUCATION_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationEducationRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_EDUCATION_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.EDUCATION_RU_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairTransportEn(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_TRANSPORT_EN, DAOConstant.SPECIALIZATION_EN_PARAM_NAME, DAOConstant.REPAIR_EN_PARAM_NAME);
	}

	@Override
	public Specialization showSpecializationRepairTransportRu(final String activitie) throws DAOException {
		return showSpecialization(activitie, SQLRequest.SELECT_SPECIALIZATION_REPAIR_TRANSPORT_RU, DAOConstant.SPECIALIZATION_RU_PARAM_NAME, DAOConstant.REPAIR_TRANSPORT_RU_PARAM_NAME);
	}

}
