package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.CrudLogic;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CrudBean<E, L extends CrudLogic<E>> extends JSFUtil {

    private Status status = Status.BUSCA;

    private E entidade;
    private List<E> entidades;
    private Class<E> classeEntidade;

    private enum Status {
        BUSCA,
        NOVO,
        EDITA
    }

    public CrudBean(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    public void novo() {
        try {
            this.entidade = classeEntidade.getDeclaredConstructor().newInstance();
            status = Status.NOVO;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(E entidade) {
        try {
            this.entidade = getLogic().buscarPorId(entidade);
            status = Status.EDITA;
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar(E entidade){
        try {
            this.getLogic().deletar(entidade);
            this.entidades.remove(entidade);
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            getLogic().salvar(this.entidade);
            addMensagemInfo("Salvo com sucesso");
            buscar();
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void buscar() {
        if (!status.equals(Status.BUSCA)) {
            status = Status.BUSCA;
            return;
        }
        try {
            this.entidades = getLogic().buscar(entidade);
            if (this.entidades.isEmpty()) {
                addMensagemAviso("Nenhum dado cadastrado.");
            }
        } catch (ErroNegocioException ex) {
            addMensagemErro(ex.getMessage());
        } catch (ErroSistemaException ex) {
            addMensagemFatal(ex.getMessage());
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract L getLogic();

}
