/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chen__000
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Cultist> unusedCultists;
     private ArrayList<Cultist> usedCultists;
    
    
    private CardDealer() {
    }
    
    public static CardDealer getInstance() {
        if(instance==null){
            instance=new CardDealer();
        }
        return instance;
    }
    
      
     
   private void initTreasureCardDeck(){
       this.unusedTreasures=new ArrayList();
       this.usedTreasures=new ArrayList();

       unusedTreasures.add(new Treasure("si mi amo",4,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOES));
       unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
       unusedTreasures.add(new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR));
       unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Fez alopodo",3,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
       unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Carabato mistico",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("La rebeca metalica",2,TreasureKind.ARMOR));
       unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Necro-comicon",1,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Linterna 2 manos",3,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Necro-gnomicon",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("necrotelecom",2,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("porra preternatural",2,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
       unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
       unusedTreasures.add(new Treasure("Tentaculo de pega",2,TreasureKind.HELMET));
       unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));
   }
   
   private void initMonsterCardDeck(){
        this.unusedMonsters=new ArrayList();
        this.usedMonsters=new ArrayList();
        
        NumericBadConsequence badConsequence1 = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        Prize prize1 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa",13,badConsequence1,prize1));
        
        SpecificBadConsequence badConsequence2 = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                                                             new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize2 = new Prize(4,1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca",14,badConsequence2,prize2));
        
        SpecificBadConsequence badConsequence3 = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0,
                                                             new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                                                             new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize3 = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,badConsequence3,prize3));
    
        SpecificBadConsequence badConsequence4 = new SpecificBadConsequence ("Embobados con el lindo primigenio te descarta de tu casco visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize4 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu",2,badConsequence4,prize4));
    
       SpecificBadConsequence badConsequence5 = new SpecificBadConsequence ("El primordial bostezo contagioso, pierdes el calzado visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.SHOES))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize5 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,badConsequence5,prize5));
    
       SpecificBadConsequence badConsequence6 = new SpecificBadConsequence ("Pierdes todos los tesoros visibles",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.BOTHHANDS,TreasureKind.HELMET,TreasureKind.ONEHAND,TreasureKind.SHOES))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize6 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorron en el umbral",10,badConsequence6,prize6));
    
        SpecificBadConsequence badConsequence7 = new SpecificBadConsequence ("Pierdes la armadura visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize7 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6,badConsequence7,prize7));
    
        SpecificBadConsequence badConsequence8 = new SpecificBadConsequence ("Sientes bichos bajo la ropa. Descarta la armadura visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ARMOR))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize8 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2,badConsequence8,prize8));
    
        NumericBadConsequence badConsequence9 = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        Prize prize9 = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,badConsequence9,prize9));
        
        DeathBadConsequence badConsequence10 = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto",0,0,0,true);
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los Hondos",8,badConsequence10,prize10));
        
        NumericBadConsequence badConsequence11 = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu",4,badConsequence11,prize11));
        
        SpecificBadConsequence badConsequence12 = new SpecificBadConsequence ("Te intentas escaquear. Pierdes una mano visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo",1,badConsequence12,prize12));
        
        NumericBadConsequence badConsequence13 = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        Prize prize13 = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipolipo volante",3,badConsequence13,prize13));
        
        DeathBadConsequence badConsequence14 = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto",0,0,0,true);
        Prize prize14 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12,badConsequence14,prize14));
        
        DeathBadConsequence badConsequence15 = new DeathBadConsequence("La familia te atrapa. Estas muerto",0,0,0,true);
        Prize prize15 = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz",1,badConsequence15,prize15));
        
       SpecificBadConsequence badConsequence16 = new SpecificBadConsequence ("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2
                                                                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,badConsequence16,prize16));
        
        SpecificBadConsequence badConsequence17 = new SpecificBadConsequence ("Te asusta en la noche. Pierdes un casco visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.HELMET))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia",5,badConsequence17,prize17));
        
        NumericBadConsequence badConsequence18 = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        Prize prize18 = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas",20,badConsequence18,prize18));
        
        SpecificBadConsequence badConsequence19 = new SpecificBadConsequence ("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3
                                                                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize19 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicefalo",20,badConsequence19,prize19));
        
        
        //monstruos con sectarios
        
         SpecificBadConsequence badConsequence = new SpecificBadConsequence ("Pierdes 1 mano visible",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.ONEHAND))
                                                                ,new ArrayList(Arrays.asList()));
        Prize prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,badConsequence,prize,-2));
        
          
       NumericBadConsequence NbadConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Ja ja ja", 0, 
                Integer.MAX_VALUE, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6,  NbadConsequence,prize, +2));
          
        DeathBadConsequence DbadConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres",0,0,0,true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu",20,DbadConsequence,prize,+4));
        
        NbadConsequence = new NumericBadConsequence ("Tu gobierno te recorta 2 niveles",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico",8,NbadConsequence,prize,-2));
        
         badConsequence = new SpecificBadConsequence ("Pierdes tu casco y tu armadura visible.Pierdes tus manos ocultas",0
                                                                ,new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR))
                                                                ,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth",2,badConsequence,prize,+5));
        
        NbadConsequence = new NumericBadConsequence ("Pierdes 2 niveles",2,0,0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggth",16,NbadConsequence,prize,-4));
        
        NbadConsequence = new NumericBadConsequence ("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolotagooth",8,NbadConsequence,prize,+3));
        
        
   }
   
   private void shuffleTreasures(){
       Collections.shuffle(unusedTreasures);
   }
   
   private void shuffleMonsters(){
       Collections.shuffle(unusedMonsters);
   }
   public Treasure nextTreasure(){
       if(this.unusedTreasures.size()==0){
          for(int i=0;i<this.usedTreasures.size();i++){
               this.unusedTreasures.add(this.usedTreasures.get(i));
           }
           this.usedTreasures.clear();
           this.shuffleTreasures();
       }
           Treasure aux;
           aux=this.unusedTreasures.get(0);
           this.usedTreasures.add(aux);
           this.unusedTreasures.remove(0);
           return aux;
   }
   
   public Monster nextMonster(){
       if(this.unusedMonsters.isEmpty()){
          for(int i=0;i<this.usedMonsters.size();i++){
               this.unusedMonsters.add(this.usedMonsters.get(i));
           }
           this.usedMonsters.clear();
           this.shuffleMonsters();
       }
           Monster aux;
           aux=this.unusedMonsters.get(0);
           this.usedMonsters.add(aux);
           this.unusedMonsters.remove(0);
           return aux;
   }
   
   public void giveTreasureBack(Treasure t){
       usedTreasures.add(t);
   }
   
   public void giveMonsterBack(Monster m){
       usedMonsters.add(m);
   }
   
   public void initCards(){
       this.initTreasureCardDeck();  //1.3.1
       this.shuffleTreasures();
       this.initMonsterCardDeck();  //1.3.2
       this.shuffleMonsters();
       this.initCultistCardDeck();
   }
   
   
   private void shuffleCultists(){
       Collections.shuffle(unusedCultists);
   }
   
   private void initCultistCardDeck(){
       this.unusedCultists=new ArrayList();
       this.usedCultists=new ArrayList();
       
        unusedCultists.add(new Cultist("Sectario : +1 por cada sectario en juego.\n No puedes dejar de ser sectario",1));
        unusedCultists.add(new Cultist("Sectario : +2 por cada sectario en juego.\n No puedes dejar de ser sectario",2));
        unusedCultists.add(new Cultist("Sectario : +1 por cada sectario en juego.\n No puedes dejar de ser sectario",1));
        unusedCultists.add(new Cultist("Sectario : +2 por cada sectario en juego.\n No puedes dejar de ser sectario",2));
        unusedCultists.add(new Cultist("Sectario : +1 por cada sectario en juego.\n No puedes dejar de ser sectario",1));
        unusedCultists.add(new Cultist("Sectario : +1 por cada sectario en juego.\n No puedes dejar de ser sectario",1));
        this.shuffleCultists();
   }
   
   public Cultist nextCultist(){
       if(this.unusedCultists.size()==0){
          for(int i=0;i<this.usedCultists.size();i++){
               this.unusedCultists.add(this.usedCultists.get(i));
           }
           this.usedCultists.clear();
           this.shuffleCultists();
       }
           Cultist aux;
           aux=this.unusedCultists.get(0);
           this.usedCultists.add(aux);
           this.unusedCultists.remove(0);
           return aux;
   }
   
}
