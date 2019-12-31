// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameCartellaClinica;

import frameFunzionali.WindowNonEsiste;
import java.awt.event.MouseEvent;
import utility.CartellaClinica;
import java.util.ArrayList;
import frame.FrameCartellaClinica;
import oggetti.Paziente;
import javax.swing.JTextField;
import utility.JTableModelMia;
import java.awt.event.MouseListener;

public class AggiungiATableDiarioClinico implements MouseListener
{
    private JTableModelMia model;
    private Object[][] data;
    private JTextField primaColonna;
    private JTextField secondaColonna;
    private Paziente p1;
    private FrameCartellaClinica frame;
    private ArrayList<Object> dataR;
    
    public AggiungiATableDiarioClinico(final JTableModelMia model, final Object[][] data, final JTextField textFieldAggiungiVoce, final JTextField textFieldAggiungiData, final Paziente p1, final FrameCartellaClinica frame) {
        this.model = model;
        this.data = CartellaClinica.deserializzaMatriceDiarioClinico(p1);
        this.secondaColonna = textFieldAggiungiVoce;
        this.primaColonna = textFieldAggiungiData;
        this.p1 = p1;
        this.frame = frame;
        this.dataR = new ArrayList<Object>();
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.primaColonna.getText().trim().isEmpty() || this.secondaColonna.getText().trim().isEmpty()) {
                new WindowNonEsiste("Inserimento ").setVisible(true);
                return;
            }
            final Object[] newRow = { this.primaColonna.getText(), this.secondaColonna.getText() };
            if (this.data.length != 0) {
                for (int i = 0; i < this.data.length; ++i) {
                    if (((String)this.data[i][0]).equalsIgnoreCase(this.primaColonna.getText()) && ((String)this.data[i][1]).equalsIgnoreCase(this.secondaColonna.getText())) {
                        return;
                    }
                }
                for (int i = 0; i < this.data.length; ++i) {
                    this.dataR.add(this.data[i][0]);
                    this.dataR.add(this.data[i][1]);
                }
            }
            this.dataR.add(newRow[0]);
            this.dataR.add(newRow[1]);
            System.out.println(this.dataR.toString());
            final Object[][] data2 = new Object[this.dataR.size() - this.dataR.size() / 2][2];
            int pos = 0;
            for (int j = 0; j < this.dataR.size() - this.dataR.size() / 2; ++j) {
                data2[j][0] = this.dataR.get(pos);
                ++pos;
                data2[j][1] = this.dataR.get(pos);
                ++pos;
            }
            this.model.addRow(newRow);
            this.frame.setData(data2);
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
