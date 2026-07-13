package mycontacts.controller;

import java.util.ArrayList;

import mycontacts.exceptions.ContatoDuplicadoException;
import mycontacts.exceptions.ContatoNaoEncontradoException;
import mycontacts.model.Contato;

public class Agenda implements Buscavel{

    ArrayList<Contato> listaContatos = new ArrayList<>();

    public void adicionarContato(Contato novoContato){
        for(int i = 0; i < listaContatos.size(); i++){
            if(listaContatos.get(i).getNome().equalsIgnoreCase(novoContato.getNome())){
                throw new ContatoDuplicadoException("Um contato com esse nome já existe!");
            }
        }
        listaContatos.add(novoContato);
    }

    public void listarContatos(){
        for(int i = 0; i < listaContatos.size(); i++){
            System.out.println(listaContatos.get(i));
        }
    }

    public Contato buscarPorNome(String nome){
        for(int i = 0; i < listaContatos.size(); i++){
            if(listaContatos.get(i).getNome().equalsIgnoreCase(nome)){
                return listaContatos.get(i);
            }
        }
        throw new ContatoNaoEncontradoException("Nome não existe na agenda!");
    }


    public Contato buscarPorEmail(String email) {
        for(int i = 0; i < listaContatos.size(); i++){
            if(listaContatos.get(i).getEmail().equalsIgnoreCase(email)){
                return listaContatos.get(i);
            }
        }
        throw new ContatoNaoEncontradoException("Email não existe na agenda!");
    }

    public void removerContato(String nome) {
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaContatos.remove(i);
                System.out.println("Contato removido com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado");
    }
}