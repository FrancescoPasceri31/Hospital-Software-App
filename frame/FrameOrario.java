// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import java.awt.Container;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import utility.OrarioMatrice;
import javax.swing.JTable;
import javax.swing.JFrame;

public class FrameOrario extends JFrame
{
    private JFrame f;
    private JTable table;
    private OrarioMatrice or;
    
    public FrameOrario(final OrarioMatrice or) {
        this.or = or;
        this.f = new JFrame();
        final String[] giorniFalsi = { "", "", "", "", "", "", "", "" };
        final String[][] orario_matrice = or.getOrario();
        this.table = new JTable(orario_matrice, giorniFalsi);
        final Container cp = this.f.getContentPane();
        final JPanel c = new JPanel();
        cp.add(c);
        c.add(this.table);
        this.f.setSize(1250, 750);
        this.table.setBackground(Color.PINK);
        this.table.setFont(new Font("Arial", 0, 12));
        this.table.setRowHeight(30);
        this.table.setAutoResizeMode(0);
        this.setDefaultCloseOperation(0);
        this.f.setResizable(false);
        final JScrollPane pane = new JScrollPane(this.table);
        pane.setPreferredSize(new Dimension(this.f.getWidth() - 25, this.f.getHeight() - 45));
        c.add(pane);
        this.f.add(c);
        this.f.setVisible(true);
        for (int i = 0; i < or.getNumeroColonne(); ++i) {
            this.table.getColumnModel().getColumn(i).setPreferredWidth(200);
        }
        this.addWindowListener(new ConfermaUscita(this));
        this.f.setLocationRelativeTo(null);
    }
    
    public OrarioMatrice getOrarioM() {
        return this.or;
    }
}
