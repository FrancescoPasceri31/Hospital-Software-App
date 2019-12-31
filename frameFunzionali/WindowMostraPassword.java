// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import oggetti.Medico;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import oggetti.Paziente;
import javax.swing.JWindow;

public class WindowMostraPassword extends JWindow
{
    public WindowMostraPassword(final Paziente paziente) {
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        final JLabel lblNome = new JLabel("");
        lblNome.setText(paziente.getNome());
        panel.add(lblNome);
        final Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);
        final JLabel lblCognome = new JLabel("");
        lblCognome.setText(paziente.getCognome());
        panel.add(lblCognome);
        final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);
        final JLabel lblPassword = new JLabel(paziente.getPassword());
        lblPassword.setFont(new Font("Tahoma", 1, 11));
        panel.add(lblPassword);
        final Component horizontalStrut_2 = Box.createHorizontalStrut(50);
        panel.add(horizontalStrut_2);
        final JButton btnOk = new JButton("Ok");
        btnOk.addMouseListener(new ContinuaNo(this));
        panel.add(btnOk);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.pack();
    }
    
    public WindowMostraPassword(final Medico medico) {
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        final JLabel lblNome = new JLabel("");
        lblNome.setText(medico.getNome());
        panel.add(lblNome);
        final Component horizontalStrut = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut);
        final JLabel lblCognome = new JLabel("");
        lblCognome.setText(medico.getCognome());
        panel.add(lblCognome);
        final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel.add(horizontalStrut_1);
        final JLabel lblPassword = new JLabel(medico.getPassword());
        lblPassword.setFont(new Font("Tahoma", 1, 11));
        panel.add(lblPassword);
        final Component horizontalStrut_2 = Box.createHorizontalStrut(50);
        panel.add(horizontalStrut_2);
        final JButton btnOk = new JButton("Ok");
        btnOk.addMouseListener(new ContinuaNo(this));
        panel.add(btnOk);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.pack();
    }
}
