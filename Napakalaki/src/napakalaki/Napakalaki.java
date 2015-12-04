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
    
    private static Napakalaki instance = null;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer=CardDealer.getInstance();
    private Monster currentMonster;
    
    private Napakalaki() {
    }
    
    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
    
    
    private void initPlayers(ArrayList<String> names){
        players=new ArrayList();
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    private Player nextPlayer(){
        Player nextp;
        
        if(currentPlayer==null){
             int numero= (int) (Math.random()*players.size());
             nextp=players.get(numero);
        }
        else{
            int indice=players.indexOf(this.currentPlayer);
            if(indice==players.size()-1){
                nextp=players.get(0);
            }
            else{
                nextp=players.get(indice+1);
            }
        }
       return nextp;    
    }
    
    private boolean nextTurnAllowed(){
       boolean allowed;

        if (this.currentPlayer == null) {
            allowed = true; 
        } else {
            allowed = this.currentPlayer.validState(); //1.1.1
        }

        return allowed;
    }
    
    private void setEnemies(){
        for(int i=0;i<players.size();i++){
            int numero= (int) (Math.random()*players.size());
            while(numero==i){
                 numero= (int) (Math.random()*players.size());
            }
            players.get(i).setEnemy(players.get(numero));
        }
    }
    
    public CombatResult developCombat(){
        CombatResult result;
        result=this.currentPlayer.combat(this.currentMonster); //1.1
        this.dealer.giveMonsterBack(this.currentMonster);  //1.2
        return result;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){//1.1
            this.currentPlayer.discardVisibleTreasures(t); //1.2
            this.dealer.giveTreasureBack(t); //1.3
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
         for(Treasure t: treasures){
            this.currentPlayer.discardHiddenTreasures(t); //1.2
            this.dealer.giveTreasureBack(t); //1.3
         }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t :treasures){
            this.currentPlayer.makeTreasureVisible(t); //1.2
        }
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players); //1.1
        this.setEnemies();  //1.2
        dealer.initCards();  //1.3
        this.nextTurn();  //1.4
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK=this.nextTurnAllowed(); //1.1
        
        if(stateOK){
            currentMonster=dealer.nextMonster(); //1.2
            currentPlayer=this.nextPlayer(); //1.3
            boolean dead=currentPlayer.isDead();  //1.4
                if(dead){
                    currentPlayer.initTreasures(); //1.5
        
                }
        }
       return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
       boolean res=false;
       if(result==CombatResult.WINGAME){
           res=true;
       }
       return res;
    }
    
    
    
}
