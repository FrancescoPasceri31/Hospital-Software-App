// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import utility.ControlloWindowUnica;
import frameFunzionali.FrameTablePazienti;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.event.MouseListener;

public class AscoltatoreVisualizzaPazienti implements MouseListener
{
    private JToggleButton bottone;
    
    public AscoltatoreVisualizzaPazienti(final JToggleButton bottone) {
        this.bottone = bottone;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            if (this.bottone.isSelected()) {
                new FrameTablePazienti(this.bottone);
            }
            else {
                ControlloWindowUnica.chiudiAltre("Pazienti", 0.2);
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
