// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import utility.ControlloWindowUnica;
import frameFunzionali.FrameTableReparti;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.event.MouseListener;

public class AscoltatoreVisualizzaReparto implements MouseListener
{
    private JToggleButton bottone;
    private JFrame frame;
    
    public AscoltatoreVisualizzaReparto(final JToggleButton bottone, final JFrame frame) {
        this.bottone = bottone;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.bottone.isSelected()) {
                new FrameTableReparti(this.bottone, this.frame);
            }
            else {
                ControlloWindowUnica.chiudiAltre("Reparti");
            }
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
