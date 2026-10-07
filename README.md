```markdown
# 📇 MyContacts - Agenda de Contactos

Um sistema interativo de gestão de contactos com **Interface Gráfica (JavaFX)** e **persistência de dados**, desenvolvido inteiramente em Java. O projeto foca-se na aplicação prática dos pilares da Programação Orientada a Objetos (POO), arquitetura MVC, validação de dados e testes automatizados.

## ✨ Funcionalidades

- **Adicionar Contactos:** Suporte para contactos Padrão e Comerciais (com campo de empresa).
- **Listagem Visual:** Visualização em tempo real de todos os contactos guardados através de uma tabela interativa na ecrã.
- **Persistência de Dados:** Os contactos são guardados de forma segura e permanente numa base de dados SQLite local (`agenda.db`).
- **Validação de Dados:** Verificação rigorosa do formato de e-mails e telefones (DDD + número).
- **Busca e Remoção:** Ferramentas para procurar contactos específicos e removê-los da agenda.

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem & Build:** Java (JDK 21) com gestão de dependências via Maven.
- **Interface Gráfica (GUI):** JavaFX com estruturação visual em ficheiros `.fxml`.
- **Base de Dados:** SQLite com integração através da API JDBC.
- **Testes Automatizados:** JUnit 5 para a criação de testes unitários que garantem a fiabilidade das validações de regras de negócio.
- **POO & Genéricos:** Encapsulamento, Herança (`Contato` -> `ContatoComercial`), Polimorfismo e utilização de Generics (`RepositorioGenerico<T>`).
- **Tratamento de Exceções:** Criação de exceções personalizadas (`ContatoNaoEncontradoException`, `ContatoDuplicadoException`, `FormatoInvalidoException`).
- **Arquitetura de Software:** Implementação dos padrões estruturais MVC (Model-View-Controller) e DAO (Data Access Object), com o projeto dividido nos pacotes `app`, `controller`, `dao`, `model`, `exceptions`, `utils` e `view`.

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Ter o **Java JDK** (recomendado versão 21 LTS) instalado na sua máquina.
- Git instalado.
- IDE com suporte a projetos Maven (recomendado o IntelliJ IDEA, que descarrega automaticamente as bibliotecas necessárias).

### Passo a Passo

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone [https://github.com/matheuslevicarmo99/MyContacts---Projeto-Modulo-Basico-Capacita.git](https://github.com/matheuslevicarmo99/MyContacts---Projeto-Modulo-Basico-Capacita.git)

```

2. Abra o projeto na sua IDE de preferência e aguarde que o Maven descarregue todas as dependências do `pom.xml`.
3. Localize o ficheiro principal de execução no seguinte caminho: `src/mycontacts/app/Main.java`.
4. Execute a classe principal (No IntelliJ, abra a classe `Main` e clique no botão ▶️ verde ou prima `Shift + F10`).
5. Interaja com o sistema! A interface gráfica irá abrir, gerando automaticamente a base de dados na raiz do projeto, e já poderá adicionar e gerir os seus contactos.

---

*Nota: A versão original do projeto, que funcionava exclusivamente via consola e guardava os dados em memória RAM, encontra-se devidamente preservada e disponível para consulta na secção de **Releases** (`v1.0-console`) deste repositório.*

```

```