// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.FrameModificaAppuntamento;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import oggetti.Reparto;
import utility.Appuntamento;
import java.util.ArrayList;
import frameFunzionali.WindowContinua;
import java.awt.event.MouseListener;

public class ClickApriFrameModificaAppuntamento implements MouseListener
{
    private WindowContinua wc;
    private ArrayList<Appuntamento> index;
    private Appuntamento appuntamento;
    private Reparto r;
    private JFrame frame;
    private Medico medico;
    
    public ClickApriFrameModificaAppuntamento(final WindowContinua windowContinua, final ArrayList<Appuntamento> i, final Appuntamento appuntamento, final Reparto r, final JFrame frame, final Medico medico) {
        this.wc = windowContinua;
        this.index = i;
        this.appuntamento = appuntamento;
        this.r = r;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.wc.dispose();
            new FrameModificaAppuntamento(this.appuntamento, this.r, this.frame, this.medico).setVisible(true);
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
