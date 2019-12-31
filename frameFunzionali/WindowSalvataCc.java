// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class WindowSalvataCc extends JWindow
{
    public WindowSalvataCc() {
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "North");
        final JLabel lblCartellaClinicaSalvata = new JLabel("Cartella clinica salvata! ");
        lblCartellaClinicaSalvata.setFont(new Font("Tahoma", 1, 16));
        panel.add(lblCartellaClinicaSalvata);
        final JPanel panel_1 = new JPanel();
        this.getContentPane().add(panel_1, "Center");
        final JButton btnOk = new JButton("Ok");
        btnOk.addMouseListener(new ContinuaNo(this));
        panel_1.add(btnOk);
        this.setLocation(456, 240);
        ControlloWindowUnica.controlloWindowUnica(this);
        this.pack();
    }
}
