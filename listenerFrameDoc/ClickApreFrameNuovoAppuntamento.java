// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.FrameCreaAppuntamento;
import frameFunzionali.WindowNessunPazienteInReparto;
import java.awt.event.ActionEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import oggetti.Reparto;
import java.awt.event.ActionListener;

public class ClickApreFrameNuovoAppuntamento implements ActionListener
{
    private Reparto r;
    private JFrame frame;
    private Medico medico;
    
    public ClickApreFrameNuovoAppuntamento(final Reparto r, final JFrame frame, final Medico medico) {
        this.r = r;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void actionPerformed(final ActionEvent arg0) {
        if (arg0.getModifiers() == 16) {
            if (this.r.getListaPazienti().size() == 0) {
                new WindowNessunPazienteInReparto();
            }
            else {
                new FrameCreaAppuntamento(this.r, this.frame, this.medico);
            }
        }
    }
}
