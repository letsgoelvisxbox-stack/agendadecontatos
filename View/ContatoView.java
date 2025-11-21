package View;
import Model.Contato;
import Controller.ContatoController;
import java.util.List;

public class ContatoView {
  
    // MÉTODO QUE ESTAVA FALTANDO
   public void menu() {
        ContatoController controller = new ContatoController();
        List<Contato> lista = controller.listarContatos();
        mostrarContatos(lista);
    } 
    
    public void mostrarContatos(List<Contato> contatos) {
        System.out.println("=== Lista de Contatos ===");
        for (Contato c : contatos) {
            System.out.println(c); 
        }
    }

}
