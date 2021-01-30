package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Usuario;
import br.edu.iftm.os.repository.UsuarioRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class UsuarioLogic implements CrudLogic<Usuario>{

    @Inject
    private UsuarioRepository repository;
    
    @Override
    @Transacao
    public Usuario salvar(Usuario entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade.getDataCadastro() == null) {
            entidade.setDataCadastro(new Date());
        }
        return this.repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Usuario entidade) throws ErroNegocioException, ErroSistemaException {
        this.repository.remover(entidade.getId());
    }

    @Override
    public Usuario buscarPorId(Usuario entidade) throws ErroNegocioException, ErroSistemaException {
        return this.repository.buscarPorId(entidade.getId());
    }

    @Override
    public List<Usuario> buscar(Usuario entidade) throws ErroNegocioException, ErroSistemaException {
        return this.repository.listar();
    }
    
}
