
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Humam
 */
public class NewClass {
    java.util.List<Integer> row = new ArrayList<Integer>();
     java.util.List<Integer> column = new ArrayList<Integer>();
     //int pos[][] ;
      int r;
      int c;
     //List<List<Integer>> pos = new ArrayList<List<Integer>>();
      public boolean finder(int ObsticleX, int ObsticleY )
              
  {
     
      
      row.add(6);
      row.add(3);
      column.add(5);
      column.add(7);
      boolean first= false;
      boolean second = false; 
     
      boolean found = false;
      
      for (int r = 0; r<row.size();r++)
      {
          if (row.get(r) ==3 && column.get(r)==7)
          {//System.out.println(row.get(r)+" "+column.get(c));
          first= true;
          second = true;}else{ first = false;System.out.println("First = "+first);}
//          for(int c = 0; c<column.size();c++)
//          {
//              if ( column.get(r)==ObsticleY)
//              {//System.out.println(row.get(r)+" "+column.get(c));
//              second=true;}else {second = false;System.out.println("Second = "+second);}
//              }
              
          }
      
        if (first && second )
              {
                  found = true;
                  System.out.println("found point "+row.get(r)+", "+column.get(r));
              }else{         found = false;
                  System.out.println("found"+row.get(r)+" "+column.get(c));
          }
      
      
       System.out.println(found);
        return found;
  }}//}

