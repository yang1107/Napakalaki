# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
  
  attr_reader :name,:level,:dead,:canISteal,:enemy,:hiddenTreasures,:visibleTreasures,:pendingBadConsequence
  @@MAXLEVEL=10
  
  def initialize
    
  end
   
  def bringToLife
       @dead=false
  end
   
  def getCombatLevel
       
  end
   
  def incrementLevels(i)
      @level+=i
  end
   
  def decrementLevels(i)
       @level-=i
  end
   
  def setPendingBadConsequence(b)
      @pendingBadConsequence=b 
  end
   
  def applyPrize( m)
       
  end
   
  def canMakeTreasureVisible(t)
       
  end
    
  def howManyVisibleTreasures(tKind)
     i=0
     @visibleTreasure.each do |t|
       if(t.type==tKind)
         i=i+1
       end
     end
     return i
  end
   
  def dieIfNotTreasures
    if(@visibleTreasures.length==0&&@hiddenTreasures.length==0)
      dead=true
    end
  end
   
  def isDead
      return @dead
  end
   
  def combat
       
  end
   
  def makeTreasureVisible(t)
       
  end
   
  def discardVisibleTreasure( t)
       
  end
   
  def discardHiddenTreasure( t)
       
  end
   
  def validState
    res=false
    if(@pendingBadConsequence.isEmpty&&@hiddenTreasures.length<4)
      res=true
    end
    return res
  end
   
  def initTreasures
       
  end
   
  def stealTreasure
       
  end
   
   
  def setEnemy(e)
       @enemy=e
  end
   
  def giveMeATreasure
       
  end
   
  def canISteal
     @canISteal
  end
   
  def canYouGiveMeATreasure
       res=false
       if(@hiddenTreasures.length>0 && @visibleTreasures.length>0)
         res=true
       end
       res
  end
   
  def haveStolen
       @canISteal=false
  end
   
  def discardAllTreasures
       
  end
   
end
