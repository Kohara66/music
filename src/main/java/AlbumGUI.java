import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by Happy on 5/3/2017.
 */
public class AlbumGUI {
    private JPanel AlbumGUI;
    private JTable albumtable1;
    private JComboBox searchescomboBox1;
    private JTextField titletextField1;
    private JTextField artisttextField2;
    private JTextField categorytextField3;
    private JTextField sellingPricetextField4;
    private JButton addToAlbumButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton quitButton;
    private JTextField searchtextField1;


    AlbumGUI(final albumDateModel albumDateModel) {
        albumtable1.setGridColor(Color.black);
        albumtable1.setModel(albumDateModel);

        String search = "Title";
        String serach2 = "Artist";
        String search3 = "category";
        String search4 = "sellingPrice";


        searchescomboBox1.addItem(search);
        searchescomboBox1.addItem(serach2);
        searchescomboBox1.addItem(search3);
        searchescomboBox1.addItem(search4);


        addToAlbumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titletextField1.getText();
                String artist = artisttextField2.getText();
                String category = categorytextField3.getText();
                Double sellPrice = Double.parseDouble(sellingPricetextField4.getText());

                Album albumToAdd = new Album(title, artist, category, sellPrice);

                Main.addToAlbum(albumToAdd);


            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.shutdown();
                System.exit(0);

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchCriteria = searchescomboBox1.getSelectedItem().toString();
                String word = searchtextField1.getText();

                if (!word.equals("")){
                    Main.searchAlbum(searchCriteria, word);


                }

                else {
                    JOptionPane.showMessageDialog(AlbumGUI, "Please enter something to search for.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentRow = albumtable1.getSelectedRow();

                if (currentRow == -1) {      // -1 means no row is selected. Display error message.
                    //JOptionPane.showMessageDialog(rootPane, "Please choose a sale to delete");
                }
                boolean deleted = albumDateModel.deleteRow(currentRow);
                if (deleted) {
                    Main.loadAllRecord();
                } else {
                    // JOptionPane.showMessageDialog(rootPane, "Error deleting movie");

                }

            }
        });
    }

    public AlbumGUI() {



    }


    public JPanel getPanel () { return AlbumGUI; }
}




