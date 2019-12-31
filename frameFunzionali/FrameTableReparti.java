// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.util.ArrayList;
import utility.ControlloWindowUnica;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import oggetti.Medico;
import listener.SelezioneCellaInUnFrameTable;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
import utility.JTableModelMia;
import oggetti.Reparto;
import oggetti.Segreteria;
import avvio.App;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JFrame;

public class FrameTableReparti extends JFrame
{
    private JTable table;
    
    public FrameTableReparti(final JToggleButton bottone, final JFrame frame) {
        this.setTitle("Reparti Ospedale");
        App.segreteria.deserializzazioneArrayListReparto();
        final String[] arrayTestate = { "Nome reparto", "Numero medici", "Numero Pazienti" };
        final Segreteria segreteria = App.segreteria;
        final ArrayList<Reparto> arrayCopia = Segreteria.getListaReparti();
        final String[][] matriceReparti = new String[arrayCopia.size()][3];
        for (int i = 0; i < arrayCopia.size(); ++i) {
            int size = 0;
            int sizePaz = 0;
            if (arrayCopia.get(i).getListaMedici().size() >= 1) {
                size = arrayCopia.get(i).getListaMedici().size();
            }
            if (arrayCopia.get(i).getListaPazienti().size() >= 1) {
                sizePaz = arrayCopia.get(i).getListaPazienti().size();
            }
            matriceReparti[i][0] = arrayCopia.get(i).getNomeReparto();
            matriceReparti[i][1] = new StringBuilder().append(size).toString();
            matriceReparti[i][2] = new StringBuilder().append(sizePaz).toString();
        }
        (this.table = new JTable(new JTableModelMia(matriceReparti, arrayTestate)) {
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
        }).addMouseListener(new SelezioneCellaInUnFrameTable(this.table, matriceReparti, "Reparti", frame, null));
        this.table.setAutoCreateRowSorter(true);
        this.table.getTableHeader().setReorderingAllowed(false);
        final JScrollPane scrollPane = new JScrollPane(this.table);
        this.getContentPane().add(scrollPane, "Center");
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this, bottone));
        this.pack();
        ControlloWindowUnica.chiudiAltre("Reparti");
        this.setVisible(true);
    }
}
