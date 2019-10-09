package dao.postgresql;

import dao.AutorizadorDAO;
import dao.BaseDados;
import modelo.Autorizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutorizadorDAOPostgreSQL implements AutorizadorDAO {

    @Override
    public boolean salvar(Autorizador autorizador) {
        return false;
    }

    @Override
    public List<Autorizador> buscarTodos() {
        return null;
    }

    @Override
    public boolean desativar(int id_autorizador) {
        return false;
    }

    @Override
    public boolean validarRegra(Autorizador autorizador) {
        boolean resultado = false;
        ConexaoPostgreSQL minhaConexaoPostgreSQL = new ConexaoPostgreSQL(BaseDados.POSTGRESQL);
        minhaConexaoPostgreSQL.conectar();
        Connection conn = minhaConexaoPostgreSQL.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM autorizador " +
                    "WHERE nr_procedimento = ?" +
                    "AND idade = ?" +
                    "AND sexo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, autorizador.getNr_procedimento());
            pstmt.setInt(2, autorizador.getIdade());
            pstmt.setString(3, autorizador.getSexo());
            rs = pstmt.executeQuery();

            while(rs.next()){
                resultado = true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(pstmt != null){
                try{
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }
}
