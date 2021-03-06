
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserProfile extends javax.swing.JFrame {


    public UserProfile(String [] userInfo) { //saves values of array into variables and converts US measurement to metric
       
        username = userInfo[0];
        age = Integer.parseInt(userInfo[1]);
        if (userInfo[4].equals("pounds"))
            weight = (Integer.parseInt(userInfo[3]))/KILOGRAM;
        else 
            weight = Integer.parseInt(userInfo[3]);
        if (userInfo[5].contains(","))
        	height = Integer.parseInt(userInfo[5].substring(0, 1)) * 30.48 + Integer.parseInt(userInfo[5].substring(2, userInfo[5].length())) * 2.54;
        else 
            height = Integer.parseInt(userInfo[5]);
        HealthCalculator(userInfo[2], userInfo[6]);
        initComponents();
    }
    
    private void HealthCalculator(String gender, String exerciseLevel)
    {  
   
         if (gender.equals("male"))
         {
            BMR = (int) ( (10 * weight) + (6.25 * height) - (5 * age) + 5); //Harris-Bennedict Formula for BMR
            idealWeight = 2.20462 * (50 + 2.3 * ( (height * 0.393701) - 60) ); //HAMWI formula
         }
         
         else 
         {
            BMR = (int) ( (10 * weight) + (6.25 * height) - (5 * age) - 161); //Harris-Bennedict Formula for BMR
            idealWeight = 2.20462 * (45.5 + 2.3 * ( (height * 0.393701) - 60) ); //HAMWI formula
         }  
         	calorieLevel = (int) (BMR * (1.2 + (0.175 * Integer.parseInt(exerciseLevel)))); //Harris - Bennedict Formula for calorie levels
            BMI = (int) ( weight/(height * height) * 10000 ); //Uses CDC formula
    }

                          
    private void initComponents() {

        greetingTitle = new javax.swing.JLabel();
        calorieTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        calorieList = new javax.swing.JList<>();
        BMRTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        foodDiaryText = new javax.swing.JTextArea();
        foodDiaryTitle = new javax.swing.JLabel();
        BMITitle = new javax.swing.JLabel();
        idealWeightTitle = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        greetingTitle.setFont(new java.awt.Font("L M Roman10", 0, 24)); 
        greetingTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        greetingTitle.setText("Welcome");
        greetingTitle.setText("Welcome " + username );

        calorieTitle.setFont(new java.awt.Font("L M Roman10", 0, 24));
        calorieTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calorieTitle.setText("Daily Calories");

        calorieList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        calorieList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"You need " + String.valueOf(calorieLevel) + " Calories/day to maintain your weight",
                "You need " + String.valueOf(calorieLevel - 500) + " Calories/day to lose 1 lb per week",
                "You need " + String.valueOf(calorieLevel - 1000) + " Calories/day to lose 2 lb per week",
                "You need " + String.valueOf(calorieLevel + 500) + " Calories/day to gain 1 lb per week",
                "You need " + String.valueOf(calorieLevel + 1000) + " Calories/day to gain 2 lb per week",
            };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(calorieList);

        BMRTitle.setFont(new java.awt.Font("LM Roman 10", 0, 18)); // NOI18N
        BMRTitle.setText("Basal Metabolic Rate: ####");
        BMRTitle.setText("Basal Metabolic Rate: " + BMR);

        foodDiaryText.setColumns(20);
        foodDiaryText.setRows(5);
        jScrollPane2.setViewportView(foodDiaryText);
        File file = new File(System.getProperty("user.dir") + "/foodDiary.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String textLine = reader.readLine();
            while (textLine != null)
            {
                if (textLine.equals(username))
                {
                    textLine = reader.readLine();
                    while (!textLine.contains("--") && textLine != null)
                    {
                        foodDiaryText.append(textLine);
                        foodDiaryText.append(System.getProperty("line.separator"));
                        textLine = reader.readLine();
                    }
                    if (textLine != null)
                    {
                        foodDiaryText.append(textLine);
                        foodDiaryText.append(System.getProperty("line.separator"));
                    }
                }
                textLine = reader.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        foodDiaryText.append("[" + getDateTime() + "]" + System.getProperty("line.separator"));

        foodDiaryTitle.setFont(new java.awt.Font("L M Roman10", 0, 24));
        foodDiaryTitle.setText("Food Diary");

        BMITitle.setFont(new java.awt.Font("LM Roman 10", 0, 18)); 
        BMITitle.setText("Your Body Mass Index: ## ");
        BMITitle.setText("Your Body Mass Index: " + BMI);

        idealWeightTitle.setFont(new java.awt.Font("LM Roman 10", 0, 18)); 
        idealWeightTitle.setText("Ideal Body Weight: ###.##");
        idealWeightTitle.setText("Ideal Body Weight: " + new DecimalFormat("###.##").format(idealWeight));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(calorieTitle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BMRTitle)
                    .addComponent(idealWeightTitle)
                    .addComponent(BMITitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(foodDiaryTitle)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(greetingTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(greetingTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calorieTitle)
                    .addComponent(foodDiaryTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BMRTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idealWeightTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BMITitle))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        pack();
        this.setResizable(false);
    }                        

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        File file = new File(System.getProperty("user.dir") + "/foodDiary.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(username + System.getProperty("line.separator"));
            String foodDiary = foodDiaryText.getText();
            
            if (foodDiary.contains("------------"))   
            {
                int position = 0;
                int index = foodDiary.indexOf("-----------------");
                while (index >= 0) 
                    { 
                    position = index;
                    index = foodDiary.indexOf("-----------------", index + 1);
                    }
                foodDiary = foodDiary.substring(position + 18);
            }            
            writer.append(foodDiary);
            writer.append(System.getProperty("line.separator") + "-----------------" + System.getProperty("line.separator"));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                          

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        GUI firstPage = new GUI();
        firstPage.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

       
    }
    
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss aa");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    private static int age;
    private static int exerciseLevel;
    private static double weight;
    private static double height;
    private static String username;
    private static final double KILOGRAM = 2.2046226218;
    private static int BMR;
    private static int calorieLevel;
    private static int BMI;
    private static double idealWeight;
    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel BMITitle;
    private javax.swing.JLabel BMRTitle;
    private javax.swing.JButton backButton;
    private javax.swing.JList<String> calorieList;
    private javax.swing.JLabel calorieTitle;
    private javax.swing.JTextArea foodDiaryText;
    private javax.swing.JLabel foodDiaryTitle;
    private javax.swing.JLabel greetingTitle;
    private javax.swing.JLabel idealWeightTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveButton;
    // End of variables declaration                   
}
