package dao;

public enum BaseDados {

    POSTGRESQL("postgres","postgres","localhost","sistema-autorizador");

    private String usuario;
    private String senha;
    private String servidor;
    private String database;

    BaseDados(String usuario, String senha, String servidor, String database) {
        this.usuario = usuario;
        this.senha = senha;
        this.servidor = servidor;
        this.database = database;
    }
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getServidor() {
        return servidor;
    }

    public String getDatabase() {
        return database;
    }
}
