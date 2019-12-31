// 
// Decompiled by Procyon v0.5.36
// 

package oggetti;

import java.util.Random;
import java.io.Serializable;
import utility.Login;

public abstract class Persona extends Login implements Serializable, Comparable
{
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cognome;
    private String gender;
    protected String codFiscale;
    private String email;
    private String dataDiNascita;
    protected String password;
    private String nomeUtente;
    private String ALFABETO;
    private Reparto tipoReparto;
    static Random rnd;
    private static final int l = 10;
    
    static {
        Persona.rnd = new Random(System.currentTimeMillis());
    }
    
    public Persona(final String nome, final String cognome, final String gender, final String codFiscale, final String dataDiNascita, final Reparto tipoReparto) {
        this.nome = nome.toLowerCase();
        this.cognome = cognome.toLowerCase();
        this.gender = gender.toLowerCase();
        this.codFiscale = codFiscale.toLowerCase();
        this.dataDiNascita = dataDiNascita;
        this.password = this.generaPassword().toLowerCase();
        this.generaNomeUtente(this.codFiscale);
        this.tipoReparto = tipoReparto;
    }
    
    public String generaPassword() {
        this.ALFABETO = String.valueOf(this.nome) + this.cognome + this.codFiscale;
        final StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; ++i) {
            sb.append(this.ALFABETO.charAt(Persona.rnd.nextInt(this.ALFABETO.length())));
        }
        return sb.toString();
    }
    
    public void generaNomeUtente(final String codFiscale) {
        this.nomeUtente = codFiscale;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCognome() {
        return this.cognome;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public String getCodFiscale() {
        return this.codFiscale;
    }
    
    public String getDataDiNascita() {
        return this.dataDiNascita;
    }
    
    public String getNomeUtente() {
        return this.nomeUtente;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Reparto getTipoReparto() {
        return this.tipoReparto;
    }
    
    public void setNome(final String n) {
        this.nome = n;
    }
    
    public void setCognome(final String c) {
        this.cognome = c;
    }
    
    public void setGender(final String g) {
        this.gender = g;
    }
    
    public void setCodFiscale(final String co) {
        this.codFiscale = co;
    }
    
    public void setDataDiNascita(final String d) {
        this.dataDiNascita = d;
    }
    
    public void setNomeUtente(final String no) {
        this.nomeUtente = no;
    }
    
    public void setPassword(final String p) {
        this.password = p;
    }
    
    public void setEmail(final String s) {
        this.email = s;
    }
    
    public void setReparto(final Reparto rep) {
        this.tipoReparto = rep;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.cognome) + " " + this.nome + ",data di nascita:" + this.dataDiNascita + ",codice fiscale:" + this.codFiscale + ",telefono:" + ",sesso:" + this.gender + "\n" + "email:" + this.email.toLowerCase() + ",nome utente:" + this.nomeUtente.toLowerCase() + ",password:" + this.password;
    }
    
    @Override
    public boolean equals(final Object medico2) {
        if (this == medico2) {
            return true;
        }
        if (medico2 == null) {
            return false;
        }
        if (this.getClass() != medico2.getClass()) {
            return false;
        }
        final Persona other = (Persona)medico2;
        if (this.codFiscale == null) {
            if (other.codFiscale != null) {
                return false;
            }
        }
        else if (!this.codFiscale.equals(other.codFiscale)) {
            return false;
        }
        if (this.cognome == null) {
            if (other.cognome != null) {
                return false;
            }
        }
        else if (!this.cognome.equals(other.cognome)) {
            return false;
        }
        if (this.dataDiNascita == null) {
            if (other.dataDiNascita != null) {
                return false;
            }
        }
        else if (!this.dataDiNascita.equals(other.dataDiNascita)) {
            return false;
        }
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        }
        else if (!this.email.equals(other.email)) {
            return false;
        }
        if (this.gender == null) {
            if (other.gender != null) {
                return false;
            }
        }
        else if (!this.gender.equals(other.gender)) {
            return false;
        }
        if (this.nome == null) {
            if (other.nome != null) {
                return false;
            }
        }
        else if (!this.nome.equals(other.nome)) {
            return false;
        }
        if (this.nomeUtente == null) {
            if (other.nomeUtente != null) {
                return false;
            }
        }
        else if (!this.nomeUtente.equals(other.nomeUtente)) {
            return false;
        }
        if (this.password == null) {
            if (other.password != null) {
                return false;
            }
        }
        else if (!this.password.equals(other.password)) {
            return false;
        }
        if (this.tipoReparto == null) {
            if (other.tipoReparto != null) {
                return false;
            }
        }
        else if (!this.tipoReparto.equals(other.tipoReparto)) {
            return false;
        }
        return true;
    }
}
