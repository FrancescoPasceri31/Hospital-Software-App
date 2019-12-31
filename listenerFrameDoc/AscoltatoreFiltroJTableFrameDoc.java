// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

public class AscoltatoreFiltroJTableFrameDoc implements DocumentListener
{
    private JTextField textFieldRicerca;
    private JTable table;
    
    public AscoltatoreFiltroJTableFrameDoc(final JTextField textFieldRicerca, final JTable table) {
        this.textFieldRicerca = textFieldRicerca;
        this.table = table;
    }
    
    @Override
    public void changedUpdate(final DocumentEvent arg0) {
        this.newFilterTitolo();
    }
    
    @Override
    public void insertUpdate(final DocumentEvent arg0) {
        this.newFilterTitolo();
    }
    
    @Override
    public void removeUpdate(final DocumentEvent arg0) {
        this.newFilterTitolo();
    }
    
    private void newFilterTitolo() {
        RowFilter<Object, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(this.textFieldRicerca.getText(), 0);
        }
        catch (PatternSyntaxException e) {
            return;
        }
        final TableModel model = this.table.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        this.table.setRowSorter((RowSorter<? extends TableModel>)sorter);
        sorter.setRowFilter(rf);
    }
}
