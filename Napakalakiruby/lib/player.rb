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
   
  
  def isDead
      return @dead
  end
   
  def combat
       
  end
   
  def makeTreasureVisible(t)
       @canI=canMakeTreasureVisible(t) #1.2.1
       if(canI)
         @visibleTreasures<<t #1.2.2
         @hiddenTreasures.delete(t) #1.2.3
       end
  end 
   
  def discardVisibleTreasure( t)
    @visibleTreasures.delete(t) #1.2.1
    if((@pendingBadConsequence!=nil)&&(!@pendingBadConsequence.isEmpty)) 
      @pendingBadConsequence.substractVisibleTreasure(t)  #1.2.2
    end
    dieIfNoTreasures   #1.2.3
  end
   
  def discardHiddenTreasure( t)
      @hiddenTreasures.delete(t) #1.2.1
    if((@pendingBadConsequence!=nil)&&(!@pendingBadConsequence.isEmpty)) 
      @pendingBadConsequence.substractHiddenTreasure(t)  #1.2.2
    end
    dieIfNoTreasures   #1.2.3
  end
   
  def validState
    res=false
    if(@pendingBadConsequence.isEmpty&&@hiddenTreasures.length<4)
      res=true
    end
    return res
  end
   
  def initTreasures
    @dealer=CardDealer.getInstance #1
    @dice=Dice.getInstance #2
    bringToLife #3
    @treasure=dealer.nextTreasure #4
    @hiddenTreasures<<treasure #5
    @number=dice.nextNumber #6
    
    if(Number>1)
      treasure=dealer.nextTreasure #7
      @hiddenTreasures<<treasure #8
    end
    
    if(Number==6)
      treasure=dealer.nextTreasure #9
      @hiddenTreasures<<treasure #10
    end
  end
   
  def stealTreasure
    @treasure=nil
    @canI=canISteal
    if(canI)
      @canYou=@enemy.canYouGiveMeATreasure
      if(canYou)
        treasure=enemy.giveMeATreasure
        @hiddenTreasures<<treasure
        haveStolen
      end
    end
    return treasure
  end
   
   
  def setEnemy(e)
       @enemy=e
  end
   
 def canISteal
     @canISteal
  end
   

   
  def discardAllTreasures
       @visibleTreasures.each do |vt|
         @treasure=@visibleTreasures.next #1.1
         discardVisibleTreasure(treasure) #1.2
       end
       
    @hiddenTreasures.each do |ht|
      @treasure=@hiddenTreasures.next #1.3
      discardHiddenTreasure(treasure) #1.4
    end
  end
    
  private
  
  def bringToLife
       @dead=false
  end
   
def  getCombatLevel
     lv=@level
     visibleTreasures.each {|t| lv+=t.bonus}
     return lv
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
   @nLevels=m.getLevelsGained
   incrementLevels(nLevels)
   @nTreasures=m.getTreasuresGained
   if(nTreasures>0)
     dealer=CardDealer.getInstance
     
     nTreasures.times do
       @treasure=dealer.nextTreasure
       @hiddenTreasures<<treasure
     end
   end
  end
  
 def applyBadConsequence(b)
   @badConsequence=m.getBadConsequence #1
   @nLevels=badConsequence.getLevels #2
   decrementLevels(nLevels) #3
   @pendingBadConsequence=badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)#4
   setPendingBadConsequence(pendingBadConsequence) #5
 end
   
def canMakeTreasureVisible(t)
       res=true
       if(t.type!=[TreasureKind::ONEHAND])
         @visibleTreasures.each do |tre|
           if(t.type==tre.type)
             res=false
           end
         end
       else
         i=0
         @visibleTreasures.each do |tre|
           if(tre.type==[TreasureKind::ONEHAND])
             i=i+1
           end
         end
         if(i==2)
           res=false
         end
       end
  end
    
 def howManyVisibleTreasures(tKind)
     i=0
     @visibleTreasures.each {|t| if t.type ==tkind then i=il+1   end}
     return i
  end
   
 def dieIfNotTreasures
    if(@visibleTreasures.length==0&&@hiddenTreasures.length==0)
      dead=true
    end
  end
  
 def giveMeATreasure
   indice=rand(@hiddenTreasures.length)
   return @hiddenTreasures[indice]
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
end
