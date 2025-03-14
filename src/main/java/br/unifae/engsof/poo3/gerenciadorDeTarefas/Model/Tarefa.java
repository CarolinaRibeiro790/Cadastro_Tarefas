package br.unifae.engsof.poo3.gerenciadorDeTarefas.Model;

import java.time.LocalDate;

public abstract class Tarefa extends Object {

    private String descricao;
    private boolean concluida;
    private int prioridade;
    private LocalDate dataCriacao;

    //Sobrecarregando com dados
    public Tarefa(String descricao, int prioridade, LocalDate dataCriacao) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
        this.concluida = false;
    }

    //Construtor util para realizar consultas
    public Tarefa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Tarefa:" + "\nDescricao:" + descricao + "\nData Criação: " + dataCriacao + "\nPrioridade: " + prioridade;
    }

    @Override
      public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Tarefa tarefa = (Tarefa) obj;
        return prioridade == tarefa.prioridade &&
               concluida == tarefa.concluida &&
               descricao.equals(tarefa.descricao) &&
               dataCriacao.equals(tarefa.dataCriacao);
    }
    
    
   /* public boolean equals(Object obj) {
        //duas tarefas (objetos) são iguais  se : 1 - tiverem o mesmo endereço
        if (!this.equals(obj)) {
            return false;
        }

        // 2 - se tiverem os mesmos valores nos atributos
        if (!(obj instanceof Tarefa)) {
            return false;
        }

        if (!(this.descricao.equals(((Tarefa) obj).descricao))) {
            return false;
        }

        if (!(this.prioridade != ((Tarefa) obj).prioridade)) {
            return false;
        }

        if (!(this.concluida != ((Tarefa) obj).concluida)) {
            return false;
        }

        if (!(this.dataCriacao.equals(((Tarefa) obj).dataCriacao))) {
            return false;
        }
        return true;

    } */
}
