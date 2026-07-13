package mycontacts.controller;

import mycontacts.model.Contato;

public interface Buscavel {
    Contato buscarPorNome(String nome);
    Contato buscarPorEmail(String email);
}
