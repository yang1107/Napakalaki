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
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
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
    

    private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();
    
    public BadConsequence(String txt, int lvs, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        text=txt;
        levels=lvs;
        specificHiddenTreasures=tHidden;
        specificVisibleTreasures=tVisible;
    }
}