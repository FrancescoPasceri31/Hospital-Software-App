// 
// Decompiled by Procyon v0.5.36
// 

package oggetti;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import frameFunzionali.WindowNonEsiste;
import java.io.IOException;
import java.io.File;
import utility.ControlloOs;
import avvio.App;
import utility.OrarioMatrice;
import utility.Appuntamento;
import java.util.ArrayList;
import java.io.Serializable;

public class Reparto implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String nomeReparto;
    private ArrayList<Medico> listaMedici;
    private ArrayList<Paziente> listaPazienti;
    private ArrayList<Appuntamento> listaAppuntamento;
    private OrarioMatrice orario;
    
    public Reparto(final String nomeReparto) {
        this.nomeReparto = nomeReparto;
        App.segreteria.aggiungiRepartoALista(this);
        if (!new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale").mkdir()) {
            new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale").mkdir();
        }
        this.nomeReparto = nomeReparto;
        if (!new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto).mkdir()) {
            new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto).mkdir();
        }
        File m;
        if (!(m = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaMedici.txt")).exists()) {
            this.listaMedici = new ArrayList<Medico>();
            m = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaMedici.txt");
            try {
                m.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            this.serializzaArrayListMedico(this.listaMedici);
            this.serializzaArrayListMedico(this.listaMedici);
        }
        File p;
        if (!(p = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaPazienti.txt")).exists()) {
            this.listaPazienti = new ArrayList<Paziente>();
            p = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaPazienti.txt");
            try {
                p.createNewFile();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
            this.serializzaArrayListPaziente(this.listaPazienti);
        }
        File f;
        if (!(f = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaAppuntamenti.txt")).exists()) {
            this.listaAppuntamento = new ArrayList<Appuntamento>();
            f = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//listaAppuntamenti.txt");
            try {
                f.createNewFile();
            }
            catch (IOException e3) {
                e3.printStackTrace();
            }
            this.serializzaArrayListAppuntamento(this.listaAppuntamento);
        }
        if (!(m = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//orario.txt")).exists()) {
            final File o = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//orario.txt");
            try {
                m.createNewFile();
            }
            catch (IOException e4) {
                e4.printStackTrace();
            }
            this.serializzaOrario(this.orario);
        }
        this.deserializzazioneArrayListMedico();
        this.deserializzazioneArrayListPaziente();
        this.deserializzazioneArrayListAppuntamento();
        this.deserializzazioneOrario();
    }
    
    public boolean creaOrario() {
        if (this.listaMedici.size() > 13) {
            this.serializzaOrario(this.orario = new OrarioMatrice(this));
            return true;
        }
        return false;
    }
    
    public OrarioMatrice getOrario() {
        this.deserializzazioneOrario();
        return this.orario;
    }
    
    public ArrayList<Paziente> getListaPazienti() {
        this.deserializzazioneArrayListPaziente();
        return this.listaPazienti;
    }
    
    public ArrayList<Medico> getListaMedici() {
        this.deserializzazioneArrayListMedico();
        return this.listaMedici;
    }
    
    public ArrayList<Appuntamento> getListaAppuntamento() {
        this.deserializzazioneArrayListAppuntamento();
        return this.listaAppuntamento;
    }
    
    public String getNomeReparto() {
        return this.nomeReparto;
    }
    
    public void setNomeReparto(final String nomeReparto) {
        final String pathDirectoryVecchia = String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.nomeReparto;
        final File vecchiaDir = new File(pathDirectoryVecchia);
        if (!vecchiaDir.exists()) {
            new WindowNonEsiste("Reparto ");
        }
        final File nuovaDir = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto);
        App.segreteria.deserializzazioneArrayListReparto();
        final Segreteria segreteria = App.segreteria;
        for (final Reparto repartoDaCambiareNome : Segreteria.getListaReparti()) {
            if (repartoDaCambiareNome.getNomeReparto().equalsIgnoreCase(this.nomeReparto)) {
                repartoDaCambiareNome.deserializzazioneArrayListMedico();
                repartoDaCambiareNome.deserializzazioneArrayListAppuntamento();
                repartoDaCambiareNome.deserializzazioneArrayListPaziente();
                App.login.deserializzaMappaLoginMedico();
                App.login.deserializzaMappaLoginPaziente();
                for (final Map.Entry<String, Medico> entry : App.login.getMappaLoginMedico().entrySet()) {
                    entry.getValue().setReparto(repartoDaCambiareNome);
                }
                for (final Map.Entry<String, Paziente> entry2 : App.login.getMappaLoginPaziente().entrySet()) {
                    entry2.getValue().setReparto(repartoDaCambiareNome);
                }
                for (final Medico medico : repartoDaCambiareNome.listaMedici) {
                    medico.setReparto(repartoDaCambiareNome);
                }
                for (final Appuntamento appuntamento : repartoDaCambiareNome.listaAppuntamento) {
                    appuntamento.setReparto(repartoDaCambiareNome);
                }
                for (final Paziente paziente : repartoDaCambiareNome.listaPazienti) {
                    paziente.setReparto(repartoDaCambiareNome);
                }
                final boolean rename = vecchiaDir.renameTo(nuovaDir);
                repartoDaCambiareNome.nomeReparto = nomeReparto;
                App.login.serializzaMappaLoginMedico(App.login.getMappaLoginMedico());
                App.login.serializzaMappaLoginPaziente(App.login.getMappaLoginPaziente());
                repartoDaCambiareNome.serializzaArrayListAppuntamento(repartoDaCambiareNome.listaAppuntamento);
                repartoDaCambiareNome.serializzaArrayListMedico(repartoDaCambiareNome.listaMedici);
                repartoDaCambiareNome.serializzaArrayListPaziente(repartoDaCambiareNome.listaPazienti);
                final Segreteria segreteria2 = App.segreteria;
                final Segreteria segreteria3 = App.segreteria;
                Segreteria.serializzaReparto(Segreteria.getListaReparti());
                break;
            }
        }
    }
    
    public void aggiungiMedicoALista(final Medico medico) {
        this.deserializzazioneArrayListMedico();
        if (!this.listaMedici.contains(medico)) {
            this.listaMedici.add(medico);
        }
        this.serializzaArrayListMedico(this.listaMedici);
        this.creaOrario();
    }
    
    public void rimuoviMedicoDaLista(final Medico m) {
        this.listaMedici.remove(m);
        if (this.listaMedici.size() == 0) {
            this.serializzaArrayListMedico(this.listaMedici = new ArrayList<Medico>());
        }
        else {
            this.serializzaArrayListPaziente(this.listaPazienti);
        }
        this.creaOrario();
    }
    
    public void aggiungiPazienteALista(final Paziente m) {
        this.deserializzazioneArrayListPaziente();
        App.segreteria.deserializzaListaRepartiTrascorsi();
        final Segreteria segreteria = App.segreteria;
        if (!Segreteria.getArchivioPazienti().contains(m)) {
            final Segreteria segreteria2 = App.segreteria;
            Segreteria.getArchivioPazienti().add(m);
        }
        m.aggiungiRepartoPassato(this.nomeReparto);
        final Segreteria segreteria3 = App.segreteria;
        final Segreteria segreteria4 = App.segreteria;
        Segreteria.serializzaListaRepartiTrascorsi(Segreteria.getArchivioPazienti());
        if (!this.listaPazienti.contains(m)) {
            this.listaPazienti.add(m);
        }
        this.serializzaArrayListPaziente(this.listaPazienti);
    }
    
    public void rimuoviPazienteDaLista(final Paziente m) {
        App.segreteria.deserializzaListaRepartiTrascorsi();
        m.setNomeRepartoPerAggiuntaInArchivio();
        final Segreteria segreteria = App.segreteria;
        if (!Segreteria.getArchivioPazienti().contains(m)) {
            final Segreteria segreteria2 = App.segreteria;
            Segreteria.getArchivioPazienti().add(m);
        }
        m.aggiungiRepartoPassato(m.getTipoReparto().nomeReparto);
        final Segreteria segreteria3 = App.segreteria;
        final Segreteria segreteria4 = App.segreteria;
        Segreteria.serializzaListaRepartiTrascorsi(Segreteria.getArchivioPazienti());
        this.listaPazienti.remove(m);
        if (this.listaPazienti.size() == 0) {
            this.listaPazienti = new ArrayList<Paziente>();
        }
        this.serializzaArrayListPaziente(this.listaPazienti);
    }
    
    public void aggiungiAppuntamentoALista(final Appuntamento a) {
        this.deserializzazioneArrayListAppuntamento();
        if (!this.listaAppuntamento.contains(a)) {
            this.listaAppuntamento.add(a);
        }
        this.serializzaArrayListAppuntamento(this.listaAppuntamento);
    }
    
    public Appuntamento cercaAppuntamento(final String codFiscale) {
        for (int i = 0; i < this.listaAppuntamento.size(); ++i) {
            if (codFiscale == this.listaAppuntamento.get(i).getCodFiscalePaziente()) {
                return this.listaAppuntamento.get(i);
            }
        }
        return null;
    }
    
    public void rimuoviAppuntamentoDaLista(final Appuntamento a) {
        this.deserializzazioneArrayListAppuntamento();
        this.listaAppuntamento.remove(a);
        if (this.listaAppuntamento.size() == 0) {
            this.serializzaArrayListAppuntamento(this.listaAppuntamento = new ArrayList<Appuntamento>());
        }
        else {
            this.serializzaArrayListAppuntamento(this.listaAppuntamento);
        }
    }
    
    @Override
    public String toString() {
        return this.nomeReparto;
    }
    
    public void serializzaArrayListPaziente(final ArrayList<Paziente> listaPaziente) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaPazienti.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(listaPaziente);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void serializzaArrayListMedico(final ArrayList<Medico> listaMedici2) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaMedici.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(listaMedici2);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void serializzaArrayListAppuntamento(final ArrayList<Appuntamento> listaAppuntamento) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaAppuntamenti.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(listaAppuntamento);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void serializzaOrario(final OrarioMatrice orario) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//orario.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(orario);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deserializzazioneArrayListPaziente() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaPazienti.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            this.listaPazienti = (ArrayList<Paziente>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    public void deserializzazioneArrayListMedico() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaMedici.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            this.listaMedici = (ArrayList<Medico>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    public void deserializzazioneOrario() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//orario.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            this.orario = (OrarioMatrice)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    public void deserializzazioneArrayListAppuntamento() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.getNomeReparto() + "//listaAppuntamenti.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            this.listaAppuntamento = (ArrayList<Appuntamento>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean equals(final Object reparto) {
        if (this == reparto) {
            return true;
        }
        if (reparto == null) {
            return false;
        }
        if (this.getClass() != reparto.getClass()) {
            return false;
        }
        final Reparto altroReparto = (Reparto)reparto;
        if (this.listaAppuntamento == null) {
            if (altroReparto.listaAppuntamento != null) {
                return false;
            }
        }
        else if (!this.listaAppuntamento.equals(altroReparto.listaAppuntamento)) {
            return false;
        }
        if (this.listaMedici == null) {
            if (altroReparto.listaMedici != null) {
                return false;
            }
        }
        else if (!this.listaMedici.equals(altroReparto.listaMedici)) {
            return false;
        }
        if (this.listaPazienti == null) {
            if (altroReparto.listaPazienti != null) {
                return false;
            }
        }
        else if (!this.listaPazienti.equals(altroReparto.listaPazienti)) {
            return false;
        }
        if (this.nomeReparto == null) {
            if (altroReparto.nomeReparto != null) {
                return false;
            }
        }
        else if (!this.nomeReparto.equals(altroReparto.nomeReparto)) {
            return false;
        }
        if (this.orario == null) {
            if (altroReparto.orario != null) {
                return false;
            }
        }
        else if (!this.orario.equals(altroReparto.orario)) {
            return false;
        }
        return true;
    }
}
