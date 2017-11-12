import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import vacuum.agent.newAgent;

/**
 *
 * @author TS
 */
public class vcai extends JFrame implements ActionListener {

    JTextField[][] b = new JTextField[10][10];
    JButton bt;
    //int count;
    int face;//1 u;2 d; 3 l; 4 r
    int i;
    int j;
    int moves;
     java.util.List<Integer> row = new ArrayList<Integer>();
     java.util.List<Integer> column = new ArrayList<Integer>();

  
  public boolean finder(int ObsticleX, int ObsticleY )
  {
      boolean found = false;
      for (int r = 0; r<row.size();r++)
      {
          for(int c=0;c<column.size();c++)
          {
              if (ObsticleX ==row.get(r)&&column.get(c) == ObsticleY)
              {
                  found = true;
              }else
                  found = false;
                  }
      }
        return found;
  }
    void move() {
        Random rn = new Random();
        int n = 4;
        int nface = Math.abs(rn.nextInt() % n);
      
                    System.out.println(nface);
        switch (face) {
            case 0:
                if (moves%5==0 || i + 1 > 9 || b[i + 1][j].getText().equalsIgnoreCase("o")) {
                    face = nface;
                    System.out.println(nface);
                } else {
                    b[i + 1][j].setText("A");
                    b[i][j].setText("c");
                    i = i + 1;
                }
                    moves=moves+1;
                break;
            case 1:
                if (moves%5==0 || i - 1 < 0 || b[i - 1][j].getText().equalsIgnoreCase("o")) {
                    face = nface;
                    System.out.println(nface);
                } else {
                    b[i - 1][j].setText("A");
                    b[i][j].setText("c");
                    i = i - 1;
                }
                    moves=moves+1;
                break;
            case 2:
                if (moves%5==0 || j - 1 < 0 || b[i][j - 1].getText().equalsIgnoreCase("o")) {
                    face = nface;
                    System.out.println(nface);
                } else {
                    b[i][j - 1].setText("A");
                    b[i][j].setText("c");
                    j = j - 1;
                }
                    moves=moves+1;
                break;
            case 3:
                if (moves%5==0 || j + 1 > 9 || b[i][j + 1].getText().equalsIgnoreCase("o")) {
                    face = nface;
                    System.out.println(nface);
                } else {
                    b[i][j + 1].setText("A");
                    b[i][j].setText("c");
                    j = j + 1;
                }
                    moves=moves+1;
                break;
        }
        if(moves%70==0) {
            JOptionPane.showMessageDialog(this, "step");
        }
    }

    //GroupLayout layout = new GroupLayout(getContentPane());
    //GroupLayout.Group[] g=new GroupLayout.Group[10];
    public vcai() {
        super("vacuum cleaner agent");
        bt = new JButton("Start");
        Container content = this.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 10));
        for (int i = 0; i < 10; i++) {
            //g[i]=layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup());
            for (int j = 0; j < 10; j++) {
                b[i][j] = new JTextField();
                //b[i][j].setLocation((i*10)+10, (j*10)+10);
                panel.add(b[i][j], j);
            }
        }
        bt.addActionListener(this);
        content.add(new JLabel("A: Agent ; o: obstacle ; *: dirt"), BorderLayout.PAGE_END);
        content.add(bt, BorderLayout.AFTER_LINE_ENDS);
        content.add(panel);
        //getContentPane().setLayout(layout);
        //  pack();
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent be) {
        if (be.getActionCommand().equals(bt.getLabel())) {
            //System.out.println("this");
            placeAgent();
            //slp(5000);
            face = 3;
            int l[] = new int[2];
            i = l[0];
            j = l[1];
            moves=1;
            while (true) {
                move();
            }
        }
    }

    void placeAgent() {
        outerloop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (b[i][j].getText().equalsIgnoreCase("")) {
                    b[i][j].setText("A");
                    break outerloop;
                }
            }
        }
    }


    int[] aloc() {
        int l[] = {0, 0};
        outerloop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (b[i][j].getText().equalsIgnoreCase("A")) {
                    l[0] = i;
                    l[1] = j;
                    break outerloop;
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        //new vcai2().setVisible(true);
        //new NewClass().finder(7,3);
        new newAgent().setVisible(true);
    }
}