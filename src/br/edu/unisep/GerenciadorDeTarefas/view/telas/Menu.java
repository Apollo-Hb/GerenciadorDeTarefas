package br.edu.unisep.GerenciadorDeTarefas.view.telas;

import br.edu.unisep.GerenciadorDeTarefas.model.GerenciadorDeTarefas;

import javax.swing.*;

public class Menu extends JFrame {

    private GerenciadorDeTarefas gerenciador;

    public Menu(GerenciadorDeTarefas gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void exibirMenu() {
        int opcao;

        do {
            String menu = "Selecione uma opção:\n" +
                    "1. Adicionar tarefa\n" +
                    "2. Marcar tarefa como concluída\n" +
                    "3. Remover tarefa\n" +
                    "4. Exibir todas as tarefas\n" +
                    "5. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefaComoConcluida();
                    break;
                case 3:
                    removerTarefa();
                    break;
                case 4:
                    exibirTarefas();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
            }
        } while (opcao != 5);
    }

    private void adicionarTarefa() {
        String descricao = JOptionPane.showInputDialog("Digite a tarefa a ser adicionada:");
        gerenciador.adicionarTarefa(descricao);
        JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.");
    }

    private void marcarTarefaComoConcluida() {
        if (gerenciador.getQuantidadeTarefas() == 0) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para marcar como concluída.");
            return;
        }
        String tarefas = gerenciador.listarTarefas();
        int indice = Integer.parseInt(JOptionPane.showInputDialog(tarefas + "\nDigite o número da tarefa concluída:")) - 1;
        gerenciador.marcarTarefaComoConcluida(indice);
        JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída.");
    }

    private void removerTarefa() {
        if (gerenciador.getQuantidadeTarefas() == 0) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para remover.");
            return;
        }
        String tarefas = gerenciador.listarTarefas();
        int indice = Integer.parseInt(JOptionPane.showInputDialog(tarefas + "\nDigite o número da tarefa a ser removida:")) - 1;
        gerenciador.removerTarefa(indice);
        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.");
    }

    private void exibirTarefas() {
        String tarefas = gerenciador.listarTarefas();
        JOptionPane.showMessageDialog(null, tarefas.isEmpty() ? "Não há tarefas." : tarefas);
    }
}

