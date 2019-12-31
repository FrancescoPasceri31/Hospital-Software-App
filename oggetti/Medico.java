// 
// Decompiled by Procyon v0.5.36
// 

package oggetti;

import utility.Login;
import avvio.App;
import java.util.Scanner;
import java.io.Serializable;

public class Medico extends Persona implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Reparto tipoReparto;
    private String emailMedico;
    public Scanner sc;
    
    public Medico(final String nome, final String cognome, final String gender, final String codFiscale, final String dataDiNascita, final Reparto tipoReparto) {
        super(nome, cognome, gender, codFiscale, dataDiNascita, tipoReparto);
        this.generaNomeUtente(this.codFiscale);
        tipoReparto.aggiungiMedicoALista(this);
        App.login.deserializzaMappaLoginMedico();
        App.login.getMappaLoginMedico().put(this.getCodFiscale(), this);
        App.login.serializzaMappaLoginMedico(App.login.getMappaLoginMedico());
        this.getTipoReparto().deserializzazioneArrayListMedico();
    }
    
    public String[][] consultaOrario() {
        return this.tipoReparto.getOrario().getOrario();
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
    
    public String getEmailMedico() {
        return this.emailMedico;
    }
    
    @Override
    public Reparto getTipoReparto() {
        return super.getTipoReparto();
    }
    
    public void aggiungi_A_LoginMapMedico(final Login lg) {
        lg.getMappaLoginMedico().put(this.getCodFiscale(), this);
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
    
    @Override
    public String toString() {
        return "\n{ NOMEUTENTE=" + this.codFiscale + ", PASSWORD=" + this.password + " }";
    }
    
    public String toStringCompleto() {
        return "---->  codFiscale=" + this.codFiscale + ", password=" + this.password + ", getNome()=" + this.getNome() + ", getCognome()=" + this.getCognome();
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
        final Medico other = (Medico)obj;
        if (this.emailMedico == null) {
            if (other.emailMedico != null) {
                return false;
            }
        }
        else if (!this.emailMedico.equals(other.emailMedico)) {
            return false;
        }
        return true;
    }
}
