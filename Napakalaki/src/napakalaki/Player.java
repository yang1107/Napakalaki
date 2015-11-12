/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author chen__000
 */
public class Player {
    
   final int MAXLEVEL=10;
   private String name;
   private int level;
   private boolean dead=true;
   private boolean canISteal=true;
   private ArrayList<Treasure> hiddenTreasures;
   private ArrayList<Treasure> visibleTreasures;
   private BadConsequence pendingBadConsequence;
   private Player enemy;
   
   public Player(String nm){
       name=nm;
       level=1;
       hiddenTreasures=new ArrayList();
       visibleTreasures=new ArrayList();
   }
   
   public String getName(){
       return name;
   }
   
   private void bringToLife(){
       dead=false;
   }
   
   private int getCombatLevel(){
       int lv=level;
       for(Treasure t: visibleTreasures){
           lv=lv+t.getBonus();
       }
        for(Treasure t: hiddenTreasures){
           lv=lv+t.getBonus();
       }
        return lv;
   }
   
   private void incrementLevels(int i){
       level=level+i;
   }
   
   private void decrementLevels(int i){
       level=level-i;
   }
   
   private void setPendingBadConsequence(BadConsequence b){
       pendingBadConsequence=b;
   }
   
   private void applyPrize(Monster m){
       
   }
   
   private boolean canMakeTreasureVisible(Treasure t){
       return false;
   }
    
   private int howManyVisibleTreasures(TreasureKind tKind){
       int i=0;
       for(Treasure t: visibleTreasures){
           if(t.getType()==tKind){
               i++;
           }
       }
       return i;
   }
   
   private void dieIfNotTreasures(){
       if(visibleTreasures.isEmpty()&&hiddenTreasures.isEmpty())
            dead=true;
   }
   
   public boolean isDead(){
       boolean res=false;
       if(dead==true){
           res=true;
       }
       return res;
   }
   
   public ArrayList<Treasure> getHiddenTreasures(){
       return null;
   }
   
   public ArrayList<Treasure> getVisivleTreasures(){
       return null;
   }
   
   public CombatResult combat(){
       return null;
   }
   
   public void makeTreasureVisible(Treasure t){
       
   }
   
   public void discardVisibleTreasure(Treasure t){
       
   }
   
   public void discardHiddenTreasure(Treasure t){
       
   }
   
   public boolean validState(){
       boolean res=false;
        if(pendingBadConsequence.isEmpty() && hiddenTreasures.size()>4){
            res=true;
        } 
        return res;
   }
   
   public void initTreasures(){
       
   }
   
   public int getLevels(){
       return level;
   }
   
   public Treasure stealTreasure() {
       return null;
   }
   
   
   public void setEnemy(Player e){
       enemy=e;
   }
   
   private Treasure giveMeATreasure(){
       return null;
   }
   
   public boolean canISteal(){
       return this.canISteal;
   }
   
   private boolean canYouGiveMeATreasure(){
       boolean res=false;
       if(this.hiddenTreasures.size()>0&&this.visibleTreasures.size()>0){
           res=true;
       }
       return res;
   }
   
   private void haveStolen() {
        this.canISteal=false;
   }
   
   public void discardAllTreasures(){
       
   }
   
   
   
}
