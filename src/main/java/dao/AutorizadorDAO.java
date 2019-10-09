package dao;

import modelo.Autorizador;

import java.util.List;

public interface AutorizadorDAO {
    public boolean salvar(Autorizador autorizador);
    public List<Autorizador> buscarTodos();
    public boolean desativar(int id_autorizador);
    public boolean validarRegra(Autorizador autorizador);
}
