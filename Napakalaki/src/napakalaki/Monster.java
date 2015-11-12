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
public class Monster {
    private String name;
    private int combatLevel;
     public Prize price;
    public BadConsequence bc;
    
    public String getName(){
        return name;
    }
    public int getCombatLevel(){
        return combatLevel;
    }
    
   
    
    public Monster(String nm, int lv, BadConsequence badconseq, Prize prc){
        name=nm;
        combatLevel=lv;
        bc=badconseq;
        price=prc;
    }
    public String toString(){
      return name+ "\nNivel de combate = " + combatLevel + "\n" + bc + "\n" + price;
    }
    
    public BadConsequence getBadConsequence(){
        return null;
    }
    
    public int getLevelsGained(){
        return this.price.getLevel();
    }
    
    public int getTreasuresGained(){
        return this.price.getTreasures();
    }
    
    
}
