// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import oggetti.Medico;
import javax.swing.BorderFactory;
import java.awt.Color;
import utility.ControlloWindowUnica;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JWindow;

public class WindowCreato extends JWindow
{
    public WindowCreato(final String s, final JFrame frame) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        final JLabel soggetto = new JLabel(String.valueOf(s) + " creato.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(400, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame));
        this.getContentPane().add(ok);
        ControlloWindowUnica.controlloWindowUnica(this);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
    }
    
    public WindowCreato(final String s, final JFrame frame, final Medico m) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        final JLabel soggetto = new JLabel(String.valueOf(s) + " creato.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(400, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame, m));
        this.getContentPane().add(ok);
        ControlloWindowUnica.controlloWindowUnica(this);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
    }
    
    public WindowCreato(final String s, final int i, final JFrame frame) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        final JLabel soggetto = new JLabel(String.valueOf(s) + " modificato.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(400, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame));
        this.getContentPane().add(ok);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
        this.setVisible(true);
    }
    
    public WindowCreato(final String s, final int i, final JFrame frame, final Medico m) {
        this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        final JLabel soggetto = new JLabel(String.valueOf(s) + " modificato.");
        this.setLocation(456, 240);
        this.getContentPane().add(soggetto);
        this.setSize(400, 50);
        final JButton ok = new JButton("Ok");
        ok.addMouseListener(new ContinuaNo(this, frame, m));
        this.getContentPane().add(ok);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
        this.setVisible(true);
    }
}
