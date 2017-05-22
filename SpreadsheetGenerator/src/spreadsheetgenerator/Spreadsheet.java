/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadsheetgenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author pc
 */
public class Spreadsheet {
    String[] columns;
    List<Object[]> tableData;
    String fileName;

    public Spreadsheet(String[] columns, List<Object[]> tableData, String fileName) {
        this.columns = columns;
        this.tableData = tableData;
        this.fileName = fileName;
    }

    
    public void generate() throws IOException{
        Object[][]data= tableData.toArray(new Object[tableData.size()][5]);
        TableModel model = new DefaultTableModel(data, columns); 
        File file = new File(fileName);
        SpreadSheet.createEmpty(model).saveAs(file);
        OOUtils.open(file);
    }
   
    
}
