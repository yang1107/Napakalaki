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
   protected ArrayList<Treasure> hiddenTreasures;
   protected ArrayList<Treasure> visibleTreasures;
   private BadConsequence pendingBadConsequence;
   protected Player enemy;
   
   public Player(String nm){
       name=nm;
       level=1;
       hiddenTreasures=new ArrayList();
       visibleTreasures=new ArrayList();
       this.pendingBadConsequence= new NumericBadConsequence("",0,0,0);
   }
   
   public Player(Player p){
       this.name=p.name;
       this.level=p.level;
       this.hiddenTreasures=p.hiddenTreasures;
       this.visibleTreasures=p.visibleTreasures;
       this.pendingBadConsequence=p.pendingBadConsequence;
   }
   
   public String getName(){
       return name;
   }
   
   private void bringToLife(){
       dead=false;
   }
   
   protected int getCombatLevel(){
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
       if(level<1){
           level=1;
       }
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
       int nLevels = badConsequence.getLevels();
       this.decrementLevels(nLevels);//3
       BadConsequence pendingBad=badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);//4
       this.setPendingBadConsequence(pendingBad); //5
   }
   
   private boolean canMakeTreasureVisible(Treasure t){
       int nOnehand=0;
       int nBothhands=0;
       int nArmor=0;
       int nShoes=0;
       int nHelmet=0;
       boolean res=false;
       
       for (Treasure tre : visibleTreasures) {
           if(tre.getType() == TreasureKind.ONEHAND){
               nOnehand++;
           }else if(tre.getType() ==  TreasureKind.BOTHHANDS){
               nBothhands++;
           }else if(tre.getType() == TreasureKind.ARMOR){
               nArmor++;
           }else if(tre.getType() ==  TreasureKind.SHOES){
               nShoes++;
           }else{
               nHelmet++;
           }
       }
       switch(t.getType()){
            case ONEHAND:
                if(nOnehand < 2 && nBothhands == 0)
                    res = true;
                break;
            case BOTHHANDS:
                if(nOnehand == 0 && nBothhands == 0)
                    res = true;
                break;
            case HELMET:
                if(nHelmet == 0)
                    res = true;
                break;
            case SHOES:
                if(nShoes == 0)
                    res = true;
                break;
            case ARMOR:
                if(nArmor == 0)
                    res = true;
                break;
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
       return dead;
   }
   
   public ArrayList<Treasure> getHiddenTreasures(){
       return this.hiddenTreasures;
   }
   
   public ArrayList<Treasure> getVisibleTreasures(){
       return this.visibleTreasures;
   }
   
   public CombatResult combat(Monster m){
       CombatResult result;
       boolean should;
       int myLevel=this.getCombatLevel();  //1.1.1
       int monsterLevel=this.getOponentLevel(m); //1.1.2
       
       if(myLevel>monsterLevel){
           this.applyPrize(m); //1.1.3
           
           if(this.level>=MAXLEVEL){
               result=CombatResult.WINGAME;
           }
           else{
               result=CombatResult.WIN;
           }
       }
       else{
           this.applyBadConsequence(m); //1.1.4
           
           should=this.shouldConvert();
           if(should==true){
               result=CombatResult.LOSEANDCONVERT;
           }
           else{
               result=CombatResult.LOSE;
           }
       }
       return result;
    }
   
   public void makeTreasureVisible(Treasure t){
       boolean canI=this.canMakeTreasureVisible(t); //1.2.1
       if(canI){
           this.visibleTreasures.add(t);  //1.2.2
           this.hiddenTreasures.remove(t);  //1.2.3
       }
   }
   
   public void discardVisibleTreasures(Treasure t){
       this.visibleTreasures.remove(t);  //1.2.1
       if((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty())){ 
           this.pendingBadConsequence.substractVisibleTreasure(t);  //1.2.2
       }
      this.dieIfNotTreasures(); // 1.2.3
   }
   
   public void discardHiddenTreasures(Treasure t){
       this.hiddenTreasures.remove(t);  //1.2.1
       while((this.pendingBadConsequence!=null) && (!this.pendingBadConsequence.isEmpty())){ 
           this.pendingBadConsequence.substractHiddenTreasure(t);  //1.2.2
       }
      this.dieIfNotTreasures(); // 1.2.3
   }
   
   public boolean validState(){
       boolean res=false;
        if(pendingBadConsequence==null||pendingBadConsequence.isEmpty() && hiddenTreasures.size()<=4 ){
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
   
   protected Treasure giveMeATreasure(){
        int numero= (int) (Math.random()*hiddenTreasures.size());
        return hiddenTreasures.get(numero);
   }
   
   public boolean canISteal(){
       return this.canISteal;
   }
   
   protected boolean canYouGiveMeATreasure(){
       boolean res=false;
       if(this.hiddenTreasures.size()>0){
           res=true;
       }
       return res;
   }
   
   private void haveStolen() {
        this.canISteal=false;
   }
   
   public void discardAllTreasures(){
       Treasure treasure;
       ArrayList<Treasure> visiblet=new ArrayList(this.visibleTreasures);
       ArrayList<Treasure> hiddent=new ArrayList(this.hiddenTreasures);
       
       for(Treasure vt : visiblet){
          this.discardVisibleTreasures(vt); //1.2
       }
       for(Treasure ht : hiddent){
           this.discardHiddenTreasures(ht);  //1.4
       }
   }
   
   
     protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice=Dice.getInstance();
        boolean should=false;
        
        if(dice.nextNumber()==1){
            should=true;
        }
        
        return should;
    }
    
   
    public String toString() {
        return "Nombre: " + this.name + " Nivel: " + this.level;
    }
   
}
