package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.controller.command.Command;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.ownership.Ownership;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.service.ServiceStaffInfo;
import by.epam.domain.user.Person;
import by.epam.domain.user.Role;
import by.epam.domain.user.User;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class ChangingUserSetting implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isDelete = null;
		String photo = null;
		String role = null;
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
		
		User user = (User) request.getSession().getAttribute("user"); 
		typePerson = request.getParameter(ParamAndAttribute.TYPE_PERSON_PARAM_NAME);
		formOwnership = request.getParameter(ParamAndAttribute.FORM_OWNERSHIP_PARAM_NAME);
		email = request.getParameter(ParamAndAttribute.EMAIL_PARAM_NAME);
		phoneNumber = request.getParameter(ParamAndAttribute.PHONE_NUMBER_PARAM_NAME);
		address = request.getParameter(ParamAndAttribute.ADDRESS_PARAM_NAME);
		photo = request.getParameter(ParamAndAttribute.PHOTO_PARAM_NAME);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		UserService userService = serviceFactory.getUserService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		if (typePerson.equals(ControllerConstant.SERVICE_PERSON_PARAM_NAME)) {
			name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
			surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
			user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
					setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
					setPerson(new Person.Builder().setTypePerson(typePerson).build()).setServiceStaffInfo(new ServiceStaffInfo.Builder().setName(name).setSurname(surname).build()).build();				
		}
		
		if (typePerson.equals(ControllerConstant.CUSTOMER_PARAM_NAME)) {
			switch (formOwnership) {
			case ControllerConstant.CUSTOMER_NATURAL_PARAM_NAME:
				name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
				user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
						setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
						setPerson(new Person.Builder().setTypePerson(typePerson).build()).
						setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
						setNaturalCustomerInfo(new NaturalCustomerInfo.Builder().setName(name).setSurname(surname).build()).build()).build();
				break;
			case ControllerConstant.CUSTOMER_LEGAL_PARAM_NAME:
				name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
				requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
				copyRegistration = request.getParameter(ParamAndAttribute.COPY_REGISTTRATION_PARAM_NAME);
				user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
						setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
						setPerson(new Person.Builder().setTypePerson(typePerson).build()).
						setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
						setLegalCustomerInfo(new LegalCustomerInfo.Builder().setName(name).setSurname(surname).setRequisites(requisites).setCopyRegistration(copyRegistration).build()).build()).build();						
				break;
			case ControllerConstant.CUSTOMER_COMPANY_PARAM_NAME:
				companyName = request.getParameter(ParamAndAttribute.COMPANY_PARAM_NAME);
				name = request.getParameter(ParamAndAttribute.NAME_AGENT_PARAM_NAME);
				surname = request.getParameter(ParamAndAttribute.SURNAME_AGENT_PARAM_NAME);
				requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
				description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
				user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
						setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
						setPerson(new Person.Builder().setTypePerson(typePerson).build()).
						setCustomer(new Customer.Builder().setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
						setCompanyCustomerInfo(new CompanyCustomerInfo.Builder().setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname).setRequisites(requisites).setDescription(description).build()).build()).build();						
				break;
			}
		} else {
			if (typePerson.equals(ControllerConstant.PERFORMER_PARAM_NAME)) {
				switch (formOwnership) {
				case ControllerConstant.PERFORMER_LEGAL_PARAM_NAME:
					name = request.getParameter(ParamAndAttribute.NAME_PARAM_NAME);
					surname = request.getParameter(ParamAndAttribute.SURNAME_PARAM_NAME);
					requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
					copyRegistration = request.getParameter(ParamAndAttribute.COPY_REGISTTRATION_PARAM_NAME);
					user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
							setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
							setPerson(new Person.Builder().setTypePerson(typePerson).build()).
							setPerformer(new Performer.Builder().setRequisites(requisites).setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
							setLegalPerformerInfo(new LegalPerformerInfo.Builder().setName(name).setSurname(surname).setCopyRegistration(copyRegistration).build()).build()).build();							
					break;
				case ControllerConstant.PERFORMER_COMPANY_PARAM_NAME:
					companyName = request.getParameter(ParamAndAttribute.COMPANY_PARAM_NAME);
					name = request.getParameter(ParamAndAttribute.NAME_AGENT_PARAM_NAME);
					surname = request.getParameter(ParamAndAttribute.SURNAME_AGENT_PARAM_NAME);
					requisites = request.getParameter(ParamAndAttribute.REQUISITES_PARAM_NAME);
					description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
					user = new User.Builder().setUsername(user.getUsername()).setIsDelete(ControllerConstant.USER_FALSE_PARAM_NAME).setEmail(email).
							setPhoneNumber(phoneNumber).setAddress(address).setPhoto(photo).setRole(new Role.Builder().setTypeRole(ControllerConstant.ROLE_USER_PARAM_NAME).build()).
							setPerson(new Person.Builder().setTypePerson(typePerson).build()).
							setPerformer(new Performer.Builder().setRequisites(requisites).setOwnership(new Ownership.Builder().setFormOwnership(formOwnership).build()).
							setCompanyPerformerInfo(new CompanyPerformerInfo.Builder().setNameCompany(companyName).setNameAgent(name).setSurnameAgent(surname).setDescription(description).build()).build()).build();							
					break;
				}
			}
		}
		
		try {
			if (userService.editUser(user, locale)) {
				session.setAttribute(ParamAndAttribute.USER_ATTRIBUTE, user);
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Данные пользователя успешно измененны");
				} else {
					session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Data of user changed successfully");
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_EDIT_SUCCESS_PAGE);
				dispatcher.forward(request, response);
			} else {
				if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Ошибка редактирования пользователя");
					response.sendRedirect(request.getHeader("Referer"));
				} else {
					session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, "Error of edit user");
					response.sendRedirect(request.getHeader("Referer"));
				}
			}
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			session.setAttribute(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE, ErrorMap.getTempDataForErrors());
			response.sendRedirect(request.getHeader("Referer"));
		}

	}

}
