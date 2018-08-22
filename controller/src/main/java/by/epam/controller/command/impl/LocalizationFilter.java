package by.epam.controller.command.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalizationFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(LocalizationFilter.class.getName());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			{
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		if (!httpServletRequest.getParameter(ControllerConstant.COMMAND).equals(ControllerConstant.COMMAND_LOCALIZATION)) {

			String tempPath = "?";
			String previousCommandAndAttribute = httpServletRequest.getRequestURI();
								
			Map<String, String[]> allParamsFromRequest = httpServletRequest.getParameterMap();			
			Set<Entry<String, String[]>> set = allParamsFromRequest.entrySet();
			for (Entry<String, String[]> iterable_element : set) {
				String key = iterable_element.getKey();

				for (String value : iterable_element.getValue()) {
					tempPath = tempPath + key + "=" + value + "&";					
				}
			}
			tempPath = tempPath.substring(0, tempPath.length() - 1);
			previousCommandAndAttribute = previousCommandAndAttribute + tempPath;
						
			httpServletRequest.getSession(true).setAttribute(ControllerConstant.PREVIOUS_COMMAND_AND_ATTRIBUTE, previousCommandAndAttribute);
			httpServletRequest.getSession(true).setAttribute(ControllerConstant.COMMAND, httpServletRequest.getParameter(ControllerConstant.COMMAND));

		}

		try {
			chain.doFilter(httpServletRequest, response);
		} catch (IOException | ServletException e) {
			for (StackTraceElement stackTraceElement : e.getStackTrace()) {
				log.error(stackTraceElement.toString());
			}
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
