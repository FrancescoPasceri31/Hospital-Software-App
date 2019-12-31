// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frameFunzionali.FrameRecuperaPassword;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CliccaPerRecuperarePassoword implements MouseListener
{
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            new FrameRecuperaPassword().setVisible(true);
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
