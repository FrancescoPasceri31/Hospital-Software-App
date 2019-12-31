// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class FrameRicordaNonEsistenzaOrario extends JFrame
{
    public FrameRicordaNonEsistenzaOrario() {
        this.setTitle("Orario Inesistente! ");
        this.setSize(400, 100);
        this.setResizable(false);
        this.setLocation(120, 80);
        final Container p = this.getContentPane();
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
        final Component verticalStrut_1 = Box.createVerticalStrut(20);
        p.add(verticalStrut_1);
        final JPanel panel = new JPanel();
        p.add(panel);
        panel.setLayout(new FlowLayout(1, 5, 5));
        final JLabel lblNumeroInsufficenteDi = new JLabel("Numero ancora insufficiente di medici per generare orario!");
        lblNumeroInsufficenteDi.setFont(new Font("Tahoma", 0, 13));
        panel.add(lblNumeroInsufficenteDi);
        final Component verticalStrut = Box.createVerticalStrut(20);
        p.add(verticalStrut);
        this.setVisible(true);
    }
}
