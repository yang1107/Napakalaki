# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"
require_relative "monster.rb"
require_relative "treasure_kind.rb"
require_relative "prize.rb"
require_relative "treasure.rb"

class CardDealer
  include Singleton
  
  attr_accessor :unusedMonsters,:usedMonsters,:unusedTreasures,:usedTreasures

  
  def nextTreasure
    if(@unusedTreasures.empty?)
      @usedTreasures.each do |u|
        @unusedTreasures<<u
      end
      shuffleTreasures
      @usedTreasures.clear
    end
    
    aux=@unusedTreasures[0]
      @usedTreasures<<aux
      @unusedTreasures.delete(aux)
  end
   
  def nextMonster
    @unusedMonsters=Array.new
    @usedMonsters=Array.new
    if @unusedMonsters.empty?
      @usedMonsters.each do |u|
        @unusedMonsters<<u
      end
      shuffleMonsters
      @usedMonsters.clear
    end
    
    aux=@unusedMonsters[0]
      @usedMonsters<<aux
      @unusedMonsters.delete(aux)
  end
   
  def giveTreasureBack(t)
       @usedTreasures.add(t)
  end
   
  def giveMonsterBack( m)
       @usedMonsters.add(m)
  end
   
  def initCards
       initTreasuresCardDeck #1.3.1
       initMonsterCardDeck #1.3.2
  end
  
  
  private
  
  def initTreasureCardDeck
       @unusedTreasures << Treasure.new("Si mi amo", 4, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("Botas de investigacion", 3, TreasureKind::SHOES)
       @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
       @unusedTreasures << Treasure.new("Botas de lluvia acida", 1, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
       @unusedTreasures << Treasure.new("Claco de rail ferroviario", 3, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Fez alopodo", 3, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("Hacha prehistorica", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
       @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Escopeta de 3 caniones",4 , TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Garabato mistico", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("La rebeca metalica", 2, TreasureKind::ARMOR)
       @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Necro-comicon", 1, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Necronomicon", 5, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Necro-gnomicon", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Necro-playboycon", 3, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
       @unusedTreasures << Treasure.new("Tentaculo de pega", 2, TreasureKind::HELMET)
       @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
       @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHAND)
       @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
  end
   
  def initMonsterCardDeck
    
        prize1 = Prize.new(4,2)
        badConsequence1 = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        @unusedMonsters << Monster.new("el rey de rosa",13,prize1,badConsequence1)
        
        prize2 = Prize.new(4,1)
        badConsequence2 = BadConsequence.newLevelNumberOfTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
        @unusedMonsters<<Monster.new("Angeles de la noche ibicena",14,prize2,badConsequence2)
        
        prize3 = Prize.new(2,1)
        badConsequence3 = BadConsequence.newLevelNumberOfTreasures("Pierdes tu armadura visible y otra oculta",0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
        @unusedMonsters<<Monster.new("3 Byakhees de bonanza",8,prize3,badConsequence3)
        
        prize4=Prize.new(1,1)
        badConsequence4=BadConsequence.newLevelNumberOfTreasures("Embobados con el lindo primigenio te descartas de tu casco visible",0,[TreasureKind::HELMET],[])
        @unusedMonsters<<Monster.new("Chibithulhu",2,prize4,badConsequence4)
        
        prize5=Prize.new(1,1)
        badConsequence5=BadConsequence.newLevelNumberOfTreasures("El primordial bostezo contagioso. Pierdes el calzado visible",0,[TreasureKind::SHOES],[])
        @unusedMonsters<<Monster.new("El sopor de Dunwich",2,prize5,badConsequence5)
        
        prize6=Prize.new(3,1)
        badConsequence6=BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles",0,[TreasureKind::ARMOR,TreasureKind::HELMET,TreasureKind::SHOES,TreasureKind::ONEHAND,TreasureKind::BOTHHAND],[])
        @unusedMonsters<<Monster.new("H.P. Munchcraft",6,prize6,badConsequence6)
        
        prize7=Prize.new(1,1)
        badConsequence7=BadConsequence.newLevelNumberOfTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible",0,[TreasureKind::ARMOR],[])
        @unusedMonsters<<Monster.new("Bichgooth",2,prize7,badConsequence7)
        
        prize8=Prize.new(1,1)
        badConsequence8= BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",2,0,0);
        @unusedMonsters << Monster.new("La que redacta en las tinieblas",2,prize8,badConsequence8)
        
        prize9=Prize.new(2,1)
        badConsequence9=BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
        @unusedMonsters << Monster.new("Los hondos",8,prize9,badConsequence9)
        
        prize10=Prize.new(2,1)
        badConsequence10= BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        @unusedMonsters << Monster.new("Semillas Cthulhu",4,prize10,badConsequence10)
        
        prize11=Prize.new(2,1)
        badConsequence11=BadConsequence.newLevelNumberOfTreasures("Te intentas escaquear. Pierdes una mano visible",0,[TreasureKind::ONEHAND],[])
        @unusedMonsters<<Monster.new("Dameargo",1,prize11,badConsequence11)
        
        prize12=Prize.new(1,1)
        badConsequence12=BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles",3,0,0)
        @unusedMonsters<<Monster.new("Pollipolipo volante",3,prize12,badConsequence12)
        
        prize13=Prize.new(3,1)
        badConsequence13=BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
        @unusedMonsters << Monster.new("Yskhtihyssg-Goth",12,prize13,badConsequence13)
        
        prize14=Prize.new(4,1)
        badConsequence14=BadConsequence.newDeath("La familia te atrapa. Estas muerto")
        @unusedMonsters << Monster.new("Familia feliz",1,prize14,badConsequence14)
        
        prize15=Prize.new(2,1)
        badConsequence15=BadConsequence.newLevelNumberOfTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,[TreasureKind::BOTHHAND],[])
        @unusedMonsters<<Monster.new("Roboggoth",8,prize15,badConsequence15)
        
        prize16=Prize.new(1,1)
        badConsequence16=BadConsequence.newLevelNumberOfTreasures("Te asusta en la noche. Pierdes un casco visible",0,[TreasureKind::HELMET],[])
        @unusedMonsters<<Monster.new("El espia",5,prize16,badConsequence16)
        
        prize17=Prize.new(1,1)
        badConsequence17= BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        @unusedMonsters << Monster.new("El Lenguas",20,prize17,badConsequence17)
        
        prize18=Prize.new(1,1)
        badConsequence18=BadConsequence.newLevelNumberOfTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,[TreasureKind::BOTHHAND],[])
        @unusedMonsters<<Monster.new("Bicefalo",20,prize18,badConsequence18)
        
  end
   
  def shuffleTreasures
    @unusedTreasures.shuffle
  end
   
  def shuffleMonsters
    @unusedMonsters.shuffle
  end
  
end
