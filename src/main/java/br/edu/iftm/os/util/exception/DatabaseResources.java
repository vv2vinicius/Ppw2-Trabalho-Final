package br.edu.iftm.os.util.exception;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class DatabaseResources implements Serializable {

    @Produces
    @SessionScoped
    public EntityManager getEntityManager() throws ErroSistemaException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaospu");
            EntityManager em = emf.createEntityManager();
            return em;
        } catch (Exception ex) {
            throw new ErroSistemaException("Erro ao gerar EntityManager", ex);
        }
    }

    public void close(@Disposes EntityManager em){
        em.close();
    }
    
}
