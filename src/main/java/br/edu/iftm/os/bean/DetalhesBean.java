package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.DetalhesLogic;
import br.edu.iftm.os.model.Detalhes;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class DetalhesBean extends CrudBean<Detalhes, DetalhesLogic> {
    @Inject
    private DetalhesLogic logic;

    public DetalhesBean() {
        super(Detalhes.class);
    }
    
    @Override
    public DetalhesLogic getLogic() {
        return this.logic;
    }
       
}