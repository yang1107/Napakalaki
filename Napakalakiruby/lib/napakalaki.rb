# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require "singleton"
require_relative "player.rb"
require_relative "card_dealer.rb"
require_relative "combat_result.rb"
require_relative "prize.rb"
require_relative "bad_consequence.rb"

class Napakalaki
  include Singleton
  
  attr_accessor:currentPlayer,:players,:dealer,:currentMonster
  
    
  def developCombat
    @result=@currentPlayer.combat(@currentMonster) #1.1
    @dealer.giveMonsterBack(@currentMonster)   #1.2
    
    return @result
  end
    
  def discardVisibleTreasures( treasures)
        treasures.each do |t|
          @currentPlayer.discardVisibleTreasures(t) #1.2
          dealer.giveTreasureBack(t) #1.3
        end
  end
    
  def discardHiddenTreasures(treasures)
        treasures.each do |t|
          @currentPlayer.discardHiddenTreasures(t) #1.2
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
        CardDealer.instance.initCards #1.3
        nextTurn #1.4
        
  end
    
  def getCurrentPlayer
        return @currentPlayer
  end
    
  def getCurrentMonster
        return @currentMonster
  end
    
  def nextTurn
        stateOK=nextTurnAllowed #1.1
        
    if stateOK then
      @currentMonster=dealer.nextMonster
      @currentPlayer=nextPlayer
      @dead=@currentPlayer.isDead
      if @dead then
        @currentPlayer.initTreasures
      end
    end
    return stateOK
  end
    
  def endOfGame( result)
        res=false
        if(result==[CombatResult::WINGAME])
          res=true
        end
        return res
  end
  
  
  private
  
  def initPlayers(names)
    @dealer=CardDealer.instance
    @players=Array.new
    
     names.each do |nm|
      players<<Player.new(nm)
    end
  end
  
  def nextPlayer
        if(@currentPlayer==nil)
          nextp=@players.at(rand(@players.length-1))
         else
          indice=@players.index(@currentPlayer)
          if(indice==@players.length-1)
            nextp=@players[0]
            else
            nextp=@players[indice+1]
          end
       end
       @currentPlayer=nextp
       return @currentPlayer
  end
    
  def nextTurnAllowed
        @allowed=false
        if @current_player == nil then
            allowed = true 
        else
            allowed = @currentPlayer.validState #1.1.1
        end
        return allowed
  end
    
  def setEnemies
      i=0
      while(i<@players.length)
        numero=rand(@players.length)
        while(numero==i)
          numero=rand(@players.length)
        end
        @players[i].setEnemy(@players[numero])
        i=i+1
      end
  end
  
end
