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
import by.epam.service.OrderService;
import by.epam.service.ServiceFactory;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class DeleteOrder implements Command{
	private static final Logger log = LoggerFactory.getLogger(DeleteUser.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idOrder = request.getParameter(ParamAndAttribute.ORDER_ID_PARAM_NAME);

		ServiceFactory serviceFactory = ServiceFactory.getInstatnce();
		OrderService orderService = serviceFactory.getOrderService();
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		
		try {			
			orderService.delete(idOrder, locale);
			if (locale.equals(ControllerConstant.LOCALE_RU_PARAM_NAME)) {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "Заказ успешно удален");
			} else {
				session.setAttribute(ParamAndAttribute.SUCCESS_EDIT_ATTRIBUTE, "The order deleted successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ORDER_EDIT_SUCCESS_PAGE);
			dispatcher.forward(request, response);			
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.USER_ORDERS_PAGE);
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
