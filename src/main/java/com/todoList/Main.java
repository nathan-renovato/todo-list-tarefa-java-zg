package com.todoList;

import com.todoList.model.Tarefa;

import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<Tarefa> listaDeTarefas= new ArrayList<>();
    public static void main(String[] args) {

        int opcao=-1;
        while (opcao != 5){
            menu();
            Scanner entradaOpcao = new Scanner(System.in);
            opcao = Integer.parseInt(entradaOpcao.nextLine());


            //opcao = scaner.input
            switch (opcao){
                case 1:
                    Tarefa novaTarefa = criarTarefa();
                    listaDeTarefas.add(novaTarefa);
                break;
                case 2:
                    int filtroSelecionado = menuListarTarefas();
                    ArrayList<Tarefa> listaFiltrada = retornarListaFiltroSelecionado(filtroSelecionado);
                    System.out.println(listaFiltrada);
                    break;
                case 3:
                    System.out.println("Escreva o nome da tarefa a ser atualizada:");
                    String nomeTarefaParaAtualizar = entrada.nextLine();

                    int indiceTarefaParaAtualizar = encontrarIndiceTarefa(nomeTarefaParaAtualizar);
                    if(indiceTarefaParaAtualizar == -1){
                        System.out.println("Tarefa não encontrada");
                    } else{
                        atualizarTarefa(indiceTarefaParaAtualizar);
                    }
                    break;
                case 4:
                   Boolean deletouTarefa = deletarTarefa(listaDeTarefas);
                   if(deletouTarefa){
                       System.out.println("Tarefa deletada com sucesso.");
                   } else{
                       System.out.println("Não foi possível deletar a tarefa. Talvez o nome não foi informado corretamente.");
                   }
                    break;
                case 5:
                    exit(0);
                    break;
                default :
                    System.out.println("Opção inexistente!");
                    break;
            }
        }


    }

    public static void menu(){
        System.out.println("Selecione a opção que deseja realizar: " +
                "\n [1] criar tarefa" +
                "\n [2] listar tarefas" +
                "\n [3] atualizar tarefa" +
                "\n [4] deletar tarefa" +
                "\n [5] sair"
        );
    }

    public static Tarefa criarTarefa (){
        System.out.println("Escreva o nome da nova atividade:");
        String nomeAtividade = entrada.nextLine();

        System.out.println("Descreva a sua atividade:");
        String descricaoAtividade = entrada.nextLine();

        System.out.println("Escreva a data de término da atividade:");
        String dataTerminoAtividade = entrada.nextLine();

        System.out.println("Informe a prioridade da atividade, sendo 1 a menor \n" +
                " prioridade e o 5 a maior prioridade :");
        int prioridadeAtividade = entrada.nextInt();

        System.out.println("Escreva a categoria da nova atividade:");
        entrada.nextLine();
        String categoriaAtividade = entrada.nextLine();

        System.out.println("Escreva o status da nova atividade, sendo ToDo,Doing ou Done:");
        String statusAtividade = entrada.nextLine();

       return new Tarefa(
                0,
                nomeAtividade,
                descricaoAtividade,
                dataTerminoAtividade,
                prioridadeAtividade,
                categoriaAtividade,
                statusAtividade
        );
    }

    public static int menuListarTarefas(){
        System.out.println("Deseja listar as tarefas por: " +
                "\n [1] categoria" +
                "\n [2] prioridade" +
                "\n [3] status" +
                "\n [4] listar todos");
        return entrada.nextInt();
    }

    public static ArrayList<Tarefa> retornarListaFiltroSelecionado(int filtroSelecionado){
        switch (filtroSelecionado){
            case 1:
                System.out.println("Insira a categoria a ser listada: ");
                entrada.nextLine();
                String categoriaSelecionada = entrada.nextLine();
                return listarTarefaCategoria(categoriaSelecionada);
            case 2:
                System.out.println("Insira a prioridade a ser listada: ");
                int prioridadeSelecionada = entrada.nextInt();
                entrada.nextLine();
                return listarTarefaPrioridade(prioridadeSelecionada);
            case 3:
                System.out.println("Insira o status a ser listado: ");
                String statusSelecionado = entrada.nextLine();
                return listarTarefaStatus(statusSelecionado);
            case 4:
                return listaDeTarefas;
        }
        return new ArrayList<Tarefa>();
    }
     public static ArrayList<Tarefa> listarTarefaCategoria(String categoria){
        ArrayList<Tarefa> listagemTarefaCategoria = new ArrayList<>();

        for(int i = 0; i < listaDeTarefas.size(); i++){
            if(listaDeTarefas.get(i).getCategoria().equals(categoria)){
                listagemTarefaCategoria.add(listaDeTarefas.get(i));
            }
        }
         return  listagemTarefaCategoria;
    }

    public static ArrayList<Tarefa> listarTarefaPrioridade(int prioridade){
        ArrayList<Tarefa> listagemTarefaPrioridade = new ArrayList<>();

        for(int i = 0; i < listaDeTarefas.size(); i++){
            if(listaDeTarefas.get(i).getPrioridade() == prioridade){
                listagemTarefaPrioridade.add(listaDeTarefas.get(i));
            }
        }
        return  listagemTarefaPrioridade;
    }

    public static ArrayList<Tarefa> listarTarefaStatus(String status){
        ArrayList<Tarefa> listagemTarefaStatus = new ArrayList<>();

        for(int i = 0; i < listaDeTarefas.size(); i++){
            if(listaDeTarefas.get(i).getStatus().equals(status)){
                listagemTarefaStatus.add(listaDeTarefas.get(i));
            }
        }
        return  listagemTarefaStatus;
    }
     public static int encontrarIndiceTarefa(String nomeAtividade){
            for(int i = 0; i < listaDeTarefas.size(); i++ ){
                if(listaDeTarefas.get(i).getNome().equals(nomeAtividade))
                    return i;
            }
         return -1;
     }
    public static void atualizarTarefa(int indiceTarefaAtualizar){
        int opcaoSelecionada =menuAtualizarTarefa();
        entrada.nextLine();

      switch (opcaoSelecionada){
            case 1:
                System.out.println("Insira o novo nome da tarefa:");
                String nomeAtualizado = entrada.nextLine();
                listaDeTarefas.get(indiceTarefaAtualizar).setNome(nomeAtualizado);
                break;
            case 2:
                System.out.println("Insira a nova descrição da tarefa:");
                String descricaoAtualizada = entrada.nextLine();
                listaDeTarefas.get(indiceTarefaAtualizar).setDescricao(descricaoAtualizada);
                break;
            case 3:
                System.out.println("Insira a nova data de término da tarefa:");
                String dataTerminoAtualizada = entrada.nextLine();
                listaDeTarefas.get(indiceTarefaAtualizar).setDataTermino(dataTerminoAtualizada);
                break;
            case 4:
                System.out.println("Insira a nova prioridade da tarefa, sendo 1 a menor" +
                                "\n  prioridade e o 5 a maior prioridade :");
                int prioridadeAtualizada = entrada.nextInt();
                listaDeTarefas.get(indiceTarefaAtualizar).setPrioridade(prioridadeAtualizada);
                break;
            case 5:
                System.out.println("Insira a nova categoria da tarefa:");
                String categoriaAtualizada = entrada.nextLine();
                listaDeTarefas.get(indiceTarefaAtualizar).setCategoria(categoriaAtualizada);
                break;
            case 6:
                System.out.println("Insira o novo status da tarefa, sendo ToDo,Doing ou Done:");
                String statusAtualizado = entrada.nextLine();
                listaDeTarefas.get(indiceTarefaAtualizar).setStatus(statusAtualizado);
                break;
        }
    }
        public static int menuAtualizarTarefa(){
            System.out.println("Selecione a opção que deseja atualizar da tarefa: " +
                    "\n [1] nome" +
                    "\n [2] descrição" +
                    "\n [3] data término" +
                    "\n [4] prioridade" +
                    "\n [5] categoria" +
                    "\n [6] status"
            );
            return entrada.nextInt();
        }

    public static  Boolean deletarTarefa(List<Tarefa> listaDeTarefas){
        System.out.println("Escreva o nome da atividade a ser removida: ");
        String nomeAtividadeExcluida = entrada.nextLine();

        for (int indice = 0; indice < listaDeTarefas.size(); indice++ ){
            if(listaDeTarefas.get(indice).getNome().equals(nomeAtividadeExcluida)){
                Tarefa remove = listaDeTarefas.remove(indice);
                return true;
            }
        }

        return false;
    }
}