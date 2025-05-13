import java.util.ArrayList; // Lista de tarefas
import java.util.Scanner;   // Para ler o que o usuário digita

public class GerenciadorTarefas {
    private ArrayList<Tarefa> listaTarefas = new ArrayList<>(); // lista de tarefas
    private Scanner scanner = new Scanner(System.in); // leitor de entrada

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome ENTER

            switch (opcao) {
                case 1: adicionarTarefa(); break;
                case 2: listarTarefas(); break;
                case 3: marcarTarefaConcluida(); break;
                case 4: removerTarefa(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String desc = scanner.nextLine();
        listaTarefas.add(new Tarefa(desc));
        System.out.println("Tarefa adicionada!");
    }

    private void listarTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\n=== Lista de Tarefas ===");
        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa t = listaTarefas.get(i);
            String status = t.isConcluida() ? "[Concluída]" : "[Pendente]";
            System.out.println(i + ". " + status + " " + t.getDescricao());
        }
    }

    private void marcarTarefaConcluida() {
        listarTarefas();
        System.out.print("Digite o número da tarefa para marcar como concluída: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < listaTarefas.size()) {
            listaTarefas.get(indice).marcarConcluida();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private void removerTarefa() {
        listarTarefas();
        System.out.print("Digite o número da tarefa para remover: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < listaTarefas.size()) {
            listaTarefas.remove(indice);
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
