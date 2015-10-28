# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "prize.rb"
require_relative "bad_consequence.rb"
require_relative "monster.rb"

monsters=Array.new
       
#        prize1 = Prize.new(4,2)
#        badConsequence1 = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
#        monsters << Monster.new("el rey de rosa",13,prize1,badConsequence1)
#        
#        prize2 = Prize.new(4,1)
#        badConsequence2 = BadConsequence.newLevelNumberOfTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
#        monsters<<monster.new("Angeles de la noche ibicena",14,prize2,badConsequence2)
#        
#        prize3 = Prize.new(2,1)
#        badConsequence3 = BadConsequence.newLevelNumberOfTreasures("Pierdes tu armadura visible y otra oculta",0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
#        monsters<<monster.new("3 Byakhees de bonanza",8,prize3,badConsequence3)
#        
#        prize4=Prize.new(1,1)
#        badConsequence4=BadConsequence.newLevelNumbreOfTreasures("Embobados con el lindo primigenio te descartas de tu casco visible",0,[TreasureKind::HELMET],[])
#        monsters<<monster.new("Chibithulhu",2,prize4,badConsequence4)
#        
#        prize5=Prize.new(1,1)
#        badConsequence5=BadConsequence.newLevelNumbreOfTreasures("El primordial bostezo contagioso. Pierdes el calzado visible",0,[TreasureKind::SHOES],[])
#        monsters<<monster.new("El sopor de Dunwich",2,prize5,badConsequence5)
#        
#        prize6=Prize.new(3,1)
#        badConsequence6=BadConsequence.newLevelNumbreOfTreasures("Pierdes todos tus tesoros visibles",0,[TreasureKind::ARMOR::BOTHHAND::HELMET::ONEHAND::SHOES],[])
#        monsters<<monster.new("H.P. Munchcraft",6,prize6,badConsequence6)
#        
#        prize7=Prize.new(1,1)
#        badConsequence7=BadConsequence.newLevelNumbreOfTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible",0,[TreasureKind::ARMOR],[])
#        monsters<<monster.new("Bichgooth",2,prize7,badConsequence7)
#        
#        prize8=Prize.new(1,1)
#        badConsequence8= BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",2,0,0);
#        monsters << Monster.new("La que redacta en las tinieblas",2,prize8,badConsequence8)
#        
#        prize9=Prize.new(2,1)
#        badConsequence9=BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto")
#        monsters << Monster.new("Los hondos",8,prize9,badConsequence9)
#        
#        prize10=Prize.new(2,1)
#        badConsequence10= BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
#        monsters << Monster.new("Semillas Cthulhu",4,prize10,badConsequence10)
#        
#        prize11=Prize.new(2,1)
#        badConsequence11=BadConsequence.newLevelNumbreOfTreasures("Te intentas escaquear. Pierdes una mano visible",0,[TreasureKind::ONEHAND],[])
#        monsters<<monster.new("Dameargo",1,prize11,badConsequence11)
#        
#        prize12=Prize.new(1,1)
#        badConsequence12=BadConsequence.newLevelNumbreOfTreasures("Da mucho asquito. Pierdes 3 niveles",3,[],[])
#        monsters<<monster.new("Pollipolipo volante",3,prize12,badConsequence12)
#        
#        prize13=Prize.new(3,1)
#        badConsequence13=BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto")
#        monsters << Monster.new("Yskhtihyssg-Goth",12,prize13,badConsequence13)
#        
#        prize14=Prize.new(4,1)
#        badConsequence14=BadConsequence.newDeath("La familia te atrapa. Estas muerto")
#        monsters << Monster.new("Familia feliz",1,prize14,badConsequence14)
#        
#        prize15=Prize.new(2,1)
#        badConsequence15=BadConsequence.newLevelNumbreOfTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles",2,[TreasureKind::BOTHHAND],[])
#        monsters<<monster.new("Roboggoth",8,prize15,badConsequence15)
#        
#        prize16=Prize.new(1,1)
#        badConsequence16=BadConsequence.newLevelNumbreOfTreasures("Te asusta en la noche. Pierdes un casco visible",0,[TreasureKind::HELMET],[])
#        monsters<<monster.new("El espia",5,prize16,badConsequence16)
#        
#        prize17=Prize.new(1,1)
#        badConsequence17= BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
#        monsters << Monster.new("El Lenguas",20,prize17,badConsequence17)
#        
#        prize18=Prize.new(1,1)
#        badConsequence18=BadConsequence.newLevelNumbreOfTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,[TreasureKind::BOTHHAND],[])
#        monsters<<monster.new("Bicefalo",20,prize18,badConsequence18)
        


 prize17=Prize.new(1,1)
        badConsequence17= BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
      
m1=  Monster.new("El Lenguas",20,prize17,badConsequence17)
puts m1