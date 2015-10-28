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
    getName()
        return name;
    end
    def
    getCombatLevel()
        return combatLevel;
    end

    
    def
      to_s()
      "#{@name}\n nivel de combate: #{@combatLevel}\n #{@bc}\n  #{@price}"
    end
end
