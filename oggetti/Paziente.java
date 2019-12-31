// 
// Decompiled by Procyon v0.5.36
// 

package oggetti;

import utility.Login;
import java.util.ArrayList;
import listenerFrameCartellaClinica.FrameCartellaClinicaModel;
import java.io.File;
import utility.ControlloOs;
import avvio.App;
import java.io.Serializable;

public class Paziente extends Persona implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String emailPaziente;
    private String repartiPassati;
    private String repartoAttuale;
    
    public Paziente(final String nome, final String cognome, final String gender, final String codFiscale, final String dataDiNascita, final Reparto tipoReparto) {
        super(nome, cognome, gender, codFiscale, dataDiNascita, tipoReparto);
        this.repartoAttuale = tipoReparto.getNomeReparto();
        if (!tipoReparto.getListaPazienti().contains(this)) {
            this.password = this.generaPassword().toLowerCase();
        }
        this.generaNomeUtente(this.codFiscale);
        this.getTipoReparto().aggiungiPazienteALista(this);
        App.login.deserializzaMappaLoginPaziente();
        App.login.getMappaLoginPaziente().put(this.getCodFiscale(), this);
        App.login.serializzaMappaLoginPaziente(App.login.getMappaLoginPaziente());
        if (!new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + tipoReparto.getNomeReparto() + "//" + this.getCodFiscale()).exists()) {
            new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + tipoReparto.getNomeReparto() + "//" + this.getCodFiscale()).mkdir();
        }
        new FrameCartellaClinicaModel(this);
    }
    
    public void aggiungiRepartoPassato(final String nomeReparto) {
        if (this.repartiPassati == null || this.repartiPassati.length() == 0) {
            this.repartiPassati = nomeReparto;
        }
        else {
            final ArrayList<String> tmp = new ArrayList<String>();
            String stringaReparto = "";
            for (int i = 0; i < this.repartiPassati.length(); ++i) {
                if (this.repartiPassati.charAt(i) == ',') {
                    tmp.add(stringaReparto);
                    stringaReparto = "";
                }
                else if (this.repartiPassati.charAt(i) != ' ') {
                    stringaReparto = String.valueOf(stringaReparto) + this.repartiPassati.charAt(i);
                }
            }
            if (!tmp.contains(nomeReparto)) {
                this.repartiPassati = String.valueOf(this.repartiPassati) + nomeReparto;
            }
        }
    }
    
    @Override
    public String getNome() {
        return super.getNome();
    }
    
    @Override
    public String getCognome() {
        return super.getCognome();
    }
    
    @Override
    public String getGender() {
        return super.getGender();
    }
    
    @Override
    public String getCodFiscale() {
        return super.getCodFiscale();
    }
    
    @Override
    public String getDataDiNascita() {
        return super.getDataDiNascita();
    }
    
    @Override
    public String getNomeUtente() {
        return super.getNomeUtente();
    }
    
    @Override
    public String getPassword() {
        return super.getPassword();
    }
    
    public void aggiungi_A_LoginMapPaziente(final Login lg) {
        lg.getMappaLoginPaziente().put(this.getCodFiscale(), this);
    }
    
    public String getEmailPaziente() {
        return this.emailPaziente;
    }
    
    public String getNomeRepartoAttuale() {
        return this.repartoAttuale;
    }
    
    public String getNomeRepartiPassati() {
        return this.repartiPassati;
    }
    
    @Override
    public Reparto getTipoReparto() {
        return super.getTipoReparto();
    }
    
    @Override
    public void setNome(final String n) {
        super.setNome(n);
    }
    
    @Override
    public void setCognome(final String c) {
        super.setCognome(c);
    }
    
    @Override
    public void setGender(final String g) {
        super.setGender(g);
    }
    
    @Override
    public void setCodFiscale(final String co) {
        super.setCodFiscale(co);
    }
    
    @Override
    public void setDataDiNascita(final String d) {
        super.setDataDiNascita(d);
    }
    
    @Override
    public void setNomeUtente(final String no) {
        super.setNomeUtente(no);
    }
    
    @Override
    public void setPassword(final String p) {
        super.setPassword(p);
    }
    
    public void setNomeRepartoPerAggiuntaInArchivio() {
        this.repartoAttuale = "";
    }
    
    @Override
    public String toString() {
        return "\n{ NOMEUTENTE:" + this.getNomeUtente().toLowerCase() + ", PASSWORD:" + this.password.toLowerCase() + " }";
    }
    
    public String toStringCompleto() {
        return "{ NOME:" + this.getNome().toLowerCase() + ", COGNOME:" + this.getCognome().toLowerCase() + ", GENDER:" + this.getGender().toLowerCase() + ", DATA DI NASCITA:" + this.getDataDiNascita() + ", NOMEUTENTE:" + this.getNomeUtente().toLowerCase() + ", EMAIL :" + this.emailPaziente.toLowerCase() + ", CODICEFISCALE :" + this.codFiscale.toLowerCase() + ", PASSWORD:" + this.password.toLowerCase() + ", REPARTO: " + this.getTipoReparto() + " }";
    }
    
    public String toString2() {
        return "Paziente " + this.getNome() + " " + this.getCognome() + " : " + this.getCodFiscale();
    }
    
    public String toString3() {
        return String.valueOf(this.getNome()) + " " + this.getCognome() + " : " + this.getCodFiscale();
    }
    
    @Override
    public int compareTo(final Object o) {
        return 0;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Paziente other = (Paziente)obj;
        if (this.emailPaziente == null) {
            if (other.emailPaziente != null) {
                return false;
            }
        }
        else if (!this.emailPaziente.equals(other.emailPaziente)) {
            return false;
        }
        return true;
    }
}
