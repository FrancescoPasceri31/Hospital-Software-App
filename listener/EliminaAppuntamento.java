// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frameFunzionali.WindowRimosso;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import oggetti.Reparto;
import utility.Appuntamento;
import java.awt.event.MouseListener;

public class EliminaAppuntamento implements MouseListener
{
    private Appuntamento a;
    private Reparto r;
    private JFrame frame;
    private Medico medico;
    
    public EliminaAppuntamento(final Appuntamento a, final Reparto r, final JFrame frame, final Medico medico) {
        this.a = a;
        this.r = r;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.r.rimuoviAppuntamentoDaLista(this.a);
            new WindowRimosso("Appuntamento", this.frame, this.medico).setVisible(true);
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
