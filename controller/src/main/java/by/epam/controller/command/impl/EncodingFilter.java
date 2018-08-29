package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "EncodingFilter", initParams = {
		@WebInitParam(name = "encoding_request", value = "UTF-8"),
		@WebInitParam(name = "encoding_response", value = "text/html;charset=UTF-8") })
public class EncodingFilter implements Filter {

	private String encodingRequestParams;
	private String encodingResponseParams;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		this.encodingRequestParams = filterConfig.getInitParameter("request_encoding");
		this.encodingResponseParams = filterConfig.getInitParameter("response_encoding");
		if (encodingRequestParams == null) {
			this.encodingRequestParams = "UTF-8";
		}
		if (encodingResponseParams == null) {
			this.encodingResponseParams = "text/html;charset=UTF-8";
		}
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encodingRequestParams);
		response.setContentType(encodingResponseParams);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
