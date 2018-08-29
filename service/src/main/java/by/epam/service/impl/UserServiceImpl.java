package by.epam.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam.dao.DAOFactory;
import by.epam.dao.UserDAO;
import by.epam.dao.exception.DAOException;
import by.epam.domain.error.ErrorMap;
import by.epam.domain.page.PageDetail;
import by.epam.domain.user.User;
import by.epam.service.UserService;
import by.epam.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	public Map<String, String> errorOfCreating = new HashMap<>();
	public Map<String, String> tempDataForError = new HashMap<>();
	public Map<String, Integer> pagesDetails = new HashMap<>();

	DAOFactory daoFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoFactory.getUserDAO();

	@Override
	public User createCustomerNatural(User user, final String locale) throws ServiceException {

		validateParamUser(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				user = userDAO.createCustomerNatural(user);
				if (user == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
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
	public User createCustomerLegal(User user, final String locale) throws ServiceException {

		validateParamUser(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				user = userDAO.createCustomerLegal(user);
				if (user == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
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
	public User createCustomerCompany(User user, final String locale) throws ServiceException {

		validateParamUser(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				user = userDAO.createCustomerCompany(user);
				if (user == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
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
	public User createPerformerLegal(User user, final String locale) throws ServiceException {

		validateParamUser(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				user = userDAO.createPerformerLegal(user);
				if (user == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
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
	public User createPerformerCompany(User user, final String locale) throws ServiceException {

		validateParamUser(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				user = userDAO.createPerformerCompany(user);
				if (user == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
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
	public User logination(final String username, final String password, final String locale) throws ServiceException {
		User user = null;

		if (!username.isEmpty()) {
			if (!password.isEmpty()) {
				DAOFactory daoFactory = DAOFactory.getInstance();
				UserDAO userDAO = daoFactory.getUserDAO();

				try {
					user = userDAO.checkUser(username, password);
					if (user == null) {
						if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
							throw new ServiceException("Неправильное имя пользователя или пароль");
						} else {
							throw new ServiceException("Incorrect username or password");
						}
					} else {
						if (user.getIsDelete().equals("true")) {
							if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
								user = null;
								throw new ServiceException("Ваша учетная запись удалена");
							} else {
								user = null;
								throw new ServiceException("Your account is deleted");
							}
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
	public List<User> getAllUser(final User user, final String page, final String locale) throws ServiceException {
		List<User> users = null;
		int currentPage = 1;
		int noOfRecords = 0;
		int noOfPages = 0;
		int recordsPerPage = 4;

		if (ServiceConstant.ADMIN_PARAM_NAME.equals(user.getRole().getTypeRole())
				|| ServiceConstant.EDITOR_PARAM_NAME.equals(user.getRole().getTypeRole())) {
			try {
				if (page != null) {
					currentPage = Integer.parseInt(page);
				}
				users = userDAO.getAllUser((currentPage - 1) * recordsPerPage, recordsPerPage);
				noOfRecords = userDAO.getNoOfRecords();
				noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
				pagesDetails.put(ServiceConstant.NO_OF_PAGES_PARAM_NAME, noOfPages);
				pagesDetails.put(ServiceConstant.CURRENT_PAGE_PARAM_NAME, currentPage);
				PageDetail.setPagesDetails(pagesDetails);
				if (users.isEmpty() || users == null) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Список пуст");
					} else {
						throw new ServiceException("Users list is empty");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Невозможно получить список пользователей, попробуйте позже");
				} else {
					throw new ServiceException("Impossible to get users list, try it later");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Недостаточно прав для получения списка пользователей пользователей");
			} else {
				throw new ServiceException("Insufficient privileges to get users list");
			}
		}

		return users;
	}

	@Override
	public boolean editAdministration(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editAdministration(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean editCustomerNatural(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editCustomerNatural(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean editCustomerLegal(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editCustomerLegal(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean editCustomerCompany(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editCustomerCompany(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean editPerformerLegal(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editPerformerLegal(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean editPerformerCompany(final User user, final String locale) throws ServiceException {

		validateParamUserChanging(user, locale);

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editPerformerCompany(user)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка создания пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of creating user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка создания пользователя");
				} else {
					throw new ServiceException("Error of creating user");
				}
			}
		} else {
			ErrorMap.setTempDataForErrors(tempDataForError);
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Вы ввели неверные данные");
			} else {
				throw new ServiceException("You entered wrong data");
			}
		}
	}

	@Override
	public boolean changePassword(final User user, final String oldPassword, final String newPassword,
			final String confirmPassword, final String locale) throws ServiceException {

		errorOfCreating.replaceAll((k, v) -> null);
		errorOfCreating.clear();

		if (oldPassword.isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.OLD_PASSWORD_PARAM_NAME, "Поле старый пароль пусто");
			} else {
				errorOfCreating.put(ServiceConstant.OLD_PASSWORD_PARAM_NAME, "Old password is empty");
			}
		} else {
			try {
				if (!user.getUsername().toLowerCase().equals(userDAO.checkPassword(oldPassword).toLowerCase())) {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						errorOfCreating.put(ServiceConstant.OLD_PASSWORD_PARAM_NAME, "Вы ввели неверный старый пароль");
					} else {
						errorOfCreating.put(ServiceConstant.OLD_PASSWORD_PARAM_NAME, "You entered wrong old password");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Не возможно проверить старый пароль, попробуйте позже");
				} else {
					throw new ServiceException("Impossible to check old password, try it later");
				}
			}
		}

		if (newPassword.isEmpty()) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME, "Поле новый пароль пусто");
			} else {
				errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME, "New password is empty");
			}
		} else {
			if (!Validator.validatePassword(newPassword)) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME,
							"Ваш пароль должен состоять минимум из восьми символов, по крайней мере, одной заглавной буквы, одной строчной буквы и одной цифры");
				} else {
					errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME,
							"Your password must consist of minimum eight characters, at least one uppercase letter, one lowercase letter and one number");
				}
			}
		}

		if (!newPassword.equals(confirmPassword)) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME,
						"Значения полей новый пароль и подтвердить пароль не совпадают");
			} else {
				errorOfCreating.put(ServiceConstant.NEW_PASSWORD_PARAM_NAME,
						"Values of fields new password and confirm password are different");
			}
		}

		if (errorOfCreating.isEmpty() || errorOfCreating == null) {
			try {
				if (userDAO.editPassword(user, newPassword)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка изменения пароля пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of changing password of user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка изменения пароля пользователя");
				} else {
					throw new ServiceException("Error of changing password of user");
				}
			}
		} else {
			ErrorMap.setErrorsOfCreating(errorOfCreating);
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Ошибка изменения пароля пользователя");
			} else {
				throw new ServiceException("Error of changing password of user");
			}
		}

	}

	@Override
	public boolean delete(final String username, final String locale) throws ServiceException {

		if (!username.isEmpty() || username != null) {
			try {
				if (userDAO.delete(username)) {
					return true;
				} else {
					if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
						throw new ServiceException("Ошибка удаления пользователя, попробуйте позже");
					} else {
						throw new ServiceException("Error of deleting user, try it later");
					}
				}
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка удаления пользователя");
				} else {
					throw new ServiceException("Error of deleting user");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Пользователь не найден");
			} else {
				throw new ServiceException("The user is not found");
			}
		}

	}

	@Override
	public User getUser(final String username, final String locale) throws ServiceException {
		User user = null;

		if (!username.isEmpty() || username != null) {
			try {
				user = userDAO.getUser(username);
			} catch (DAOException e) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Ошибка редактирования пользователя");
				} else {
					throw new ServiceException("Error of editing user");
				}
			}
		} else {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Пользователь не найден");
			} else {
				throw new ServiceException("The user is not found");
			}
		}

		return user;
	}

	@Override
	public void validateParamUser(final User user, final String locale) throws ServiceException {
		errorOfCreating.replaceAll((k, v) -> null);
		errorOfCreating.clear();
		tempDataForError.replaceAll((k, v) -> null);
		tempDataForError.clear();

		String userName = null;

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
					throw new ServiceException("Ошибка проверки пользователя");
				} else {
					throw new ServiceException("The error of checking user");
				}
			}
			if (userName != null) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME,
							"Пользователь с таким именем уже существует");
				} else {
					errorOfCreating.put(ServiceConstant.USERNAME_PARAM_NAME,
							"The user with such name has already existed");
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
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME,
							"Вы ввели некорректный мобильный номер");
				} else {
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "You entered incorrect mobile number");
				}
			} else {
				tempDataForError.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, user.getPhoneNumber());
			}
		}

		tempDataForError.put(ServiceConstant.ADDRESS_PARAM_NAME, user.getAddress());
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_NATURAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.NAME_PARAM_NAME,
					user.getCustomer().getNaturalCustomerInfo().getName());
			tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME,
					user.getCustomer().getNaturalCustomerInfo().getSurname());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_LEGAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.NAME_PARAM_NAME, user.getCustomer().getLegalCustomerInfo().getName());
			tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME,
					user.getCustomer().getLegalCustomerInfo().getSurname());
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME,
					user.getCustomer().getLegalCustomerInfo().getRequisites());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_COMPANY_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getRequisites());
			tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getNameCompany());
			tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getNameAgent());
			tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
			tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getDescription());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_LEGAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME, user.getPerformer().getRequisites());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_COMPANY_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getNameCompany());
			tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getNameAgent());
			tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
			tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getDescription());
		}
	}

	@Override
	public void validateParamUserChanging(final User user, final String locale) throws ServiceException {

		errorOfCreating.replaceAll((k, v) -> null);
		errorOfCreating.clear();
		tempDataForError.replaceAll((k, v) -> null);
		tempDataForError.clear();

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
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME,
							"Вы ввели некорректный мобильный номер");
				} else {
					errorOfCreating.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, "You entered incorrect mobile number");
				}
			} else {
				tempDataForError.put(ServiceConstant.PHONE_NUMBER_PARAM_NAME, user.getPhoneNumber());
			}
		}

		tempDataForError.put(ServiceConstant.ADDRESS_PARAM_NAME, user.getAddress());
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_NATURAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.NAME_PARAM_NAME,
					user.getCustomer().getNaturalCustomerInfo().getName());
			tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME,
					user.getCustomer().getNaturalCustomerInfo().getSurname());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_LEGAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.NAME_PARAM_NAME, user.getCustomer().getLegalCustomerInfo().getName());
			tempDataForError.put(ServiceConstant.SURNAME_PARAM_NAME,
					user.getCustomer().getLegalCustomerInfo().getSurname());
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME,
					user.getCustomer().getLegalCustomerInfo().getRequisites());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.CUSTOMER_PARAM_NAME) && user.getCustomer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.CUSTOMER_COMPANY_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getRequisites());
			tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getNameCompany());
			tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getNameAgent());
			tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getSurnameAgent());
			tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME,
					user.getCustomer().getCompanyCustomerInfo().getDescription());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_LEGAL_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.REQUISITES_PARAM_NAME, user.getPerformer().getRequisites());
		}
		if (user.getPerson().getTypePerson().equals(ServiceConstant.PERFORMER_PARAM_NAME) && user.getPerformer()
				.getOwnership().getFormOwnership().equals(ServiceConstant.PERFORMER_COMPANY_PARAM_NAME)) {
			tempDataForError.put(ServiceConstant.COMPANY_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getNameCompany());
			tempDataForError.put(ServiceConstant.NAME_AGENT_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getNameAgent());
			tempDataForError.put(ServiceConstant.SURNAME_AGENT_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getSurnameAgent());
			tempDataForError.put(ServiceConstant.DESCRIPTION_PARAM_NAME,
					user.getPerformer().getCompanyPerformerInfo().getDescription());
		}

	}

	@Override
	public List<User> getAllPerformer(final String page, final String locale) throws ServiceException {

		List<User> users = null;
		int currentPage = 1;
		int noOfRecords = 0;
		int noOfPages = 0;
		int recordsPerPage = 4;

		try {
			if (page != null) {
				currentPage = Integer.parseInt(page);
			}
			users = userDAO.getAllPerformer((currentPage - 1) * recordsPerPage, recordsPerPage);
			noOfRecords = userDAO.getNoOfRecords();
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			pagesDetails.put(ServiceConstant.NO_OF_PAGES_PARAM_NAME, noOfPages);
			pagesDetails.put(ServiceConstant.CURRENT_PAGE_PARAM_NAME, currentPage);
			PageDetail.setPagesDetails(pagesDetails);
			if (users.isEmpty() || users == null) {
				if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
					throw new ServiceException("Список пуст");
				} else {
					throw new ServiceException("Users list is empty");
				}
			}
		} catch (DAOException e) {
			if (locale.equals(ServiceConstant.LOCALE_RU_PARAM_NAME)) {
				throw new ServiceException("Невозможно получить список пользователей, попробуйте позже");
			} else {
				throw new ServiceException("Impossible to get users list, try it later");
			}
		}

		return users;
	}

}
