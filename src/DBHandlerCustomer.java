
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mustafa
 */
public class DBHandlerCustomer {
    public static final String USERNAME = "mustafa"; // database kullanıcı adı
    public static final String PASSWORD = "12345"; // database şifre
    public static final String URL = "jdbc:sqlserver://127.0.0.1; databaseName=DBCompany"; //Server bilgisi
    public static final String JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //Veritabanın hangi tür olduğu bilgisi
    
    private Connection connection = null; // database bağlantısını yapan referans
    private Statement statement = null;//sql sorgularını çalıştırmayı sağlar.
    private PreparedStatement preparedStatement = null; //sql sorgularına parametre gönderilmesini ve çalıştırılmasını sağlar
    public DBHandlerCustomer(){
        try {
            
            Class.forName(JDBC);//JDBC sınıfının var olup olmadığını kontrolü
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //Database bağlantısının sağlanması
            System.out.println("Veritabanı bağlantısı başarılı.");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC sürücüsü bulunamadı.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Veritabanına bağlanırken hata oluştu!");
            ex.printStackTrace();
        }
    }
    
    //METHODS
    //Database içerisinde bulunan tbl_Customer tablosunda bulunan verileri çeken metod
    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customerList = new ArrayList<Customer>(); //ÇEkilen verilerin aktarılacağı Customer türünde ArrayList objesinin oluşturulması
        try {
            statement = connection.createStatement(); //sorguyu çalıştıracak olan Statement objesinin oluşturulması
            
            String sql = "select * from tbl_Customer"; //Verilerin çekilmesini sağlayan sql sorgusu
            ResultSet rs = statement.executeQuery(sql); //Sorgunun çalıştırıp çekilen verilerin ResultSet referansına aktarılması
            
            //rs referansının gösterdiği verilerin next() metodu ile satır satır okunmasını
            //sağlayan ve değişkenlere aktaran while döngüsü
            
            while(rs.next()){
                int customerId = rs.getInt("Customer_Id");
                String customerName = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                customerList.add(new Customer(customerId, customerName, address, phone)); //customers Arraylistine musteri objelerinin oluşturulup eklenmesi
                
            }
            return customerList;//doldurulan customerList ArrayListinin döndürülmesi
            
        } catch (SQLException ex) {//Verilerin çekilmesi sırasında hata oluşması durumunda çalışan catch bloğu
            System.out.println("SQL Error! => getCustomers()");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    //Müşterilerin güncellenmesini sağlayan metod
    public boolean updateCustomer(int id, String customerName, String address, String phone){
        
        //tbl_Customer tablosu üzerinde güncelleme işleminin yapan sql sorgusu
        String sql = "update tbl_Customer set Customer_Name = ?, Address = ?, Phone = ? where Customer_Id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql); //sql sorgusunu çalıştıran objenin oluşturulması
            
            //parametre olarak gelen değerlerin sorguya gönderilmesi
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, id);
            
            
            preparedStatement.executeUpdate();//Sorgunun çalışması ve güncelleme işleminin yapılması
            return true;
            
        } catch (SQLException ex) {//sql sorgusunun düzgün çalışmaması durumunda çalışan catch bloğu
            System.out.println("SQL Error! => updateCustomer()");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    //tbl_Customer tablosuna müşteri eklenmesini sağlayan metod
    public boolean addCustomer(String customerName, String address, String phone){
        
        //tabloya veri ekleme işlemi yapan sql sorgusu
        String sorgu = "INSERT INTO tbl_Customer (Customer_Name, Address, Phone) VALUES(?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);//sql sorgusunu çalıştıran objenin oluşturulması
            
            //parametre olarak gelen değerlerin sorguya gönderilmesi
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            
            preparedStatement.executeUpdate();//Sorgunun çalışması ve güncelleme işleminin yapılması
            return true;
            
        } catch (SQLException ex) {//sql sorgusunun düzgün çalışmaması durumunda çalışan catch bloğu
            System.out.println("SQL Error! => addCustomer()");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    //jTable üzerinden seçilen müşterinin tbl_Customer tablosu üzerinden silinmesini işlemini yapan metod
    public boolean deleteCustomer(int id){
        
        //Silme sırasında hata oluşmaması için müşteriye satılmış projeler var o projelerin tbl_Sales_Project tablosundan silinmesi
        // ve daha sonra tbl_Customer tablosundan gönderilen id değerine göre müşterinin silinmesi
        String sqlTbl_Project_Sales = "delete from tbl_Project_Sales where Customer_Id = ?";
        String sqlTbl_Customer = "DELETE from tbl_Customer where Customer_Id = ?";
        try {
            
            
            preparedStatement = connection.prepareStatement(sqlTbl_Project_Sales);//ilk sorgunun çalışması için oluşturulan preparedStatement objesi
            preparedStatement.setInt(1, id);//metoda gönderilen parametrenin sorguya gönderilmesi
            
            
            preparedStatement = connection.prepareStatement(sqlTbl_Customer);//ikinci sorgunun çalışması için oluşturulan preparedStatement objesi
            preparedStatement.setInt(1, id);//metoda gönderilen parametrenin sorguya gönderilmesi
            
            preparedStatement.executeUpdate();//sorguların sırasıyla çalıştırılması
            return true;
            
        } catch (SQLException ex) {//sql sorgusunun düzgün çalışmaması durumunda çalışan catch bloğu
            System.out.println("SQL Error => deleteCustomer()");
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
