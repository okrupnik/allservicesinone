package by.epam.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.dao.OrderDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;

public class SQLOrderDAO implements OrderDAO {
	private static final Logger log = LoggerFactory.getLogger(SQLOrderDAO.class.getName());

	private int noOfRecords;

	@Override
	public Order create(final User user, final Order order) throws DAOException {

		int userId = 0;
		int orderId = 0;
		Order orderReturn = null;

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
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_USER_ID);
			preparedStatement.setString(1, user.getUsername());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userId = Integer.parseInt(resultSet.getString(DAOConstant.ID_PARAM_NAME));
			}
			preparedStatement = connection.prepareStatement(SQLRequest.CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, order.getTitle());
			preparedStatement.setString(2, order.getDescription());
			preparedStatement.setString(3, order.getSubtypeSpecialization());
			preparedStatement.setString(4, order.getStatus());
			preparedStatement.setString(5, order.getAddress());
			preparedStatement.setDate(6, Date.valueOf(order.getEndDate()));
			preparedStatement.setDate(7, Date.valueOf(order.getDateOfCreating()));
			preparedStatement.setString(8, order.getAttachment());
			preparedStatement.setInt(9, userId);
			preparedStatement.setInt(10, order.getIdSpecialization());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			orderId = resultSet.getInt(1);
			order.setIdOrder(orderId);
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

		return order;
	}

	@Override
	public List<Order> getAllOrderOfUser(final User user, final int offset, final int noOfRecords) throws DAOException {
		int id = 0;
		String title = null;
		String description = null;
		String specialization = null;
		String subtypeSpecialization = null;
		String status = null;
		String address = null;
		LocalDate endDate = null;
		LocalDate dateOfCreating = null;
		String attachment = null;
		String usernamePerformer = null;
		int specializationId = 0;
		String activitieSpecialization = null;

		List<Order> orderList = new ArrayList<Order>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Order order = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;
		;
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_ORDER_OF_USER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, offset);
			preparedStatement.setInt(3, noOfRecords);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt(DAOConstant.ID_PARAM_NAME);
				title = resultSet.getString(DAOConstant.TITLE_ORDER_PARAM_NAME);
				description = resultSet.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
				subtypeSpecialization = resultSet.getString(DAOConstant.SUBTYPE_SPECIALIZATION_ORDER_PARAM_NAME);
				status = resultSet.getString(DAOConstant.STATUS_ORDER_PARAM_NAME);
				address = resultSet.getString(DAOConstant.ADDRESS_PARAM_NAME);
				endDate = resultSet.getDate(DAOConstant.END_DATE_ORDER_PARAM_NAME).toLocalDate();
				dateOfCreating = resultSet.getDate(DAOConstant.DATE_CREATING_ORDER_PARAM_NAME).toLocalDate();
				attachment = resultSet.getString(DAOConstant.ATTACHMENT_ORDER_PARAM_NAME);
				usernamePerformer = resultSet.getString(DAOConstant.USERNAME_PERFORMER_ORDER_PARAM_NAME);
				specializationId = resultSet.getInt(DAOConstant.ID_SPECIALIZATION_ORDER_PARAM_NAME);
				specialization = resultSet.getString(DAOConstant.SPECIALIZATION_DESCRIPT_ORDER_PARAM_NAME);
				activitieSpecialization = resultSet.getString(DAOConstant.ACTIVITIE_SPECIALIZATION_ORDER_PARAM_NAME);

				order = new Order.Builder().setIdOrder(id).setTitle(title).setDescription(description)
						.setSubtypeSpecialization(subtypeSpecialization).setStatus(status).setAddress(address)
						.setEndDate(endDate).setDateOfCreating(dateOfCreating).setAttachment(attachment)
						.setUsernamePerformer(usernamePerformer).setIdSpecialization(specializationId)
						.setSpecialization(specialization).setActivitieSpecialization(activitieSpecialization).build();
				orderList.add(order);

			}
			resultSet = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_ORDER);
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);
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

		return orderList;
	}

	@Override
	public Order getOrder(final int orderId) throws DAOException {
		int id = 0;
		String title = null;
		String description = null;
		String specialization = null;
		String subtypeSpecialization = null;
		String status = null;
		String address = null;
		LocalDate endDate = null;
		LocalDate dateOfCreating = null;
		String attachment = null;
		String usernamePerformer = null;
		int specializationId = 0;
		String activitieSpecialization = null;
		Order order = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ORDER_OF_USER);
			preparedStatement.setInt(1, orderId);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				id = resultSet.getInt(DAOConstant.ID_PARAM_NAME);
				title = resultSet.getString(DAOConstant.TITLE_ORDER_PARAM_NAME);
				description = resultSet.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
				subtypeSpecialization = resultSet.getString(DAOConstant.SUBTYPE_SPECIALIZATION_ORDER_PARAM_NAME);
				status = resultSet.getString(DAOConstant.STATUS_ORDER_PARAM_NAME);
				address = resultSet.getString(DAOConstant.ADDRESS_PARAM_NAME);
				endDate = resultSet.getDate(DAOConstant.END_DATE_ORDER_PARAM_NAME).toLocalDate();
				dateOfCreating = resultSet.getDate(DAOConstant.DATE_CREATING_ORDER_PARAM_NAME).toLocalDate();
				attachment = resultSet.getString(DAOConstant.ATTACHMENT_ORDER_PARAM_NAME);
				usernamePerformer = resultSet.getString(DAOConstant.USERNAME_PERFORMER_ORDER_PARAM_NAME);
				specializationId = resultSet.getInt(DAOConstant.ID_SPECIALIZATION_ORDER_PARAM_NAME);
				specialization = resultSet.getString(DAOConstant.SPECIALIZATION_DESCRIPT_ORDER_PARAM_NAME);
				activitieSpecialization = resultSet.getString(DAOConstant.ACTIVITIE_SPECIALIZATION_ORDER_PARAM_NAME);
				
				order = new Order.Builder().setIdOrder(id).setTitle(title).setDescription(description)
						.setSubtypeSpecialization(subtypeSpecialization).setStatus(status).setAddress(address)
						.setEndDate(endDate).setDateOfCreating(dateOfCreating).setAttachment(attachment)
						.setUsernamePerformer(usernamePerformer).setIdSpecialization(specializationId)
						.setSpecialization(specialization).setActivitieSpecialization(activitieSpecialization).build();
			}
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

		return order;
	}

	@Override
	public int getNoOfRecords() throws DAOException {
		return noOfRecords;
	}

	@Override
	public boolean editOrder(final Order order) throws DAOException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.UPDATE_ORDER);
			preparedStatement.setString(1, order.getTitle());
			preparedStatement.setString(2, order.getDescription());
			preparedStatement.setString(3, order.getSubtypeSpecialization());
			preparedStatement.setString(4, order.getStatus());
			preparedStatement.setString(5, order.getAddress());
			preparedStatement.setDate(6, Date.valueOf(order.getEndDate()));
			preparedStatement.setDate(7, Date.valueOf(order.getDateOfCreating()));
			preparedStatement.setString(8, order.getAttachment());
			preparedStatement.setInt(9, order.getIdOrder());
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
	public boolean delete(final String idOrder) throws DAOException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ConnectionPool conPool = ConnectionPool.getInstance();

		try (Connection connection = conPool.takeConnection()) {
			preparedStatement = connection.prepareStatement(SQLRequest.DELETE_ORDER);			
			preparedStatement.setString(1, idOrder);
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
	public List<Order> getAllOrdersOfUsers(final int offset, final int noOfRecords) throws DAOException {

		int idOrder = 0;
		String title = null;
		String descriptionOrder = null;
		String specialization = null;
		String subtypeSpecialization = null;
		String status = null;
		String address = null;
		LocalDate endDate = null;
		LocalDate dateOfCreating = null;
		String attachment = null;
		String usernameOfChoosingPerformer = null;
		int specializationId = 0;
		String activitieSpecialization = null;
		
		int idOffering = 0;
		String descriptionOffering = null; 
		String usernamePerformer = null;

		List<Order> orderList = new ArrayList<Order>();
		List<Offering> offeringList = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSetOrder = null;
		ResultSet resultSetOffering = null;

		Order order = null;
		Offering offering = null;
		ConnectionPool conPool = ConnectionPool.getInstance();
		Connection connection = null;
		
		try {
			connection = conPool.takeConnection();
		} catch (InterruptedException e) {
			log.error("The thread was interrupted", e);
		}
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_ORDERS_OF_USERS);
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, noOfRecords);
			resultSetOrder = preparedStatement.executeQuery();
			while (resultSetOrder.next()) {
				idOrder = resultSetOrder.getInt(DAOConstant.ID_PARAM_NAME);
				title = resultSetOrder.getString(DAOConstant.TITLE_ORDER_PARAM_NAME);
				descriptionOrder = resultSetOrder.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
				subtypeSpecialization = resultSetOrder.getString(DAOConstant.SUBTYPE_SPECIALIZATION_ORDER_PARAM_NAME);
				status = resultSetOrder.getString(DAOConstant.STATUS_ORDER_PARAM_NAME);
				address = resultSetOrder.getString(DAOConstant.ADDRESS_PARAM_NAME);
				endDate = resultSetOrder.getDate(DAOConstant.END_DATE_ORDER_PARAM_NAME).toLocalDate();
				dateOfCreating = resultSetOrder.getDate(DAOConstant.DATE_CREATING_ORDER_PARAM_NAME).toLocalDate();
				attachment = resultSetOrder.getString(DAOConstant.ATTACHMENT_ORDER_PARAM_NAME);
				usernameOfChoosingPerformer = resultSetOrder.getString(DAOConstant.USERNAME_PERFORMER_ORDER_PARAM_NAME);
				specializationId = resultSetOrder.getInt(DAOConstant.ID_SPECIALIZATION_ORDER_PARAM_NAME);
				specialization = resultSetOrder.getString(DAOConstant.SPECIALIZATION_DESCRIPT_ORDER_PARAM_NAME);
				activitieSpecialization = resultSetOrder.getString(DAOConstant.ACTIVITIE_SPECIALIZATION_ORDER_PARAM_NAME);
				
				order = new Order.Builder().setIdOrder(idOrder).setTitle(title).setDescription(descriptionOrder)
						.setSubtypeSpecialization(subtypeSpecialization).setStatus(status).setAddress(address)
						.setEndDate(endDate).setDateOfCreating(dateOfCreating).setAttachment(attachment)
						.setUsernamePerformer(usernameOfChoosingPerformer).setIdSpecialization(specializationId)
						.setSpecialization(specialization).setActivitieSpecialization(activitieSpecialization).build();
				orderList.add(order);
			}
			resultSetOrder = preparedStatement.executeQuery(SQLRequest.SELECT_COUNT_ORDER);
			if (resultSetOrder.next())
				this.noOfRecords = resultSetOrder.getInt(1);
			
			for (Order tempOrder : orderList) {		
				offeringList = null;;
				offeringList = new ArrayList<Offering>();
				preparedStatement = connection.prepareStatement(SQLRequest.SELECT_ALL_OFFERING_BY_ID_ORDER);
				preparedStatement.setInt(1, tempOrder.getIdOrder());
				resultSetOffering = preparedStatement.executeQuery();
				while (resultSetOffering.next()) {
					idOffering = resultSetOffering.getInt(DAOConstant.ID_PARAM_NAME);
					descriptionOffering = resultSetOffering.getString(DAOConstant.DESCRIPTION_ORDER_PARAM_NAME);
					usernamePerformer = resultSetOffering.getString(DAOConstant.USERNAME_PARAM_NAME);
					offering = new Offering.Builder().setId(idOffering).setDescription(descriptionOffering).setUsernamePerformer(usernamePerformer).build();
					offeringList.add(offering);
				}
				tempOrder.setOfferingList(offeringList);
			}			
			
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
				if (resultSetOffering != null)
					resultSetOffering.close();
				if (resultSetOrder != null)
					resultSetOrder.close();
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

		return orderList;
	}

}
