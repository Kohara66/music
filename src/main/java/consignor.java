/**
 * Created by Happy on 5/3/2017.
 */
public class consignor {

    String consignorName;
    String phoneNumber;
    Double consignorPay;
    Double consignorOwe;
    public consignor(String name, String phoneNumber, double pay, double owe) {
        this.consignorName = name;
        this.phoneNumber = phoneNumber;
        this.consignorPay = pay;
        this.consignorOwe = owe;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public Double getConsignorPay() {

        return consignorPay;
    }

    public Double getConsignorOwe() {

        return consignorOwe;
    }

    public String getConsignorName() {

        return consignorName;
    }

    public void setConsignorName(String consignorName) {

        this.consignorName = consignorName;
    }


}

