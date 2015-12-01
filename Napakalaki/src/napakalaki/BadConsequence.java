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
public class BadConsequence {
    int MAXTREASURES=10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();

    public BadConsequence(String txt, int lvs, int nVsbl, int nHddn){
        text=txt;
        levels=lvs;
        nVisibleTreasures=nVsbl;
        nHiddenTreasures=nHddn;
    }
    public BadConsequence(String txt, boolean dth){
        txt=text;
        death=dth;
    }
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    public boolean getDeath(){
        return death;
    }
    
    
    public BadConsequence(String txt, int lvs, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        text=txt;
        levels=lvs;
        specificHiddenTreasures=tHidden;
        specificVisibleTreasures=tVisible;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    public String toString(){
      return "Bad Consequence : " + text;
    }
    
    public boolean isEmpty(){
       boolean empty=false;
       if(levels==0&&nHiddenTreasures==0&&nVisibleTreasures==0 && death==false
               &&specificHiddenTreasures.isEmpty()&&specificHiddenTreasures.isEmpty()){
           empty=true;
       }
       return empty;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(this.nVisibleTreasures>0){
            this.nVisibleTreasures--;
        }
        if(this.nVisibleTreasures==0){
            this.specificVisibleTreasures.remove(t.getType());
        }
    }
    
     public void substractHiddenTreasure(Treasure t){
         if(this.nHiddenTreasures>0){
            this.nHiddenTreasures--;
        }
        if(this.nHiddenTreasures==0){
            this.specificHiddenTreasures.remove(t.getType());
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        return null;
    }
    
    
}