package modelo;

public class Validador {

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
