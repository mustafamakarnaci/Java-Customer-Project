/**
 *
 * @author mustafa
 */
public class Customer {
    private int musteriId;
    private String MusteriName;
    private String address;
    private String phone;

    public Customer( int id, String MusteriName, String address, String phone) {
        this.musteriId = id;
        this.MusteriName = MusteriName;
        this.address = address;
        this.phone = phone;
    }

    public int getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    public String getMusteriName() {
        return MusteriName;
    }

    public void setMusteriName(String MusteriName) {
        this.MusteriName = MusteriName;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString(){
        return MusteriName + "-" + phone + "-" + address;
    }
    
}
