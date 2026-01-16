package com.br;


import com.br.Entity.Autor;
import com.br.Entity.Biblioteca;
import com.br.Entity.Emprestimo;
import com.br.Entity.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String escolha;
        boolean option = true;

        Biblioteca biblioteca = new Biblioteca();
        popularDadosBiblioteca(biblioteca);

        while(option) {
            System.out.println("----------------------------");
            System.out.println("Deseja ver a lista de livros?");
            escolha = scanner.nextLine().trim().toUpperCase();

            if(escolha.equals("NAO") || escolha.equals("NÃO")){
                option = false;
                break;
            }

            if(!escolha.equals("SIM")) {
                System.out.println("Resposta invalida");
                continue;
            }

            List<Livro> disponiveis = biblioteca.listarLivrosDisponiveis();
            if(disponiveis.isEmpty()){
                System.out.println("Nenhum livro diponivel no momento");
                break;
            }

            System.out.println("===========");
            for(Livro livro : disponiveis) {
                System.out.println(livro);
            }

            int idLivro;
            while(true) {
                System.out.println("\n Digite o ID do livro para emprestar: ");
                String entrada = scanner.nextLine().trim();

                try {
                    idLivro = Integer.parseInt(entrada);
                    break;
                }catch(NumberFormatException e) {
                    System.out.println("ID invalido. Digite um numero.");
                }
            }

            System.out.println("Digite seu nome:");
            String nomeCliente = scanner.nextLine().trim();

            Emprestimo emprestimo = biblioteca.emprestarLivro(idLivro, nomeCliente);

            if(emprestimo == null) {
                System.out.println("Nao foi possivel emprear: livro nao existe ou ja foi emprestado");
                break;
            }

            System.out.println("\n Emprestimo realizado com sucesso!");
            System.out.println(emprestimo);
            break;


        }

    }

    private static void popularDadosBiblioteca(Biblioteca biblioteca) {
        Autor a1 = new Autor(1, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor a2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        Autor a3 = new Autor(3, "George Orwell", LocalDate.of(1903, 6, 25));

        biblioteca.adicionarAutor(a1);
        biblioteca.adicionarAutor(a2);
        biblioteca.adicionarAutor(a3);

        biblioteca.adicionarLivro(new Livro(1, "Dom Casmurro", a1));
        biblioteca.adicionarLivro(new Livro(2, "Memorias postumas de bras cubas", a1));
        biblioteca.adicionarLivro(new Livro(3, "A hora da estrela", a2));
        biblioteca.adicionarLivro(new Livro(4, "1984", a3));
    }
}