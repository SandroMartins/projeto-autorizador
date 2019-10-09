package view;
import dao.postgresql.*;
import modelo.Autorizador;


public class Principal {

    public static void main(String[] args) {
        System.out.print("teste ok ");
        boolean resultado = false;
        Autorizador autorizador = new Autorizador();

        AutorizadorDAOPostgreSQL dao = new AutorizadorDAOPostgreSQL();

        autorizador.setNr_procedimento(1234);
        autorizador.setIdade(40);
        autorizador.setSexo("M");

        resultado = dao.validarRegra(autorizador);

        if (resultado == true) {
            System.out.println("ACHOU!!!!!");
        }else{
            System.out.println("ERRRROUUUU!!!!!");
        }

    }
}
