package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Permissao;
import br.edu.iftm.os.repository.PermissaoRepository;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class PermissaoLogic implements Serializable {
    
    @Inject
    private PermissaoRepository repository;
    
    public List<Permissao> buscar() throws ErroSistemaException{
        return repository.listar();
    }
    
}
