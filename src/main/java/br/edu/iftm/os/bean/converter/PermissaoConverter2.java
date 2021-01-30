package br.edu.iftm.os.bean.converter;

import br.edu.iftm.os.model.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class PermissaoConverter2 implements Converter{

    @Override
    public Permissao getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("Permissao: "+string);
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        System.out.println(t.toString());
        return t.toString();
    }
    
}
