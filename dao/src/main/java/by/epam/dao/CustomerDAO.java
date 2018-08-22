package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.customer.CompanyCustomerInfo;
import by.epam.domain.customer.Customer;
import by.epam.domain.customer.LegalCustomerInfo;
import by.epam.domain.customer.NaturalCustomerInfo;

public interface CustomerDAO {
	
	Customer createNaturalCustomer(final Customer customer, final NaturalCustomerInfo naturalCustomerInfo) throws DAOException;
	Customer createLegalCustomer(final Customer customer, final LegalCustomerInfo legalCustomerInfo) throws DAOException;
	Customer createCompanyCustomer(final Customer customer, final CompanyCustomerInfo companyCustomerInfo) throws DAOException;
	Customer checkCustomer(final String username,final String password) throws DAOException;
	Customer checkusernameCustomer(final String username) throws DAOException;
	NaturalCustomerInfo getNaturalCustomerInfo(final String username) throws DAOException;
	LegalCustomerInfo getLegalCustomerInfo(final String username) throws DAOException;
	CompanyCustomerInfo getCompanyCustomerInfofinal (String username) throws DAOException;
	boolean editNaturalCustomer(final Customer customer, final NaturalCustomerInfo naturalCustomerInfo) throws DAOException;
	boolean editLegalCustomer(final Customer customer, final LegalCustomerInfo legalCustomerInfo) throws DAOException;
	boolean editCompanyCustomer(final Customer customer, final CompanyCustomerInfo companyCustomerInfo) throws DAOException;
	Customer delete(final String username) throws DAOException;

}
