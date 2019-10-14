package modelo;

public class Validador {
    /**
     * Classe que faz a validção dos campos que serão
     * digitados pelo usuário
     *
     * @author Sandro Ireno Martins Junior
     */
    public Validador(){

    }
    public boolean validarSexo(String sexo){
        if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f")){
            return true;
        }
        return false;
    }

    public boolean validarNumeroNegativo (int numero){
        if (numero < 0) {
            return false;
        }
        return true;
    }
}
