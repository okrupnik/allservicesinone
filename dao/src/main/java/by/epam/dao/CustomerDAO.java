package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;

public interface CustomerDAO {
	
	Customer createNaturalCustomer(Customer customer, NaturalCustomerInfo naturalCustomerInfo) throws DAOException;
	Customer createLegalCustomer(Customer customer, LegalCustomerInfo legalCustomerInfo) throws DAOException;
	Customer createCompanyCustomer(Customer customer, CompanyCustomerInfo companyCustomerInfo) throws DAOException;
	Customer checkCustomer(String login, String password) throws DAOException;
	Customer checkLoginCustomer(String login) throws DAOException;
	NaturalCustomerInfo getNaturalCustomerInfo(String login) throws DAOException;
	LegalCustomerInfo getLegalCustomerInfo(String login) throws DAOException;
	CompanyCustomerInfo getCompanyCustomerInfo(String login) throws DAOException;
	boolean editNaturalCustomer(Customer customer, NaturalCustomerInfo naturalCustomerInfo) throws DAOException;
	boolean editLegalCustomer(Customer customer, LegalCustomerInfo legalCustomerInfo) throws DAOException;
	boolean editCompanyCustomer(Customer customer, CompanyCustomerInfo companyCustomerInfo) throws DAOException;
	Customer delete(String login) throws DAOException;

}
