package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Servico;
import br.edu.iftm.os.repository.ServicoRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class ServicoLogic implements CrudLogic<Servico> {

    @Inject
    private ServicoRepository repository;

    @Override
    @Transacao
    public Servico salvar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        if (entidade.getDescricao() == null || entidade.getDescricao().equals("")) {
            throw new ErroNegocioException("Descrição é obrigatória");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        this.repository.remover(entidade.getId());
    }

    @Override
    public Servico buscarPorId(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        if (entidade != null || entidade.getId() != null) {
            return this.repository.buscarPorId(entidade.getId());
        }
        throw new ErroNegocioException("Serviço não pode ser carregado.");
    }

    @Override
    public List<Servico> buscar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        return this.repository.listar();
    }

}
