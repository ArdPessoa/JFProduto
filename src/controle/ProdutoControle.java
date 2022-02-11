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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Produto;
import util.BancoDados;

/**
 *
 * @author sala303b
 */
public class ProdutoControle {

    public static boolean Cadastrar(Produto p) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Produto.
            String sql = "INSERT INTO produto  ";
            sql += " (produto, desproduto, preco, nomecategoria, idcategoria) ";
            sql += " VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getProduto());
            ps.setString(2, p.getDesProduto());
            ps.setDouble(3, p.getPreco());
            ps.setString(4, p.getNomeCategoria());
            ps.setLong(5, p.getIdCategoria());
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

    public static boolean Atualizar(Produto p) {
        try {
            Connection conn = BancoDados.getConexao(); //conectar com o bando de dados e enviar os dados salvos da classe Produto.
            String sql = "UPDATE  produto  ";
            sql += "SET produto = ?, ";
            sql += "  desproduto = ?, ";
            sql += " preco = ?, ";
            sql += " idcategoria = ?, ";
            sql += " nomecategoria =? ";
            sql += " WHERE id = ?; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProduto());
            ps.setString(2, p.getDesProduto());
            ps.setDouble(3, p.getPreco());
            ps.setLong(4, p.getIdCategoria());
            ps.setString(5, p.getNomeCategoria());
            ps.setLong(6, p.getId());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                System.out.println("Atualizou");
                return true;

            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Produto BuscarPorId(long id) {
        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM produto where id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            Produto prod = new Produto();
            if (rs.next()) {

                prod.setId(rs.getLong("id"));
                prod.setProduto(rs.getString("produto"));
                prod.setDesProduto(rs.getString("desproduto"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setIdCategoria(rs.getLong("idcategoria"));
                prod.setDataCadastro(rs.getDate("datacadastro"));
                prod.setNomeCategoria(rs.getString("nomecategoria"));

            }
            return prod;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public static boolean Excluir(long idProduto) {
        return true;
    }

    public static List<Produto> ListarProduto() {
        try {

            Connection conn = BancoDados.getConexao();
            String sql = "SELECT * FROM produto; ";
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Produto> lista = new ArrayList();
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Produto c = new Produto();
                c.setId(rs.getLong("id"));
                c.setProduto(rs.getString("produto"));
                c.setDesProduto(rs.getString("desproduto"));
                c.setPreco(rs.getDouble("preco"));
                c.setIdCategoria(rs.getLong("idcategoria"));
                c.setDataCadastro(rs.getDate("datacadastro"));
                c.setNomeCategoria(rs.getString("nomecategoria"));
                lista.add(c);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    }

