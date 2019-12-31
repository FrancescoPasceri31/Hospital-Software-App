// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frameFunzionali.WindowRimosso;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import java.util.ArrayList;
import oggetti.Reparto;
import utility.Appuntamento;
import frameFunzionali.WindowContinua;
import java.awt.event.MouseListener;

public class EliminaAppuntamentoSi implements MouseListener
{
    private WindowContinua wc;
    private Appuntamento a;
    private Reparto reparto;
    private ArrayList<Appuntamento> listaAppuntamenti;
    private int index;
    private JFrame frame;
    private Medico medico;
    
    public EliminaAppuntamentoSi(final WindowContinua windowContinua, final Appuntamento appuntamento, final Reparto reparto, final ArrayList<Appuntamento> listaAppuntamenti, final int index, final JFrame frame, final Medico medico) {
        this.wc = windowContinua;
        this.a = appuntamento;
        this.reparto = reparto;
        this.listaAppuntamenti = listaAppuntamenti;
        this.index = index;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            this.wc.dispose();
            this.reparto.deserializzazioneArrayListPaziente();
            this.reparto.deserializzazioneArrayListAppuntamento();
            this.listaAppuntamenti.remove(this.index);
            this.reparto.serializzaArrayListAppuntamento(this.listaAppuntamenti);
            new WindowRimosso("Appuntamento", this.frame, this.medico).setVisible(true);
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
