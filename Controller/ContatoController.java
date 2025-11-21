package Controller;

import Db.Database;
import Model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoController {

    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
//try cach para lidar com possíveis exceções
        // tenta e depois fecha a conexão
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM contatos"; 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Contato c = new Contato(
                        rs.getInt("id_contato"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                contatos.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contatos;
    }

    public void inserir(Contato contato) {

        String sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getnome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());

            stmt.executeUpdate();

            System.out.println("Contato inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {

        String sql = "DELETE FROM contatos WHERE id_contato = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Contato deletado com sucesso!");
            } else {
                System.out.println("Nenhum contato encontrado com esse ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Contato contato) {

        String sql = "UPDATE contatos SET nome = ?, email = ?, telefone = ? WHERE id_contato = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contato.getnome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setInt(4, contato.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Contato atualizado com sucesso!");
            } else {
                System.out.println("Nenhum contato encontrado com esse ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
