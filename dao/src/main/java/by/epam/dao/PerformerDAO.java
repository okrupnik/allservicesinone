package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;

public interface PerformerDAO {
	
	Performer createLegalPerformer(Performer performer, LegalPerformerInfo legalPerformerInfo) throws DAOException;
	Performer createCompanyPerformer(Performer performer, CompanyPerformerInfo companyPerformerInfo) throws DAOException;
	Performer checkPerformer(String login, String password) throws DAOException;
	Performer checkLoginPerformer(String login) throws DAOException;
	LegalPerformerInfo getLegalPerformerInfo(String login) throws DAOException;
	CompanyPerformerInfo getCompanyPerformerInfo(String login) throws DAOException;
	boolean editLegalPerformer(Performer performer, LegalPerformerInfo legalPerformerInfo) throws DAOException;
	boolean editCompanyPerformer(Performer performer, CompanyPerformerInfo companyPerformerInfo) throws DAOException;
	Performer delete(String login) throws DAOException;

}
