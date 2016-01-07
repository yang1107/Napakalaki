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
public abstract class BadConsequence {
    int MAXTREASURES=10;
    protected String text;
    protected int levels;
    
    public BadConsequence(String txt,int lv){
        this.text=txt;
        this.levels=lv;
    }

    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    
    public abstract boolean isEmpty();
   
    public String toString(){
        return "Bad Consequence : " + text;
      }

    public abstract void substractVisibleTreasure(Treasure t);
    public abstract void substractHiddenTreasure(Treasure t);
 
   public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);
   
//    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){

//        
//        BadConsequence resultado=null;
//        levels=0;
//        if(this.specificVisibleTreasures.isEmpty()&&this.specificHiddenTreasures.isEmpty()){
//            int visibles,ocultos;
//            
//            visibles=Math.min(v.size(), this.nVisibleTreasures);
//            ocultos=Math.min(h.size(), this.nHiddenTreasures);
//            
//            resultado=new BadConsequence(this.getText(),this.getLevels(),visibles,ocultos);
//        }
//        else if(!v.isEmpty() || !h.isEmpty()){
//            ArrayList<TreasureKind> visiblesR=new ArrayList();
//            ArrayList<TreasureKind> ocultosR=new ArrayList();
//            
//            visiblesR=interseccion(v, this.specificVisibleTreasures);
//            ocultosR=interseccion(h, this.specificHiddenTreasures);
//            
//            resultado=new BadConsequence(this.getText(),this.getLevels(),visiblesR,ocultosR);
//        }
//        
//        return resultado;
//    }
//    
//    
 
    
}