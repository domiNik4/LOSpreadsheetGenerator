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
import spreadsheetgenerator.database.DBAccess;

/**
 *
 * @author D33
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        DBAccess d = new DBAccess();
        
        List<Object[]>listOfCities=d.getAllCities();
        String[] columns = new String[] { "ID", "Name","Country code","District","Info" };
        Spreadsheet spreadsheetCities=new Spreadsheet(columns,listOfCities,"cities.ods");
        spreadsheetCities.generate();
        
        List<Object[]>listOfCountries=d.getAllCountries();
        columns = new String[] {"Code","Name","Capital"};
        Spreadsheet spreadsheetCountries=new Spreadsheet(columns,listOfCountries,"countries.ods");
        spreadsheetCountries.generate();
        
        
    }
    
}
