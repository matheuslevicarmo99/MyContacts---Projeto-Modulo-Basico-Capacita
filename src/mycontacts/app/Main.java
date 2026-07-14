package mycontacts.app;

import mycontacts.controller.Agenda;
import mycontacts.exceptions.ContatoDuplicadoException;
import mycontacts.exceptions.ContatoNaoEncontradoException;
import mycontacts.exceptions.FormatoInvalidoException;
import mycontacts.model.Contato;
import mycontacts.model.ContatoComercial;
import mycontacts.utils.Validador;

import java.util.Scanner;


public class Main{
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        Agenda agenda = new Agenda();
        int acao = 0;

        do{
            System.out.println();
            System.out.println("====== AGENDA DE CONTATOS ======");
            System.out.println("1. Adicionar novo contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Buscar por nome");
            System.out.println("4. Buscar por email");
            System.out.println("5. Remover contato");
            System.out.println("6. Sair");
            System.out.println("================================");

            System.out.println("Aguardando ação:");

            acao = sc.nextInt();
            sc.nextLine();

            if(acao == 1){
                System.out.println("Qual o tipo de contato: 1 - Comum ou 2 - Comercial");
                int tipoDeContato = sc.nextInt();
                sc.nextLine();
                if(tipoDeContato == 1){
                    try {
                        System.out.println("Adicionar Contato Padrão:");
                        System.out.println("Insira os dados em ordem: Nome, Telefone e Email.");
                        System.out.print("Digite o Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Digite o Telefone (apenas números com DDD (Ex: 85999881267): ");
                        String telefone = sc.nextLine();
                        Validador.validarTelefone(telefone);

                        System.out.print("Digite o Email: ");
                        String email = sc.nextLine();
                        Validador.validarEmail(email);

                        Contato contato = new Contato(nome, telefone, email);
                        agenda.adicionarContato(contato);
                    }catch (ContatoDuplicadoException erro){
                        System.out.println("Este nome já está registrado na agenda !!!");
                        System.out.println("Detalhes do erro: " + erro.getMessage());
                    }catch (FormatoInvalidoException e){
                        System.out.println("Erro !!!");
                        System.out.println("Detalhes do erro: " + e.getMessage());
                    }
                } else if (tipoDeContato == 2) {
                    try {
                        System.out.println("Adicionar Contato Comercial:");
                        System.out.println("Insira os dados em ordem: Nome, Telefone, Email e Empresa.");
                        System.out.print("Digite o Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Digite o Telefone: ");
                        String telefone = sc.nextLine();
                        Validador.validarTelefone(telefone);

                        System.out.print("Digite o Email: ");
                        String email = sc.nextLine();
                        Validador.validarEmail(email);

                        System.out.print("Digite a Empresa:");
                        String empresa = sc.nextLine();
                        ContatoComercial cc = new ContatoComercial(nome, telefone, email, empresa);
                        agenda.adicionarContato(cc);
                    }catch (ContatoDuplicadoException erro){
                        System.out.println("Este nome já está registrado na agenda !!!");
                        System.out.println("Detalhes do erro: " + erro.getMessage());
                    }catch (FormatoInvalidoException e){
                        System.out.println("Erro !!!");
                        System.out.println("Detalhes do erro: " + e.getMessage());
                    }
                }else{
                    System.out.println("ERRO: Opção Inválida");
                }

            } else if (acao == 2) {
                agenda.listarContatos();

            } else if (acao == 3) {
                try {
                    System.out.println("Buscar nome:");
                    System.out.println("Digite o nome que deseja buscar:");
                    String nomeBusca = sc.nextLine();
                    System.out.println(agenda.buscarPorNome(nomeBusca));
                }catch (ContatoNaoEncontradoException e){
                    System.out.println("Nome não esta na agenda !");
                    System.out.println("Detalhes do erro: " + e.getMessage());
                }
            } else if (acao == 4) {
                try {
                    System.out.println("Buscar email:");
                    System.out.println("Digite o email que deseja buscar:");
                    String emailBusca = sc.nextLine();
                    System.out.println(agenda.buscarPorEmail(emailBusca));
                }catch (ContatoNaoEncontradoException e){
                    System.out.println("Entrada inválida !");
                    System.out.println("Detalhes do erro: " + e.getMessage());
                }
            }

            else if (acao == 5) {
                System.out.println("Remover nome:");
                System.out.println("Digite o nome que deseja remover:");
                String nomeRemover = sc.nextLine();
                agenda.removerContato(nomeRemover);
            } else if (acao == 6) {
                System.out.println("Saindo do programa.");
            }
            else{
                System.out.println("ERRO: Opção Inválida");
            }
        }while (acao != 6);
    }
}