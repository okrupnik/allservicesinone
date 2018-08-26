package by.epam.controller.command.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.order.Order;
import by.epam.domain.user.User;
import by.epam.service.OrderService;
import by.epam.service.ServiceFactory;
import by.epam.service.exception.ServiceException;

public class CreateOrderRepair implements Command {
	private static final Logger log = LoggerFactory.getLogger(CreateOrderRepair.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titleOrder = null;
		int idSpecialization = 0;
		String description = null;
		String status = null;
		String subspecialization = null;
		LocalDate endDate = null;
		LocalDate dateOfCreating = null;
		String address = null;
		String attachment = null;
		Order orderRepair = null;
		User user = (User) request.getSession(true).getAttribute(ParamAndAttribute.USER_ATTRIBUTE);

		titleOrder = request.getParameter(ParamAndAttribute.ORDER_TITLE_PARAM_NAME);
		idSpecialization = Integer.parseInt(request.getParameter(ParamAndAttribute.ID_SPECIALIZATION_TITLE_PARAM_NAME));
		description = request.getParameter(ParamAndAttribute.DESCRIPTION_PARAM_NAME);
		status = request.getParameter(ParamAndAttribute.STATUS_PARAM_NAME);
		subspecialization = request.getParameter(ParamAndAttribute.SUB_SPECIALIZATION_PARAM_NAME);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		endDate = LocalDate.parse(request.getParameter(ParamAndAttribute.END_DATE_PARAM_NAME), formatter);
		dateOfCreating = LocalDate.now();
		address = request.getParameter(ParamAndAttribute.ADDRESS_PARAM_NAME);
		attachment = request.getParameter(ParamAndAttribute.ATTACHMENT_PARAM_NAME);

		orderRepair = new Order.Builder().setTitle(titleOrder).setIdSpecialization(idSpecialization)
				.setDescription(description).setStatus(status).setSubtypeSpecialization(subspecialization)
				.setEndDate(endDate).setDateOfCreating(dateOfCreating).setAddress(address).setAttachment(attachment)
				.build();

		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		OrderService orderService = serviceFactory.getOrderService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);

		try {
			orderRepair = orderService.create(user, orderRepair, locale);
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Заказ успешно создан");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "The order created successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_EDIT_SUCCESS_PAGE);
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			session.setAttribute(ParamAndAttribute.ERROR_INPUT_ATTRIBUTE, ErrorMap.getErrorsOfCreating());
			session.setAttribute(ParamAndAttribute.ERROR_TEMP_DATA_ATTRIBUTE, ErrorMap.getTempDataForErrors());
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ORDER_REPAIR_PAGE);
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
