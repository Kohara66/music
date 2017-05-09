import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Happy on 5/3/2017.
 */
public class ConsignorAlbumSaleGUI extends JPanel {
    private JPanel ConsignorAlbumSale;
    private JTable saletable1;
    private JTextField soldpricetextField1;
    private JTextField ConsignorPaytextField2;
    private JTextField OwnerPaytextField3;
    private JButton addButton;
    private JButton quitButton;
    private JButton deleteButton;
    private JPanel getJpanel;

    ConsignorAlbumSaleGUI(final albumDateModel albumDateModel){
        saletable1.setGridColor(Color.black);
        saletable1.setModel(albumDateModel);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = Double.parseDouble(soldpricetextField1.getText());
                if (price < 0){
                    JOptionPane.showMessageDialog(ConsignorAlbumSale, "Enter album sale price");
                    return;
                }

                double consignorpay = (price / 100) * 40;
                ConsignorPaytextField2.setText(Double.toString(consignorpay));

                double OwnerPay = (price / 100) * 60;
                OwnerPaytextField3.setText(Double.toString(OwnerPay));


                System.out.println(" to add " + price + " " + consignorpay + " " + OwnerPay);

                boolean insertrow = albumDateModel.insertSale(price, consignorpay, OwnerPay);
                if (insertrow){
                    Main.loadAllSales();
                }else {
                    JOptionPane.showMessageDialog(ConsignorAlbumSale, "Error adding information");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.shutdown();
                System.exit(0);

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int currentRow = saletable1.getSelectedRow();

                if (currentRow == -1) {      // -1 means no row is selected. Display error message.
                    //JOptionPane.showMessageDialog(rootPane, "Please choose a sale to delete");
                }
                boolean deleted = albumDateModel.deleteRow(currentRow);
                if (deleted) {
                    Main.loadAllRecord();
                } else {

                }
            }
        });
    }
    public JPanel getJPanel(){
        return getJpanel;
    }
}





