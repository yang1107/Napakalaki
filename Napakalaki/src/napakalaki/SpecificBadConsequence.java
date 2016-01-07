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
public class SpecificBadConsequence extends BadConsequence{
      private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
      private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();
    
     
       public SpecificBadConsequence(String txt, int lvs, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
          super(txt,lvs);
         specificHiddenTreasures=tHidden;
         specificVisibleTreasures=tVisible;
       }
        
       public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
         return specificVisibleTreasures;
      }

     public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
         return specificHiddenTreasures;
      }
        
      @Override
        public boolean isEmpty(){
            boolean empty=false;
       if(levels==0&&specificVisibleTreasures.isEmpty()&&specificHiddenTreasures.isEmpty()){
           empty=true;
       }
       return empty;
        }
        
    @Override
        public void substractVisibleTreasure(Treasure t){

         if (!this.specificVisibleTreasures.isEmpty()){
            if (specificVisibleTreasures.contains(t.getType()))
                specificVisibleTreasures.remove(t.getType());
        }
    }
        
    @Override
        public void substractHiddenTreasure(Treasure t){
            if (!this.specificHiddenTreasures.isEmpty()){
              if (specificHiddenTreasures.contains(t.getType()))
                  specificHiddenTreasures.remove(t.getType());
        }
    }
        
    @Override
 public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
     
        
       SpecificBadConsequence resultado=null;
        levels=0;
         if(!v.isEmpty() || !h.isEmpty()){
            ArrayList<TreasureKind> visiblesR=new ArrayList();
            ArrayList<TreasureKind> ocultosR=new ArrayList();
            
            visiblesR=interseccion(v, this.specificVisibleTreasures);
            ocultosR=interseccion(h, this.specificHiddenTreasures);
            
            resultado=new SpecificBadConsequence(this.getText(),this.getLevels(),visiblesR,ocultosR);
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
