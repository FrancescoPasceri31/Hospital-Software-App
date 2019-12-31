// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import javax.swing.BorderFactory;
import java.awt.Color;
import listener.ContinuaNo;
import listenerFrameDoc.ClickRimuoviPaziente;
import listenerFrameDoc.ClickPerModificarePaziente;
import java.awt.event.MouseListener;
import listenerFrameDoc.ClickPerAprireCc;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import oggetti.Medico;
import javax.swing.JFrame;
import oggetti.Paziente;
import javax.swing.JWindow;

public class WindowModificaRimuoviAnnullaPaziente extends JWindow
{
    public WindowModificaRimuoviAnnullaPaziente(final Paziente paziente, final JFrame frame, final Medico medico) {
        this.setSize(134, 150);
        this.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        final JPanel panel_4 = new JPanel();
        this.getContentPane().add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, 3));
        final JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
        panel_4.add(panel);
        final JButton btnApriCc = new JButton("Apri cartella clinica");
        btnApriCc.addMouseListener(new ClickPerAprireCc(paziente, this));
        panel.add(btnApriCc);
        final JPanel panel_5 = new JPanel();
        panel_5.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
        panel_4.add(panel_5);
        final JButton btnModifica = new JButton("Modifica");
        btnModifica.addMouseListener(new ClickPerModificarePaziente(paziente, this, frame, medico));
        panel_5.add(btnModifica);
        final JPanel panel_6 = new JPanel();
        panel_6.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
        panel_4.add(panel_6);
        final JButton btnRimuovi = new JButton("Rimuovi");
        btnRimuovi.addMouseListener(new ClickRimuoviPaziente(paziente.getTipoReparto().getListaPazienti(), paziente, this, frame, medico));
        panel_6.add(btnRimuovi);
        final JPanel panel_7 = new JPanel();
        panel_7.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
        panel_4.add(panel_7);
        final JButton btnAnnulla = new JButton("Annulla");
        btnAnnulla.addMouseListener(new ContinuaNo(this));
        panel_7.add(btnAnnulla);
        final JPanel panel_8 = new JPanel();
        panel_8.setBackground(UIManager.getColor("ScrollBar.thumbDarkShadow"));
        this.getContentPane().add(panel_8, "North");
        final JPanel panel_9 = new JPanel();
        panel_9.setBackground(UIManager.getColor("ScrollBar.thumbDarkShadow"));
        this.getContentPane().add(panel_9, "South");
        final JPanel panel_10 = new JPanel();
        panel_10.setBackground(UIManager.getColor("ScrollBar.thumbDarkShadow"));
        this.getContentPane().add(panel_10, "West");
        final JPanel panel_11 = new JPanel();
        panel_11.setBackground(UIManager.getColor("ScrollBar.thumbDarkShadow"));
        this.getContentPane().add(panel_11, "East");
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ControlloWindowUnica.controlloWindowUnica(this);
        this.pack();
        this.setVisible(true);
    }
}
