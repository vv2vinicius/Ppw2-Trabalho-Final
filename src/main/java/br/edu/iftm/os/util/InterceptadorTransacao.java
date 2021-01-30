package br.edu.iftm.os.util;

import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transacao
public class InterceptadorTransacao implements Serializable {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object interceptacao(InvocationContext context) throws ErroNegocioException, ErroSistemaException {

        try {

            em.getTransaction().begin();

            Object object = context.proceed();

            em.getTransaction().commit();
            return object;

        } catch (ErroNegocioException | ErroSistemaException ex) {
            em.getTransaction().rollback();
            throw ex;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new ErroSistemaException("Erro ao executar a operação. "+ex.getMessage(), ex);
        }
    }

}
