
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
    }
                         
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        newUserButton = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        signatureLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("L M Roman10", 1, 48)); 
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Healthy Living");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        newUserButton.setText("New User?");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        usernameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameText.setText("Enter Username");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signatureLabel.setFont(new java.awt.Font("Caladea", 0, 15)); 
        signatureLabel.setText("Created by Edward Seley");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 77, Short.MAX_VALUE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(signatureLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(signatureLabel))
        );

        pack();
    }                     

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.setVisible(false);
        NewUser userprofile = new NewUser();
        userprofile.setVisible(true);
    }                                                                                       

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        File file = new File(System.getProperty("user.dir") + "/UserInfo.txt");
        boolean correctUsername = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((reader.readLine() != null))
            {
                String textLine = reader.readLine();
                if (textLine.equals(usernameText.getText())) //finds username in UserInfo and reads the information, then stores in array
                {	
                    userInfo[0] = textLine;
                    correctUsername = true;
                    for (int x = 1; x < 7; x++)
                    {
                        textLine = reader.readLine();
                        userInfo[x] = textLine;
                    }
                
                }
                
            }
            
            reader.close();
            if (correctUsername)
            {
            	this.setVisible(false);
            	UserProfile userPro = new UserProfile(userInfo);
            	userPro.setVisible(true);
            } 
            
            else 
            {
                
             WarningFrame warning = new WarningFrame();
             this.setVisible(false);
             warning.setVisible(true);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private static String[] userInfo = new String[7];                  
    private javax.swing.JButton loginButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JLabel signatureLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameText;
    
}
