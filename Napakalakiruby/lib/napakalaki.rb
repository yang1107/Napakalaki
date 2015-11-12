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
  
  private def getInstance
    return Napakalaki.instance
  end
  
  private def initPlayers(names)
    
  end
  
  private def nextPlayer
        
  end
    
  private def nextTurnAllowed
        
  end
    
  private def setEnemies
        
  end
    
  def developCombat
        
  end
    
  def discardVisibleTreasures( treasures)
        
  end
    
  def discardHiddenTreasures(treasures)
        
  end
    
  def makeTreasuresVisible( treasures)
        
  end
    
  def initGame( players)
        
  end
    
  def getCurrentPlayer
        
  end
    
  def getCurrentMonster
        
  end
    
  def nextTurn
        
  end
    
  def endOfGame( result)
        
  end
  
end
