package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Grácio Macuácua
 */

public class Divida implements Serializable, Comparable{
    
    private String nomeDevedor;
    private String apelidoDevedor;
    private String id;
    private float valorDivida;
    private float valorAPagar;
    private float remanescente;
    private Date data;
    private String estadoDivida;

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public String getApelidoDevedor() {
        return apelidoDevedor;
    }

    public void setApelidoDevedor(String apelidoDevedor) {
        this.apelidoDevedor = apelidoDevedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(float valorDivida) {
        this.valorDivida = valorDivida;
    }

    public float getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(float valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public float getRemanescente() {
        return remanescente;
    }

    public void setRemanescente(float remanescente) {
        this.remanescente = remanescente;
    }        

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEstadoDivida() {
        return estadoDivida;
    }

    public void setEstadoDivida(boolean estado) {
        if(estado == true)
            this.estadoDivida = "Pago";
        else
            this.estadoDivida = "Não Pago";  
        
            
    }

    @Override
    public int compareTo(Object o) {
        Divida outro = (Divida) o;
        if (getValorAPagar() < outro.getValorAPagar()) {
            return -1;
        }
        if (getValorAPagar() > outro.getValorAPagar()) {
            return 1;
        }
        return 0;
    }
}
