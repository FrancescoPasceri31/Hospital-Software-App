// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import java.awt.Window;
import frame.FramePaziente;
import frameFunzionali.WindowLoginSbagliato;
import frame.FrameSegreteria;
import oggetti.Segreteria;
import frame.FrameDoc;
import avvio.App;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.event.MouseListener;

public class AscoltatoreMouse implements MouseListener
{
    private JFrame f;
    private JCheckBox a;
    private JCheckBox b;
    private JCheckBox c;
    private JTextField textArea;
    private JPasswordField passwordField;
    
    public AscoltatoreMouse(final JFrame f, final JCheckBox a, final JCheckBox b, final JCheckBox c, final JTextField textArea, final JPasswordField passwordField) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.textArea = textArea;
        this.passwordField = passwordField;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1 && (this.a.isSelected() || this.b.isSelected() || this.c.isSelected()) && (this.a.isSelected() || this.b.isSelected() || this.c.isSelected())) {
            if (this.a.isSelected()) {
                if (App.login.controlloLoginMedico(this.textArea.getText(), this.passwordField.getText())) {
                    this.f.setVisible(false);
                    final FrameDoc frameDoc = new FrameDoc(App.login.getMedico(this.textArea.getText()));
                    this.chiudiWindowPass();
                    frameDoc.setVisible(true);
                }
            }
            else if (this.b.isSelected()) {
                if (this.textArea.getText().equalsIgnoreCase(Segreteria.getUsername()) && this.passwordField.getText().equalsIgnoreCase(Segreteria.getPassword())) {
                    this.f.setVisible(false);
                    final FrameSegreteria frameSegreteria = new FrameSegreteria();
                    this.chiudiWindowPass();
                    frameSegreteria.setVisible(true);
                }
                else {
                    final WindowLoginSbagliato hoScrittoMale = new WindowLoginSbagliato();
                    hoScrittoMale.setVisible(true);
                }
            }
            else if (this.c.isSelected() && App.login.controlloLoginPaziente(this.textArea.getText(), this.passwordField.getText())) {
                this.f.setVisible(false);
                final FramePaziente framePublic = new FramePaziente(App.login.getPaziente(this.textArea.getText()));
                this.chiudiWindowPass();
                framePublic.setVisible(true);
            }
        }
    }
    
    public void chiudiWindowPass() {
        final Window[] daChiudere = Window.getWindows();
        Window[] array;
        for (int length = (array = daChiudere).length, i = 0; i < length; ++i) {
            final Window window = array[i];
            window.dispose();
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
