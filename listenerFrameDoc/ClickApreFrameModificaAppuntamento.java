// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.WindowContinua;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import oggetti.Reparto;
import utility.Appuntamento;
import java.awt.event.MouseListener;

public class ClickApreFrameModificaAppuntamento implements MouseListener
{
    private Appuntamento appuntamento;
    private Reparto r;
    private ArrayList<Appuntamento> i;
    private JPanel panelR;
    private JLabel l;
    private int index;
    private JFrame frame;
    private Medico medico;
    
    public ClickApreFrameModificaAppuntamento(final ArrayList<Appuntamento> arrayList, final Appuntamento appuntamento, final Reparto reparto, final JPanel panelR, final JLabel l, final int index, final JFrame frame, final Medico medico) {
        this.appuntamento = appuntamento;
        this.r = reparto;
        this.i = arrayList;
        this.l = l;
        this.panelR = panelR;
        this.index = index;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            final WindowContinua wc = new WindowContinua(this.i, this.appuntamento, this.r, this.index, this.frame, this.medico);
            wc.setVisible(true);
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
