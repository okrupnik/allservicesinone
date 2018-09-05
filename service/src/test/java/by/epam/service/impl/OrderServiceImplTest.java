package by.epam.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import by.epam.dao.OrderDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;
import by.epam.service.OrderService;
import by.epam.service.exception.ServiceException;

class OrderServiceImplTest {

	@Mock
	private static OrderDAO orderDAO;
		
	@InjectMocks
	private static OrderService orderService;
	
	@BeforeAll
	public static void setup() {
		orderDAO = Mockito.mock(OrderDAO.class);
		orderService = new OrderServiceImpl(orderDAO);
		
	}
	
	@AfterEach
	public void resetMock() {
		Mockito.reset(orderDAO);
	}
	
	
	@Test
	public void successfullyChangeStatusTest() throws ServiceException, DAOException {
		
		Mockito.when(orderDAO.changeStatusOrder(1)).thenReturn(true);
		Assert.assertEquals(true, orderService.changeStatusOrder("1", "en"));
		Mockito.verify(orderDAO).changeStatusOrder(1);		
					
	}
	
//	@Test
//	public void invalidTest() throws ServiceException, DAOException {
//		
//		Mockito.when(orderDAO.changeStatusOrder(1)).thenReturn(true);
//		Assert.assertEquals(true, orderService.changeStatusOrder("2", "en"));
//		Mockito.verify(orderDAO).changeStatusOrder(1);		
//					
//	}
//	
//	@Test
//	public void excepionTest() throws ServiceException, DAOException {
//		final String errorMessage = "error";
//		Mockito.doThrow(new RuntimeException(errorMessage)).when(orderDAO).changeStatusOrder(1);
//		try {
//		orderService.changeStatusOrder("1", "en");
//		Assertions.fail("expected exception");
//		} catch ( IllegalArgumentException e ){
//			Assertions.assertEquals(errorMessage, e.getMessage());
//		}
//					
//	}
	
	@Test
	public void successfullyEditOrderTest() throws ServiceException, DAOException {
		
		Mockito.when(orderDAO.editOrder(Mockito.any(Order.class))).thenReturn(true);
		Order order = new Order.Builder().setTitle("something").build();
		Assert.assertEquals(true, orderService.editOrder(order, "en"));
		Mockito.verify(orderDAO).editOrder(Mockito.any(Order.class));		
					
	}
	
	@Test
	public void successfullyGetOrderTest() throws ServiceException, DAOException {
		
		Order order = new Order.Builder().setTitle("something").build();
		Mockito.when(orderDAO.getOrder(2)).thenReturn(order);		
		Assert.assertEquals(order, orderService.getOrder("2", "en"));
		Mockito.verify(orderDAO).getOrder(2);		
					
	}

}
