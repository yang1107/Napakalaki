# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  def 
    initialize( atext,  someLevels,  someVisibleTreasures,  someHiddenTreasures, someSpecificVisibleTreasures ,someSpecificHiddenTreasures,dh)
        @text=atext
        @levels=someLevels
        @nVisibleTreasures=someVisibleTreasures
        @nHiddenTreasures=someHiddenTreasures
        @nSpecificVisibleTreasures=someSpecificVisibleTreasures
        @nSpecificHiddenTreasures=someSpecificHiddenTreasures
        @death=dh
        
  end
  

  def
     getText
        @text;
  end

  def
    getLevels
      @levels;
  end
  
  def
     getnVisibleTreasures
      @nVisibleTreasures;
  end
  def
    getnHiddenTreasures
        @nHiddenTreasures;
  end
  
  def
  getDeath()
        return death;
    
  end
  
#  def
#    BadConsequence.newLevelNumberOfTreasures(aText,someLevels,someVisibleTreasures,someHiddenTreasures)
#        text=aText
#        levels=someLevels
#        nVisibleTreasures=someVisibleTreasures
#        nHiddenTreasures=someHiddenTreasures
#  end
#  
#  def
#    BadConsequence.newLevelSpecificTreasures(aText,someLevels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
#        text=aText
#        levels=someLevels
#        nSpecificVisibleTreasures=someSpecificVisibleTreasures
#        nSpecificHiddenTreasures=someSpecificHiddenTreasures
#  end
#  
#  def
#    BadConsequence.newDeath(aText)
#      text=aText
#  end
  
  
   def
    BadConsequence.newLevelNumberOfTreasures(aText,someLevels,someVisibleTreasures,someHiddenTreasures)
        new(aText, someLevels, someVisibleTreasures, someHiddenTreasures,0,0,false)
  end
  
  def
    BadConsequence.newLevelSpecificTreasures(aText,someLevels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
       new(aText,someLevels,0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures,false)
  end
  
  def
    BadConsequence.newDeath(aText)
     new(aText, 0, 0, 0, Array.new, Array.new, true)
  end
  
  
  private_class_method:new
  

    def to_s
      " Bad consequence: #{@text} \n Pierdes: #{@levels} niveles."
    end
 
end
