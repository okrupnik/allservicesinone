package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;
import by.epam.domain.order.Order;
import by.epam.domain.specialization.Specialization;
import by.epam.service.OrderService;
import by.epam.service.ServiceFactory;
import by.epam.service.SpecializationService;
import by.epam.service.exception.ServiceException;

public class ToEditOrderUser implements Command{
	private static final Logger log = LoggerFactory.getLogger(ToEditOrderUser.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		String locale = null;
		String orderId = null;
		String activitieSpecialization = null;
		Order orderForEdit = null;
		
		locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		orderId = request.getParameter(ParamAndAttribute.ORDER_ID_PARAM_NAME);
		activitieSpecialization = request.getParameter(ParamAndAttribute.ACTIVE_SPECIALIZATION_PARAM_NAME);
		
		SpecializationService specializationService = ServiceFactory.getInstatnce().getSpecializationService();
		OrderService orderService = ServiceFactory.getInstatnce().getOrderService();
		Specialization specialization = null;
		HttpSession session = request.getSession();
		
		try {
			specialization = specializationService.showSpecialization(activitieSpecialization, locale);
			orderForEdit = orderService.getOrder(orderId, locale);
			session.setAttribute(ParamAndAttribute.SPECIALIZATION_ATTRIBUTE, specialization);
			session.setAttribute(ParamAndAttribute.ORDER_EDIT_ATTRIBUTE, orderForEdit);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.getGoToPageEdit(activitieSpecialization));
			dispatcher.forward(request, response);	
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ERROR_PAGE);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				for (StackTraceElement stackTraceElement : e.getStackTrace()) {
					log.error(stackTraceElement.toString());
				}
			}
		} catch (ServletException | IOException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}				
		
	}

}
