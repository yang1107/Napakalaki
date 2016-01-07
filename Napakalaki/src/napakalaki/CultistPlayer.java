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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard;
   

    public CultistPlayer(Player p,Cultist c) {
        super(p);
        this.myCultistCard=c;
        this.totalCultistPlayers++;
    }
    
    protected int getCombatLevel(){
        int nivel=super.getCombatLevel();
        int porcentaje=nivel*20/100;
        int cultislv=this.myCultistCard.getGainedLevels()*this.getTotalCultistPlayers();
        int lv=nivel+porcentaje+cultislv;
        return lv;
        
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        int numero= (int) (Math.random()*this.visibleTreasures.size());
        return this.visibleTreasures.get(numero);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
         boolean res=false;
       if(this.enemy.visibleTreasures.size()>0){
           res=true;
       }
       return res;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    
    
    
    
    
}
