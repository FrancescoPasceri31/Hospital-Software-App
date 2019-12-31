// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import javax.swing.BorderFactory;
import java.awt.Color;
import utility.ControlloWindowUnica;
import listener.EliminaAppuntamentoSi;
import listenerFrameSegreteria.ClickApriFrameModificaAppuntamento;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import java.awt.MouseInfo;
import oggetti.Medico;
import javax.swing.JFrame;
import oggetti.Reparto;
import utility.Appuntamento;
import java.util.ArrayList;
import javax.swing.JWindow;

public class WindowContinua extends JWindow
{
    public WindowContinua(final ArrayList<Appuntamento> i, final Appuntamento appuntamento, final Reparto r, final int index, final JFrame frame, final Medico medico) {
        this.setSize(280, 70);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 1));
        final JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
        this.getContentPane().add(panel);
        final JLabel continuare = new JLabel("Vuoi Modificare?");
        panel.add(continuare);
        final JButton si = new JButton("Si");
        panel.add(si);
        final JButton no = new JButton("No");
        panel.add(no);
        no.addMouseListener(new ContinuaNo(this));
        si.addMouseListener(new ClickApriFrameModificaAppuntamento(this, i, appuntamento, r, frame, medico));
        final JPanel panel_1 = new JPanel();
        panel_1.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        this.getContentPane().add(panel_1);
        final JLabel lblVuoiEliminare = new JLabel("Vuoi Eliminare? ");
        panel_1.add(lblVuoiEliminare);
        final JButton btnSi = new JButton("Si");
        panel_1.add(btnSi);
        final JButton btnNo = new JButton("No");
        panel_1.add(btnNo);
        btnNo.addMouseListener(new ContinuaNo(this));
        btnSi.addMouseListener(new EliminaAppuntamentoSi(this, appuntamento, r, i, index, frame, medico));
        ControlloWindowUnica.controlloWindowUnica(this);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
    }
}
