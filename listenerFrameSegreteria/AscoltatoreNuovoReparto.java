// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import java.util.ArrayList;
import frameFunzionali.WindowCreato;
import oggetti.Reparto;
import oggetti.Segreteria;
import avvio.App;
import frameFunzionali.WindowNonEsiste;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class AscoltatoreNuovoReparto implements MouseListener
{
    private JTextField textNomeReparto;
    private JButton button;
    private JFrame frame;
    
    public AscoltatoreNuovoReparto(final JButton button, final JTextField textNomeReparto, final JFrame frame) {
        this.textNomeReparto = textNomeReparto;
        this.button = button;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            if (!(this.textNomeReparto.getText() instanceof String)) {
                new WindowNonEsiste("Reparto ");
            }
            App.segreteria.deserializzazioneArrayListReparto();
            final Segreteria segreteria = App.segreteria;
            final ArrayList<Reparto> copiaListaReparti = Segreteria.getListaReparti();
            boolean giaPresente = false;
            for (int i = 0; i < copiaListaReparti.size(); ++i) {
                System.out.println(String.valueOf(copiaListaReparti.get(i).getNomeReparto().trim().toLowerCase()) + " -- " + this.textNomeReparto.getText().trim().toLowerCase());
                if (copiaListaReparti.get(i).getNomeReparto().trim().toLowerCase().equalsIgnoreCase(this.textNomeReparto.getText().trim().toLowerCase())) {
                    giaPresente = true;
                    break;
                }
            }
            if (giaPresente) {
                new WindowNonEsiste("Reparto ", "giaEsiste");
            }
            else {
                final Reparto rep = new Reparto(this.textNomeReparto.getText());
                new WindowCreato("Reparto", this.frame);
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
