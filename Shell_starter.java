/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Yingjie(Chelsea) Wang
 */
public class Shell_starter {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      RadixDSA alpha = new RadixDSA(5);
      alpha.push(13);
      alpha.push(245);
      alpha.push(3);
      alpha.push(52);
      alpha.push(6);
      alpha.push(80);
      //alpha.display();
      //alpha.push(99); //results in overflow
      alpha.maxLen();
      alpha.pad();
      //alpha.display();
      alpha.rSortO(2);
      alpha.display();
      //alpha.displayDec();
      System.exit(0);
   }  
}
