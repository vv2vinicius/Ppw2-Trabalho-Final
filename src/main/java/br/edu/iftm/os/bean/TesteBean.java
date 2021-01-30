package br.edu.iftm.os.bean;

import br.edu.iftm.os.model.Permissao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Getter;
import lombok.Setter;


@Named
@SessionScoped
@Getter @Setter
public class TesteBean implements Serializable {
    
    private String nome;
    private String ola;
    
    public void dizerOla(){
        EntityManager em = getEntityManager();
        Permissao p1 = new Permissao();
        p1.setId(3);
        p1.setNome("BUSCAR_CLIENTE");
        p1.setDescricao("Permite BUSCAR os clientes no sistema.");
        em.getTransaction().begin();
        em.merge(p1);
        em.getTransaction().commit();
        List<Permissao> p  = em.createQuery("from Permissao", Permissao.class).getResultList();
        this.ola = p.get(p.size()-1).getDescricao();
    }
    
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaospu");
        return emf.createEntityManager();
    }
}