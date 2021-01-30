package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.CaixaLogic;
import br.edu.iftm.os.model.Caixa;
import br.edu.iftm.os.model.Endereco;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named @SessionScoped @Getter
public class CaixaBean extends CrudBean<Caixa, CaixaLogic>{

    @Inject
    private CaixaLogic logic;
    
    public CaixaBean() {
        super(Caixa.class);
        }
    
    @Override





    public CaixaLogic getLogic() {
        return this.logic;
    }
    
}
