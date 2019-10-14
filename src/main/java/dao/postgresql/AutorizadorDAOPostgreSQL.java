package dao.postgresql;

import dao.AutorizadorDAO;
import dao.BaseDados;
import modelo.Autorizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
* Classe responsável em realizar operações no banco de dados
 * Em todas as operações é aberto e fechado a conexão.
 *
 * @author Sandro Ireno Martins Junior
* */

public class AutorizadorDAOPostgreSQL implements AutorizadorDAO {
    //Método responsável em salvar (cadastrar) uma regra de autorização
    @Override
    public boolean salvar(Autorizador autorizador) {
        boolean resultado = false;
        ConexaoPostgreSQL minhaConexaoPostgreSQL = new ConexaoPostgreSQL(BaseDados.POSTGRESQL);
        minhaConexaoPostgreSQL.conectar();
        Connection conn = minhaConexaoPostgreSQL.getConnection();
        PreparedStatement pstmt = null;

        try{
            String sql = "INSERT INTO autorizador (nr_procedimento, idade, sexo)" +
                    "VALUES(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, autorizador.getNr_procedimento());
            pstmt.setInt(2, autorizador.getIdade());
            pstmt.setString(3, autorizador.getSexo());

            pstmt.executeUpdate();
            resultado = true;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (pstmt != null){
                try{
                    pstmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }if(conn != null) {
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    @Override
    public List<Autorizador> buscarTodos() {
        return null;
    }

    @Override
    public boolean desativar(int id_autorizador) {
        return false;
    }
    //Responsável em validar se a regra existe, retornando true ou false
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
                    "AND lower(sexo) = lower(?)";
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
            if (pstmt != null){
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
    //Validação de procedimentos
    @Override
    public boolean validarProcedimento(Autorizador autorizador) {
        boolean resultado = false;
        ConexaoPostgreSQL minhaConexaoPostgreSQL = new ConexaoPostgreSQL(BaseDados.POSTGRESQL);
        minhaConexaoPostgreSQL.conectar();
        Connection conn = minhaConexaoPostgreSQL.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM autorizador " +
                    "WHERE nr_procedimento = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, autorizador.getNr_procedimento());
            rs = pstmt.executeQuery();

            while(rs.next()){
                resultado = true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null){
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
