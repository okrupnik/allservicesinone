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
import by.epam.service.OfferingService;
import by.epam.service.ServiceFactory;
import by.epam.service.exception.ServiceException;

public class EditOfferingOfOrder implements Command{
	private static final Logger log = LoggerFactory.getLogger(EditOfferingOfOrder.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idOffering = request.getParameter(ParamAndAttribute.OFFERING_ID_PARAM_NAME);
		String description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME); 		
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		HttpSession session = request.getSession();
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		OfferingService offeringService = serviceFactory.getOfferingService();
		
		try {
			offeringService.edit(idOffering, description, locale);
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Предложение успешно изменено");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "The offering changing successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.EDIT_OFFERING_SUCCESS_PAGE);
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.EDIT_OFFERING_ERROR_PAGE);
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
