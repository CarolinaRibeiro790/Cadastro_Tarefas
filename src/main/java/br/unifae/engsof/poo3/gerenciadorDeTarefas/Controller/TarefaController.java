package br.unifae.engsof.poo3.gerenciadorDeTarefas.Controller;

import br.unifae.engsof.poo3.gerenciadorDeTarefas.Model.GerenciaTarefa;
import br.unifae.engsof.poo3.gerenciadorDeTarefas.Model.Tarefa;
import br.unifae.engsof.poo3.gerenciadorDeTarefas.Model.TarefaSimples;
import br.unifae.engsof.poo3.gerenciadorDeTarefas.Model.TarefaComPrazo;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaController {

   /*Tenta cadastrar os dados de uma tarefa simples
    param descr: descricao tarefa
    param prior: 1 a 5
    parm data: data de criação da tarefa
    return: true se pode cadastrar e fazer o contrario
    Adiciona uma tarefa simples */
    
    
    public boolean addTarefaSimples(String desc, int prior, LocalDate data) {
        //Criar a rarefa simples
        GerenciaTarefa gerenciador = GerenciaTarefa.getInstance();
        return gerenciador.cadastrar(new TarefaSimples(desc, prior, data));

    }

    // Adiciona uma tarefa com prazo
    public boolean addTarefaPrazo(String desc, int prior, LocalDate data, LocalDate prazo) {
        GerenciaTarefa gerenciador = GerenciaTarefa.getInstance();
        return gerenciador.cadastrar(new TarefaComPrazo(prazo, desc, prior, data));
    }

    // Preenche a tabela com as tarefas
    public void preencherTabela(JTable jTabela) {
        DefaultTableModel tabela = (DefaultTableModel) jTabela.getModel();

        jTabela.setModel(tabela);
        jTabela.selectAll();
        tabela.setRowCount(0);

        // Obtém a instância única de GerenciaTarefa
        GerenciaTarefa gerenciador = GerenciaTarefa.getInstance();

        // Preenche a tabela com todas as tarefas
        for (Tarefa tarefa : gerenciador.getTarefas()) {
            Object[] linha;
            if (tarefa instanceof TarefaComPrazo) {
                // Se for uma tarefa com prazo, adiciona a data de prazo
                TarefaComPrazo tarefaPrazo = (TarefaComPrazo) tarefa;
                linha = new Object[]{
                    tarefaPrazo.getDescricao(),
                    tarefaPrazo.getPrioridade(),
                    tarefaPrazo.getDataCriacao(),
                    tarefaPrazo.getDataPrazo(), 
                    tarefaPrazo.isConcluida() ? "Sim" : "Não"
                };
            } else {
                // Se for uma tarefa simples, não adiciona a data de prazo
                linha = new Object[]{
                    tarefa.getDescricao(),
                    tarefa.getPrioridade(),
                    tarefa.getDataCriacao(),
                    "",
                    tarefa.isConcluida() ? "Sim" : "Não"
                };
            }
            tabela.addRow(linha);
            
        }
    }

    // Exclui uma tarefa
    public void excluir(JTable jTabela) {
        int linhaSelecionada = jTabela.getSelectedRow();

        //Verifica se há algum registro na tabela
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa selecionada!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a tarefa?", "Aviso", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            GerenciaTarefa gerenciador = GerenciaTarefa.getInstance();
            Tarefa tarefaSelecionada = gerenciador.getTarefas().get(linhaSelecionada);
            boolean removido = gerenciador.removeTarefas(tarefaSelecionada);
            if (removido) {
                JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                preencherTabela(jTabela); 
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
