package by.epam.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.controller.command.Command;
import by.epam.domain.order.Order;
import by.epam.domain.page.PageDetail;
import by.epam.service.OrderService;
import by.epam.service.ServiceFactory;
import by.epam.service.exception.ServiceException;

public class ShowAllOrdersOfUsers implements Command{
	private static final Logger log = LoggerFactory.getLogger(ShowAllOrdersOfUsers.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		List<Order> ordersList = null;
		OrderService orderService = ServiceFactory.getInstatnce().getOrderService();
		
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		String page = request.getParameter(ParamAndAttribute.PAGE_ATTRIBUTE);
		
		try {
			ordersList = orderService.getAllOrdersOfUsers(page, locale);
			session.setAttribute(ParamAndAttribute.ORDER_LIST_ATTRIBUTE, ordersList);
			session.setAttribute(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME));
			session.setAttribute(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME));
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ALL_ORDERS_OF_USER_PAGE);
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
