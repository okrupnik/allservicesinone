package by.epam.service;

import by.epam.service.impl.OfferingServiceImpl;
import by.epam.service.impl.OrderServiceImpl;
import by.epam.service.impl.SpecializationServiceImpl;
import by.epam.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final OrderService orderService = new OrderServiceImpl();
	private final OfferingService offeringService = new OfferingServiceImpl();
	private final SpecializationService specializationService = new SpecializationServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstatnce() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	
	public OfferingService getOfferingService() {
		return offeringService;
	}

	public SpecializationService getSpecializationService() {
		return specializationService;
	}

}
