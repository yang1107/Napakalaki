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
       int nLevels=m.getLevelsGained(); //1
       this.incrementLevels(nLevels);  //2
       int nTreasures=m.getTreasuresGained(); // 3
       
       if(nTreasures>0){
           CardDealer dealer=CardDealer.getInstance();  //4
       
          for(int i=0;i<nTreasures;i++){
             Treasure treasure=dealer.nextTreasure();  //5
             this.hiddenTreasures.add(treasure);  //6
           }
       }
   }
   
   private void applyBadConsequence(Monster m){
       BadConsequence badConsequence=m.getBadConsequence();//1
       int nLevels=badConsequence.getLevels();//2
       this.decrementLevels(nLevels);//3
       this.pendingBadConsequence=badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);//4
       this.setPendingBadConsequence(pendingBadConsequence);
   }
   
   private boolean canMakeTreasureVisible(Treasure t){
       boolean res=true;
       if(t.getType()!=TreasureKind.ONEHAND){
       for(Treasure tre: visibleTreasures){
           if(t.getType()==tre.getType()){
               res=false;
           }
       }
      }
       else{
           int i=0;
           for(Treasure tre: visibleTreasures){
           if(t.getType()==TreasureKind.ONEHAND){
               i++;
           }
           }
           if(i==2){
               res=false;
           }
           else{
           res=true;
            }
       }
        return res;
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
   
   public CombatResult combat(Monster m){
       int myLevel=this.getLevels();  //1.1.1
       int monsterLevel=this.getCombatLevel(); //1.1.2
       
       if(myLevel>monsterLevel){
           this.applyPrize(m);
       }
       
    }
   
   public void makeTreasureVisible(Treasure t){
       boolean canI=this.canMakeTreasureVisible(t); //1.2.1
       if(canI){
           this.visibleTreasures.add(t);  //1.2.2
           this.hiddenTreasures.remove(t);  //1.2.3
       }
   }
   
   public void discardVisibleTreasure(Treasure t){
       this.visibleTreasures.remove(t);  //1.2.1
       if((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty())){ 
           this.pendingBadConsequence.substractVisibleTreasure(t);  //1.2.2
       }
      this.dieIfNotTreasures(); // 1.2.3
   }
   
   public void discardHiddenTreasure(Treasure t){
       this.hiddenTreasures.remove(t);  //1.2.1
       while((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty())){ 
           this.pendingBadConsequence.substractHiddenTreasure(t);  //1.2.2
       }
      this.dieIfNotTreasures(); // 1.2.3
   }
   
   public boolean validState(){
       boolean res=false;
        if(pendingBadConsequence.isEmpty() && hiddenTreasures.size()>4){
            res=true;
        } 
        return res;
   }
   
   public void initTreasures(){
       Treasure treasure;
       int number;
       CardDealer dealer=CardDealer.getInstance();  //1
       Dice dice=Dice.getInstance();//2
       this.bringToLife();//3
       treasure=dealer.nextTreasure();//4
       this.hiddenTreasures.add(treasure);//5
       number=dice.nextNumber();//6
       
       if(number>1){
           treasure=dealer.nextTreasure();//7
           this.hiddenTreasures.add(treasure);//8
       }
       if(number==6){
           treasure=dealer.nextTreasure();//9
           this.hiddenTreasures.add(treasure);//10
       }
   }
   
   public int getLevels(){
       return level;
   }
   
   public Treasure stealTreasure() {
       Treasure treasure=null;
       boolean canI=this.canISteal();  //1.1
       if(canI){
           boolean canYou=this.enemy.canYouGiveMeATreasure();  //1.2
           if(canYou){
               treasure=this.enemy.giveMeATreasure();  //1.3
               this.hiddenTreasures.add(treasure);  //1.4
               this.haveStolen();  //1.6
           }
       }
       return treasure;
   }
   
   
   public void setEnemy(Player e){
       enemy=e;
   }
   
   private Treasure giveMeATreasure(){
        int numero= (int) (Math.random()*hiddenTreasures.size());
        return hiddenTreasures.get(numero);
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
       Treasure treasure;
       for(Treasure vt : this.visibleTreasures){
         // treasure=vt.next(); //1.1
          this.discardVisibleTreasure(vt); //1.2
       }
       for(Treasure ht : this.hiddenTreasures){
          // treasure=ht.next();  //1.3
           this.discardHiddenTreasure(ht);  //1.4
       }
   }
   
   
   
}
