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
public class Napakalaki {
    
    private Player cunrrentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    private Napakalaki() {
    }
    
    public static Napakalaki getInstance() {
        return NapakalakiHolder.INSTANCE;
    }
    
    private static class NapakalakiHolder {

        private static final Napakalaki INSTANCE = new Napakalaki();
    }
    
    private void initPlayers(ArrayList<String> names){
        for(int i=0;i<names.size();i++){
           players.add(new Player(names.get(i)));
        }
    }

    private Player nextPlayer(){
        Player nextp;
        
        if(cunrrentPlayer==null){
             int numero= (int) (Math.random()*players.size()+1);
             nextp=players.get(numero);
        }
        else{
            int indice=players.indexOf(this.cunrrentPlayer);
            if(indice==players.size()){
                nextp=players.get(0);
            }
            else{
                nextp=players.get(indice+1);
            }
        }
       return nextp;    
    }
    
    private boolean nextTurnAllowed(){
        boolean cumple=false;
        if(this.cunrrentPlayer.validState()){
            cumple=true;
        }
        return cumple;
    }
    
    private void setEnemies(){
        for(int i=0;i<players.size();i++){
            int numero= (int) (Math.random()*players.size()+1);
            while(numero==i){
                 numero= (int) (Math.random()*players.size()+1);
            }
            players.get(i).setEnemy(players.get(numero));
        }
    }
    
    public CombatResult developCombat(){
        return null;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }
    
    public Player getCurrentPlayer(){
        return cunrrentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
       boolean res=false;
       if(result==CombatResult.WINGAME){
           res=true;
       }
       return res;
    }
    
    
    
}
