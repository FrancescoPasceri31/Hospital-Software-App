// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.util.Iterator;
import java.util.ArrayList;
import frameFunzionali.WindowContinua;
import utility.Appuntamento;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import javax.swing.JTable;
import java.awt.event.MouseListener;

public class SelezionaCellaNotifica implements MouseListener
{
    private String[][] matrice;
    private JTable table;
    private Medico medico;
    private JFrame frame;
    
    public SelezionaCellaNotifica(final String[][] matrice, final JTable table, final Medico medico, final JFrame frame) {
        this.matrice = matrice;
        this.table = table;
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            final int indiceAppuntamento = this.table.getSelectedRow();
            final String tipologia = this.matrice[indiceAppuntamento][0];
            final String data = this.matrice[indiceAppuntamento][4];
            final String codFiscale = this.matrice[indiceAppuntamento][3];
            final ArrayList<Appuntamento> arrayCopia = this.medico.getTipoReparto().getListaAppuntamento();
            for (final Appuntamento appuntamento : arrayCopia) {
                if (appuntamento.getTipologia().equalsIgnoreCase(tipologia) && appuntamento.getCodFiscalePaziente().equalsIgnoreCase(codFiscale) && appuntamento.getData().equalsIgnoreCase(data)) {
                    final int index = arrayCopia.indexOf(appuntamento);
                    new WindowContinua(this.medico.getTipoReparto().getListaAppuntamento(), appuntamento, this.medico.getTipoReparto(), index, this.frame, this.medico);
                    break;
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
