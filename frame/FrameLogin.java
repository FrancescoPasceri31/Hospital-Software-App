// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import java.awt.Font;
import listener.CliccaPerRecuperarePassoword;
import java.awt.event.MouseListener;
import listener.AscoltatoreMouse;
import javax.swing.JButton;
import javax.swing.text.Document;
import utility.LimitedTextField;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import utility.Login;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class FrameLogin extends JFrame
{
    private static final ButtonGroup buttonGroup;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JCheckBox boxDoc;
    private JCheckBox boxSegreteria;
    private JCheckBox boxPaziente;
    
    static {
        buttonGroup = new ButtonGroup();
    }
    
    public FrameLogin(final Login log) {
        this.setTitle("Login Ospedale");
        this.setLocation(120, 80);
        this.setSize(400, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        final Container p = this.getContentPane();
        final JPanel panelNorth = new JPanel();
        p.add(panelNorth, "North");
        final JLabel lblSeleziona = new JLabel("Seleziona :");
        panelNorth.add(lblSeleziona);
        this.boxDoc = new JCheckBox("Medico");
        FrameLogin.buttonGroup.add(this.boxDoc);
        panelNorth.add(this.boxDoc);
        this.boxSegreteria = new JCheckBox("Segreteria");
        FrameLogin.buttonGroup.add(this.boxSegreteria);
        panelNorth.add(this.boxSegreteria);
        this.boxPaziente = new JCheckBox("Pubblico");
        FrameLogin.buttonGroup.add(this.boxPaziente);
        panelNorth.add(this.boxPaziente);
        final JPanel panelWest = new JPanel();
        p.add(panelWest, "West");
        final Component horizontalStrut = Box.createHorizontalStrut(70);
        panelWest.add(horizontalStrut);
        final JPanel panelEast = new JPanel();
        p.add(panelEast, "East");
        final Component horizontalStrut_1 = Box.createHorizontalStrut(70);
        panelEast.add(horizontalStrut_1);
        final JPanel panelCenter = new JPanel();
        p.add(panelCenter, "Center");
        panelCenter.setLayout(new BoxLayout(panelCenter, 1));
        final JSeparator separator = new JSeparator();
        panelCenter.add(separator);
        final Component verticalStrut = Box.createVerticalStrut(20);
        panelCenter.add(verticalStrut);
        final JPanel panel_Username = new JPanel();
        panelCenter.add(panel_Username);
        panel_Username.setLayout(new FlowLayout(1, 5, 5));
        final JLabel lblUsername = new JLabel("Username :");
        panel_Username.add(lblUsername);
        final Component verticalStrut_1 = Box.createVerticalStrut(10);
        panelCenter.add(verticalStrut_1);
        (this.textFieldUsername = new JTextField()).setDocument(new LimitedTextField(20));
        panelCenter.add(this.textFieldUsername);
        final Component verticalStrut_2 = Box.createVerticalStrut(20);
        panelCenter.add(verticalStrut_2);
        final JPanel panel_Password = new JPanel();
        panelCenter.add(panel_Password);
        final JLabel lblPassword = new JLabel("Password :");
        panel_Password.add(lblPassword);
        final Component verticalStrut_3 = Box.createVerticalStrut(10);
        panelCenter.add(verticalStrut_3);
        (this.passwordField = new JPasswordField()).setDocument(new LimitedTextField(20));
        this.passwordField.setEchoChar('*');
        panelCenter.add(this.passwordField);
        final Component verticalStrut_4 = Box.createVerticalStrut(50);
        panelCenter.add(verticalStrut_4);
        final JPanel panelSouth = new JPanel();
        p.add(panelSouth, "South");
        final JButton invioButton = new JButton("INVIO");
        panelSouth.add(invioButton);
        invioButton.addMouseListener(new AscoltatoreMouse(this, this.boxDoc, this.boxSegreteria, this.boxPaziente, this.textFieldUsername, this.passwordField));
        final JLabel lblRecuperaPassword = new JLabel("Recupera password");
        lblRecuperaPassword.addMouseListener(new CliccaPerRecuperarePassoword());
        lblRecuperaPassword.setFont(new Font("Tahoma", 1, 11));
        panelCenter.add(lblRecuperaPassword);
        final Component verticalStrut_5 = Box.createVerticalStrut(40);
        panelCenter.add(verticalStrut_5);
    }
}
