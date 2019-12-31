// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.util.Iterator;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import utility.JTableModelMia;
import java.util.Collection;
import oggetti.Reparto;
import oggetti.Paziente;
import java.util.ArrayList;
import oggetti.Segreteria;
import avvio.App;
import utility.ControlloWindowUnica;
import javax.swing.JToggleButton;
import javax.swing.JFrame;

public class FrameTablePazienti extends JFrame
{
    public FrameTablePazienti(final JToggleButton bottone) {
        ControlloWindowUnica.chiudiAltre("Pazienti", new Double(0.2));
        this.setTitle("Pazienti Ospedale");
        final String[] arrayTestate = { "Nome", "Cognome", "Codice Fiscale", "Data di Nascita", "Reparto", "Reparti precedenti" };
        App.segreteria.deserializzazioneArrayListReparto();
        final Segreteria segreteria = App.segreteria;
        final ArrayList<Reparto> arrayCopia = Segreteria.getListaReparti();
        final ArrayList<Paziente> arrayCopiaPazienti = new ArrayList<Paziente>();
        for (int i = 0; i < arrayCopia.size(); ++i) {
            arrayCopiaPazienti.addAll(arrayCopia.get(i).getListaPazienti());
        }
        App.segreteria.deserializzaListaRepartiTrascorsi();
        final int size = arrayCopiaPazienti.size();
        final Segreteria segreteria2 = App.segreteria;
        final int postiMatrice = size + Segreteria.getArchivioPazienti().size();
        final String[][] matricePazienti = new String[postiMatrice][arrayTestate.length];
        int pos = 0;
        for (int j = 0; j < arrayCopiaPazienti.size(); ++j) {
            matricePazienti[j][0] = arrayCopiaPazienti.get(j).getNome();
            matricePazienti[j][1] = arrayCopiaPazienti.get(j).getCognome();
            matricePazienti[j][2] = arrayCopiaPazienti.get(j).getDataDiNascita();
            matricePazienti[j][3] = arrayCopiaPazienti.get(j).getCodFiscale().toUpperCase();
            matricePazienti[j][4] = arrayCopiaPazienti.get(j).getNomeRepartoAttuale();
            matricePazienti[j][5] = arrayCopiaPazienti.get(j).getNomeRepartiPassati();
            final Segreteria segreteria3 = App.segreteria;
            for (final Paziente pazienteInArchivio : Segreteria.getArchivioPazienti()) {
                if (arrayCopiaPazienti.get(j).getCodFiscale().equalsIgnoreCase(pazienteInArchivio.getCodFiscale())) {
                    matricePazienti[j][5] = pazienteInArchivio.getNomeRepartiPassati();
                }
            }
            ++pos;
        }
        final Segreteria segreteria4 = App.segreteria;
        for (final Paziente pazienteAncoraNonAggiunto : Segreteria.getArchivioPazienti()) {
            if (!this.contiene(pazienteAncoraNonAggiunto, arrayCopiaPazienti)) {
                matricePazienti[pos][0] = pazienteAncoraNonAggiunto.getNome();
                matricePazienti[pos][1] = pazienteAncoraNonAggiunto.getCognome();
                matricePazienti[pos][2] = pazienteAncoraNonAggiunto.getDataDiNascita();
                matricePazienti[pos][3] = pazienteAncoraNonAggiunto.getCodFiscale();
                matricePazienti[pos][4] = pazienteAncoraNonAggiunto.getNomeRepartoAttuale();
                matricePazienti[pos][5] = pazienteAncoraNonAggiunto.getNomeRepartiPassati();
                ++pos;
            }
        }
        final JTable table = new JTable(new JTableModelMia(matricePazienti, arrayTestate)) {
            @Override
            public String getToolTipText(final MouseEvent e) {
                String tip = null;
                final Point p = e.getPoint();
                final int rowIndex = this.rowAtPoint(p);
                final int colIndex = this.columnAtPoint(p);
                try {
                    tip = this.getValueAt(rowIndex, colIndex).toString();
                }
                catch (RuntimeException ex) {}
                return tip;
            }
        };
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        final JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane, "Center");
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this, bottone));
        this.pack();
        this.setVisible(true);
    }
    
    public boolean contiene(final Paziente pazienteAncoraNonAggiunto, final ArrayList<Paziente> arrayCopiaPazienti) {
        for (int i = 0; i < arrayCopiaPazienti.size(); ++i) {
            if (pazienteAncoraNonAggiunto.getCodFiscale().equalsIgnoreCase(arrayCopiaPazienti.get(i).getCodFiscale())) {
                return true;
            }
        }
        return false;
    }
}
