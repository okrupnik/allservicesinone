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
import by.epam.domain.error.ErrorMap;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ChangingAdminSetting implements Command {
	private static final Logger log = LoggerFactory.getLogger(ChangingAdminSetting.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String photo = null;
		String typePerson = null;
		String email = null;
		String phoneNumber = null;
		String name = null;
		String surname = null;
		String address = null;

		User user = (User) request.getSession(true).getAttribute(ParamAndAttribute.USER_ATTRIBUTE);
		typePerson = request.getParameter(ParamAndAttribute.TYPE_PERSON_PARAM_NAME);
		email = request.getParameter(ParamAndAttribute.EMAIL_PARAM_NAME);
		phoneNumber = request.getParameter(ParamAndAttribute.PHONE_NUMBER_PARAM_NAME);
		address = request.getParameter(ParamAndAttribute.ADDRESS_PARAM_NAME);
		photo = request.getParameter(ParamAndAttribute.PHOTO_PARAM_NAME);
		name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
		surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);

		Role role = new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build();
		Person person = new Person.Builder().setTypePerson(typePerson).build();
		ServiceStaffInfo serviceStaffInfo = new ServiceStaffInfo.Builder().setName(name).setSurname(surname).build();

		user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME)
				.setEmail(email).setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(role)
				.setPerson(person).setServiceStaffInfo(serviceStaffInfo).build();

		UserService userService = ServiceFactory.getInstatnce().getUserService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			userService.editAdministration(user, locale);
			session.setAttribute(ParamAndAttribute.USER_ATTRIBUTE, user);
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Данные пользователя успешно измененны");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Data of user changed successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_EDIT_SUCCESS_PAGE);
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			session.setAttribute(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE, ErrorMap.getTempDataForErrors());
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_SETTING_PAGE);
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
