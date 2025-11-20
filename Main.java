import Controller.ContatoController;
import Model.Contato;
import View.ContatoView;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Entrou no main");    
        int programa = 0;
        ContatoController controller = new ContatoController();
        ContatoView view = new ContatoView();

        while (programa != 5) {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                MENU                  ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1 - Listar Contatos                 ║");
            System.out.println("║  2 - Cadastrar Contato               ║");
            System.out.println("║  3 - Deletar Contato                 ║");
            System.out.println("║  4 - Atualizar Contato               ║");
            System.out.println("║  5 - Sair                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
        
        Scanner s = new Scanner(System.in);
        int opcao = s.nextInt();
        
        switch (opcao) {
                case 1:
                    List<Contato> contatos = controller.listarContatos();
                    view.mostrarContatos(contatos);
                    espacamento();
                    break;
                case 2:
                    Scanner smenu = new Scanner(System.in);
                    System.out.println("Digite o nome: ");
                    String nome = smenu.nextLine();
                    System.out.println("Digite o email: ");
                    String email = smenu.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = smenu.nextLine();
                    
                    Contato novo = new Contato(0, nome, email, telefone);
                    controller.inserir(novo);
                    espacamento();
                    break;

                case 3:
                    Scanner smenu2 = new Scanner(System.in);
                    System.out.print("Digite o ID do contato que deseja deletar: ");
                    int idDelete = smenu2.nextInt();
                    controller.deletar(idDelete);
                    espacamento();
                    break;

                case 4:
                    Scanner upd = new Scanner(System.in);
    
                    System.out.print("Digite o ID do contato que deseja atualizar: ");
                    int idUpd = upd.nextInt();
                    upd.nextLine(); // limpar buffer
    
                    System.out.print("Novo nome: ");
                    String novoNome = upd.nextLine();
    
                    System.out.print("Novo email: ");
                    String novoEmail = upd.nextLine();
    
                    System.out.print("Novo telefone: ");
                    String novoTelefone = upd.nextLine();
    
                    Contato atualizado = new Contato(idUpd, novoNome, novoEmail, novoTelefone);
                    controller.atualizar(atualizado);
    
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Atualização concluída");
                    System.out.println("-------------------------------");
                    System.out.println();
                    break;  

                case 5:
                    programa = 5;
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Opção inválida");
                    espacamento();
                    break;
        }
        s.nextLine();  
        }

        
       
    }

    public static void espacamento() {
        System.out.println();
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println();
    }
    
}

