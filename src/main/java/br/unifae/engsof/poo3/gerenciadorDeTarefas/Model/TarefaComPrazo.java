package br.unifae.engsof.poo3.gerenciadorDeTarefas.Model;

import java.time.LocalDate;

public class TarefaComPrazo extends Tarefa {

    private LocalDate dataPrazo;

    public TarefaComPrazo(LocalDate dataPrazo, String descricao, int prioridade, LocalDate dataCriacao) {
        super(descricao, prioridade, dataCriacao);
        this.dataPrazo = dataPrazo;
    }

    public TarefaComPrazo() {
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrazo: " + dataPrazo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false; // Verifica igualdade na superclasse
        }
        if (obj instanceof TarefaComPrazo) {
            TarefaComPrazo outra = (TarefaComPrazo) obj;
            return this.dataPrazo.equals(outra.dataPrazo);
        }
        return false;
    }

    /* public boolean equals(Object obj) {
        
        if (super.equals(obj)) {
            if(this.dataPrazo.equals(((TarefaComPrazo)obj).dataPrazo))
            return true;
        }
        return false;
    } */
}
