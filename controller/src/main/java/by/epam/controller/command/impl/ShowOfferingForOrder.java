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
import by.epam.domain.order.Offering;
import by.epam.domain.page.PageDetail;
import by.epam.service.OfferingService;
import by.epam.service.ServiceFactory;
import by.epam.service.exception.ServiceException;

public class ShowOfferingForOrder implements Command{
	private static final Logger log = LoggerFactory.getLogger(ShowOfferingForOrder.class.getName());

	@Override
	public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		List<Offering> offeringList = null;
		String idOrder = null;
		String orderTitle = null;
		OfferingService offeringService = ServiceFactory.getInstatnce().getOfferingService();
			
		idOrder = request.getParameter(ParamAndAttribute.ORDER_ID_PARAM_NAME);
		HttpSession session = request.getSession();
		String locale = (String) request.getSession().getAttribute(ParamAndAttribute.LOCALE_ATTRIBUTE);
		String page = request.getParameter(ParamAndAttribute.PAGE_ATTRIBUTE);
		orderTitle = request.getParameter(ParamAndAttribute.ORDER_TITLE_PARAM_NAME);
		
		try {
			offeringList = offeringService.getAllOfferingForOrder(idOrder, page, locale);
			session.setAttribute(ParamAndAttribute.OFFERING_LIST_ATTRIBUTE, offeringList);
			session.setAttribute(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.NO_OF_PAGES_PARAM_NAME));
			session.setAttribute(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME, PageDetail.getPagesDetails().get(ParamAndAttribute.CURRENT_PAGE_PARAM_NAME));
			session.setAttribute(ParamAndAttribute.ORDER_TITLE_ATTRIBUTE, orderTitle);
			session.setAttribute(ParamAndAttribute.ORDER_ID_ATTRIBUTE, idOrder);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ORDER_OFFERING_PAGE);
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			String errorMessage = e.getMessage();
			session.setAttribute(ParamAndAttribute.ERROR_MESSAGE_ATTRIBUTE, errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSPPagePath.ERROR_CHOSE_PERFORMER_PAGE);
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
