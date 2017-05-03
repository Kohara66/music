import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by Happy on 5/3/2017.
 */
public class ConsignorGUI  extends JPanel {
    private JTable Consignortable1;
    private JPanel ConsignorGUI;
    private JComboBox searchcomboBox1;
    private JTextField consignorNametextField1;
    private JTextField consignorPaytextField2;
    private JTextField consignorOwetextField3;
    private JTextField phoneNumbertextField2;
    private JTextField searchnametextField1;
    private JTextField salepricetextField1;
    private JButton addToConsignorButton;
    private JButton deleteButton;
    private JButton quitButton;



    ConsignorGUI(final albumDateModel albumDateModel) {
        Consignortable1.setGridColor(Color.black);
        Consignortable1.setModel(albumDateModel);

        String search = "Title";
        String serach2 = "Artist";
        String search3 = "category";
        String search4 = "SellingPrice";





        addToConsignorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = searchcomboBox1.getSelectedItem().toString();
                String name = consignorNametextField1.getText();
                String phoneNumber = phoneNumbertextField2.getText();
                // Double consignorpay = Double.parseDouble(consignorPaytextField2.getText());
                //Double consignorowe = Double.parseDouble(consignorOwntextField3.getText());
                Double sale = Double.parseDouble(salepricetextField1.getText());
                double pay = (sale / 100) * 40;
                double keep = (sale / 100) * 60;

                consignor consignor = new consignor(name, phoneNumber, pay, keep); //consignorpay, consignorowe);
                Main.addtoConsignor(consignor);


                double price = Double.parseDouble(salepricetextField1.getText());
                if (price < 0) {
                    JOptionPane.showMessageDialog(ConsignorGUI, "enter album sale price");
                    return;
                }

                double consignorPay = (price / 100) * 40;
                consignorPaytextField2.setText(Double.toString(consignorPay));

                double consignorOwe = (price / 100) * 60;
                consignorOwetextField3.setText(Double.toString(consignorOwe));


                System.out.println(" to add " + price + " " + consignorPay + " " + consignorOwe);

                boolean insertrow = albumDateModel.inserSale(price, consignorPay, consignorOwe);
                if (insertrow) {
                    Main.loadAllConsignor();
                } else {
                    JOptionPane.showMessageDialog(ConsignorGUI, "error adding information");
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
                int currentRow = Consignortable1.getSelectedRow();

                if (currentRow == -1) {      // -1 means no row is selected. Display error message.
                    //JOptionPane.showMessageDialog(rootPane, "Please choose a sale to delete");
                }
                boolean deleted = albumDateModel.deleteRow(currentRow);
                if (deleted) {
                    Main.loadAllConsignor();
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "Error deleting movie");
                }
            }
        });
    }

    public ConsignorGUI() {

    }

    public JPanel getPanel () {
        return ConsignorGUI;
    }
}




