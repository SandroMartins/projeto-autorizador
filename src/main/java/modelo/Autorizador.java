package modelo;

public class Autorizador {

    private int id_autorizador;
    private int nr_procedimento;
    private int idade;
    private String sexo;
    private boolean ativo;


    public Autorizador() {

    }

    public int getId_autorizador() {
        return id_autorizador;
    }

    public void setId_autorizador(int id_autorizador) {
        this.id_autorizador = id_autorizador;
    }

    public int getNr_procedimento() {
        return nr_procedimento;
    }

    public void setNr_procedimento(int nr_procedimento) {
        this.nr_procedimento = nr_procedimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}