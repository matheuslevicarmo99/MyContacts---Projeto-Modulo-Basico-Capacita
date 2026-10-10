package mycontacts.dao;

import java.util.List;

public interface RepositorioGenerico<T> {
    void inserir(T entidade);
    List<T> listarTodos();
    void remover(String identificador);
    List<T> buscarPorNome(String nome);
}