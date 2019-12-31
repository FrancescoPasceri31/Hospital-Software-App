// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import java.util.Iterator;
import frameFunzionali.WindowModificaRimuoviAnnullaPaziente;
import oggetti.Paziente;
import frameFunzionali.WindowModificaRimuoviAnnullaMedico;
import java.util.Collection;
import java.util.ArrayList;
import frameFunzionali.WindowModificaRimuoviAnnullaReparto;
import oggetti.Reparto;
import oggetti.Segreteria;
import avvio.App;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.event.MouseListener;

public class SelezioneCellaInUnFrameTable implements MouseListener
{
    private JTable table;
    private String[][] matrice;
    private String qualeTable;
    private JFrame frame;
    private Medico medico1;
    
    public SelezioneCellaInUnFrameTable(final JTable table, final String[][] matrice, final String qualeTable, final JFrame frame, final Medico medico1) {
        this.table = table;
        this.matrice = matrice;
        this.qualeTable = qualeTable;
        this.frame = frame;
        this.medico1 = medico1;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.qualeTable.equalsIgnoreCase("Reparti")) {
                final int indiceReparto = this.table.getSelectedRow();
                final String nomeReparto = this.matrice[indiceReparto][0];
                App.segreteria.deserializzazioneArrayListReparto();
                final Segreteria segreteria = App.segreteria;
                final ArrayList<Reparto> arrayCopia = Segreteria.getListaReparti();
                for (final Reparto reparto : arrayCopia) {
                    if (reparto.getNomeReparto().equalsIgnoreCase(nomeReparto)) {
                        new WindowModificaRimuoviAnnullaReparto(reparto, this.table, this.frame);
                        break;
                    }
                }
            }
            else if (this.qualeTable.equalsIgnoreCase("Medici")) {
                final int indiceMedico = this.table.getSelectedRow();
                final String codFiscaleMedico = this.matrice[indiceMedico][3];
                final ArrayList<Medico> arrayCopiaMedici = new ArrayList<Medico>();
                App.segreteria.deserializzazioneArrayListReparto();
                final Segreteria segreteria2 = App.segreteria;
                final ArrayList<Reparto> arrayCopia2 = Segreteria.getListaReparti();
                for (final Reparto reparto2 : arrayCopia2) {
                    arrayCopiaMedici.addAll(reparto2.getListaMedici());
                }
                for (final Medico medico : arrayCopiaMedici) {
                    if (medico.getCodFiscale().equalsIgnoreCase(codFiscaleMedico)) {
                        new WindowModificaRimuoviAnnullaMedico(medico, this.table, this.frame).setVisible(true);
                        break;
                    }
                }
            }
            else if (this.qualeTable.equalsIgnoreCase("Pazienti")) {
                final int indicePaziente = this.table.getSelectedRow();
                final String codFiscalePaziente = this.matrice[indicePaziente][2];
                final ArrayList<Paziente> arrayCopiaPazienti = new ArrayList<Paziente>();
                App.segreteria.deserializzazioneArrayListReparto();
                final Segreteria segreteria3 = App.segreteria;
                final ArrayList<Reparto> arrayCopia2 = Segreteria.getListaReparti();
                for (final Reparto reparto2 : arrayCopia2) {
                    System.out.println("aggiungo reparto");
                    arrayCopiaPazienti.addAll(reparto2.getListaPazienti());
                }
                for (final Paziente pazienteNuovo : arrayCopiaPazienti) {
                    System.out.println(String.valueOf(pazienteNuovo.getCodFiscale()) + " " + pazienteNuovo.getNome());
                    if (pazienteNuovo.getCodFiscale().equalsIgnoreCase(codFiscalePaziente)) {
                        System.out.println("Trovato");
                        new WindowModificaRimuoviAnnullaPaziente(pazienteNuovo, this.frame, this.medico1);
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
