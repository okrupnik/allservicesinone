package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.controller.command.Command;
import by.epam.domain.specialization.Specialization;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.SpecializationService;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ChooseSpecialization implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String activitie = request.getParameter(ParamAndAttribute.SPECIALIZATION_PARAM_NAME);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		SpecializationService specializationService = serviceFactory.getSpecializationService();
		Specialization specialization = null;
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		
		try {
			specialization = specializationService.showSpecialization(activitie, locale);
			if (specialization != null) {
				session.setAttribute(ParamAndAttribute.SPECIALIZATION_ATTRIBUTE, specialization);
				RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.getGoToPage(activitie));
				dispatcher.forward(request, response);
			} else {
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Невозможно перейти на страницу создания заказа ");
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Impossible to move on the page of creating order");
					response.sendRedirect(request.getHeader("Referer"));
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			response.sendRedirect(request.getHeader("Referer"));
		}
		
	}

}
