// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class JTableModelMia extends DefaultTableModel implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Object[][] dataRow;
    
    public JTableModelMia(final Object[][] dataRow, final Object[] columnNames) {
        super(dataRow, columnNames);
        this.dataRow = dataRow;
    }
    
    @Override
    public boolean isCellEditable(final int row, final int col) {
        return false;
    }
}
