// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.FrameRicordaNonEsistenzaOrario;
import frame.FrameOrario;
import java.awt.event.ActionEvent;
import oggetti.Reparto;
import java.awt.event.ActionListener;

public class ClickMostraOrario implements ActionListener
{
    private Reparto reparto;
    
    public ClickMostraOrario(final Reparto reparto) {
        this.reparto = reparto;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getModifiers() == 16) {
            if (this.reparto.getOrario() != null) {
                new FrameOrario(this.reparto.getOrario());
            }
            else {
                new FrameRicordaNonEsistenzaOrario();
            }
        }
    }
}
