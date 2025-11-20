package Model;

import Db.Database;
import java.sql.*;

public class Contato {
    private int id;
    String nome;
    private String email;	
    String telefone;

    // parenteses = valores que serão passados para o construtor
    public Contato(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        
    }

    // Getters e setters
    public int getId() 
    { return id; }
    public void setId(int id)
    { this.id = id; }

    public String getnome()
    { return nome; }
    public void setnome(String nome)
    { this.nome = nome; }

    public String getEmail() 
    { return email; }

    public void setEmail(String email) 
    { this.email = email; }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Sobrescrevendo toString para exibir dados do contato
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }
}
