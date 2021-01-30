package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Caixa;
import br.edu.iftm.os.repository.CaixaRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class CaixaLogic implements CrudLogic<Caixa> {

    @Inject
    private CaixaRepository repository;

    @Override
    @Transacao
    public Caixa salvar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Caixa buscarPorId(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        if (entidade == null || entidade.getId() == null) {
            throw new ErroNegocioException("Caixa não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;

    }

    @Override
    public List<Caixa> buscar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        List clientes = repository.listar();
        return clientes;
    }

}
