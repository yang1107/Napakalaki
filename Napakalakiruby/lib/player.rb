# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
  
  attr_reader :name,:level,:dead,:canISteal,:enemy,:visibleTreasures,:hiddenTreasures,:pendingBadConsequence
  @@MAXLEVEL=10
  
  def initialize(nm)
    @name=nm
    @level=1
    @visibleTreasures=Array.new 
    @hiddenTreasures=Array.new
  end
   
private def bringToLife
       @dead=false
  end
   
private def  getCombatLevel
     lv=@level
     visibleTreasures.each {|t| lv+=t.bonus}
     hiddenTreasures.each {|t| lv+=t.bonus}

     return lv
  end
   
private def incrementLevels(i)
      @level+=i
  end
   
private def decrementLevels(i)
       @level-=i
  end
   
private def setPendingBadConsequence(b)
      @pendingBadConsequence=b 
  end
   
private def applyPrize( m)
       
  end
   
private def canMakeTreasureVisible(t)
       
  end
    
private def howManyVisibleTreasures(tKind)
     i=0
     @visibleTreasures.each {|t| if t.type ==tkind then i=il+1   end}
     return i
  end
   
private def dieIfNotTreasures
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
   
  private def giveMeATreasure
       
  end
   
 def canISteal
     @canISteal
  end
   
 private def canYouGiveMeATreasure
       res=false
       if(@hiddenTreasures.length>0 && @visibleTreasures.length>0)
         res=true
       end
       res
  end
   
private def haveStolen
       @canISteal=false
  end
   
  def discardAllTreasures
       
  end
    
end
