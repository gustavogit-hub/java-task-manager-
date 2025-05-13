public class Tarefa {
    private String descricao; // Texto da tarefa
    private boolean concluida; // Diz se foi concluída

    // Construtor: cria uma tarefa com descrição
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false; // começa como não concluída
    }

    // Método para marcar como concluída
    public void marcarConcluida() {
        this.concluida = true;
    }

    // Método que retorna a descrição da tarefa
    public String getDescricao() {
        return descricao;
    }

    // Método que diz se a tarefa está concluída
    public boolean isConcluida() {
        return concluida;
    }
}
