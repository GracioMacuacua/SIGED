package controller;

import model.Divida;
import model.FicheiroDividas;

/**
 *
 * @author Grácio Macuácua
 */
public final class DevedoresController {
    
    /**
     * Efectua o registro de uma dívida na base de dados.
     * @param divida a dívida a ser registada
     * @return {@code true} se a dívida tiver sido salvo com sucesso, 
     * {@code false} caso contrário
     */
    public static final boolean guardarDivida(Divida divida) {
        return FicheiroDividas.create(divida);
    }
    
    /**
     * Gera o ID das dívidas.
     * @return o ID gerado
     */
    public static final String setarId() {
        FicheiroDividas controller = new FicheiroDividas();
        controller.CaminhoPrincipal();

        String id = "";
        boolean existe = false;
        if (!FicheiroDividas.lista().isEmpty()) {
            while (true) {
                id = ((int) (100000 * Math.random())) + "SGD";
                for (Divida d : FicheiroDividas.lista()) {
                    if (id == null ? d.getId() == null : id.equals(d.getId())) {
                        existe = true;
                        break;
                    }
                }
                if (existe == false) {
                    break;
                }
            }
        } else {
            id = ((int) (100000 * Math.random())) + "SGD";
        }
        
        return id;
    }
    
    /**
     * Calcula o valor a ser pago pelo aderente ao empréstimo.
     * @param valorDivida o valor que foi requisitado pelo aderente
     * @return o valor total a ser pago com juros
     */
    public static final float calcularValor(float valorDivida) {
        if (valorDivida > 100.00)
            if (valorDivida <= 500.00)
                return (float) (valorDivida + valorDivida * 0.3);
            else if (valorDivida <= 1000.00)
                return (float) (valorDivida + valorDivida * 0.2);
            else
                return (float) (valorDivida + valorDivida * 0.15);            
        else 
            return (float) (valorDivida + valorDivida * 0.4);
    }
}
