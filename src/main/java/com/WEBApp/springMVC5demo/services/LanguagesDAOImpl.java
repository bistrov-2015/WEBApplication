/*
package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.repository.LanguagesDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Repository
public class LanguagesDAOImpl implements LanguagesDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Boolean deleteRowByLanguageId(long languageId) {
        String sql = "DELETE FROM Languages l WHERE l.LANGUAGE_ID = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, languageId);
        int rowsDeleted = query.executeUpdate();
        return rowsDeleted > 0;
    }
}
*/
