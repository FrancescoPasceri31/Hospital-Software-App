// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JPanel;
import utility.ControlloWindowUnica;
import javax.swing.JWindow;

public class WindowNessunPazienteInReparto extends JWindow
{
    public WindowNessunPazienteInReparto() {
        ControlloWindowUnica.controlloWindowUnica(this);
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        panel.setLayout(new FlowLayout(1, 5, 5));
        final JLabel lblNessunPazienteIn = new JLabel("Nessun paziente in reparto. Impossibile creare nuova notifica.");
        panel.add(lblNessunPazienteIn);
        final JButton btnOk = new JButton("OK");
        btnOk.addMouseListener(new ContinuaNo(this));
        panel.add(btnOk);
        this.setLocation(456, 240);
        this.setSize(352, 75);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setVisible(true);
    }
}
