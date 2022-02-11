/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author sala303b
 */
public class Produto {

    /**
     * @return the nomeCategoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nomeCategoria the nomeCategoria to set
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the descricao
     */
    public String getDesProduto() {
        return desProduto;
    }

    /**
     * @param desProduto the descricao to set
     */
    public void setDesProduto(String desProduto) {
        this.desProduto = desProduto;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the categoria
     */
    public long getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }
    private long id;
    private String produto;
    private String desProduto;
    private double preco;
    private long idCategoria;
    private Date dataCadastro;
    private String nomeCategoria;
}
