package by.epam.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.dao.OrderDAO;
import by.epam.dao.connectionpool.ConnectionPool;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.Customer;
import by.epam.domain.order.Offering;
import by.epam.domain.order.Order;
import by.epam.domain.performer.Performer;
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
			preparedStatement.setDate(6, Date.valueOf(order.getStartDate()));
			preparedStatement.setDate(7, Date.valueOf(order.getDateOfCreating()));
			preparedStatement.setString(8, order.getAttachment());
			preparedStatement.setInt(9, userId);
			preparedStatement.setInt(10, order.getIdSpecialization());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			orderId = resultSet.getInt(1);
			orderReturn = new Order.Builder().setIdOrder(orderId).build();
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
	public List<Order> showOrder(final User user) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderCustomer(final Customer customer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showOrderPerformer(final Performer performer) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(final Order order) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offering> showOrderOffering(final Order order) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
