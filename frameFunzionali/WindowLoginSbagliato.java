// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import javax.swing.BorderFactory;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JWindow;

public class WindowLoginSbagliato extends JWindow
{
    private static final long serialVersionUID = 1L;
    
    public WindowLoginSbagliato() {
        this.getContentPane().setBackground(Color.YELLOW);
        this.setSize(450, 65);
        this.setLocation(156, 240);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        final JLabel scrittaErrore = new JLabel("Username e/o password sono errati. Riprovare.");
        panel.add(scrittaErrore);
        final JPanel panel_1 = new JPanel();
        this.getContentPane().add(panel_1);
        final JButton okPerContinuare = new JButton("OK");
        okPerContinuare.addMouseListener(new ContinuaNo(this));
        panel_1.add(okPerContinuare);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
    }
}
