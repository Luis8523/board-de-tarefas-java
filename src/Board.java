import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("🎉 Tarefa adicionada com sucesso!");
    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("📌 Lista de Tarefas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + " - " + tasks.get(i));
        }
    }

    public void completeTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).concluir();
            System.out.println("✅ Tarefa marcada como concluída.");
        } else {
            System.out.println("❌ Índice inválido.");
        }
    }

    public void removeTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index);
            System.out.println("🗑️ Tarefa removida com sucesso.");
        } else {
            System.out.println("❌ Índice inválido.");
        }
    }

    public void editarTarefa(int index, String novoTitulo, String novaDescricao, Prioridade novaPrioridade) {
        if (isValidIndex(index)) {
            Task tarefa = tasks.get(index);
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setPrioridade(novaPrioridade);
            System.out.println("✏️ Tarefa editada com sucesso.");
        } else {
            System.out.println("❌ Índice inválido.");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}