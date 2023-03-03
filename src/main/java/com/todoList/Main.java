package com.todoList;

import com.todoList.model.Tarefa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Tarefa> listaDeTarefas= new ArrayList<>();

        int opcao=-1;
        while (opcao != 5){
            menu();
            //opcao = scaner.input
            switch (opcao){
                case 1:
                break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
}