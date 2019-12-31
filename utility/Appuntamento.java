// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import oggetti.Reparto;
import java.io.Serializable;

public class Appuntamento implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String data;
    private String tipoVisita;
    private String codFiscale;
    private Reparto reparto;
    
    public Appuntamento(final String data, final String codFiscalePaziente, final Reparto reparto, final String tipoVisita) {
        this.data = data;
        this.codFiscale = codFiscalePaziente;
        this.tipoVisita = tipoVisita;
        this.reparto = reparto;
        this.addAppuntamentoALista(this);
    }
    
    public void addAppuntamentoALista(final Appuntamento appuntamento) {
        this.reparto.deserializzazioneArrayListAppuntamento();
        this.reparto.aggiungiAppuntamentoALista(appuntamento);
        this.reparto.serializzaArrayListAppuntamento(this.reparto.getListaAppuntamento());
    }
    
    public String getCodFiscalePaziente() {
        return this.codFiscale;
    }
    
    public String getTipologia() {
        return this.tipoVisita;
    }
    
    public String getData() {
        return this.data;
    }
    
    public void setReparto(final Reparto reparto) {
        this.reparto = reparto;
    }
    
    @Override
    public String toString() {
        return "Data=" + this.data + ", Paziente=" + this.codFiscale + ", " + this.tipoVisita;
    }
    
    public String toStringPerFramePaziente() {
        return "Data=" + this.data + ", " + this.tipoVisita;
    }
    
    public void setData(final String data) {
        this.data = data;
    }
    
    public void setTipoVisita(final String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }
    
    public void setCodFiscale(final String codFiscale) {
        this.codFiscale = codFiscale;
    }
}
