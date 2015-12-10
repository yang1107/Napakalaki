# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
  def
    initialize( nm,  lv,prc,  badconseq)
        @name=nm;
        @combatLevel=lv;
        @bc=badconseq;
        @price=prc;
  end

  
    def
    getName
        @name
    end
    def
    getBadConsequence
        @bc
    end

    def
    getPrice
        @price
    end
    
    def
    getCombatLevel
        @combatLevel
    end
    
    def
      to_s()
      "#{@name}\nnivel de combate: #{@combatLevel}\n#{@bc}\n#{@price}"
    end
    
    def getLevelsGained()
      return @price.getLevel
    end
    
    def getTreasuresGained
      return @price.getTreasures
    end
end
