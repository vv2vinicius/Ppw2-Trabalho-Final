package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.ClienteLogic;
import br.edu.iftm.os.logic.OsLogic;
import br.edu.iftm.os.model.Cliente;
import br.edu.iftm.os.model.OS;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class OsBean extends CrudBean<OS, OsLogic> {

    @Inject
    private OsLogic logic;
    @Inject
    private ClienteLogic clienteLogic;

    public OsBean() {
        super(OS.class);
    }

    @Override
    public OsLogic getLogic() {
        return this.logic;
    }
  
}
