/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuum.agent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Humam
 */
public class newAgent extends JFrame implements ActionListener{
    
    
     JTextField[][] position = new JTextField[10][10];
        JButton start;
        JButton clean;
        
        Random random = new Random();
        //int row;
       // int column;
        int length=0;
        int width=0;
        int face;
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> column = new ArrayList<Integer>();
        
        
        public void ObjectsAndObsticles()
        {
             
            
             for (int i = 0; i < 33; i++)
             {
                 position[random.nextInt(9 - 0 + 1) + 0] [random.nextInt(9 - 0 + 1)+0].setText("object");
             }
              for (int i = 0; i < 10; i++) 
              {
                 position[random.nextInt(9 - 0 + 1) + 0] [random.nextInt(9 - 1 + 1)+1].setText("O");
              }
             
        }
    public void checkEnviroment()
    {
        
//               if(position[length+1][width].getText().equalsIgnoreCase("O")&&length<10&&width<10)
//               {
//                row.add(length+1);
//                column.add(width);
//               }else if (position[length][width+1].getText().equalsIgnoreCase("O")&&length<10&&width<10)
//               {
//                row.add(length);
//                column.add(width+1); 
//                   System.out.println(row +" "+ column);
//               }
//                if (position[length+1<10][width] && position[length+1][width].getText().equalsIgnoreCase("O"))
                
            
//        for(int i=9; i >=0; i--)
//        {
//            for(int j=9; j>=0; j--)
//            {
//                if (position[i+1][j].getText().equalsIgnoreCase("O"))
//                {
//                    row.add(i);
//                    column.add(j);
//                   
//                    System.out.println("R "+row+" "+"C "+column+" " +position[i][j].getText() );
//                }
//            
//            }
//        }
    }
   
    public  void cleaning()
    {
     
     for (int i = 0; i<=9; i++)
     {
         for(int j=0;j<=9;j++)
         {
             if (position[i][j].getText().equalsIgnoreCase("object")){
                 System.out.println("Object found and Cleaned in "+i +" , "+j);
                 position[i][j].setText("A");
                 position[i][j].setText("CL");
            }else if(position[i][j].getText().equalsIgnoreCase("O"))
            {
                System.out.println("Obstcle found and location has been saved into memory "+i +" , "+j);
                row.add(i);
                column.add(j);
                System.out.println("List of obsticle positions Row"+ row + ", Column "+column);
            }
             
         }
         position[0][0].setText("A");
         System.out.println("Agent came back to its inital point");
     }
    
//        switch(face)
//        {
//            case 0:
//                if (position[length][width].getText().equalsIgnoreCase("object"))
//                {
//                    position[length][width].setText("CL");
//                    position[length+1][width].setText("A");
//                    length = length + 1;
//                }else
//                    System.out.println("land finished");
//                
//            break;
//        }
    }
    
    public newAgent()
    {
        super("vacuum cleaner agent");
        start = new JButton("Start");
        clean = new JButton("CLEAN");
        Container content = this.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 10));
        for (int i = 0; i < 10; i++) {
            //g[i]=layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup());
            for (int j = 0; j < 10; j++) {
                position[i][j] = new JTextField();
                //b[i][j].setLocation((i*10)+10, (j*10)+10);
                panel.add(position[i][j], j);
            }
        }
        start.addActionListener(this);
        clean.addActionListener(this);
        content.add(new JLabel("A: Agent ; O: obstacle ; CL: Cleaned"), BorderLayout.PAGE_END);
        content.add(start, BorderLayout.AFTER_LINE_ENDS);
        content.add(clean, BorderLayout.BEFORE_FIRST_LINE);
        content.add(panel);
        //getContentPane().setLayout(layout);
        //  pack();
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public void actionPerformed(ActionEvent be) {
           if (be.getActionCommand().equals(start.getText())) {
            //System.out.println("this");
            //placeAgent();
            //slp(5000);
            //face = 3;
               ObjectsAndObsticles();
               cleaning();
               checkEnviroment();
//            int l[] = new int[2];
//            i = l[0];
//            j = l[1];
//            moves=1;
//            while (true) {
//                move();
//            }
        }
//           if (be.getActionCommand().equals(clean.getText())) 
//           {
//               cleaning();
//           }
    }

        
        
    
}

