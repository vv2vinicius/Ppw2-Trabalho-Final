package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.ClienteLogic;
import br.edu.iftm.os.model.Cliente;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean extends CrudBean<Cliente, ClienteLogic>{

    @Inject
    private ClienteLogic logic;

    public ClienteBean() {
        super(Cliente.class);
    }
    
    @Override
    public ClienteLogic getLogic() {
        return this.logic;
    }
    
}
