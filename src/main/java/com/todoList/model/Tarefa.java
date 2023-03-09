package com.todoList.model;

public class Tarefa implements Comparable{

    private int id;
    private String nome;
    private String descricao;
    private String dataTermino;
    private int prioridade;
    private String categoria;
    private String status;

    public Tarefa(int id, String nome, String descricao, String dataTermino, int prioridade, String categoria, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Data de término: " + this.dataTermino + "\n" +
                "Prioridade: " + this.prioridade + "\n" +
                "Categoria: " + this.categoria + "\n" +
                "Status: " + this.status ;
    }
}
