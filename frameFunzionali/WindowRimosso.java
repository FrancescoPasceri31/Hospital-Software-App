// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import oggetti.Medico;
import utility.ControlloWindowUnica;
import javax.swing.BorderFactory;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JWindow;

public class WindowRimosso extends JWindow
{
    public WindowRimosso(final String s, final JFrame frame) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        this.getContentPane().setBackground(Color.GRAY);
        final JLabel soggetto = new JLabel(String.valueOf(s) + " rimosso. Aggiorna la pagina con il tasto destro per visualizzare.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(420, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame));
        this.getContentPane().add(ok);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
    }
    
    public WindowRimosso(final String s, final JFrame frame, final Medico medico) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        this.getContentPane().setBackground(Color.GRAY);
        final JLabel soggetto = new JLabel(String.valueOf(s) + " rimosso. Premi ok per aggiornare.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(420, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame, medico));
        this.getContentPane().add(ok);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
    }
}
