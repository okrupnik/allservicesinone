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
import by.epam.domain.specialization.Specialization;
import by.epam.service.ServiceFactory;
import by.epam.service.SpecializationService;
import by.epam.service.exception.ServiceException;

public class ChooseSpecialization implements Command {
	private static final Logger log = LoggerFactory.getLogger(ChooseSpecialization.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String activitie = request.getParameter(ParamAndAttribute.SPECIALIZATION_PARAM_NAME);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		SpecializationService specializationService = serviceFactory.getSpecializationService();
		Specialization specialization = null;
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		
		try {
			specialization = specializationService.showSpecialization(activitie, locale);			
			session.setAttribute(ParamAndAttribute.SPECIALIZATION_ATTRIBUTE, specialization);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.getGoToPage(activitie));
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
