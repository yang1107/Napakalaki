# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"

class Napakalaki
  include Singleton
  
  attr_accesor:currentPlayer,:players,:dealer,:currentMonster
  
def initialize(cp,p,d,cm)
    @currentPlayer=cp
    @players=p
    @dealer=d
    @currentMonster=cm
  end
  
  def getInstance
    return Napakalaki.instance
  end
  
  private def initPlayers(names)
    @players=Array.new
    i=0
    while(i<names.size)
      @players<<Player.new(names[i])
      i=i+1
    end
  end
  
  private def nextPlayer
        if(@currentPlayer==nil)
          nextp=rand(@players.length)
         else
          indice=@players.index(@currentPlayer)
          if(indice==@players.length)
            nextp=@players[0]
            else
            nextp=@players[indice+1]
          end
       end
  end
    
  private def nextTurnAllowed
        @cumple=false
        if(@currentPlayer.validState)
          cumple=true
        end
        if(@currentPlayer==nil)
          cumple=true
        end
        return cumple
  end
    
  private def setEnemies
      i=0
      while(i<@players.length)
        numero=rand(@players.length)
        while(numero==i)
          numero=rand(@players.length)
        end
        @players[i].setEnemy(@players[numero])
      end
  end
    
  def developCombat
        
  end
    
  def discardVisibleTreasures( treasures)
        treasures.each do |t|
          @treasure=t.next #1.1
          @currentPlayer.discardVisibleTreasure(t) #1.2
          dealer.giveTreasureBack(t) #1.3
        end
  end
    
  def discardHiddenTreasures(treasures)
        treasures.each do |t|
          @treasure=t.next #1.1
          @currentPlayer.discardHiddenTreasure(t) #1.2
          dealer.giveTreasureBack(t) #1.3
        end
  end
    
  def makeTreasuresVisible( treasures)
        treasures.each do |tre|
          @t=tre.next #1.1
          @currentPlayer.makeTreasureVisible(t) #1.2
        end
  end
    
  def initGame( players)
        initPlayers(players) #1.1
        setEnemies #1.2
        nextTurn #1.4
        dealer.initCards #1.3
  end
    
  def getCurrentPlayer
        return @currentPlayer
  end
    
  def getCurrentMonster
        return @currentMonster
  end
    
  def nextTurn
        @stateOk=nextTurnAllowed #1.1
        
    if(stateOK)
      @currentMonster=dealer.nextMonster
      @currentPlayer=nextPlayer
      @dead=currentPlayer.isDead
      if(dead)
        @currentPlayer.initTreasures
      end
    end
    return @stateOK
  end
    
  def endOfGame( result)
        res=false
        if(result==[CombatResult::WINGAME])
          res=true
        end
        return res
  end
  
end
