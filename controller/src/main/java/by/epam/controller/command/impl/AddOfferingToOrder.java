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
import by.epam.domain.user.User;
import by.epam.service.OfferingService;
import by.epam.service.ServiceFactory;
import by.epam.service.exception.ServiceException;

public class AddOfferingToOrder implements Command{
	private static final Logger log = LoggerFactory.getLogger(AddOfferingToOrder.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		String idOrder = request.getParameter(ParamAndAttribute.ORDER_ID_PARAM_NAME);
		String description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
		User user = (User) request.getSession().getAttribute(ParamAndAttribute.USER_ATTRIBUTE); 
		
		OfferingService offeringService = ServiceFactory.getInstatnce().getOfferingService();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		HttpSession session = request.getSession();
		
		try {
			offeringService.addOfferfingToOrder(user, idOrder, description, locale);
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Предложение успешно добавлено к заказу");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "The offering was added to the order successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ADD_OFFERING_SUCCESS_PAGE);
			dispatcher.forward(request, response);			
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ADD_OFFERING_ERROR_PAGE);
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
