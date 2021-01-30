package br.edu.iftm.os.logic;

import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;

public interface CrudLogic<E> extends Serializable{
    
    public E salvar(E entidade) throws ErroNegocioException, ErroSistemaException;
    public void deletar(E entidade) throws ErroNegocioException, ErroSistemaException;
    public E buscarPorId(E entidade) throws ErroNegocioException, ErroSistemaException;
    public List<E> buscar(E entidade) throws ErroNegocioException, ErroSistemaException;
    
}
