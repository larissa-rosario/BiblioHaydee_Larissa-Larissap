package br.escola.bibliohaydee.app;


import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);




        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileiro");
        autor.setAnoNascimento(1839);
        autores.add(autor);




        Livro livro = new Livro(
                "Dom Casmurro",
                "123456789",
                autor,
                1899,
                "Romance"
        );




        livros.add(livro);


        Livro livro2 = new Livro(
                "Memórias Póstumas de Brás Cubas",
                "123456790",
                autor,
                1881,
                "Romance"
        );
        livros.add(livro2);


        Livro livro3 = new Livro(
                "Quincas Borba",
                "123456791",
                autor,
                1891,
                "Romance"
        );
        livros.add(livro3);


        Autor autor2 = new Autor();
        autor2.setNome("Graciliano Ramos");
        autor2.setNacionalidade("Brasileiro");
        autor2.setAnoNascimento(1892);
        autores.add(autor2);

        Livro livro4 = new Livro(
                "Vidas Secas",
                "123456792",
                autor2,
                1938,
                "Romance"
        );
        livros.add(livro4);


        Autor autor3 = new Autor();
        autor3.setNome("Aluísio Azevedo");
        autor3.setNacionalidade("Brasileiro");
        autor3.setAnoNascimento(1857);
        autores.add(autor3);

        Livro livro5 = new Livro(
                "O Cortiço",
                "123456793",
                autor3,
                1890,
                "Romance"
        );
        livros.add(livro5);

        Autor autor4 = new Autor();
        autor4.setNome("Jorge Amado");
        autor4.setNacionalidade("Brasileiro");
        autor4.setAnoNascimento(1912);
        autores.add(autor4);

        Livro livro6 = new Livro(
                "Capitães da Areia",
                "123456794",
                autor4,
                1937,
                "Romance"
        );
        livros.add(livro6);


        System.out.println("===== AUTORES =====");
        for (Autor a : autores) {
            System.out.println(a);
            System.out.println("-------------------");
        }


        System.out.println("\n===== LIVROS =====");

        if (!livros.isEmpty()) {
            for (Livro l : livros) {
                System.out.println(l);
                System.out.println("----------------------");
            }
        } else {
            System.out.println("Não há livros cadastrados.");


        }

        System.out.println("\n===== CADASTRO DE USUÁRIO =====");

        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();


        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();


        System.out.print("Tipo (ALUNO/PROFESSOR): ");
        String tipo = scanner.nextLine().toUpperCase();


        System.out.print("Definir o limite? (S/N): ");
        String resposta = scanner.nextLine();


        Usuario usuario;

        System.out.println("\n===== PESQUISAR POR TÍTULO =====");
        pesquisarPorTitulo(livros, scanner);

        System.out.println("\n===== PESQUISAR POR AUTOR =====");
        pesquisarPorAutor(livros, scanner);



        gerarRelatorioAcervo(livros);

        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("Digite o limite de empréstimos: ");
            int limite = Integer.parseInt(scanner.nextLine());


            usuario = new Usuario(nome, matricula, tipo, limite);
        } else {
            usuario = new Usuario(nome, matricula, tipo);
        }


        usuarios.add(usuario);


        System.out.println("\nUsuário cadastrado:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
    }

    private static void pesquisarPorTitulo(ArrayList<Livro> livros, Scanner scanner) {

        System.out.println("Digite parte do título:");
        String termo = scanner.nextLine();


        if (termo.trim().isEmpty()) {
            System.out.println("Digite um título válido!");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro livro : livros) {

            String titulo = livro.getTitulo().trim().toLowerCase();

            if (titulo.contains(termo)) {
                System.out.println("Livro encontrado: " + livro.getTitulo());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado!");
        }
    }
    private static void pesquisarPorAutor(ArrayList<Livro> livros, Scanner scanner) {

        System.out.println("Digite o nome completo do autor:");
        String nomeAutor = scanner.nextLine();

        if (nomeAutor.trim().isEmpty()) {
            System.out.println("Digite um nome válido!");
            return;
        }

        nomeAutor = nomeAutor.trim().toLowerCase();

        boolean encontrou = false;

        for (Livro livro : livros) {

            String nome = livro.getAutor().getNome().trim().toLowerCase();

            if (nome.equals(nomeAutor)) {
                System.out.println("Livro encontrado: " + livro.getTitulo());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Autor não encontrado!");
        }
    }

    private static void gerarRelatorioAcervo(ArrayList<Livro> livros) {

        StringBuilder relatorio = new StringBuilder();


        relatorio.append("===== RELATÓRIO DO ACERVO =====\n");

        if (livros.isEmpty()) {

            relatorio.append("Não há livros cadastrados.\n");

        } else {

            int numero = 1;

            for (Livro livro : livros) {

                relatorio.append("\nLivro ").append(numero).append("\n");
                relatorio.append("Título: ").append(livro.getTitulo()).append("\n");
                relatorio.append("Autor: ").append(livro.getAutor().getNome()).append("\n");
                relatorio.append("Disponibilidade: Disponível\n");

                numero++;
            }

            relatorio.append("\nTotal de livros: ").append(livros.size());
        }

        System.out.println(relatorio.toString());
    }
}
