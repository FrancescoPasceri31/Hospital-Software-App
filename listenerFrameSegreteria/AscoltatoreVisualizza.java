// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.FrameTableMedici;
import frameFunzionali.FrameTablePazienti;
import utility.ControlloWindowUnica;
import frameFunzionali.FrameTableReparti;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.event.MouseListener;

public class AscoltatoreVisualizza implements MouseListener
{
    private JToggleButton bottone;
    private String cosaDevoVisualizzare;
    private JFrame frame;
    
    public AscoltatoreVisualizza(final JToggleButton bottone, final String cosaDevoVisualizzare, final JFrame frame) {
        this.bottone = bottone;
        this.cosaDevoVisualizzare = bottone.getText();
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1 && this.cosaDevoVisualizzare.equalsIgnoreCase("Reparti")) {
            if (this.bottone.isSelected()) {
                new FrameTableReparti(this.bottone, this.frame);
            }
            else {
                ControlloWindowUnica.chiudiAltre("Reparti");
            }
            if (this.cosaDevoVisualizzare.equalsIgnoreCase("Pazienti")) {
                if (this.bottone.isSelected()) {
                    new FrameTablePazienti(this.bottone);
                }
                else {
                    ControlloWindowUnica.chiudiAltre("Pazienti", 0.2);
                }
            }
            if (this.cosaDevoVisualizzare.equalsIgnoreCase("Medici")) {
                if (this.bottone.isSelected()) {
                    new FrameTableMedici(this.bottone, this.frame);
                }
                else {
                    ControlloWindowUnica.chiudiAltre("Medici", 0);
                }
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
