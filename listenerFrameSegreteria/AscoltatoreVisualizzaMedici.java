// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import utility.ControlloWindowUnica;
import frameFunzionali.FrameTableMedici;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.event.MouseListener;

public class AscoltatoreVisualizzaMedici implements MouseListener
{
    private JToggleButton bottone;
    private JFrame frame;
    
    public AscoltatoreVisualizzaMedici(final JToggleButton bottone, final JFrame frame) {
        this.bottone = bottone;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            if (this.bottone.isSelected()) {
                new FrameTableMedici(this.bottone, this.frame);
            }
            else {
                ControlloWindowUnica.chiudiAltre("Medici", 0);
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
}
