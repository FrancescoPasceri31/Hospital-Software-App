// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickSxPerResetCampi implements MouseListener
{
    private JTextField textFieldNome;
    private JTextField textFieldCognome;
    private JTextField textFieldCodFiscale;
    private JTextField dataField;
    
    public ClickSxPerResetCampi(final JTextField textFieldNome, final JTextField textFieldCognome, final JTextField textFieldCodFiscale, final JTextField dataField) {
        this.textFieldNome = textFieldNome;
        this.textFieldCognome = textFieldCognome;
        this.textFieldCodFiscale = textFieldCodFiscale;
        this.dataField = dataField;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.textFieldCodFiscale.setText("");
            this.textFieldCognome.setText("");
            this.textFieldNome.setText("");
            this.dataField.setText("");
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
