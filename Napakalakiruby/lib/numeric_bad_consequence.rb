# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "bad_consequence.rb"

class NumericBadConsequence<BadConsequence
  attr_accessor:nVisibleTreasures,:nHiddenTreasures
  
  def initialize(txt,lv,nv,nh)
    @text=txt
    @levels=lv
    @nVisibleTreasures=nv
    @nHiddenTreasures=nh
  end
  
  def isEmpty
    empty=false
      if(@levels==0&&@nHiddenTreasures==0&&@nVisibleTreasures==0)
        empty=true
      end
      return empty
  end
  
      def substractVisibleTreasure(t)
      if(@nVisibleTreasures>0)
        @nVisibleTreasures=@nVisibleTreasures-1
      end
    end
    
    def substractHiddenTreasure(t)
      if(@nHiddenTreasures>0)
        @nHiddenTreasures=@nHiddenTreasures-1
      end
    end
end
