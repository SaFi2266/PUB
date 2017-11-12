/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleaningcontest;

import static cleaningcontest.Environment.position;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Humam
 */
public class ReactiveAgent1 {
   public static String RA1="RA1"; 
     int face;
   public static int i=0;
   public static int j=10;
   public static int moves;
   public static String oldR;
   public static String oldL;
   public static String oldU;
   public static String oldD;
   public static int score;
  
    
   
   
   public void move(String agent)
    {
        
        Random rn = new Random();
        int n=4;
        int nface = Math.abs(rn.nextInt() % n);
    
        
        
        switch(face)
        {
            case 0:
                if (moves%5==0 || i + 1 > 10 ||position[i+1][j].getText().equalsIgnoreCase("O")) {
                    face = nface;
                    //System.out.println(nface);
                }
                else {
                    oldL=Environment.position[i + 1][j].getText();
                    i = i + 1;
                      if ("object".equals(oldL))
                    {
                       Environment.position[i ][j].setText("");
                       score = score+10;
                        System.out.println(agent+" score is "+score);
                         Environment.position[i-1][j].setText("");
                         Environment.position[i ][j].setText(agent);
                         Environment.objects=Environment.objects-1;
                         System.out.println("Objects remaining = "+Environment.objects);
                    }else if (i == ReactiveAgent2.i&&j==ReactiveAgent2.j)
                    {
                        score = (ReactiveAgent2.score+score)/2;
                         ReactiveAgent2.score=score;
                        System.out.println("Score devided between RA1 and RA2"+" RA1 = "+score);
                        Environment.position[i ][j].setText(agent);
                        Environment.position[i-1][j].setText("");
                    }
                      else{//System.out.println("No Object Collected "+oldL);
                    Environment.position[i ][j].setText(agent);
                    Environment.position[i-1][j].setText("");}
                    
                    
                }
                    moves=moves+1;
                break;
          case 1:
                if (moves%5==0 || i - 1 < 0 ||position[i-1][j].getText().equalsIgnoreCase("O") ) {
                    face = nface;
                } else {
                    oldR=Environment.position[i -1][j].getText();
                    i = i - 1;
                    if ("object".equals(oldR))
                    {
                       score = score+10;
                       System.out.println(agent+" score is "+score);
                       Environment.position[i+1][j].setText("");
                        Environment.position[i ][j].setText(agent);
                        Environment.objects=Environment.objects-1;
                         System.out.println("Objects remaining = "+Environment.objects);
                    }else if ( i == ReactiveAgent2.i&&j==ReactiveAgent2.j)
                    {
                        score = (ReactiveAgent2.score+score)/2;
                         ReactiveAgent2.score=score;
                        System.out.println("Score devided between RA1 and RA2"+" RA1 = "+score);
                        Environment.position[i ][j].setText(agent);
                        Environment.position[i+1][j].setText("");
                    }
                    else
                    {
                    //System.out.println("No Object Collected "+oldL);
                    Environment.position[i ][j].setText(agent);
                    Environment.position[i+1][j].setText("");}
                    
                   
                }
                    moves=moves+1;
                break;
            case 2:
                if (moves%5==0 || j - 1 < 0 ||position[i][j-1].getText().equalsIgnoreCase("O")) {
                    face = nface;
                  //  System.out.println(nface);
                } else {
                    oldD=Environment.position[i][j - 1].getText();
                    j = j - 1;
                    if ("object".equals(oldD))
                    {
                       score = score+10;
                       System.out.println(agent+" score is "+score);
                        Environment.position[i][j+1].setText("");
                        Environment.position[i][j ].setText(agent);
                        Environment.objects=Environment.objects-1;
                         System.out.println("Objects remaining = "+Environment.objects);
                    }else if ( i == ReactiveAgent2.i&&j==ReactiveAgent2.j)
                    {
                        score = (ReactiveAgent2.score+score)/2;
                         ReactiveAgent2.score=score;
                        System.out.println("Score devided between RA1 and RA2"+" RA1 = "+score);
                        Environment.position[i][j ].setText(agent);
                        Environment.position[i][j+1].setText("");
                    }
                    else
                    {
                    //System.out.println("No Object Collected "+oldD);
                    Environment.position[i][j ].setText(agent);
                    Environment.position[i][j+1].setText("");}
                    
                }
                    moves=moves+1;
                break;
            case 3:
                if (moves%5==0 || j + 1 > 10 ||position[i][j+1].getText().equalsIgnoreCase("O") ) {
                    face = nface;
                   // System.out.println(nface);
                } else {
                    oldU=Environment.position[i][j + 1].getText();
                    j = j + 1;
                    if ("object".equals(oldU))
                    {
                        score = score+10;
                       System.out.println(agent+" score is "+score);
                        Environment.position[i][j-1].setText("");
                        Environment.position[i][j ].setText(agent);
                        Environment.objects=Environment.objects-1;
                         System.out.println("Objects remaining = "+Environment.objects);
                    }
                    else if ( i == ReactiveAgent2.i&&j==ReactiveAgent2.j)
                    {
                        score = (ReactiveAgent2.score+score)/2;
                        ReactiveAgent2.score=score;
                        System.out.println("Score devided between RA1 and RA2"+" RA1 = "+score);
                            Environment.position[i][j ].setText(agent);
                            Environment.position[i][j-1].setText("");
                    }
                    else
                    {
                    //System.out.println("No Object Collected "+oldU);
                    Environment.position[i][j ].setText(agent);
                    Environment.position[i][j-1].setText("");}
                   
                   
                }
                    moves=moves+1;
                break;
        }
            if (Environment.objects==0)
        {
            for (int i=0;i<11;i++){
                for(int j=0;j<11;j++)
                {
                    if (position[i][j].getText().equalsIgnoreCase("O"))
                    {}
                    else if (position[i][j].getText().equalsIgnoreCase("")
                            ||position[i][j].getText().equalsIgnoreCase("CA1")
                            ||position[i][j].getText().equalsIgnoreCase("CA2")
                            ||position[i][j].getText().equalsIgnoreCase("RA1")
                            ||position[i][j].getText().equalsIgnoreCase("RA2"))
                    {
                        Environment.position[i][j].setText("");
                    }}
                
             position[0][0].setText(CognitiveAgent1.CA1);
             position[0][10].setText(ReactiveAgent1.RA1);
             position[10][0].setText(ReactiveAgent2.RA2);
             position[10][10].setText(CognitiveAgent2.CA2);
             JOptionPane.showMessageDialog (null, "Results are CA1= "+CognitiveAgent1.score+" CA2= "+CognitiveAgent2.score 
        +" RA1= "+ReactiveAgent1.score+" RA2= "+ReactiveAgent2.score);
            }
            }
       
}
}
