// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.util.Date;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;

public class JDateChooserCellEditor extends AbstractCellEditor implements TableCellEditor
{
    private static final long serialVersionUID = 917881575221755609L;
    private JDateChooser dateChooser;
    
    public JDateChooserCellEditor() {
        this.dateChooser = new JDateChooser();
    }
    
    @Override
    public Component getTableCellEditorComponent(final JTable table, final Object value, final boolean isSelected, final int row, final int column) {
        Date date = null;
        if (value instanceof Date) {
            date = (Date)value;
        }
        this.dateChooser.setDate(date);
        return this.dateChooser;
    }
    
    @Override
    public Object getCellEditorValue() {
        return this.dateChooser.getDate();
    }
}
