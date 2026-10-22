
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        String nome;

        do {
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("O nome não pode ficar vazio!");
            }
        } while (nome.trim().isEmpty());

        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();

        String tipo;

        do {
            System.out.print("Digite o tipo (ALUNO ou PROFESSOR): ");
            tipo = scanner.nextLine().trim().toUpperCase();

            if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                System.out.println("Tipo inválido! Digite ALUNO ou PROFESSOR.");
            }
        } while (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR"));

        System.out.print("Digite o limite de empréstimos: ");
        Integer limite = Integer.parseInt(scanner.nextLine());

        Usuario usuario = new Usuario(nome, matricula, tipo, limite);
        usuarios.add(usuario);

        System.out.println("\nUsuário cadastrado com sucesso!");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());

        scanner.close();
    }
}
