package by.epam.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.controller.command.Command;
import by.epam.domain.user.User;

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
		
		User user = (User)request.getSession().getAttribute("user");
		
		
	}

}
