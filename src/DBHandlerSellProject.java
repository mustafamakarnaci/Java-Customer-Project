
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author mustafa
 */
public class DBHandlerSellProject {
    public static final String USERNAME = "mustafa"; // database kullanıcı adı
    public static final String PASSWORD = "12345"; //database şifre
    public static final String URL = "jdbc:sqlserver://127.0.0.1; databaseName=DBCompany"; //Server bilgisi
    public static final String JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //Veritabanın hangi tür olduğu bilgisi
    
    private Connection connection = null;// database bağlantısını yapan referans
    private Statement statement = null;//sql sorgularını çalıştırmayı sağlar.
    private PreparedStatement preparedStatement = null; //sql sorgularına parametre gönderilmesini ve çalıştırılmasını sağlar
    public DBHandlerSellProject(){
        try {
            
            Class.forName(JDBC);//JDBC sınıfının var olup olmadığını kontrolü
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);//Database bağlantısının sağlanması
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
    
    //tbl_Customer tablosundan müşterilerin çekilemsi
    public Vector getCompanies(){
        Vector model = new Vector(); //çekilecek müşterlerin aktarılması için Vector türünde bir objenin oluşturulması
        try {
            statement = connection.createStatement(); //sql sorgusunu çalıştırması Statement objesinin oluşturulması
            
            String sql = "select * from tbl_Customer"; //tablodan verileri çeken sql sorgusu
            ResultSet rs = statement.executeQuery(sql); //sql sorgusunun çalıştırılması
            
            //tablodan çekilen verilerin ResultSet interface'inden oluşturulan rs referansına aktarılması
            //rs referansının tuttuğu verilerin satır satır okunup değişkenlere aktırılması
            while(rs.next()){
                int customerId = rs.getInt("Customer_Id");
                String customerName = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                model.addElement(new Customer(customerId, customerName, address, phone)); //değişkenler yardımıyla oluşturulan customer objelerinin model listesine aktarılması
                
            }
            return model;//model objesinin döndürülmesi
            
        } catch (SQLException ex) {//Verilerin çekilmesi sırasında hata oluşması durumunda çalışan catch bloğu
            System.out.println("SQL Error! => getCompanies()");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    //tbl_Project tablosundan verileri çeken metod
    public Vector getProject(){
        Vector model = new Vector();//çekilecek müşterlerin aktarılması için Vector türünde bir objenin oluşturulması
        try {
            statement = connection.createStatement();//sql sorgusunu çalıştırması Statement objesinin oluşturulması
            
            String sql = "select * from tbl_Project";//tablodan verileri çeken sql sorgusu
            ResultSet rs = statement.executeQuery(sql);//sql sorgusunun çalıştırılması
            
            //tablodan çekilen verilerin ResultSet interface'inden oluşturulan rs referansına aktarılması
            //rs referansının tuttuğu verilerin satır satır okunup değişkenlere aktırılması
            while(rs.next()){
                int projectId = rs.getInt("Project_Id");
                String projectName = rs.getString("Project_Name");
                model.addElement(new Project(projectId, projectName)); //değişkenler yardımıyla oluşturulan Project objelerinin model listesine aktarılması
            }
            return model; //verileri model objesinin döndürülmesi
            
        } catch (SQLException ex) {//Verilerin çekilmesi sırasında hata oluşması durumunda çalışan catch bloğu
            System.out.println("SQL Error => getProjects()");
            return null;
        }
        
    }
    
    //tbl_Project_Sales tablosuna veri ekleme işlemini yapan metod
    public boolean SellProject(int customerId, int projectId, String sellDate, int technicalSupportTime , String timeperiod, float price){
        
        //tabloya ekleme işlemini yapan sql sorgusu
        String sorgu = "INSERT INTO tbl_Project_Sales (Customer_Id, Project_Id, Sell_Date, TechnicalSupportTime, TimePeriod, Price) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sorgu);//sorguyu çalıştıracak preparedStatement objesinin oluşturulaması
            
            //gelen parametre olarak gelen değerlerin sql sorgusuna gönderilmesi
            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, projectId);
            preparedStatement.setString(3, sellDate);
            preparedStatement.setInt(4, technicalSupportTime);
            preparedStatement.setString(5, timeperiod);
            preparedStatement.setFloat(6, price);
            
            preparedStatement.executeUpdate();//sql sorgusunun çalıştırılması ve ekleme işleminin gerçekleştirilmesi
            return true;
            
        } catch (SQLException ex) {//sql sorgusu çalıştırılırken hata oluşmasın durumunda çalışacak catch bloğu
            System.out.println("SQL Error! => sellProject()");
            ex.printStackTrace();
            return false;
        }
        
    }
}
