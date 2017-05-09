/**
 * Created by Happy on 5/3/2017.
 */
public class consignor {

    String consignorName;
    String phoneNumber;
    Double consignorPay;
    Double ownerPay;
    public consignor(String name, String phoneNumber, double pay, double owner) {
        this.consignorName = name;
        this.phoneNumber = phoneNumber;
        this.consignorPay = pay;
        this.ownerPay = owner;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public Double getConsignorPay() {

        return consignorPay;
    }

    public Double getOwnerPay() {

        return ownerPay;
    }

    public String getConsignorName() {

        return consignorName;
    }

    public void setConsignorName(String consignorName) {

        this.consignorName = consignorName;
    }


}

