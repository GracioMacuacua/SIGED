package controller;

import model.Divida;
import model.FicheiroDividas;

/**
 *
 * @author Grácio Macuácua
 */
public final class PagamentosController {
    
    private PagamentosController() {
    }

    /**
     * Realiza a busca por uma dívida na base de dados.
     * @param chave o nome do devedor ou o ID da dívida
     * @return a dívida com a chave especificada, ou {@code null} caso não exista
     */
    public static Divida bustarDivida(String chave) {
        for (Divida d : FicheiroDividas.lista())
            if (chave.equalsIgnoreCase(d.getNomeDevedor() + " " + d.getApelidoDevedor()) || chave.equals(d.getId()))
                return d;        
        
        return null;
    }
    
    /**
     * Realiza o pagamento de uma dívida.
     * @param divida a dívida a ser paga
     * @return {@code true} se a dívida tiver sido paga com sucesso, 
     * {@code false} caso contrário
     */
    public static boolean registarPagamento(Divida divida) {        
        return FicheiroDividas.edit(divida.getId(), divida);
    }

}
