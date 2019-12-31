// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import javax.swing.BorderFactory;
import java.awt.Color;
import listener.ContinuaNo;
import listenerFrameSegreteria.ClickSxPerEliminareReparto;
import java.awt.event.MouseListener;
import listenerFrameSegreteria.ClickSxPerModificareReparto;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import java.awt.MouseInfo;
import javax.swing.JFrame;
import javax.swing.JTable;
import oggetti.Reparto;
import javax.swing.JWindow;

public class WindowModificaRimuoviAnnullaReparto extends JWindow
{
    public WindowModificaRimuoviAnnullaReparto(final Reparto reparto, final JTable table, final JFrame frame) {
        this.setSize(150, 100);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(new FlowLayout(1, 5, 5));
        final JButton BottoneModifica = new JButton("Modifica");
        BottoneModifica.addMouseListener(new ClickSxPerModificareReparto(reparto, this, table, frame));
        panel.add(BottoneModifica);
        final JButton BottoneElimina = new JButton("Elimina");
        BottoneElimina.addMouseListener(new ClickSxPerEliminareReparto(reparto, this, table, frame));
        panel.add(BottoneElimina);
        final JButton BottoneAnnulla = new JButton("Annulla");
        BottoneAnnulla.addMouseListener(new ContinuaNo(this));
        panel.add(BottoneAnnulla);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
        this.setVisible(true);
    }
}
