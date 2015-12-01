/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chen__000
 */
public class PruebaNapakalaki {

   static void filtro_niveles10( ArrayList<Monster> Array){
        for(int i=0;i<Array.size();i++){
             if(Array.get(i).getCombatLevel()>10)
                 System.out.println(Array.get(i));
                  System.out.println(" ");
        }
    }
   
   static void filtro_bc_pierde_nivel(ArrayList<Monster> Array){
       for(int i=0;i<Array.size();i++){
          if(Array.get(i).bc.getSpecificHiddenTreasures().size()==0&&Array.get(i).bc.getSpecificVisibleTreasures().size()==0&&Array.get(i).bc.getnHiddenTreasures()==0 && Array.get(i).bc.getnVisibleTreasures()==0 && Array.get(i).bc.getLevels()!=0 ){
                  System.out.println(Array.get(i));
                  System.out.println(" ");
           }
       }
   }
   
   
   static void filtro_gana_nivel(ArrayList<Monster> Array){
       for(int i=0;i<Array.size();i++){
          if(Array.get(i).price.getLevel()>1){
              System.out.println(Array.get(i));
              System.out.println(" ");
          }
       }
   }
   
      static void filtro_bc_pierde_tesoros(ArrayList<Monster> Array){
       for(int i=0;i<Array.size();i++){
          if(Array.get(i).bc.getSpecificHiddenTreasures().size()!=0 || Array.get(i).bc.getSpecificVisibleTreasures().size()!=0||Array.get(i).bc.getnHiddenTreasures()!=0 || Array.get(i).bc.getnVisibleTreasures()!=0  ){
                  System.out.println(Array.get(i));
                  System.out.println(" ");
           }
       }
   }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Monster> monstruos = new ArrayList();
        
        //creacion de monstruos
        
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
    
        BadConsequence badConsequence4 = new BadConsequence ("Embobados con el lindo primigenio te descarta de tu casco visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize4 = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu",2,badConsequence4,prize4));
    
       BadConsequence badConsequence5 = new BadConsequence ("El primordial bostezo contagioso, pierdes el calzado visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.SHOES))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2,badConsequence5,prize5));
    
       BadConsequence badConsequence6 = new BadConsequence ("Pierdes todos los tesoros visibles",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.BOTHHANDS,TreasureKind.HELMET,TreasureKind.ONEHAND,TreasureKind.SHOES))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(3,1);
        monstruos.add(new Monster("El gorron en el umbral",10,badConsequence6,prize6));
    
        BadConsequence badConsequence7 = new BadConsequence ("Pierdes la armadura visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize7 = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft",6,badConsequence7,prize7));
    
        BadConsequence badConsequence8 = new BadConsequence ("Sientes bichos bajo la ropa. Descarta la armadura visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize8 = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth",2,badConsequence8,prize8));
    
        BadConsequence badConsequence9 = new BadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        Prize prize9 = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas",2,badConsequence9,prize9));
        
        BadConsequence badConsequence10 = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",true);
        Prize prize10 = new Prize(2,1);
        monstruos.add(new Monster("Los Hondos",8,badConsequence10,prize10));
        
        BadConsequence badConsequence11 = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        Prize prize11 = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu",4,badConsequence11,prize11));
        
        BadConsequence badConsequence12 = new BadConsequence ("Te intentas escaquear. Pierdes una mano visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(2,1);
        monstruos.add(new Monster("Dameargo",1,badConsequence12,prize12));
        
        BadConsequence badConsequence13 = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        Prize prize13 = new Prize(1,1);
        monstruos.add(new Monster("Pollipolipo volante",3,badConsequence13,prize13));
        
        BadConsequence badConsequence14 = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",true);
        Prize prize14 = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth",12,badConsequence14,prize14));
        
        BadConsequence badConsequence15 = new BadConsequence("La familia te atrapa. Estas muerto",true);
        Prize prize15 = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz",1,badConsequence15,prize15));
        
       BadConsequence badConsequence16 = new BadConsequence ("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2
                                                                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth",8,badConsequence16,prize16));
        
        BadConsequence badConsequence17 = new BadConsequence ("Te asusta en la noche. Pierdes un casco visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize17 = new Prize(1,1);
        monstruos.add(new Monster("El espia",5,badConsequence17,prize17));
        
        BadConsequence badConsequence18 = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize prize18 = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas",20,badConsequence18,prize18));
        
        BadConsequence badConsequence19 = new BadConsequence ("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3
                                                                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize19 = new Prize(1,1);
        monstruos.add(new Monster("Bicefalo",20,badConsequence19,prize19));
        

        
        //comprobaciones

//        Monster m1;
//        BadConsequence badConsequence20 = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
//                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
//                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
//        Prize prize20 = new Prize(4,1);
//        m1=new Monster("Angeles de la noche ibicenca",14,badConsequence20,prize20);
//        System.out.println(m1);
//        
        
        //filtro_niveles10(monstruos);
        
         //filtro_bc_pierde_nivel(monstruos);

      // filtro_gana_nivel(monstruos);
        
      // filtro_bc_pierde_tesoros(monstruos);
       
     
  
    }
        
}