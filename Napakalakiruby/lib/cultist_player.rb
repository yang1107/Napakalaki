# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "cultist.rb"

class CultistPlayer<player
  
  attr_accessor:myCultistCard,:totalCultistPlayers
  
  def initialize(p,c)
    consCopia(p)
    @myCultistCard=c
    @@totalCultistPlayers+=1
  end
  
  def getCombatLevel
    plv=super
    percent=plv*20/100
    clv=myCultistCard.getGainedLevels*@@totalCultistPlayers
    lv=plv+percent+clv
    return lv
  end
  
  def getOponentLevel(m)
    return m.getCombatLevelAgainstCultistPlayer
  end
  
  def shouldConvert
    return false
  end
  
  def giveMeATreasure
    indice=rand(@visibleTreasures.length)
    return @visibleTreasures[indice]
  end
  
  def canYouGiveMeATreasure
     res=false
       if(@visibleTreasures.length>0)
         res=true
       end
       res
  end
end
