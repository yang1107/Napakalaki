/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chen__000
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence1 = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        Prize prize1 = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa",13,badConsequence1,prize1));
        
        BadConsequence badConsequence2 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize2 = new Prize(4,1);
        monstruos.add(new Monster("Angeles de la noche ibicenca",14,badConsequence2,prize2));
        
        BadConsequence badConsequence3 = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,
                                                             new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                                             new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize3 = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza",8,badConsequence3,prize3));
    }

    
}