
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mustafa
 */
public class CustomerInfo extends javax.swing.JFrame {
    
    public static int updateCustomerId = -1;
    public static String updateCustomerName = "";
    public static String updateAddress = "";
    public static String updatePhone = "";
    
    
    DefaultTableModel model;
    
    //veritabanı işlemlerini yapılabilmesi için dbhCustomer objesinin oluşturulması
    DBHandlerCustomer dbhCustomer = new DBHandlerCustomer();
            
    /**
     * Creates new form CustomerInfo
     */
    public CustomerInfo() {
        initComponents();
    }

    //Ekranda bulunan jTable üzerinde müşterlerin gösterilmesini sağlayan metod
    public void showCustomers(){
        model.setRowCount(0);//tabloyu temizler
        ArrayList<Customer> customers; //Customer türündde ArrayList referansı
        
        customers = dbhCustomer.getCustomers(); //customers ArrayList'ine getCustomers() metodundan dönen müşterilerin aktarılması
        if(!customers.isEmpty()){
            
            //Customers içindeki müşterilerin Object[] türünden bir Arraya satır satır aktarılması ve ardından
            //DefaulTableModel türündeki model objesine customerSObject Arrayinde bulunan verilerin aktarılması
            for(Customer customer : customers){
                Object[] customersObjects = {customer.getMusteriId(),customer.getMusteriName(), customer.getAddress(), customer.getPhone()};
                model.addRow(customersObjects);
            }
        }
        
    }
    
    //form üzerinde bulunan swing elemanlarının temizlenmesi
    public static void clearItems(){
        
        updateCustomerId = -1;
        updateCustomerName = "";
        updateAddress = "";
        updatePhone = "";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnAddCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnSellProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Müşteri İşlemleri");
        setSize(new java.awt.Dimension(480, 380));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(168, 168, 255));
        kGradientPanel1.setkGradientFocus(0);
        kGradientPanel1.setkStartColor(new java.awt.Color(226, 226, 255));

        btnAddCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddCustomer.setText("Müşteri Ekle");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateCustomer.setText("Müşteri Güncelle");
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteCustomer.setText("Müşteri Sil");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnSellProject.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSellProject.setText("Proje Sat");
        btnSellProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellProjectActionPerformed(evt);
            }
        });

        tblCustomers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "MÜŞTERİ", "ADRES", "PHONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.setGridColor(new java.awt.Color(255, 255, 255));
        tblCustomers.setRowHeight(20);
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);
        if (tblCustomers.getColumnModel().getColumnCount() > 0) {
            tblCustomers.getColumnModel().getColumn(0).setResizable(false);
            tblCustomers.getColumnModel().getColumn(1).setResizable(false);
            tblCustomers.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSellProject, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCustomer)
                    .addComponent(btnUpdateCustomer)
                    .addComponent(btnDeleteCustomer)
                    .addComponent(btnSellProject))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Proje Satış Butonu
    private void btnSellProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellProjectActionPerformed
        // TODO add your handling code here:
        
        //Müşteri işlemleri ekranının kapatılıp
        //Proje satış ekranın açılması
        this.setVisible(false);  
        SellProject sellProject = new SellProject();
        sellProject.setVisible(true);
    }//GEN-LAST:event_btnSellProjectActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
            // TODO add your handling code here:
            
            //jTable üzerinde seçilen satırdaki müştelerilerin değerlerinin
            //güncelleme işlemi için static değişkenlere aktarılması
            int selectedRow = tblCustomers.getSelectedRow();
            updateCustomerId = Integer.valueOf(model.getValueAt(selectedRow, 0).toString());
            updateCustomerName = model.getValueAt(selectedRow, 1).toString();
            updateAddress = model.getValueAt(selectedRow, 2).toString();
            updatePhone = model.getValueAt(selectedRow, 3).toString();
    }//GEN-LAST:event_tblCustomersMouseClicked

    //Müşteri Güncelle Butonu
    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
        
        //jTable üzerinde güncelleme işleminin yapılabilmesi için
        //müşterinin seçilip seçilmediğinin kontrolü yapılır
        int selectedRow = tblCustomers.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Lütfen müşteri seçiniz!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            
            //Müşteri işlemleri ekranı kapatır ve Müşter Güncelle ekranını açar
            this.setVisible(false);
            UpdateCustomer updateCustomerScreen = new UpdateCustomer();
            updateCustomerScreen.setVisible(true);
        }
        showCustomers();
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    //Müşteri Ekle Butonu
    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        
        //Müşteri İşlemleri ekranını kapatır ve Müşteri Ekle ekranını açar
        AddCustomer addCustomerScreen = new AddCustomer();
        this.setVisible(false);
        addCustomerScreen.setVisible(true);
        
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    //Müşteri Sil Butonu
    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        // TODO add your handling code here:
        
        //jTable üzerinde seçilen satırın index değerinin getirir
        int selectedRow = tblCustomers.getSelectedRow();
        
        if(selectedRow == -1){//jTable üzerinde herhangi bir satırın seçilip seçilmediğinin kontrolü
            JOptionPane.showMessageDialog(this, "Lütfen müşteri seçiniz!", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }else{//eğer herhangi bir satır seçilmiş ise bu koşul durumu çalıştırılır
            int dialogButton;
            
           //müşteriyi silmek istiyor musunuz? sorusunun sorulmasını sağlayan ve cevapları Yes/No butonları üzerinden alan dialog
            dialogButton = JOptionPane.showConfirmDialog(this, "Müşteriyi silmek istediğinizden emin misiniz?", "Onay Gerekiyor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(dialogButton == JOptionPane.YES_OPTION){//Çıkan dialogta Yes butonuna basılmışsa
                if(dbhCustomer.deleteCustomer(updateCustomerId)){//Seçilen satırdaki müşterinin id değerini static değişken üzerinden deleteCustomer() metoduna parametre olarak gönderilmesi
                    showCustomers(); //işlem tamamlandıktan sonra 
                    clearItems(); //static değişkenlerin null olarak değiştirilmesi
                    JOptionPane.showMessageDialog(this, "Silme işlemi başarılı", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showConfirmDialog(this, "Silme işlemi başarısız!", "Hata!", JOptionPane.ERROR, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    //Müşteri işlemleri ekranı açıldığında jTabla üzerinde müşterilerin listelenmesi
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        model = (DefaultTableModel) tblCustomers.getModel();
        tblCustomers.removeColumn(tblCustomers.getColumnModel().getColumn(0));
        showCustomers();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnSellProject;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tblCustomers;
    // End of variables declaration//GEN-END:variables
}
