package br.unifae.engsof.poo3.gerenciadorDeTarefas.Model;

import java.util.ArrayList;
import java.util.List;

public class GerenciaTarefa {

    private static GerenciaTarefa instance; // Instância única da classe
    private static List<Tarefa> tarefas = null; // Lista de tarefas

    //Tentando criar uma lista única para o cadastro
    /*public GerenciaTarefa(){;
        if(tarefas != null){
            tarefas = new ArrayList<Tarefa>();
        }
    } */
    // Construtor privado para evitar instanciação externa
    private GerenciaTarefa() {
        tarefas = new ArrayList<>();
    }

    // Método estático para obter a instância única
    public static GerenciaTarefa getInstance() {
        if (instance == null) {
            instance = new GerenciaTarefa();
        }
        return instance;
    }

    // Método para cadastrar uma tarefa
    public static boolean cadastrar(Tarefa tarefa) {
        if (tarefa != null && !tarefas.contains(tarefa)) {
            if (tarefa != null && !tarefas.contains(tarefa)) {
                return tarefas.add(tarefa);
            }
        }
        return false;
    }

    // Método para obter a lista de tarefas
    public static List<Tarefa> getTarefas() {
        return tarefas;
    }

    public List<TarefaComPrazo> getTarefasComPrazo() {
        List<TarefaComPrazo> tarefasComPrazo = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa instanceof TarefaComPrazo) {
                tarefasComPrazo.add((TarefaComPrazo) tarefa);
            }
        }
        return tarefasComPrazo;
    }

    // Método para remover uma tarefa
    public static boolean removeTarefas(Tarefa tarefa) {
        if (tarefa != null) {
            return tarefas.remove(tarefa);
        }
        return false;
    }
}
