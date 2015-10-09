/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author chen__000
 */
public class Prize {
    
    private int treasures;
    private int level;
    
    public Prize(int trs, int lv){
       treasures=trs;
       level=lv;
    }
    public int getTreasures(){
        return treasures;
    }
    public int getLevel(){
        return level;
    }
    
    public static void main(String[] args) {
        Prize unPrize=new Prize(2,5);
        System.out.println (unPrize.getLevel());
    }
    
    public String toString(){
      return "Treasures= " + Integer.toString(treasures)+ "levels =" + Integer.toString(level);
    }
             
}
