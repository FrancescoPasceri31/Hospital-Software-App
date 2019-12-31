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
import java.io.IOException;
import avvio.App;
import java.io.File;
import utility.ControlloOs;
import java.util.ArrayList;
import java.io.Serializable;

public class Segreteria implements Serializable
{
    private static final long serialVersionUID = 1L;
    private static String username;
    private static String password;
    private ArrayList<Reparto> listaReparti;
    private ArrayList<Paziente> archivioPazienti;
    
    static {
        Segreteria.username = "Admin";
        Segreteria.password = "1234";
    }
    
    public Segreteria() {
        final File f;
        if (!(f = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//listaReparti.txt")).exists()) {
            try {
                f.createNewFile();
                this.listaReparti = new ArrayList<Reparto>();
                final Segreteria segreteria = App.segreteria;
                serializzaReparto(this.listaReparti);
                final File archivio;
                if (!(archivio = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//archivioPazienti.txt")).exists()) {
                    archivio.createNewFile();
                    this.archivioPazienti = new ArrayList<Paziente>();
                    final Segreteria segreteria2 = App.segreteria;
                    serializzaListaRepartiTrascorsi(this.archivioPazienti);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getUsername() {
        return Segreteria.username;
    }
    
    public static String getPassword() {
        return Segreteria.password;
    }
    
    public void aggiungiRepartoALista(final Reparto reparto) {
        App.segreteria.deserializzazioneArrayListReparto();
        if (!App.segreteria.listaReparti.contains(reparto)) {
            App.segreteria.listaReparti.add(reparto);
            final Segreteria segreteria = App.segreteria;
            serializzaReparto(this.listaReparti);
        }
    }
    
    public void rimuoviRepartoDaLista(final Reparto reparto) {
        final String pathRepartoDaEliminare = String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + reparto.getNomeReparto();
        App.segreteria.deserializzazioneArrayListReparto();
        if (App.segreteria.listaReparti.contains(reparto)) {
            App.segreteria.listaReparti.remove(reparto);
        }
        final Segreteria segreteria = App.segreteria;
        serializzaReparto(this.listaReparti);
        this.rimuoviMediciPazientiDaLogin(reparto);
        this.cancellaDirectoryReparto(new File(pathRepartoDaEliminare));
    }
    
    public void rimuoviMediciPazientiDaLogin(final Reparto reparto) {
        App.login.deserializzaMappaLoginMedico();
        App.login.deserializzaMappaLoginPaziente();
        final ArrayList<Medico> listaMedici = reparto.getListaMedici();
        final ArrayList<Paziente> listaPazienti = reparto.getListaPazienti();
        for (final Paziente paziente : listaPazienti) {
            App.login.getMappaLoginPaziente().remove(paziente.getCodFiscale());
        }
        for (final Medico medico : listaMedici) {
            App.login.getMappaLoginMedico().remove(medico.getCodFiscale());
        }
        App.login.serializzaMappaLoginMedico(App.login.getMappaLoginMedico());
        App.login.serializzaMappaLoginPaziente(App.login.getMappaLoginPaziente());
    }
    
    public boolean cancellaDirectoryReparto(final File file) {
        if (file.exists()) {
            final File[] filesContenuti = file.listFiles();
            for (int i = 0; i < filesContenuti.length; ++i) {
                if (filesContenuti[i].isDirectory()) {
                    this.cancellaDirectoryReparto(filesContenuti[i]);
                }
                else {
                    filesContenuti[i].delete();
                }
            }
        }
        file.delete();
        return file.exists();
    }
    
    public void rimuoviMedico(final Medico medicoDaEliminare) {
        final Reparto r = medicoDaEliminare.getTipoReparto();
        r.rimuoviMedicoDaLista(medicoDaEliminare);
    }
    
    public static ArrayList<Reparto> getListaReparti() {
        return App.segreteria.listaReparti;
    }
    
    public static ArrayList<Paziente> getArchivioPazienti() {
        return App.segreteria.archivioPazienti;
    }
    
    public static void serializzaReparto(final ArrayList<Reparto> listareparti) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//listaReparti.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(listareparti);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void serializzaListaRepartiTrascorsi(final ArrayList<Paziente> archivioPazienti) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//archivioPazienti.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(archivioPazienti);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deserializzazioneArrayListReparto() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//listaReparti.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            App.segreteria.listaReparti = (ArrayList<Reparto>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    public void deserializzaListaRepartiTrascorsi() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//archivioPazienti.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            App.segreteria.archivioPazienti = (ArrayList<Paziente>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
}
