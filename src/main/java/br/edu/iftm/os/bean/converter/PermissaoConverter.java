package br.edu.iftm.os.bean.converter;

import br.edu.iftm.os.model.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;


//@FacesConverter(forClass = Permissao.class)
public class PermissaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        System.out.println(id);
        if (id != null && !"".equals(id)) {
            Permissao permissao = (Permissao) uic.getAttributes().get("permissao_" + id);
            return permissao;

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if(obj == null || !(obj instanceof Permissao)){
            return "";
        }
        Permissao permissao = (Permissao) obj;
        if(permissao.getId() != null){
            uic.getAttributes().put("permissao_"+permissao.getId(), permissao);
            return permissao.getId().toString();
        }
        return "";
    }
}
