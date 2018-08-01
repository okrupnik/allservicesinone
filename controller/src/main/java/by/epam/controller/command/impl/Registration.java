package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.controller.command.Command;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.ownership.Ownership;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = null;
		String password = null;
		String photo = null;
		String typePerson = null;
		String email = null;
		String phoneNumber = null;
		String formOwnership = null;
		String name = null;
		String surname = null;
		String address = null;
		String requisites = null;
		String copyRegistration = null;
		String companyName = null;
		String description = null;
		String activeTab = null;

		username = request.getParameter(ParamAndAttribute.USERNAME_PARAM_NAME);
		password = request.getParameter(ParamAndAttribute.PASSWORD_PARAM_NAME);
		typePerson = request.getParameter(ParamAndAttribute.TYPE_PERSON_PARAM_NAME);
		formOwnership = request.getParameter(ParamAndAttribute.FORM_OWNERSHIP_PARAM_NAME);
		email = request.getParameter(ParamAndAttribute.EMAIL_PARAM_NAME);
		phoneNumber = request.getParameter(ParamAndAttribute.PHONE_NUMBER_PARAM_NAME);
		address = request.getParameter(ParamAndAttribute.ADDRESS_PARAM_NAME);
		photo = request.getParameter(ParamAndAttribute.PHOTO_PARAM_NAME);
		activeTab = request.getParameter(ParamAndAttribute.ACTIVE_TAB_PARAM_NAME);

		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		User user = null;
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		if (typePerson.equals("customer")) {
			switch (formOwnership) {
			case "natural":
				name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
				user = new User(username, password, "false", email, phoneNumber, address, photo, new Role("user"),
						new Person(typePerson),
						new Customer(new Ownership(formOwnership), new NaturalCustomerInfo(name, surname)));
				break;
			case "legal":
				name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
				requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
				copyRegistration = request.getParameter(ParamAndAttribute.COPY_REGISTTRATION_PARAM_NAME);
				user = new User(username, password, "false", email, phoneNumber, address, photo, new Role("user"),
						new Person(typePerson), new Customer(new Ownership(formOwnership),
								new LegalCustomerInfo(name, surname, requisites, copyRegistration)));
				break;
			case "company":
				companyName = request.getParameter(ParamAndAttribute.COMPANY_PARAM_NAME);
				name = request.getParameter(ParamAndAttribute.NAME_AGENT_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_AGENT_PARAM_NAME);
				requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
				description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
				user = new User(username, password, "false", email, phoneNumber, address, photo, new Role("user"),
						new Person(typePerson), new Customer(new Ownership(formOwnership),
								new CompanyCustomerInfo(companyName, name, surname, requisites, description)));
				break;
			}
		} else {
			if (typePerson.equals("performer")) {
				switch (formOwnership) {
				case "legal":
					name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
					surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
					requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
					copyRegistration = request.getParameter(ParamAndAttribute.COPY_REGISTTRATION_PARAM_NAME);
					user = new User(username, password, "false", email, phoneNumber, address, photo, new Role("user"),
							new Person(typePerson), new Performer(requisites, new Ownership(formOwnership),
									new LegalPerformerInfo(name, surname, copyRegistration)));
					break;
				case "company":
					companyName = request.getParameter(ParamAndAttribute.COMPANY_PARAM_NAME);
					name = request.getParameter(ParamAndAttribute.NAME_AGENT_PARAM_NAME);
					surname = request.getParameter(ParamAndAttribute.SURNAME_AGENT_PARAM_NAME);
					requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
					description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
					user = new User(username, password, "false", email, phoneNumber, address, photo, new Role("user"),
							new Person(typePerson), new Performer(requisites, new Ownership(formOwnership),
									new CompanyPerformerInfo(companyName, name, surname, description)));
					break;
				}
			}
		}

		try {
			user = userService.create(user, locale);
			if (user != null) {
				session.setAttribute(ParamAndAttribute.USER_ATTRIBUTE, user);
				response.sendRedirect("Controler?command=cn.main.page");
			} else {
				if (locale.equals("ru")) {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Ошибка создания пользователя");
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Error of creating user");
					response.sendRedirect(request.getHeader("Referer"));
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			session.setAttribute(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE, ErrorMap.getTempDataForErrors());
			session.setAttribute(ParamAndAttribute.ACTIVE_TAB_ATTRIBUTE, activeTab);
			response.sendRedirect(request.getHeader("Referer"));
		}

	}

}
