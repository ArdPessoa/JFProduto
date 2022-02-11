/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import util.BancoDados;

/**
 *
 * @author sala303b
 */
public class CategoriaControle {

    public static List<Categoria> getListarCategoria() {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM categoria;";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Categoria> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdC(rs.getLong("id"));
                cat.setNomeC(rs.getString("nome"));
                cat.setDescCategoria(rs.getString("descricao"));
                cat.setDataCadastro(rs.getDate("datacadastro"));

                lista.add(cat);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
            return null;
        }
    }
 public static boolean Cadastrar(Categoria p) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Produto.
            String sql = "INSERT INTO categoria  ";
            sql += " (nome, descricao) ";
            sql += " VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNomeC());
            ps.setString(2, p.getDescCategoria());

            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    final int lastId = rs.getInt(1);
                    System.out.println("O numero do id é:"
                            + lastId);
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean Atualizar(Categoria p) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Produto.
            String sql = "UPDATE  categoria  ";
            sql += "SET nome  = ?, ";                      
            sql += "SET descricao = ?, ";
            sql += " WHERE id  = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, p.getNomeC());
            ps.setString(3, p.getDescCategoria());
            ps.setLong(1, p.getIdC());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    final int lastId = rs.getInt(1);
                    System.out.println("O numero do id é:"
                            + lastId);
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static Categoria BuscarPorId(long id) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM categoria where id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            Categoria cat = new Categoria();
            if (rs.next()) {

                cat.setIdC(rs.getLong("id"));
                cat.setNomeC(rs.getString("nome"));
                cat.setDescCategoria(rs.getString("descricao"));
                cat.setDataCadastro(rs.getDate("datacadastro"));


            }
            return cat;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}


