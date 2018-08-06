package by.epam.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import by.epam.dao.DAOFactory;
import by.epam.dao.UserDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;
import by.epam.domain.user.User;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	public Map<String, String> errorOfCreating = new HashMap<>();
	public Map<String, String> tempDataForError = new HashMap<>();

	public Map<String, String> getErrorOfCreating() {
		return errorOfCreating;
	}

	@Override
	public User create(User user, String locale) throws ServiceException {
		errorOfCreating.replaceAll((k, v) -> null);
		String userName = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();

		if (user.getUsername().isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME, "Поле имя пользователя пусто");
			} else {
				errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME, "Username is empty");
			}
		} else {
			try {
				userName = userDAO.checkUsername(user.getUsername());
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					user = null;
					throw new ServiceException("Ошибка проверки пользователя");
				} else {
					user = null;
					throw new ServiceException("The error of checking user");
				}
			}
			if (userName != null) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME, "Пользователь с таким именем уже существует");
				} else {
					errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME, "The user with such name has already existed");
				}
			} else {
				tempDataForError.put(ServiceConstant.USERNAME_PARAM_NAME, user.getUsername());
			}
		}

		if (user.getPassword().isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.PASSWORD_PARAM_NAME, "Поле пароль пусто");
			} else {
				errorOfCreating.put(ServiceConstant.PASSWORD_PARAM_NAME, "Password is empty");
			}
		} else {
			if (!Validator.validatePassword(user.getPassword())) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.PASSWORD_PARAM_NAME,
							"Ваш пароль должен состоять минимум из восьми символов, по крайней мере, одной заглавной буквы, одной строчной буквы и одной цифры");
				} else {
					errorOfCreating.put(ServiceConstant.PASSWORD_PARAM_NAME,
							"Your password must consist of minimum eight characters, at least one uppercase letter, one lowercase letter and one number");
				}
			} else {
				tempDataForError.put(ServiceConstant.PASSWORD_PARAM_NAME, user.getPassword());
			}
		}

		if (user.getEmail().isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.EMAIL_PARAM_NAME, "Поле email пусто");
			} else {
				errorOfCreating.put(ServiceConstant.EMAIL_PARAM_NAME, "Email is empty");
			}
		} else {
			if (!Validator.validateEmail(user.getEmail())) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.EMAIL_PARAM_NAME, "Вы ввели некорректный email");
				} else {
					errorOfCreating.put(ServiceConstant.EMAIL_PARAM_NAME, "You entered incorrect email");
				}
			} else {
				tempDataForError.put(ServiceConstant.EMAIL_PARAM_NAME, user.getEmail());
			}
		}

		if (user.getPhoneNumber().isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "Поле телефон пусто");
			} else {
				errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "PhoneNumber is empty");
			}
		} else {
			if (!Validator.validatePhoneNumber(user.getPhoneNumber())) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "Вы ввели некорректный мобильный номер");
				} else {
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "You entered incorrect mobile number");
				}
			} else {
				tempDataForError.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, user.getPhoneNumber());
			}
		}

		if (errorOfCreating.isEmpty()) {
			try {
				user = userDAO.create(user);
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			tempDataForError.put(ServiceConstant.ADDRESS_PARAM_NAME, user.getAddress());
			tempDataForError.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, user.getPhoneNumber());			
			if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer().getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_NATURAL_PARAM_NAME)) {
				tempDataForError.put(ServiceConstant.NAME_PARAM_NAME, user.getCustomer().getNaturalCustomerInfo().getName());
				tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME, user.getCustomer().getNaturalCustomerInfo().getSurname());
			}
			if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer().getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_LEGAL_PARAM_NAME)) {
				tempDataForError.put(ServiceConstant.NAME_PARAM_NAME, user.getCustomer().getLegalCustomerInfo().getName());
				tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME, user.getCustomer().getLegalCustomerInfo().getSurname());
				tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME, user.getCustomer().getLegalCustomerInfo().getRequisites());
			}
			if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer().getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_COMPANY_PARAM_NAME)) {
				tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME, user.getCustomer().getCompanyCustomerInfo().getRequisites());
				tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME, user.getCustomer().getCompanyCustomerInfo().getNameCompany());
				tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME, user.getCustomer().getCompanyCustomerInfo().getNameAgent());
				tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME, user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
				tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME, user.getCustomer().getCompanyCustomerInfo().getDescription());
			}
			if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer().getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_LEGAL_PARAM_NAME)) {
				tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME, user.getPerformer().getRequisites());
			}
			if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer().getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_COMPANY_PARAM_NAME)) {
				tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME, user.getPerformer().getCompanyPerformerInfo().getNameCompany());
				tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME, user.getPerformer().getCompanyPerformerInfo().getNameAgent());
				tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME, user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
				tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME, user.getPerformer().getCompanyPerformerInfo().getDescription());
			}

			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}

		return user;
	}

	@Override
	public User create(User user, Customer customer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user, Performer performer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logination(String username, String password, String locale) throws ServiceException {
		User user = null;

		if (!username.isEmpty()) {
			if (!password.isEmpty()) {
				DAOFactory daoFactory = DAOFactory.getInstance();
				UserDAO userDAO = daoFactory.getUserDAO();

				try {
					user = userDAO.checkUser(username, password);
					if (user.getIsDelete().equals("true")) {
						if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
							user = null;
							throw new ServiceException("Ваша учетная запись удалена");
						} else {
							user = null;
							throw new ServiceException("Your account is deleted");
						}
					}
				} catch (DAOException e) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Неправильное имя пользователя или пароль");
					} else {
						throw new ServiceException("Incorrect username or password");
					}
				}
			} else {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Поле пароль пусто");
				} else {
					throw new ServiceException("Password is empty");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Поле логин пусто");
			} else {
				throw new ServiceException("Login is empty");
			}
		}
		return user;
	}

	@Override
	public User checkUsername(String username, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String username, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Performer getPerformer(String username, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editCustomer(Customer customer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPerformer(Performer performer, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User delete(String username, String locale) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
