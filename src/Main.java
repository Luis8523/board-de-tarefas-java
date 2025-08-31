import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        System.out.println("\u001B[36m📋 Bem-vindo ao seu Board de Tarefas!\u001B[0m");

        while (true) {
            System.out.println("\n\u001B[33mEscolha uma opção:\u001B[0m");
            System.out.println("1️⃣ - Adicionar tarefa");
            System.out.println("2️⃣ - Listar tarefas");
            System.out.println("3️⃣ - Concluir tarefa");
            System.out.println("4️⃣ - Remover tarefa");
            System.out.println("5️⃣ - Editar tarefa"); // 👈 Nova opção
            System.out.println("0️⃣ - Sair");
            System.out.print("👉 Opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("📝 Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("📄 Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("🔥 Prioridade (BAIXA, MEDIA, ALTA): ");
                    String prioridadeStr = scanner.nextLine().toUpperCase();

                    try {
                        Prioridade prioridade = Prioridade.valueOf(prioridadeStr);
                        Task novaTarefa = new Task(titulo, descricao, prioridade);
                        board.addTask(novaTarefa);
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Prioridade inválida. Use BAIXA, MEDIA ou ALTA.");
                    }
                    break;

                case "2":
                    board.showTasks();
                    break;

                case "3":
                    System.out.print("✅ Índice da tarefa a concluir: ");
                    try {
                        int indexConcluir = Integer.parseInt(scanner.nextLine());
                        board.completeTask(indexConcluir);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida. Digite um número.");
                    }
                    break;

                case "4":
                    System.out.print("🗑️ Índice da tarefa a remover: ");
                    try {
                        int indexRemover = Integer.parseInt(scanner.nextLine());
                        board.removeTask(indexRemover);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida. Digite um número.");
                    }
                    break;

                case "5": // 👈 Novo case para editar tarefa
                    System.out.print("✏️ Índice da tarefa a editar: ");
                    try {
                        int indexEditar = Integer.parseInt(scanner.nextLine());
                        System.out.print("📝 Novo título: ");
                        String novoTitulo = scanner.nextLine();
                        System.out.print("📄 Nova descrição: ");
                        String novaDescricao = scanner.nextLine();
                        System.out.print("🔥 Nova prioridade (BAIXA, MEDIA, ALTA): ");
                        String novaPrioridadeStr = scanner.nextLine().toUpperCase();

                        try {
                            Prioridade novaPrioridade = Prioridade.valueOf(novaPrioridadeStr);
                            board.editarTarefa(indexEditar, novoTitulo, novaDescricao, novaPrioridade);
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ Prioridade inválida. Use BAIXA, MEDIA ou ALTA.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida. Digite um número.");
                    }
                    break;

                case "0":
                    System.out.println("👋 Obrigado por usar o Board de Tarefas. Até a próxima!");
                    return;

                default:
                    System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
        }
    }
}