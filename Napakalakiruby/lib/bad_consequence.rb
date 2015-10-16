# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  def 
    initialize( txt,  lvs,  nVsbl,  nHddn)
        text=txt
        levels=lvs
        nVisibleTreasures=nVsbl
        nHiddenTreasures=nHddn
  end
  
  def
     getText()
        return text;
  end

  def
    getLevels()
        return levels;
  end
  
  def
     getnVisibleTreasures()
        return nVisibleTreasures;
  end
  def
    getnHiddenTreasures()
        return nHiddenTreasures;
  end
  
  def
  getDeath()
        return death;
    
  end
end
