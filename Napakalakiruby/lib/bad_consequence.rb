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
  
  def
    BadConsequence.newLevelNumberOfTreasures(aText,someLevels,someVisibleTreasures,someHiddenTreasures)
        text=aText
        levels=someLevels
        nVisibleTreasures=someVisibleTreasures
        nHiddenTreasures=someHiddenTreasures
  end
  
  def
    BadConsequence.newLevelSpecificTreasures(aText,someLevels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
        text=aText
        levels=someLevels
        nSpecificVisibleTreasures=someSpecificVisibleTreasures
        nSpecificHiddenTreasures=someSpecificHiddenTreasures
  end
  
  def
    BadConsequence.newDeath(aText)
      text=aText
  end
  
  private_class_method:new
  
  def
    to_s()
      "#{@text}\n nivel: #{@levels}\n tesoros visibles: #{@nVisibleTreasures}\n tesoros invisibles #{@nHiddenTreasures}\n tesoro visible especifico #{@nSpecificVisibleTreasures}\n tesoro invisible especifico: #{@nSpecificHiddenTreasures}"
  end
 
end
