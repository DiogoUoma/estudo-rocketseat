package com.br.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Livro {

    private int id;

    private String titulo;

    private Autor autor;

    private boolean disponivel;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;


    public Livro(int id, String titulo, Autor autor, Boolean disponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro.atStartOfDay();
        this.dataAtualizacao = dataAtualizacao.atStartOfDay();
    }

    public Livro(int id, String titulo, Autor autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Livro() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
