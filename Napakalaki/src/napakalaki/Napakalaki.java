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
        
    }
    
    private Player nextPlayer(){
        return null;
    }
    
    private boolean nextTurnAllowed(){
        return false;
    }
    
    private void setEnemies(){
        
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
        return null;
    }
    
    public Monster getCurrentMonster(){
        return null;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
       return false; 
    }
    
    
    
}
