package com.br.Entity;

import java.time.LocalDateTime;

public class Emprestimo {

    private int id;

    private Livro livro;

    private String nomeCliente;

    private LocalDateTime dataEmpresatimo;

    private LocalDateTime dataDevolucao;

    public Emprestimo(int id, String nomeCliente, LocalDateTime dataEmpresatimo, LocalDateTime dataDevolucao) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.dataEmpresatimo = dataEmpresatimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo() {
    }

    public Emprestimo(int id, Livro livro, String nomeCliente) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataEmpresatimo = LocalDateTime.now();
        this.dataDevolucao = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDateTime getDataEmpresatimo() {
        return dataEmpresatimo;
    }

    public void setDataEmpresatimo(LocalDateTime dataEmpresatimo) {
        this.dataEmpresatimo = dataEmpresatimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", dataEmpresatimo=" + dataEmpresatimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
