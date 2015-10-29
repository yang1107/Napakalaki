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
        @text
  end

  def
    getLevels
      @levels
  end
  
  def
     getnVisibleTreasures
      @nVisibleTreasures
  end
  def
    getnHiddenTreasures
        @nHiddenTreasures
  end
  
  def
  getDeath
       @death
  end
  
  def
    getnSpecificVisibleTreasures
       @nSpecificVisibleTreasures
  end
  
  def
     getnSpecificHiddenTreasures
       @nSpecificHiddenTreasures
  end
  
  
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
      "Bad consequence: #{@text} \nPierdes: #{@levels} niveles."
    end
 
end
