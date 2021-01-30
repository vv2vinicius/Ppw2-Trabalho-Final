package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.PermissaoLogic;
import br.edu.iftm.os.logic.UsuarioLogic;
import br.edu.iftm.os.model.Permissao;
import br.edu.iftm.os.model.Usuario;
import br.edu.iftm.os.util.MD5Util;
import br.edu.iftm.os.util.StringHelper;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
@Getter @Setter
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic>{
    
    @Inject
    private UsuarioLogic logic;
    
    private String senha;
    
    @Inject
    private PermissaoLogic permissaoLogic;

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public void salvar() {
        if(StringHelper.isNotEmpty(this.senha)){
            this.senha = MD5Util.md5Hex(senha);
            getEntidade().setSenha(this.senha);
        }
        super.salvar();
    }    

    @Override
    public UsuarioLogic getLogic() {
        return this.logic;
    }
    
    public void alterarAtivacao(){
        if(this.getEntidade().getDataDesativacao() == null){
            this.getEntidade().setDataDesativacao(new Date());
        } else {
            this.getEntidade().setDataDesativacao(null);
        }
        addMensagemAviso("Para confirmar click em salvar.");
    }
    
    public List<Permissao> getPermissoes() {
        try {
            return permissaoLogic.buscar();
        } catch (ErroSistemaException ex) {
            addMensagemErro(ex.getMessage());
            return new ArrayList<>();
        }
    }
}
