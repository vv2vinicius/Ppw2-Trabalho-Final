package br.edu.iftm.os.repository;

import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GenericRepository<E, ID extends Serializable> implements Serializable {

    @Inject
    private EntityManager em;

    public E salvar(E entidade) throws ErroSistemaException {
//        em.getTransaction().begin();
        try {
            entidade = em.merge(entidade);
//            em.getTransaction().commit();
            return entidade;
        } catch (Exception ex) {
//            em.getTransaction().rollback();
            throw new ErroSistemaException("Erro ao salvar " + getEntityClass().getSimpleName(), ex);
        }
    }

    //Salvar e Deletar necessita de transação porém está sendo criada na classe lógica com a 
    //anotação Transacao
    public void remover(ID id) throws ErroSistemaException {
//        em.getTransaction().begin();
        try {
            E entidade = em.find(getEntityClass(), id);
            em.remove(entidade);
//            em.getTransaction().commit();
        } catch (Exception ex) {
//            em.getTransaction().rollback();
            throw new ErroSistemaException("Erro ao remover " + getEntityClass().getSimpleName(), ex);
        }
    }

    public E buscarPorId(ID id) throws ErroSistemaException {
        try {
            E entidade = em.find(getEntityClass(), id);
            return entidade;
        } catch (Exception ex) {
            throw new ErroSistemaException("Erro ao buscar " + getEntityClass().getSimpleName() + " com id = "+id, ex);
        }
    }

    public List<E> listar() throws ErroSistemaException {
        try {
            List<E> entidades = em.createQuery("from " + getEntityClass().getName(), getEntityClass()).getResultList();
            return entidades;
        } catch (Exception ex) {
            throw new ErroSistemaException("Erro ao listar " + getEntityClass().getSimpleName(), ex);
        }
    }

    public Class<E> getEntityClass() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        return (Class<E>) paramType.getActualTypeArguments()[0];
    }

}
