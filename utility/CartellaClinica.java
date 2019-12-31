// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import javax.swing.JPanel;
import oggetti.Paziente;
import java.io.File;
import java.io.Serializable;

public class CartellaClinica implements Serializable
{
    private File cartellaClinica;
    private Paziente p;
    
    public CartellaClinica(final Paziente paziente, final String nomeReparto) {
        final String matr_cc = String.valueOf(paziente.getCodFiscale()) + ".txt";
        this.cartellaClinica = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + nomeReparto + "//" + matr_cc);
        this.p = paziente;
    }
    
    public static JPanel deserializzaPannelloAccettazione(final Paziente paz) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + paz.getTipoReparto().getNomeReparto() + "//" + paz.getCodFiscale() + "//PannelloAccettazione.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final JPanel s = (JPanel)ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
    
    public static JPanel deserializzaPannelloTerapiaDomiciliare(final Paziente paz) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + paz.getTipoReparto().getNomeReparto() + "//" + paz.getCodFiscale() + "//PannelloTerapiaDomiciliare.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final JPanel s = (JPanel)ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
    
    public static JPanel deserializzaPannelloEsameObiettivo(final Paziente paz) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + paz.getTipoReparto().getNomeReparto() + "//" + paz.getCodFiscale() + "//PanelloEsameObiettivo.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final JPanel s = (JPanel)ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
    
    public static JPanel deserializzaPannelloValutazioneClinica(final Paziente paz) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + paz.getTipoReparto().getNomeReparto() + "//" + paz.getCodFiscale() + "//PannelloValutazioneClinica.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final JPanel s = (JPanel)ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
    
    public static JPanel deserializzaPannelloValutazioneInfermieristica(final Paziente paz) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + paz.getTipoReparto().getNomeReparto() + "//" + paz.getCodFiscale() + "//PannelloValutazioneInfermieristica.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final JPanel s = (JPanel)ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object[][] deserializzaMatriceDiarioClinico(final Paziente p1) {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + p1.getTipoReparto().getNomeReparto() + "//" + p1.getCodFiscale() + "//MatriceDiarioClinico.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final Object[][] s = (Object[][])ois.readObject();
            ois.close();
            return s;
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return null;
        }
    }
}
