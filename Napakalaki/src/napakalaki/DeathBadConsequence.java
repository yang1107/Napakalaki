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
public class DeathBadConsequence extends NumericBadConsequence{
    private boolean death;
    public DeathBadConsequence(String txt, int lvs, int nVsbl, int nHddn,boolean dth) {
        super(txt, lvs, nVsbl, nHddn);
        death=dth;
    }
  
     
}
