package com.br.Entity;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    private List<Autor> autores = new ArrayList<>();

    private List<Emprestimo> emprestimos = new ArrayList<>();

    private int proximoIdEmpresatimo = 1;

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for(Livro livro : livros) {
            if(livro.isDisponivel()) disponiveis.add(livro);
        }

        return disponiveis;
    }

    public Livro buscarLivroPorId(int id) {
        for(Livro livro : livros) {
            if(livro.getId() == id) return livro;
        }
        return null;
    }

    public Emprestimo emprestarLivro(int idLivro, String nomeCliente) {
        Livro livro = buscarLivroPorId(idLivro);
        if(livro ==  null) return null;
        if(!livro.isDisponivel()) return null;

        livro.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(proximoIdEmpresatimo++, livro, nomeCliente);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public Biblioteca(List<Livro> livros, List<Autor> autores, List<Emprestimo> emprestimos) {
        this.livros = livros;
        this.autores = autores;
        this.emprestimos = emprestimos;
    }

    public Biblioteca() {
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                ", autores=" + autores +
                ", emprestimos=" + emprestimos +
                ", proximoIdEmpresatimo=" + proximoIdEmpresatimo +
                '}';
    }
}
