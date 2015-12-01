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
 
    def isEmpty
      empty=false
      if(@levels==0&&@death==false&&@nHiddenTreasures==0&&nVisibleTreasures==0
          @nSpecificHiddenTreasures.length==0&&@nSpecificVisibleTreasures.length==0)
        empty=true
      end
      return empty
    end
    
    def substractVisibleTreasure(t)
      if(@nVisibleTreasures>0)
        @nVisibleTreasures=@nVisibleTreasures-1
      end
      if(@nVisibleTreasures==0)
        @nSpecificVisibleTreasures.remove(t.type)
      end
    end
    
    def substractHiddenTreasure(t)
      if(@nHiddenTreasures>0)
        @nHiddenTreasures=@nHiddenTreasures-1
      end
      if(@nHiddenTreasures==0)
        @nSpecificHiddenTreasures.remove(t.type)
      end
    end
    
    def adjustToFitTreasureLists(v,h)
        t_visible = Array.new
        t_hidden = Array.new
        
       
        v.each do |t|
           
            if t_visible.index(t.type) == nil then
                t_visible << t.type
            end
        end
        
      
        h.each do |t|
        
            if t_hidden.index(t.type) == nil then
                t_hidden << t.type
            end
        end

         bs = BadConsequence.newLevelSpecificTreasures(@text, 0, t_visible, t_hidden)

        return bs
    end
    
    
    
end
