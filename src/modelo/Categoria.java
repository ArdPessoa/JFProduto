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
public class Categoria {

    /**
     * @return the id
     */
    public long getIdC() {
        return idC;
    }

    /**
     * @param id the id to set
     */
    public void setIdC(long idC) {
        this.idC = idC;
    }

    /**
     * @return the nome
     */
    public String getNomeC() {
        return nomeC;
    }

    /**
     * @param nome the nome to set
     */
    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    /**
     * @return the descCategoria
     */
    public String getDescCategoria() {
        return descCategoria;
    }

    /**
     * @param descCategoria the descCategoria to set
     */
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
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
    private long idC;
    private String nomeC;
    private String descCategoria;
    private Date dataCadastro;

    @Override
    public String toString() {
        return this.getNomeC(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
