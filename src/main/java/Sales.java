import java.util.Date;

/**
 * Created by Happy on 5/3/2017.
 */
public class Sales {

    Date sale_date;
    double amount;
    int albumID;
    int consignorID;

    public Sales(Date sale_date, Double amount, int albumID, int consignorID){
        this.amount = amount;
        this.sale_date = sale_date;
        this.albumID = albumID;
        this.consignorID = consignorID;

    }

    public int getAlbumID() {
        return albumID;
    }

    public int getConsignorID() {
        return consignorID;
    }

    public double getAmount()
    {
        return amount;
    }

    public Date getSale_date() {
        return sale_date;
    }



}

