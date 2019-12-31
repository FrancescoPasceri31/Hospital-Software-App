// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import listenerFrameSegreteria.ClickResetTestoReparto;
import java.awt.event.MouseListener;
import listenerFrameSegreteria.SalvaEModificaReparto;
import javax.swing.JButton;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.MouseInfo;
import javax.swing.JTextField;
import oggetti.Reparto;
import javax.swing.JFrame;

public class FrameModificaReparto extends JFrame
{
    private Reparto reparto;
    private JTextField textField;
    
    public FrameModificaReparto(final Reparto reparto, final JFrame frame) {
        this.setTitle("MODIFICA REPARTO " + reparto.getNomeReparto().toUpperCase());
        this.reparto = reparto;
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.setSize(310, 100);
        this.setResizable(false);
        final JPanel panelCentrale = new JPanel();
        this.getContentPane().add(panelCentrale, "Center");
        final JLabel lblNewLabel = new JLabel("Nome : ");
        panelCentrale.add(lblNewLabel);
        (this.textField = new JTextField()).setDocument(new LimitedTextField(20));
        panelCentrale.add(this.textField);
        this.textField.setColumns(20);
        final JPanel panelBottom = new JPanel();
        this.getContentPane().add(panelBottom, "South");
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new SalvaEModificaReparto(this.textField, reparto, frame));
        panelBottom.add(btnSalva);
        final JButton btnReset = new JButton("Reset");
        btnReset.addMouseListener(new ClickResetTestoReparto(this.textField));
        panelBottom.add(btnReset);
    }
}
