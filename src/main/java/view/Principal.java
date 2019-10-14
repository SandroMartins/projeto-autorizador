package view;

import dao.postgresql.*;

import modelo.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal, responsavel em criar o menu, interagir com
 * o usuário, chamando metodos de consulta e inserção no banco
 *
 * @author Sandro Ireno Martins Junior
 */

public class Principal {

    public static void main(String[] args) {

        boolean resultado = false;
        int procedimento = 0;
        int idade = 0;
        String sexo = null;
        int opcao = 0;
        Validador validador = new Validador();

        Autorizador autorizador = new Autorizador();
        Scanner sc = new Scanner(System.in);
        AutorizadorDAOPostgreSQL dao = new AutorizadorDAOPostgreSQL();

        while (opcao != 3) {
            menu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    try {
                        do {
                            System.out.print("Digite o Procedimento: ");
                            procedimento = sc.nextInt();

                            if (validador.validarNumeroNegativo(procedimento)) {
                                autorizador.setNr_procedimento(procedimento);
                                resultado = dao.validarProcedimento(autorizador);

                                if (resultado == false) {
                                    System.out.println("Procedimento não foi localizado !\n");
                                }
                            } else {
                                System.out.println("Valor deve ser inteiro. \n");
                            }
                        } while (!validador.validarNumeroNegativo(procedimento) || !dao.validarProcedimento(autorizador));

                        do {
                            System.out.print("Digite a idade: ");
                            idade = sc.nextInt();

                            if (!validador.validarNumeroNegativo(idade)){
                                System.out.println("Valor deve ser inteiro. \n");
                            }
                        } while (!validador.validarNumeroNegativo(idade));

                        autorizador.setIdade(idade);

                        do {
                            System.out.print("Digite o sexo: Masculino = 'M' ou Feminino = 'F': ");
                            sexo = sc.next();

                            if (!validador.validarSexo(sexo)) {
                                System.out.println("Sexo inválido !\n");
                            }

                        } while (!validador.validarSexo(sexo));

                        autorizador.setSexo(sexo);

                        resultado = dao.validarRegra(autorizador);

                        if (resultado == true) {
                            System.out.println("\nPERMITIDO !!");
                        } else {
                            System.out.println("\nNEGADO !!");
                        }
                    } catch (InputMismatchException t) {
                        System.out.println("Valor digitado inválido.");

                        opcao = 3;
                    }
                    break;

                case 2:
                    try {
                        do {
                            System.out.print("Digite o Procedimento: ");
                            procedimento = sc.nextInt();

                            if (validador.validarNumeroNegativo(procedimento)) {
                                autorizador.setNr_procedimento(procedimento);
                            } else {
                                System.out.println("Valor deve ser inteiro. \n");
                            }
                        } while (!validador.validarNumeroNegativo(procedimento));

                        do {
                            System.out.print("Digite a idade: ");
                            idade = sc.nextInt();

                            if (!validador.validarNumeroNegativo(idade)){
                                System.out.println("Valor deve ser inteiro. \n");
                            }
                        } while (!validador.validarNumeroNegativo(idade));

                        autorizador.setIdade(idade);

                        do {
                            System.out.print("Digite o sexo: Masculino = 'M' ou Feminino = 'F': ");
                            sexo = sc.next();

                            if (!validador.validarSexo(sexo)) {
                                System.out.println("Sexo inválido !\n");
                            }

                        } while (!validador.validarSexo(sexo));

                        autorizador.setSexo(sexo);

                    } catch (InputMismatchException t) {
                        System.out.println("Valor digitado inválido.");

                        opcao = 3;
                    }
                    resultado = dao.salvar(autorizador);
                    if (resultado == true) {
                        System.out.println("\nRegra cadastrada com sucesso");
                    } else {
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
    public static void menu() {
        System.out.print("\n---------- AUTORIZADOR -----------\n" +
                "1 - Solicitar autorização de procedimento médico\n" +
                "2 - Cadastrar regra de autorização de procedimento\n" +
                "3 - Sair\n\n" +
                "Digite o número da opção desejada: ");
    }
}