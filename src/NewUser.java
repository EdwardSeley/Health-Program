
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewUser extends javax.swing.JFrame {

    public NewUser() {
        initComponents();
    }
                     
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        femaleRadioButton = new javax.swing.JRadioButton();
        maleRadioButton = new javax.swing.JRadioButton();
        genderLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JLabel();
        weightText = new javax.swing.JTextField();
        poundsRadioButton = new javax.swing.JRadioButton();
        kilosRadioButton = new javax.swing.JRadioButton();
        inchesText = new javax.swing.JTextField();
        heightLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        feetText = new javax.swing.JTextField();
        feetLabel = new javax.swing.JLabel();
        inchesLabel = new javax.swing.JLabel();
        orLabel = new javax.swing.JLabel();
        centimetersLabel = new javax.swing.JLabel();
        centimetersText = new javax.swing.JTextField();
        exerciseSpinner = new javax.swing.JSpinner();
        UsernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("LM Roman 10", 1, 24)); 
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Complete Your Profile");

        ageLabel.setFont(new java.awt.Font("Cantarell", 0, 18));
        ageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageLabel.setText("Age:");

        femaleRadioButton.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });
        femaleRadioButton.setSelected(true);

        maleRadioButton.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Cantarell", 0, 18));
        genderLabel.setText("Gender:");

        weightLabel.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        weightLabel.setText("Weight:");

        poundsRadioButton.setFont(new java.awt.Font("Cantarell", 0, 18));
        poundsRadioButton.setText("Pounds");
        poundsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poundsRadioButtonActionPerformed(evt);
            }
        });
        poundsRadioButton.setSelected(true);

        kilosRadioButton.setFont(new java.awt.Font("Cantarell", 0, 18));
        kilosRadioButton.setText("Kilos");
        kilosRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilosRadioButtonActionPerformed(evt);
            }
        });

        inchesText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inchesTextKeyPressed(evt);
            }
        });

        heightLabel.setFont(new java.awt.Font("Cantarell", 0, 18));
        heightLabel.setText("Height:");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        feetText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                feetTextKeyPressed(evt);
            }
        });

        feetLabel.setText("Feet:");

        inchesLabel.setText("Inches:");

        orLabel.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        orLabel.setText("Or");

        centimetersLabel.setText("Centimeters:");

        centimetersText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                centimetersTextKeyPressed(evt);
            }
        });

        exerciseSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"Basal Metabolic Rate", "Little/No Exercise", "Three Times a Week", "Four Times a Week ", "Five Times a Week ", "Daily ", "Daily (Intense)"}));
        exerciseSpinner.setModel(new javax.swing.SpinnerListModel(exerciseLevels));

        UsernameLabel.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        UsernameLabel.setText("Username:");

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        jLabel1.setText("Exercise:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ageLabel)
                                    .addComponent(UsernameLabel)
                                    .addComponent(genderLabel)
                                    .addComponent(heightLabel)
                                    .addComponent(feetLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(orLabel)
                                        .addComponent(weightLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(feetText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inchesLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inchesText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(femaleRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(weightText))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(maleRadioButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(poundsRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(kilosRadioButton))))
                                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(centimetersLabel)
                                .addGap(18, 18, 18)
                                .addComponent(centimetersText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exerciseSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLabel)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(femaleRadioButton)
                    .addComponent(maleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel)
                    .addComponent(weightText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poundsRadioButton)
                    .addComponent(kilosRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightLabel)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feetLabel)
                    .addComponent(inchesLabel)
                    .addComponent(inchesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(orLabel)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(centimetersLabel)
                    .addComponent(centimetersText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exerciseSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                        

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        maleRadioButton.setSelected(false);
    }                                                 

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        femaleRadioButton.setSelected(false);
    }                                               

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {  //pulls data from input fields and saves them in an array                                           

    	String[] userInformation = new String[10];

        userInformation[0] = usernameText.getText();
    
        boolean usernameExists = GUI.checkUsername(userInformation[0]);
        if (usernameExists)
        {
        	WarningDialogBox warning = new WarningDialogBox();
        	this.setVisible(false);
        	warning.setVisible(true);
        }
        
        userInformation[1] = ageText.getText();
        if (femaleRadioButton.isSelected())
            userInformation[2] = "female";
        else 
            userInformation[2] = "male";
        userInformation[3] = weightText.getText();
        if (poundsRadioButton.isSelected())
            userInformation[4] = "pounds";
        else 
            userInformation[4] = "kilos";
        if (centimetersText.getText().isEmpty()){
            userInformation[5] = feetText.getText().concat(",").concat(inchesText.getText());
        }
        else 
            userInformation[5] = centimetersText.getText();
        userInformation[6] = String.valueOf(Arrays.asList(exerciseLevels).indexOf(exerciseSpinner.getValue()));
        
        try {
            saveInformation(userInformation);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!usernameExists)
        {
        this.setVisible(false);
        UserProfile userPro = new UserProfile(userInformation);
        userPro.setVisible(true);
        }
    }                                            

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GUI firstPage = new GUI();
        this.setVisible(false);
        firstPage.setVisible(true);
    }                                          

    private void poundsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        kilosRadioButton.setSelected(false);
    }                                                 

    private void kilosRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        poundsRadioButton.setSelected(false);
    }                                                

    private void centimetersTextKeyPressed(java.awt.event.KeyEvent evt) {                                           
        feetText.setText(null);
        inchesText.setText(null);
    }                                          

    private void feetTextKeyPressed(java.awt.event.KeyEvent evt) {                                    
        centimetersText.setText(null);
    }                                   

    private void inchesTextKeyPressed(java.awt.event.KeyEvent evt) {                                      
        centimetersText.setText(null);
    }                                     

    private void saveInformation(String[] userInformation) throws FileNotFoundException, IOException{ //Writes the information from the array into a text file
    File file = new File(System.getProperty("user.dir") + "/UserInfo.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
    writer.append("---------------------" + System.getProperty("line.separator"));
    for (int x = 0; x < 7; x++)
        writer.append(userInformation[x] + System.getProperty("line.separator"));
    writer.close();
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    private final static String[] exerciseLevels = {"Basal Metabolic Rate", "Little/No Exercise", "Three Times a Week", "Four Times a Week ", "Five Times a Week ", "Daily ", "Daily (Intense)"};
                     
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageText;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel centimetersLabel;
    private javax.swing.JTextField centimetersText;
    private javax.swing.JSpinner exerciseSpinner;
    private javax.swing.JLabel feetLabel;
    private javax.swing.JTextField feetText;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel inchesLabel;
    private javax.swing.JTextField inchesText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton kilosRadioButton;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel orLabel;
    private javax.swing.JRadioButton poundsRadioButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JTextField weightText;
                 
}
