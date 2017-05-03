
/*
import java.sql.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;


*/
/**
 * Created by Happy on 5/3/2017.
 *//*

public class AlbumRecordsDB {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";        //Configure the driver needed
    private final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/AlbumRecords";     //Connection string – where's the database?
    private final String USER = "root";   //TODO replace with your username
    private final String PASSWORD = System.getenv("MYSQL_PW");   //TODO remember to set the environment variable
    // static final String PASSWORD = "password";   // If on lab PC, uncomment this line and replace "password" with your own password
    static Statement statement = null;
    static Connection conn = null;
    static ResultSet rs = null;

    public static void main(String[] args) {


        static Connection conn = null;
        static ResultSet rs = null;
        static ResultSet comboResults;
        static ResultSet CombosResults;

        static Statement statement = null;
        static Statement queriey = null;
        static Statement queries = null;
        static Statement statementconn = null;
        static Statement statementconsignor = null;

        //Album table columns
        public final static String Album = "Album_table";
        public final static String albumID = "albumID";
        public final static String Title = "title";
        public final static String Artist = "artist";
        public final static String category = "category";
        public final static String sellingPrice = "sellingPrice";
        public final static String isBasement = "isBasement";


        //consignor table columns
        public final static String Consignor = "Consignor_Table";
        public final static String PK_column = "consignorID";
        public final static String consignorName = "ConsignorName";
        public final static String consignorPhoneNumber = "PhoneNumber";
        public final static String consignorPay = "consignorPay";
        public final static String consignorOwe = "consignorOwe";

        //Sales table columns
        public final static String Sales = "Sales_table";
        public final static String sale_date = "sale_date";
        public final static String amount = "amountSold";

        //static String saleprice = "salePrice";

        static LinkedList<Statement> allStatements = new LinkedList<Statement>();
        //public final static
        public static albumDateModel albumDateModel;
        public static albumDateModel consignorDateModel;
        public static albumDateModel salesDateModel;
        public static albumDateModel salepriceDataModel;

        public static ResultSet consignerResult = null;
        public static Statement consState = null;
        public static ResultSet salesResult = null;
        public static Statement salesState = null;
        //Statement statement = null;


        PreparedStatement psInsert = null;

        //public static void main(String[] args) {
        //Statement statement = null;


        //PreparedStatement psInsert = null;
        ///try {
        if (!setup()) {
            System.exit(-1);
        }
        if (!loadAllAlbum()) {
            System.exit(-1);
        }
        if (!loadAllConsignor()) {
            System.exit(-1);
        }
        if (!loadAllSales()) {
            System.exit(-1);
        }
        System.out.println();


        //}


        //AlbumGUI albumGUI = new AlbumGUI(ablumDateModel);
        //      tabbedJframe tabbedJframe = new tabbedJframe();
        //GUIOFAlbum guiofAlbum = new GUIOFAlbum(ablumDateModel);
        //ConsignorGUI consignorGUI = new ConsignorGUI(ablumDateModel);
        //SaleGUI saleGUI = new SaleGUI(ablumDateModel);
    }

    public static boolean loadAllRecord() {
        try {
            if (rs != null) {
                rs.close();
            }
            String alldata = "SELECT * FROM " + Album;
            rs = statement.executeQuery(alldata);
            if (albumDateModel == null) {
                albumDateModel = new albumDateModel(rs);
            } else {
                albumDateModel.updateResultSet(rs);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error loading or reloading album, consignor, sale");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }

    public static boolean loadAllConsignor() {
        try {
            if (consignerResult != null) {
                consignerResult.close();
            }
            String adddat = "SELECT * FROM  " + consignor;
            consignerResult = consState.executeQuery(adddat);
            if (consignorDateModel == null) {
                consignorDateModel = new albumDateModel(consignerResult);
            } else {
                consignorDateModel.updateResultSet(consignerResult);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error loading or reloading album, consignor, sale");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }

    public static boolean loadAllSales() {
        try {
            if (salesResult != null) {
                salesResult.close();
            }
            String adddatas = "SELECT * FROM " + Sales;
            salesResult = salesState.executeQuery(adddatas);
            if (salesDateModel == null) {
                salesDateModel = new albumDateModel(salesResult);
            } else {
                salesDateModel.updateResultSet(salesResult);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error loading or reloading album, consignor, sale");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

    }

    public static boolean loadAllsaleprice() {
        try {
            if (rs != null) {
                rs.close();
            }
            String alldata = "SELECT * FROM " + amount;
            rs = statement.executeQuery(alldata);
            if (albumDateModel == null) {
                albumDateModel = new albumDateModel(rs);
            } else {
                albumDateModel.updateResultSet(rs);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error loading or reloading album, consignor, sale");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
    }


    //String alldata = "SELECT * FROM" + Album;
    //String adddat = "SELECT * FROM" + Consignor;
    //String adddatas = "SELECT * FROM" + Sale;
    //rs = statement.executeQuery(alldata);
    //rs = statement.executeQuery(adddat);
    //rs = statement.executeQuery(adddatas);

    public static boolean setup() {
        try {


            try {
                //Instantiate the driver
                Class.forName(JDBC_DRIVER);

            } catch (ClassNotFoundException cnfe) {
                System.out.println("Can't instantiate driver class; check you have drives and classpath configured correctly?");
                cnfe.printStackTrace();
                System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
            }


            try {

                conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                consState = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                salesState = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                queriey = conn.createStatement();
                queries = conn.createStatement();
                allStatements.add(statement);
                statementconn = conn.createStatement();
                statementconsignor = conn.createStatement();
                System.out.println("AlbumRecords store ");


                try {
                    Class.forName(JDBC_DRIVER);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Can't instantiate driver class; check you have drivers and classpath configured correctly?");
                    cnfe.printStackTrace();
                    System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
                }

                //Try with resources to open the connection and create a statement. Make sure your language level is 1.7+
                try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
                     Statement statement = conn.createStatement()) {
                    //You should have already created a database via terminal/command prompt OR MySQL Workbench


//create table for album, consignor and sale
                    String createTable = "CREATE TABLE IF NOT EXISTS " + Album + "( albumID int NOT NULL AUTO_INCREMENT PRIMARY KEY , Title varchar(50), Artist varchar(60),  category varchar(40), sellingPrice DOUBLE, isBasement Bool)";

                    String deletTable = "DROP TABLE " + Album;
                    String create = "CREATE TABLE IF NOT EXISTS " + consignor + " (consignorID INT NOT NULL AUTO_INCREMENT PRIMARY KEY , consignorName varchar(60), phoneNumber VARCHAR(11) NOT NULL , consignorPay DOUBLE, consignorOwe DOUBLE) ";
                    String deletetabel = "DROP TABLE " + consignor;
                    String createsaleTaple = "CREATE TABLE IF NOT EXISTS " + Sales + " (saleID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, sale_date date, amountSold Double, albumID int, FOREIGN KEY (albumID) REFERENCES " + Album + "(albumID), consignorID INT, FOREIGN KEY (consignorID) REFERENCES " + consignor + " (consignorID))";
                    String deletesql = "DROP TABLE " + Sales;
//create insert data to test the tables


                    try {


                        statement.executeUpdate(createTable);
                        System.out.println("CREATE TABLE Album ");

                        statement.executeUpdate(create);
                        System.out.println("CREAT TABLE consignor");


                        statement.executeUpdate(createsaleTaple);
                        System.out.println("CREATE TABLE Sale");

                        //createTestData();

                    } catch (SQLException sql) {
                        if (sql.getSQLState().startsWith("X0")) {
                            System.out.println("Album table appears to exist already, delete and recreate");
                            statement.executeUpdate(deletesql);
                            statement.executeUpdate(deletTable);
                            statement.executeUpdate(deletetabel);
                            //statement.executeUpdate(deletesql);
                            statement.executeUpdate(createTable);
                            //statement.executeUpdate(deletetabel);
                            statement.executeUpdate(create);
                            //statement.executeUpdate(deletesql);
                            statement.executeUpdate(createsaleTaple);
                        } else {
                            throw sql;


                        }


//                    } catch (SQLException sqle) {
//                    statement.executeUpdate(deletTable);
//                    statement.executeUpdate(deletetabel);
//                    statement.executeUpdate(deletesql);
//                    statement.executeUpdate(createsaleTaple);
//
//                    statement.executeUpdate(create);
//                    statement.executeUpdate(createTable);


                    }


                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();

                }


            } catch (Exception e) {

            }
            return true;


        }

    public static void addToAlbum(Album album) {
        String add = "INSERT INTO " + Album + " (Title, Artist,  category, sellingPrice) VALUES (?, ?, ?, ?)";
        try {


            PreparedStatement prep = conn.prepareStatement(add);
            prep.setString(1, album.getTitle());
            prep.setString(2, album.getArtist());
            prep.setString(3, album.getCategory());
            prep.setDouble(4, album.getSellingPrice());

            prep.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addtoConsignor(Consignor consignor) {
        String addconsignor = "INSERT INTO " + Consignor + " (consignorName, phoneNumber,consignorPay, consignorOwn) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement prep = conn.prepareStatement(addconsignor);
            prep.setString(1, consignor.getConsignorName());
            prep.setString(2, consignor.getPhoneNumber());
            prep.setDouble(3, consignor.getConsignorPay());
            prep.setDouble(4, consignor.getConsignorOwe());

            prep.executeUpdate();

            System.out.println("Successfully added");


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createTestData() {
        String addsql = "INSERT INTO " + Album + "(" + Title + ", " + Artist + ", " + category + "," + sellingPrice + "," + isBasement + ")" + " VALUEs ('deep do', 'jim', 'MPLS', 3.33, FALSE  )";

        String addtable = "INSERT INTO " + Consignor + " (" + consignorName + ", " + consignorPhoneNumber + ", " + consignorPay + ", " + consignorOwn + ")" + " Values ('john', '6126449988', 4.50, 3.49)";

        String addSale = "INSERT INTO " + Sale + "(" + sale_date + ", " + amount + ")" + " VALUES ('2014-08-31', 12.33)";


        try {
            statement.executeUpdate(addsql);
            statement.executeUpdate(addtable);
            statement.executeUpdate(addSale);

        } catch (SQLException se) {
            se.printStackTrace();

        }
    }

    public static void addSale(Sale sale) {
        String addSale = "INSERT INTO " + Sale + "(sale_date, amountSold , albumID, consignorID) VALUES (?, ?, ?,?)";
        Date sqlDate = new Date(sale.getSale_date().getTime());
        try {
            PreparedStatement prep = conn.prepareStatement(addSale);
            prep.setDate(1, sqlDate);
            prep.setDouble(2, sale.getAmount());
            prep.setInt(3, sale.getConsignorID());
            prep.setInt(4, sale.getAlbumID());
            prep.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static HashMap getConsignor() {
        String consignors = "SELECT consignorID , consignorName  FROM " + Consignor;
        HashMap<Integer, String> consignorHash = new HashMap<>();
        try {
            comboResults = queriey.executeQuery(consignors);
            while (comboResults.next()) {
                String name = comboResults.getString("consignorName");
                int id = comboResults.getInt("consignorID");
                consignorHash.put(id, name);
            }


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return consignorHash;
    }

    public void selectitem() {
        try {

            String update = "UPDATE  Album set isBasement = true WHERE  recieveDate < CURRENT_DATE -30";
            statement.executeUpdate(update);
            String add = "SELECT consignorName, Title FROM Consignor, Album WHERE  Consignor.albumID = Album.ID AND isBasement = TRUE ";
            statement.execute(add);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static HashMap getAlbum() {
        String albums = "SELECT albumID, Title FROM " + Album;
        HashMap<Integer, String> albumHash = new HashMap<>();
        try {
            CombosResults = queries.executeQuery(albums);
            while (CombosResults.next()) {
                String names = CombosResults.getString("Title");
                int ID = CombosResults.getInt("albumID");
                albumHash.put(ID, names);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumHash;
    }

    public static void searchAlbum(String column, String search) {
        String searchString = "Select * From " + Album + " Where " + column + " Like \"" + search + "%\"";
        try {
            rs = statement.executeQuery(searchString);
            if (albumDateModel == null) {
                albumDateModel = new albumDateModel(rs);
            } else {
                albumDateModel.updateResultSet(rs);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        try {
            if (rs != null) {
                rs.close();  //Close result set
                System.out.println("ResultSet closed");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        //Close all of the statements. Stored a reference to each statement in allStatements so we can loop over all of them and close them all.
        for (Statement s : allStatements) {

            if (s != null) {
                try {
                    s.close();
                    System.out.println("Statement closed");
                } catch (SQLException se) {
                    System.out.println("Error closing statement");
                    se.printStackTrace();
                }
            }
        }

        try {
            if (conn != null) {
                conn.close();  //Close connection to database
                System.out.println("Database connection closed");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}



*/

























        /*try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; check you have drivers and classpath configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
        }

        //Try with resources to open the connection and create a statement. Make sure your language level is 1.7+
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
             Statement statement = conn.createStatement()) {
            //You should have already created a database via terminal/command prompt OR MySQL Workbench

            //Create a table in the database, if it does not exist already
            String createTableSQL = "CREATE TABLE IF NOT EXISTS dogs (Name varchar(30), Age int)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Created Dogs table");

            //Add some data
            String addDataSQL = "INSERT INTO dogs VALUES ('Poppy', 3)";
            statement.executeUpdate(addDataSQL);

            addDataSQL = "INSERT INTO dogs VALUES ('Zelda', 5)";
            statement.executeUpdate(addDataSQL);
            System.out.println("Added two rows of data");

            addDataSQL = "INSERT INTO dogs VALUES ('Lassie', 12)";
            statement.executeUpdate(addDataSQL);

            addDataSQL = "INSERT INTO dogs VALUES ('Fred', 7)";
            statement.executeUpdate(addDataSQL);

            String fetchAllDataSQL = "SELECT * FROM Dogs";
            ResultSet rs = statement.executeQuery(fetchAllDataSQL);

            while (rs.next()) {
                String dogName = rs.getString("Name");
                int dogAge = rs.getInt("Age");
                System.out.println("Dog name = " + dogName +  " dog age =" + dogAge);
            }
            rs.close();


            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }

        System.out.println("End of program");
    }
}


*/









