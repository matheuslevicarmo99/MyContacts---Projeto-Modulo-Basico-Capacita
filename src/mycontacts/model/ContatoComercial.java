package mycontacts.model;

public class ContatoComercial extends Contato{
    private String empresa;

    public ContatoComercial(String nome, String telefone, String email, String empresa){
        super(nome, telefone, email);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "\n[ Contato Comercial ]" +
                "\nNome: " + getNome() +
                "\nTelefone: " + getTelefone() +
                "\nE-mail: " + getEmail() +
                "\nEmpresa: " + empresa +
                "\n--------------------------------";
    }
}