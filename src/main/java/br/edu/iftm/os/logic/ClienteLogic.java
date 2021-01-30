package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Cliente;
import br.edu.iftm.os.repository.ClienteRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class ClienteLogic implements CrudLogic<Cliente> {

    @Inject
    private ClienteRepository repository;
    
    @Override
    @Transacao
    public Cliente salvar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade.getDataCadastro() == null){
            entidade.setDataCadastro(new Date());
        }
        if(entidade.getNomeFantasia() == null || entidade.getNomeFantasia().equals("")){
            throw new ErroNegocioException("Nome fantasia é obrigatório");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Cliente buscarPorId(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("Cliente não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;
        
    }

    @Override
    public List<Cliente> buscar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        List clientes = repository.listar();
        return clientes;
    }
 
    
    
}
