package by.epam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.dao.DAOFactory;
import by.epam.dao.OfferingDAO;
import by.epam.dao.UserDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.user.User;

public class SQLOfferingDAO implements OfferingDAO {
	private static final Logger log = LoggerFactory.getLogger(SQLOfferingDAO.class.getName());

	DAOFactory daoFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoFactory.getUserDAO();
	private int noOfRecords;

	@Override
	public List<Offering> getAllOfferingForOrder(final int idOrder, final int offset, final int noOfRecords)
			throws DAOException {

		String username = null;
		String offeringDescription = null;
		String titleOrder = null;
		List<Offering> offeringList = new ArrayList<>();
		User user = null;
		Offering offering = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_OFFERING_OF_ORDER);
			preparedStatement.setInt(1, idOrder);
			preparedStatement.setInt(2, offset);
			preparedStatement.setInt(3, noOfRecords);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				username = resultSet.getString(DAOConstant.USERNAME_PARAM_NAME);
				offeringDescription = resultSet.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
				titleOrder = resultSet.getString(DAOConstant.TITLE_ORDER_PARAM_NAME);
				user = userDAO.getUser(username);
				offering = new Offering.Builder().setUser(user).setDescription(offeringDescription).setIdOrder(idOrder)
						.setTitleOrder(titleOrder).build();
				offeringList.add(offering);
			}
			resultSet = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_USER);
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);
			connection.commit();
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

		return offeringList;
	}

	@Override
	public int getNoOfRecords() throws DAOException {
		return noOfRecords;
	}

	@Override
	public boolean selectPerformerForOrder(final String username, final int idOrder) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_PERFORMER_FOR_ORDER);
			preparedStatement.setString(1, username);
			preparedStatement.setInt(2, idOrder);
			preparedStatement.executeUpdate();
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
		return true;
	}

	@Override
	public boolean addOfferfingToOrder(final User user, final int idOrder, final String description) throws DAOException {

		int performerId = 0;
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ID_PERFORMER);
			preparedStatement.setString(1, user.getUsername());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				performerId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}
			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_OFFERING);
			preparedStatement.setString(1, description);
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setInt(3, idOrder);
			preparedStatement.setInt(4, performerId);
			preparedStatement.executeUpdate();			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
				log.error("Transaction failed", e);
			} catch (SQLException sqle) {
				log.error("Rollback failed", e);
			}
		} finally {
			try {
				connection.setAutoCommit(true);
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		}
		
		return true;
	}

	@Override
	public List<Offering> getOfferingsOfUser(final User user, final int offset, final int noOfRecords) throws DAOException {

		int idOffering = 0;
		String description = null;
		String titleOrder = null;
		List<Offering> offeringList = new ArrayList<>();
		Offering offering = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_OFFERINGS_OF_USER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, offset);
			preparedStatement.setInt(3, noOfRecords);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				idOffering = resultSet.getInt(DAOConstant.ID_PARAM_NAME);
				description = resultSet.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
				titleOrder = resultSet.getString(DAOConstant.TITLE_ORDER_PARAM_NAME);				
				offering = new Offering.Builder().setId(idOffering).setDescription(description).setTitleOrder(titleOrder).setUser(user).build();
				offeringList.add(offering);
			}
			resultSet = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_USER);
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);
			connection.commit();
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

		return offeringList;
	}

	@Override
	public boolean edit(final int idOffering, final String description) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();
		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_OFFERING);
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, idOffering);
			preparedStatement.executeUpdate();
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
		return true;
	}

	@Override
	public boolean delete(final int idOffering) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.DELETE_OFFERING);			
			preparedStatement.setInt(1, idOffering);
			preparedStatement.executeUpdate();			
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
		return true;
	}

}
