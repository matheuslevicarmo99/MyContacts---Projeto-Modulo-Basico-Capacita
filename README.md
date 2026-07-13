# 📇 MyContacts - Agenda de Contatos

Um sistema interativo de gerenciamento de contatos via console, desenvolvido inteiramente em Java. O projeto foca na aplicação prática dos pilares da Programação Orientada a Objetos (POO), validação de dados e arquitetura modular.

## ✨ Funcionalidades

- **Adicionar Contatos:** Suporte para contatos Padrão e Comerciais (com campo de empresa).
- **Listagem:** Visualização de todos os contatos salvos na memória.
- **Busca Inteligente:** Pesquisa de contatos pelo Nome ou E-mail.
- **Remoção:** Exclusão rápida de contatos da agenda.
- **Validação de Dados:** Verificação de formato de e-mails e telefones (DDD + número).

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem:** Java (JDK 21)
- **POO:** Encapsulamento, Herança (`Contato` -> `ContatoComercial`) e Polimorfismo (`Interface Buscavel`).
- **Estruturas de Dados:** Uso de `ArrayList` para armazenamento dinâmico.
- **Tratamento de Exceções:** Criação de exceções customizadas para regras de negócio (`ContatoNaoEncontradoException`, `ContatoDuplicadoException`, `FormatoInvalidoException`).
- **Arquitetura:** Projeto dividido nos pacotes `app`, `controller`, `model`, `exceptions` e `utils`.

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Ter o **Java JDK** (recomendado versão 21 LTS) instalado em sua máquina.
- Git instalado.

### Passo a Passo

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone [https://github.com/matheuslevicarmo99/MyContacts---Projeto-Modulo-Basico-Capacita.git](https://github.com/matheuslevicarmo99/MyContacts---Projeto-Modulo-Basico-Capacita.git)

   Abra o projeto na sua IDE de preferência (recomendamos o IntelliJ IDEA).

2. Localize o arquivo principal de execução no seguinte caminho: src/mycontacts/app/Main.java.

3. Execute a classe principal (No IntelliJ, abra a classe Main e clique no botão ▶️ verde ou pressione Shift + F10).

4. Interaja com o sistema! O menu será exibido e você poderá responder aos comandos digitando as opções diretamente no console.
