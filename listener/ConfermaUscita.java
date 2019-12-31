// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;

public class ConfermaUscita extends WindowAdapter
{
    private JFrame f;
    
    public ConfermaUscita(final JFrame f) {
        this.f = f;
    }
    
    public ConfermaUscita(final JFrame frameTableReparti, final JToggleButton bottone) {
        frameTableReparti.setVisible(false);
        this.f = frameTableReparti;
        bottone.setSelected(false);
    }
    
    @Override
    public void windowClosing(final WindowEvent e) {
        final int ret = JOptionPane.showConfirmDialog(this.f, "Vuoi uscire?", "Exit", 0);
        if (ret == 0) {
            this.f.dispose();
        }
    }
}
