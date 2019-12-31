// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.FrameCreaPaziente;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import java.awt.event.ActionListener;

public class AscoltatoreClickApreFrameNuovoPaziente implements ActionListener
{
    private Medico medico;
    private JFrame frame;
    
    public AscoltatoreClickApreFrameNuovoPaziente(final JFrame frame, final Medico medico) {
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getModifiers() == 16) {
            final FrameCreaPaziente frameCrea = new FrameCreaPaziente(this.frame, this.medico);
            frameCrea.setVisible(true);
        }
    }
}
