/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleaningcontest;

import java.awt.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Environment extends JFrame implements ActionListener {
    Random random = new Random();
   public static  JTextField[][] position = new JTextField[11][11];
    JButton start;
    public static int objects;
    CognitiveAgent1 cognitiveAgent1 = new CognitiveAgent1();
    public void ObjectsAndObsticles()
    {
       
      for (int i = 0; i < 33; i++)
        {
            cognitiveAgent1.land[random.nextInt(9 - 1 + 1) + 1] [random.nextInt(9 - 1 + 1)+1]="object";
        }
        for (int i = 0; i < 10; i++)
        {
            
            cognitiveAgent1.land[random.nextInt(9 - 1 + 1) + 1] [random.nextInt(9 - 1 + 1)+1]="O";
        }
        for (int i =0;i<cognitiveAgent1.land.length;i++)
        {
            for (int j =0;j<cognitiveAgent1.land.length;j++)
            {
                Environment.position[i][j].setText(cognitiveAgent1.land[i][j]);
                if(Environment.position[i][j].getText().equalsIgnoreCase("object"))
                {Environment.objects=Environment.objects+1;
                }
            }
        }
        
        
        
        
        
        position[0][0].setText(CognitiveAgent1.CA1);
        position[0][10].setText(ReactiveAgent1.RA1);
        position[10][0].setText(ReactiveAgent2.RA2);
        position[10][10].setText(CognitiveAgent2.CA2);
//        String setAgent = setAgent("CA1");
//        if (setAgent=="CA1"){position[0][0].setText(CognitiveAgent.CA1);}
//        else if (setAgent=="CA2"){position[10][10].setText(CognitiveAgent2.CA2);}
//        else if (setAgent=="RA1"){position[10][0].setText(ReactiveAgent1.RA1);}
//        else if (setAgent=="RA2"){position[0][10].setText(ReactiveAgent1.RA2);}

        }
    public Environment()
    {
        super("vacuum cleaner agent");
        start = new JButton("Start");
        Container content = this.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11,10));
        for (int i = 0; i < 11; i++) 
        {//g[i]=layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup());
         for (int j = 0; j < 11; j++) 
         {
             position[i][j] = new JTextField();
                //b[i][j].setLocation((i*10)+10, (j*10)+10);
                panel.add(position[i][j], j);
         }
         
        }
        start.addActionListener(this);
        content.add(new JLabel("A: Agent ; O: obstacle ; RA1,RA2: ReactiveAgents ; CA1,CA2: CognitiveAgents"), BorderLayout.PAGE_END);
        content.add(start, BorderLayout.LINE_END);
        content.add(panel);
        //getContentPane().setLayout(layout);
        //  pack();
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}

    public void actionPerformed(ActionEvent e) 
    {{
        ObjectsAndObsticles();
        CognitiveAgent1 m = new CognitiveAgent1();
        CognitiveAgent2 co2=new CognitiveAgent2();
        ReactiveAgent2 ra2=new ReactiveAgent2();
        ReactiveAgent1 ra1=new ReactiveAgent1();
        while (Environment.objects>0)
        {
            m.move(CognitiveAgent1.CA1);
            co2.move(CognitiveAgent2.CA2);
            ra2.move(ReactiveAgent2.RA2);
            ra1.move(ReactiveAgent1.RA1);
        }
        
        
    } 
        
        
    }
 
}
