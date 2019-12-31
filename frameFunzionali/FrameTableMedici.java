// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import utility.ControlloWindowUnica;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import listener.SelezioneCellaInUnFrameTable;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import utility.JTableModelMia;
import java.util.Collection;
import oggetti.Reparto;
import oggetti.Medico;
import java.util.ArrayList;
import oggetti.Segreteria;
import avvio.App;
import javax.swing.JToggleButton;
import javax.swing.JFrame;

public class FrameTableMedici extends JFrame
{
    public FrameTableMedici(final JToggleButton bottone, final JFrame frame) {
        this.setTitle("Medici Ospedale");
        final String[] arrayTestate = { "Nome", "Cognome", "Data di Nascita", "Codice Fiscale", "Reparto" };
        App.segreteria.deserializzazioneArrayListReparto();
        final Segreteria segreteria = App.segreteria;
        final ArrayList<Reparto> arrayCopia = Segreteria.getListaReparti();
        final ArrayList<Medico> arrayCopiaMedici = new ArrayList<Medico>();
        for (int i = 0; i < arrayCopia.size(); ++i) {
            arrayCopiaMedici.addAll(arrayCopia.get(i).getListaMedici());
        }
        final String[][] matriceMedici = new String[arrayCopiaMedici.size()][arrayTestate.length];
        for (int j = 0; j < arrayCopiaMedici.size(); ++j) {
            matriceMedici[j][0] = arrayCopiaMedici.get(j).getNome();
            matriceMedici[j][1] = arrayCopiaMedici.get(j).getCognome();
            matriceMedici[j][2] = arrayCopiaMedici.get(j).getDataDiNascita();
            matriceMedici[j][3] = arrayCopiaMedici.get(j).getCodFiscale().toUpperCase();
            matriceMedici[j][4] = arrayCopiaMedici.get(j).getTipoReparto().getNomeReparto();
        }
        final JTable table = new JTable(new JTableModelMia(matriceMedici, arrayTestate)) {
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
        table.addMouseListener(new SelezioneCellaInUnFrameTable(table, matriceMedici, "Medici", frame, null));
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        final JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane, "Center");
        this.setDefaultCloseOperation(0);
        this.pack();
        ControlloWindowUnica.chiudiAltre("Medici", 0);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this, bottone));
        this.setVisible(true);
    }
}
