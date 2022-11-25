package controller;

import java.util.Arrays;
import model.Divida;
import model.FicheiroDividas;

/**
 *
 * @author Grácio Macuácua
 */
public final class EstatisticasController {
    
    /**
     * Gera dados estatísticos sobre os registros da base de dados
     * @return os dados estatísticos
     */
    public static final Dados gerarEstatisticas() {
        Divida[] array = null;
        Dados dados = null;
        if(!FicheiroDividas.lista().isEmpty()){
            array = new Divida[FicheiroDividas.lista().size()];        
            int i = 0;
            float totalDividas = 0, mediaDividas = 0, totalPagas = 0;
            for(Divida d : FicheiroDividas.lista()){  
                array[i] = d; 
                totalDividas += d.getValorAPagar();
                if(d.getEstadoDivida().equals("Pago"))
                    totalPagas += d.getValorAPagar();
                if((d.getEstadoDivida().equals("Não Pago") && d.getRemanescente() != 0))
                    totalPagas += (d.getValorAPagar() - d.getRemanescente());
                i++;
            }  
            
            mediaDividas = (float) (totalDividas/array.length);    
            
            Arrays.sort(array);
            dados = new Dados(array, totalPagas, totalDividas, mediaDividas);
        }
        
        return dados;
    }
    
    public static class Dados {
        
        private Divida[] dividas;
        private float totalPagas;
        private float totalDividas;
        private float mediaDividas;

        public Dados(Divida[] dividas, float totalPagas, float totalDividas, float mediaDividas) {
            this.dividas = dividas;
            this.totalPagas = totalPagas;
            this.totalDividas = totalDividas;
            this.mediaDividas = mediaDividas;
        }        

        public Divida[] getDividas() {
            return dividas;
        }

        public void setDividas(Divida[] dividas) {
            this.dividas = dividas;
        }

        public float getTotalPagas() {
            return totalPagas;
        }

        public void setTotalPagas(float totalPagas) {
            this.totalPagas = totalPagas;
        }

        public float getTotalDividas() {
            return totalDividas;
        }

        public void setTotalDividas(float totalDividas) {
            this.totalDividas = totalDividas;
        }

        public float getMediaDividas() {
            return mediaDividas;
        }

        public void setMediaDividas(float mediaDividas) {
            this.mediaDividas = mediaDividas;
        }                
        
    }
}
