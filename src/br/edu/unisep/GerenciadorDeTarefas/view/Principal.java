package br.edu.unisep.GerenciadorDeTarefas.view;

import br.edu.unisep.GerenciadorDeTarefas.model.GerenciadorDeTarefas;
import br.edu.unisep.GerenciadorDeTarefas.view.telas.Menu;

public class Principal {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Menu menu = new Menu(gerenciador);
        menu.exibirMenu();
    }
}

