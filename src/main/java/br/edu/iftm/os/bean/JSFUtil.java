package br.edu.iftm.os.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil implements Serializable {
    
    public void addMensagem(FacesMessage.Severity tipoMensagem, String resumo, String detalhe){
        FacesMessage message = new FacesMessage(tipoMensagem, resumo, detalhe);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addMensagemInfo(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }
    public void addMensagemInfo(String resumo){
        addMensagem(FacesMessage.SEVERITY_INFO, resumo, null);
    }
    public void addMensagemAviso(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addMensagemAviso(String resumo){
        addMensagem(FacesMessage.SEVERITY_WARN, resumo, null);
    }
    public void addMensagemErro(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addMensagemErro(String resumo){
        addMensagem(FacesMessage.SEVERITY_ERROR, resumo, null);
    }
    public void addMensagemFatal(String resumo, String detalhe){
        addMensagem(FacesMessage.SEVERITY_FATAL, resumo, detalhe);
    }
    public void addMensagemFatal(String resumo){
        addMensagem(FacesMessage.SEVERITY_FATAL, resumo, null);
    }
    
}
