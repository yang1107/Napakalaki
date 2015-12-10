/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Collections;

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
        if (this.nVisibleTreasures != 0){
            nVisibleTreasures--;
        }
        else if (!this.specificVisibleTreasures.isEmpty()){
            if (specificVisibleTreasures.contains(t.getType()))
                specificVisibleTreasures.remove(t.getType());
        }
    }
    
     public void substractHiddenTreasure(Treasure t){
        if (this.nHiddenTreasures != 0){
            nHiddenTreasures--;
        }
        else if (!this.specificHiddenTreasures.isEmpty()){
            if (specificHiddenTreasures.contains(t.getType()))
                specificHiddenTreasures.remove(t.getType());
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        /*
    int visibles=0;
    int ocultos=0;
    ArrayList<TreasureKind> espVisibles = new ArrayList();
    ArrayList<TreasureKind> espOcultos = new ArrayList();

        if(nVisibleTreasures > 0){ 
            if(nVisibleTreasures > v.size()){
                visibles = v.size();
            }
            else{
                visibles = nVisibleTreasures;
            }
        }
        else{ 
            for (TreasureKind specificVisibleTreasure : specificVisibleTreasures) {
                for(Treasure treasure : v){
                    if(treasure.getType() == specificVisibleTreasure)
                        espVisibles.add(specificVisibleTreasure);
                }                 
            }
        }
        if(nHiddenTreasures > 0){
            if(nHiddenTreasures > h.size()){
                ocultos = h.size();
            }
            else{
                ocultos = nHiddenTreasures;
            }
        }
        else{
           for (TreasureKind specificHiddenTreasure : specificHiddenTreasures) {
                for(Treasure treasure : h){
                    if(treasure.getType() == specificHiddenTreasure)
                        espOcultos.add(specificHiddenTreasure);
                }                 
            }
        }
       BadConsequence res = new BadConsequence("", 0, espVisibles, espOcultos);
       res.nHiddenTreasures=ocultos;
       res.nVisibleTreasures=visibles;
       return res;
                */
        
        BadConsequence resultado=null;
        levels=0;
        if(this.specificVisibleTreasures.isEmpty()&&this.specificHiddenTreasures.isEmpty()){
            int visibles,ocultos;
            
            visibles=Math.min(v.size(), this.nVisibleTreasures);
            ocultos=Math.min(h.size(), this.nHiddenTreasures);
            
            resultado=new BadConsequence(this.getText(),this.getLevels(),visibles,ocultos);
        }
        else if(!v.isEmpty() || !h.isEmpty()){
            ArrayList<TreasureKind> visiblesR=new ArrayList();
            ArrayList<TreasureKind> ocultosR=new ArrayList();
            
            visiblesR=interseccion(v, this.specificVisibleTreasures);
            ocultosR=interseccion(h, this.getSpecificHiddenTreasures());
            
            resultado=new BadConsequence(this.getText(),this.getLevels(),visiblesR,ocultosR);
        }
        
        return resultado;
    }
    
    
    private ArrayList<TreasureKind> interseccion(ArrayList<Treasure> tesoros, ArrayList<TreasureKind> tipos){
        ArrayList<TreasureKind> resultado=new ArrayList();
        ArrayList<Treasure> copiaTesoros=new ArrayList();
        
        copiaTesoros.addAll(tesoros);
        
        for(Treasure t : tesoros){
            if(tipos.contains(t.getType())){
                resultado.add(t.getType());
                copiaTesoros.remove(t);
            }
        }
        return resultado;
    }
    
}