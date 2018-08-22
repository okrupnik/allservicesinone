package by.epam.dao;

import by.epam.dao.exception.DAOException;
import by.epam.domain.performer.CompanyPerformerInfo;
import by.epam.domain.performer.LegalPerformerInfo;
import by.epam.domain.performer.Performer;

public interface PerformerDAO {
	
	Performer createLegalPerformer(final Performer performer, final LegalPerformerInfo legalPerformerInfo) throws DAOException;
	Performer createCompanyPerformer(final Performer performer, final CompanyPerformerInfo companyPerformerInfo) throws DAOException;
	Performer checkPerformer(final String login, final String password) throws DAOException;
	Performer checkLoginPerformer(final String login) throws DAOException;
	LegalPerformerInfo getLegalPerformerInfo(final String login) throws DAOException;
	CompanyPerformerInfo getCompanyPerformerInfo(final String login) throws DAOException;
	boolean editLegalPerformer(final Performer performer, final LegalPerformerInfo legalPerformerInfo) throws DAOException;
	boolean editCompanyPerformer(final Performer performer, final CompanyPerformerInfo companyPerformerInfo) throws DAOException;
	Performer delete(final String login) throws DAOException;

}
