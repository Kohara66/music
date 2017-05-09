
import sun.util.calendar.LocalGregorianCalendar;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 * Created by Happy on 5/3/2017.
 */
//This class can add and update the data i database for certain columns of data
// columns like; Title column, artist, selling price and consignor ID 
//for the use of an album table data grid in an Album Table GUI    
//used part of movieRate model"hhttps:github.com/minneapolis-edu/Movies" code to set  my albumDateModel
    
public class albumDateModel   extends AbstractTableModel {
    int rowCount = 0;
    int columnCount = 0;
    ResultSet resultSet;


    //constructor - using ResultSet to work out how many rows and columns we have.
    public albumDateModel(ResultSet rs) {
        this.resultSet = rs;
        setup();

    }

    private void setup() {
        countRows();
        try {
            columnCount = resultSet.getMetaData().getColumnCount();
        } catch (SQLException se) {
            System.out.println("Error count column" + se);
        }

    }

    public void updateResultSet(ResultSet newRS) {
        resultSet = newRS;
        setup();
    }

    @Override
    public int getRowCount() {

        countRows();
        return rowCount;
    }

    public void countRows() {
        rowCount = 0;
        try {

            //moves cursor to the start..
            resultSet.beforeFirst();

            //next() method moves the cursor forward one row and returns true if there is another row ahead
            while (resultSet.next()) {
                rowCount++;
            }
            resultSet.beforeFirst();
        } catch (SQLException se) {

            System.out.println("Error counting rows " + se);
        }

    }


    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int row, int column) {
        try {
            //move to this row in the result set, rows are numbered like 1, 2, 3....
            resultSet.absolute(row + 1);
            Object O = resultSet.getObject(column + 1);
            return O;
            //O.toString();
        } catch (SQLException se) {
            System.out.println(se);
            //display the text of the error message in th
            return se.toString();

        }


    }


    public boolean isCellEditable(int row, int column) {
        if (column == 3) {
            return true;
        }
        return false;
    }
     //Delete row, will return true if successful  or false otherwise
    public boolean deleteRow(int row) {
        try {
            resultSet.absolute(row + 1);
            resultSet.deleteRow();
            //tell table to redraw itself
            fireTableDataChanged();
            return true;
        } catch (SQLException se) {
            System.out.println("Delete row error " + se);
            return false;
        }
    }

    public boolean insertRow(String Title, String Artist, String category, int sellingPrice) {
        //move to insert row to each row
        try {
            resultSet.moveToInsertRow();
            resultSet.updateString(Main.Title, Title);
            resultSet.updateString(Main.Artist, Artist);
            resultSet.updateString(Main.category, category);
            resultSet.updateInt(Main.sellingPrice, sellingPrice);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            fireTableDataChanged();
            return true;
        } catch (SQLException e) {
            System.out.println("error adding row");
            System.out.println(e);
            return false;
        }

    }

    public boolean insertRow(String consignorName, String PhoneNumber) {
        try {
            resultSet.moveToInsertRow();
            resultSet.updateString(Main.consignorName, consignorName);
            resultSet.updateString(Main.consignorPhoneNumber, PhoneNumber);
            //resultSet.updateDouble((Main.consignorPay,consignorPay);
            //resultSet.updateDouble(Main.consignorOwe, consignorOwn);

            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            fireTableDataChanged();
            //change will go to DB but not reflected in this result set
            // therefore no need to close/re-open result set to see latest data
            //return true to the calling methods so we konw that the ResultSet was successfully updated and 
            //it can request a new Resultset for this tablemodel
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding row");
            System.out.println(e);
            return false;
        }
    }

    public boolean insertSale(Date sale_date, Double amount) {
        try {
            resultSet.moveToInsertRow();
            resultSet.updateDate(Main.sale_date, (java.sql.Date) sale_date);
            resultSet.updateDouble(Main.amount, amount);

            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            fireTableDataChanged();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding row");
            System.out.println(e);
            return false;
        }

    }


    @Override
    public String getColumnName(int column) {
        try {
            return resultSet.getMetaData().getColumnName(column + 1);

        } catch (SQLException se) {
            System.out.println("Error fetching column names" + se);
            return "?";
        }
    }


    public boolean insertSale(double price, double consignorPay, double consignorOwe) {
        try {

            resultSet.moveToInsertRow();
            //resultSet.updateDouble(Main.saleprice, price);
            resultSet.updateDouble("consignorPay", consignorPay);
            resultSet.updateDouble("consignorOwe", consignorOwe);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            fireTableDataChanged();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding row");
            System.out.println(e);
            return false;
        }
    }
}




