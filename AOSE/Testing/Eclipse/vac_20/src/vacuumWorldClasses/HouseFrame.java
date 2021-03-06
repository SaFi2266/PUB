/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuumWorldClasses;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author user
 */
public class HouseFrame extends javax.swing.JFrame {

    /**
     * Creates new form HouseFrame
     */
    public HouseFrame() {
        initComponents();
        //dirt1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        room1 = new javax.swing.JPanel();
        vacuumCleaner1 = new javax.swing.JLabel();
        dirt1 = new javax.swing.JLabel();
        room2 = new javax.swing.JPanel();
        dirt2 = new javax.swing.JLabel();
        vacuumCleaner2 = new javax.swing.JLabel();
        room4 = new javax.swing.JPanel();
        dirt4 = new javax.swing.JLabel();
        vacuumCleaner4 = new javax.swing.JLabel();
        displayLabel = new javax.swing.JLabel();
        room3 = new javax.swing.JPanel();
        dirt3 = new javax.swing.JLabel();
        vacuumCleaner3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("House");
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setName("house"); // NOI18N
        setPreferredSize(new java.awt.Dimension(579, 650));

        room1.setBackground(new java.awt.Color(255, 102, 102));
        room1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        room1.setName("Room1"); // NOI18N
        room1.setPreferredSize(new java.awt.Dimension(250, 200));

        vacuumCleaner1.setBackground(new java.awt.Color(0, 0, 0));
        vacuumCleaner1.setForeground(new java.awt.Color(255, 255, 255));
        vacuumCleaner1.setText("Vacuum Cleaner");
        vacuumCleaner1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        vacuumCleaner1.setName("vacuumCleaner1"); // NOI18N
        vacuumCleaner1.setOpaque(true);

        dirt1.setBackground(new java.awt.Color(204, 204, 204));
        dirt1.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        dirt1.setText(".");
        dirt1.setName("dirt1"); // NOI18N

        javax.swing.GroupLayout room1Layout = new javax.swing.GroupLayout(room1);
        room1.setLayout(room1Layout);
        room1Layout.setHorizontalGroup(
            room1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(room1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room1Layout.createSequentialGroup()
                        .addComponent(vacuumCleaner1)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room1Layout.createSequentialGroup()
                        .addComponent(dirt1)
                        .addGap(112, 112, 112))))
        );
        room1Layout.setVerticalGroup(
            room1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(vacuumCleaner1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(dirt1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        room2.setBackground(new java.awt.Color(153, 255, 102));
        room2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        room2.setName("room2"); // NOI18N
        room2.setPreferredSize(new java.awt.Dimension(250, 200));

        dirt2.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        dirt2.setText(".");
        dirt2.setName("dirt2"); // NOI18N

        vacuumCleaner2.setBackground(new java.awt.Color(0, 0, 0));
        vacuumCleaner2.setForeground(new java.awt.Color(255, 255, 255));
        vacuumCleaner2.setText("Vacuum Cleaner");
        vacuumCleaner2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        vacuumCleaner2.setName("vacuumCleaner2"); // NOI18N
        vacuumCleaner2.setOpaque(true);

        javax.swing.GroupLayout room2Layout = new javax.swing.GroupLayout(room2);
        room2.setLayout(room2Layout);
        room2Layout.setHorizontalGroup(
            room2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(vacuumCleaner2)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dirt2)
                .addGap(113, 113, 113))
        );
        room2Layout.setVerticalGroup(
            room2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(vacuumCleaner2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(dirt2)
                .addGap(41, 41, 41))
        );

        room4.setBackground(new java.awt.Color(51, 204, 255));
        room4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        room4.setName("room4"); // NOI18N
        room4.setPreferredSize(new java.awt.Dimension(250, 200));

        dirt4.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        dirt4.setText(".");
        dirt4.setName("dirt4"); // NOI18N

        vacuumCleaner4.setBackground(new java.awt.Color(0, 0, 0));
        vacuumCleaner4.setForeground(new java.awt.Color(255, 255, 255));
        vacuumCleaner4.setText("Vacuum Cleaner");
        vacuumCleaner4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        vacuumCleaner4.setName("vacuumCleaner4"); // NOI18N
        vacuumCleaner4.setOpaque(true);

        javax.swing.GroupLayout room4Layout = new javax.swing.GroupLayout(room4);
        room4.setLayout(room4Layout);
        room4Layout.setHorizontalGroup(
            room4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room4Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(vacuumCleaner4)
                .addGap(73, 73, 73))
            .addGroup(room4Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(dirt4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        room4Layout.setVerticalGroup(
            room4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(vacuumCleaner4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(dirt4)
                .addGap(42, 42, 42))
        );

        displayLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        displayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayLabel.setName("displayLabel"); // NOI18N

        room3.setBackground(new java.awt.Color(255, 255, 0));
        room3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        room3.setName("room3"); // NOI18N
        room3.setPreferredSize(new java.awt.Dimension(250, 200));

        dirt3.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        dirt3.setText(".");
        dirt3.setName("dirt3"); // NOI18N

        vacuumCleaner3.setBackground(new java.awt.Color(0, 0, 0));
        vacuumCleaner3.setForeground(new java.awt.Color(255, 255, 255));
        vacuumCleaner3.setText("Vacuum Cleaner");
        vacuumCleaner3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        vacuumCleaner3.setName("vacuumCleaner3"); // NOI18N
        vacuumCleaner3.setOpaque(true);

        javax.swing.GroupLayout room3Layout = new javax.swing.GroupLayout(room3);
        room3.setLayout(room3Layout);
        room3Layout.setHorizontalGroup(
            room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room3Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(dirt3)
                .addGap(109, 109, 109))
            .addGroup(room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room3Layout.createSequentialGroup()
                    .addContainerGap(83, Short.MAX_VALUE)
                    .addComponent(vacuumCleaner3)
                    .addGap(67, 67, 67)))
        );
        room3Layout.setVerticalGroup(
            room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room3Layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(dirt3)
                .addGap(43, 43, 43))
            .addGroup(room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(room3Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(vacuumCleaner3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
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
            java.util.logging.Logger.getLogger(HouseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HouseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HouseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HouseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final HouseFrame obj = new HouseFrame();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //obj = new HouseFrame();
                obj.setVisible(true);
                //createAndDisplyGUI(obj);
            }
        });
        
        int previousRoom = 1;
        int vacuumIsIn = 1;
        obj.vacuumCleaner2.setVisible(false);
        obj.vacuumCleaner4.setVisible(false);
        obj.vacuumCleaner3.setVisible(false);
        //****Randomized Dirt Insertion
        while(true){
            if(vacuumIsIn==1)
                previousRoom = 4;
            else 
                previousRoom = vacuumIsIn-1;
            //for(; currentRoom<5; ++currentRoom){
            double temp = Math.random() * 10;
            //Make the room just cleaned dirty if temp>5.0
            if(temp>5.0){  
                //System.out.println("Still runnning..................");
                switch(previousRoom){
                    case 1:
                        //obj.dirt1.setVisible(true);
                        obj.dirt1.setText(".");
                        break;
                    case 2:
                        obj.dirt2.setText(".");
                        break;
                    case 3:
                        obj.dirt3.setText(".");
                        break;
                    case 4:
                        obj.dirt4.setText(".");
                        break;
                }
            } else{
                //System.out.println("Running in the else loop");
                switch(previousRoom){
                    case 1:
                        //obj.dirt1.setVisible(true);
                        obj.dirt1.setText("");
                        break;
                    case 2:
                        obj.dirt2.setText("");
                        break;
                    case 3:
                        obj.dirt3.setText("");
                        break;
                    case 4:
                        obj.dirt4.setText("");
                        break;
                }
            }
            //}
           
            //***************End of code to move the vacuum cleaner
            switch(vacuumIsIn){
                case 1:
                    obj.vacuumCleaner1.setVisible(true);
                    obj.vacuumCleaner2.setVisible(false);
                    obj.vacuumCleaner4.setVisible(false);
                    obj.vacuumCleaner3.setVisible(false);
                    if(obj.dirt1.getText().equals(".")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt1.setText("");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 1");
                    //obj.wait(100000);
                    //for(int i=0; i<100000; ++i);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 2:
                    obj.vacuumCleaner1.setVisible(false);
                    obj.vacuumCleaner2.setVisible(true);
                    obj.vacuumCleaner4.setVisible(false);
                    obj.vacuumCleaner3.setVisible(false);
                    if(obj.dirt2.getText().equals(".")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt2.setText("");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 2");
                    //obj.wait(100000);
                    //for(int i=0; i<100000; ++i);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 3:
                    obj.vacuumCleaner1.setVisible(false);
                    obj.vacuumCleaner2.setVisible(false);
                    obj.vacuumCleaner4.setVisible(false);
                    obj.vacuumCleaner3.setVisible(true);
                    if(obj.dirt3.getText().equals(".")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt3.setText("");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 3");
                    //obj.wait(100000);
                    //for(int i=0; i<100000; ++i);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 4:
                    obj.vacuumCleaner1.setVisible(false);
                    obj.vacuumCleaner2.setVisible(false);
                    obj.vacuumCleaner4.setVisible(true);
                    obj.vacuumCleaner3.setVisible(false);
                    if(obj.dirt4.getText().equals(".")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt4.setText("");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 4");
                    //obj.wait(100000);
                    //for(int i=0; i<100000; ++i);
                    TimeUnit.SECONDS.sleep(2);
                    break;
            }
            //System.out.println("After Cleaning loop........");
            vacuumIsIn = (vacuumIsIn)%4 + 1;
            
        }
    }
    
    public static void createAndDisplyGUI(HouseFrame obj){
        //HouseFrame obj = new HouseFrame();
//        obj.dirt1.setVisible(false);
//        obj.dirt2.setVisible(false);
//        obj.dirt3.setVisibleHouseFrame(false);
//        obj.dirt4.setVisible(false);
        //System.out.println("Running....................");
        int previousRoom = 1;
        int vacuumIsIn = 1;
        //****Randomized Dirt Insertion
        while(true){
            if(vacuumIsIn==1)
                previousRoom = 4;
            else 
                previousRoom = vacuumIsIn-1;
            //for(; currentRoom<5; ++currentRoom){
            int temp = (int) Math.random() * 10;
            //Make the room just cleaned dirty if temp>5.0
            if(temp>5){  
                //System.out.println("Still runnning..................");
                switch(previousRoom){
                    case 1:
                        //obj.dirt1.setVisible(true);
                        obj.dirt1.setText("Dirty");
                        break;
                    case 2:
                        obj.dirt2.setText("Dirty");
                        break;
                    case 3:
                        obj.dirt3.setText("Dirty");
                        break;
                    case 4:
                        obj.dirt4.setText("Dirty");
                        break;
                }
            } else{
                //System.out.println("Running in the else loop");
                switch(previousRoom){
                    case 1:
                        //obj.dirt1.setVisible(true);
                        obj.dirt1.setText("Clean");
                        break;
                    case 2:
                        obj.dirt2.setText("Clean");
                        break;
                    case 3:
                        obj.dirt3.setText("Clean");
                        break;
                    case 4:
                        obj.dirt4.setText("Clean");
                        break;
                }
            }
            //}
            //*********End of Randomized Dirt Insertion
            switch(vacuumIsIn){
                case 1:
                    if(obj.dirt1.getText().equals("Dirty")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt1.setText("Clean");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 1");
                    //obj.wait(100000);
                    for(int i=0; i<100000; ++i);
                    break;
                case 2:
                    if(obj.dirt2.getText().equals("Dirty")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt2.setText("Clean");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 2");
                    //obj.wait(100000);
                    for(int i=0; i<100000; ++i);
                    break;
                case 3:
                    if(obj.dirt3.getText().equals("Dirty")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt3.setText("Clean");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 3");
                    //obj.wait(100000);
                    for(int i=0; i<100000; ++i);
                    break;
                case 4:
                    if(obj.dirt4.getText().equals("Dirty")){
                        obj.displayLabel.setText("Cleaning room "+vacuumIsIn);
                        obj.dirt4.setText("Clean");
                    } else{
                        obj.displayLabel.setText("Room "+vacuumIsIn+" is already clean");
                    }
                    System.out.println("In room 4");
                    //obj.wait(100000);
                    for(int i=0; i<100000; ++i);
                    break;
            }
            //System.out.println("After Cleaning loop........");
            vacuumIsIn = (vacuumIsIn)%4 + 1;
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dirt1;
    private javax.swing.JLabel dirt2;
    private javax.swing.JLabel dirt3;
    private javax.swing.JLabel dirt4;
    private javax.swing.JLabel displayLabel;
    private javax.swing.JPanel room1;
    private javax.swing.JPanel room2;
    private javax.swing.JPanel room3;
    private javax.swing.JPanel room4;
    private javax.swing.JLabel vacuumCleaner1;
    private javax.swing.JLabel vacuumCleaner2;
    private javax.swing.JLabel vacuumCleaner3;
    private javax.swing.JLabel vacuumCleaner4;
    // End of variables declaration//GEN-END:variables
}
