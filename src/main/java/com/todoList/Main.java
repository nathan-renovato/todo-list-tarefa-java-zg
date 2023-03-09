package com.todoList;

import com.todoList.model.Tarefa;

import java.util.*;

public class Main {
    public static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {


        ArrayList<Tarefa> listaDeTarefas= new ArrayList<>();

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
                    System.out.println(listaDeTarefas);
                    break;
                case 3:
                    System.out.println("Ainda não implementado.");
                    break;
                case 4:
                   Boolean deletouTarefa = deletarTarefa(listaDeTarefas);
                   if(deletouTarefa){
                       System.out.println("Tarefa deletada com sucesso.");
                   } else{
                       System.out.println("Não foi possível deletar a tarefa. Talvez o nome não foi informado corretamente.");
                   }
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