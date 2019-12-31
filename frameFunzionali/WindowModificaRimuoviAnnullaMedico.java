// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import javax.swing.BorderFactory;
import java.awt.Color;
import listener.ContinuaNo;
import listenerFrameSegreteria.ClickPerRimuovereMedico;
import java.awt.event.MouseListener;
import listenerFrameSegreteria.ClickPerAprireFrameModificaMedico;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import java.awt.MouseInfo;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTable;
import oggetti.Medico;
import javax.swing.JWindow;

public class WindowModificaRimuoviAnnullaMedico extends JWindow
{
    public WindowModificaRimuoviAnnullaMedico(final Medico medico, final JTable table, final JFrame frame) {
        final Date data = new Date();
        this.setSize(120, 100);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        final JButton btnModifica = new JButton("Modifica");
        btnModifica.addMouseListener(new ClickPerAprireFrameModificaMedico(medico, this, table, frame));
        panel.add(btnModifica);
        final JButton btnElimina = new JButton("Elimina");
        btnElimina.addMouseListener(new ClickPerRimuovereMedico(medico, this, table, frame));
        panel.add(btnElimina);
        final JButton btnAnnulla = new JButton("Annulla");
        btnAnnulla.addMouseListener(new ContinuaNo(this));
        panel.add(btnAnnulla);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
    }
}
