// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import java.util.Iterator;
import javax.swing.JScrollPane;
import utility.Appuntamento;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import utility.JTableModelMia;
import java.awt.Component;
import javax.swing.JPanel;
import oggetti.Reparto;
import javax.swing.JFrame;

public class FrameAppuntamento extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    public FrameAppuntamento(final String codFiscale, final Reparto reparto) {
        this.setTitle("Appuntamenti");
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        final String[] testate = { "Tipologia", "Data" };
        final Object[][] matriceAppuntamenti = new Object[0][2];
        final JTable table = new JTable(new JTableModelMia(matriceAppuntamenti, testate));
        final Object[] newRow = new Object[2];
        for (final Appuntamento appuntamento : reparto.getListaAppuntamento()) {
            if (appuntamento.getCodFiscalePaziente().equalsIgnoreCase(codFiscale)) {
                newRow[0] = appuntamento.getTipologia();
                newRow[1] = appuntamento.getData();
            }
        }
        ((JTableModelMia)table.getModel()).addRow(newRow);
        final JScrollPane sp = new JScrollPane(table);
        panel.add(sp);
        this.getContentPane().add(sp, "Center");
        this.pack();
        this.setVisible(true);
    }
}
