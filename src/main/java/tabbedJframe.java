import javax.swing.*;

/**
 * Created by Happy on 5/9/2017.
 */
public class tabbedJframe extends JFrame {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane;


    public void tabbedJframe(){}

    public tabbedJframe(){
        setContentPane(rootPanel);
        tabbedPane = new JTabbedPane();
        rootPanel.add(tabbedPane);
        tabbedPane.add("album GUI", new AlbumGUI(Main.albumDateModel).getPanel());
        tabbedPane.add("Consignor GUI", new ConsignorGUI(Main.consignorDateModel).getPanel());
        tabbedPane.add("Sale GUI", new SaleGUI(Main.salesDateModel).getPanel());


        setVisible(true);
        pack();

    }
}




