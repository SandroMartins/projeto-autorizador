package view;
import dao.postgresql.*;
import modelo.Autorizador;
import java.util.Scanner;

/**
 * Classe principal, responsavel em criar o menu, interagir com
 * o usuário, chamando metodos de consulta e inserção no banco
 *
 * @author Sandro Ireno Martins Junior
 */

public class Principal {

    public static void main(String[] args) {
        //declarando as váriaveis
        boolean resultado = false;
        int procedimento = 0;
        int idade = 0;
        String sexo = null;
        int opcao = 0;
        //Criando os objetos
        Autorizador autorizador = new Autorizador();
        Scanner sc = new Scanner(System.in);
        AutorizadorDAOPostgreSQL dao = new AutorizadorDAOPostgreSQL();

        while(opcao != 3){
            menu();
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.print("Digite o Procedimento: ");
                    procedimento = sc.nextInt();

                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();

                    System.out.print("Digite o sexo: ");
                    sexo = sc.next();

                    autorizador.setNr_procedimento(procedimento);
                    autorizador.setIdade(idade);
                    autorizador.setSexo(sexo);

                    resultado = dao.validarRegra(autorizador);

                    if (resultado == true) {
                        System.out.println("\nSIM");
                    }else{
                        System.out.println("\nNÃO");
                    }
                    break;

                case 2:
                    System.out.print("Digite o Procedimento: ");
                    procedimento = sc.nextInt();

                    System.out.print("Digite a idade: ");
                    idade = sc.nextInt();

                    System.out.print("Digite o sexo: ");
                    sexo = sc.next();

                    autorizador.setNr_procedimento(procedimento);
                    autorizador.setIdade(idade);
                    autorizador.setSexo(sexo);

                    resultado = dao.salvar(autorizador);
                    if (resultado == true) {
                        System.out.println("\nRegra cadastrada com sucesso");
                    }else{
                        System.out.println("\nErro ao cadastrar");
                    }
                    break;
                case 3:
                    System.out.println("\nLogoff");
                    break;
                default:
                    System.out.println("\nOpção inválida !!!");
                    break;
            }
        }
    }
    //Menu das opções
    public static void menu(){
        System.out.print("\n---------- AUTORIZADOR -----------\n" +
                "1 - Solicitar autorização de procedimento médico\n" +
                "2 - Cadastrar regra de autorização de procedimento\n" +
                "3 - Sair\n\n" +
                "Digite o número da opção desejada: ");
    }
}