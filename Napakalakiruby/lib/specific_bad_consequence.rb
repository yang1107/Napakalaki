# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "bad_consequence.rb"
class SpecificBadConsequence<BadConsequence
  attr_accessor:nSpecificVisibleTreasures,:nSpecificHiddenTreasures
  
  def initialize(txt,lv,nsv,nsh)
    @text=txt
    @levels=lv
    @nSpecificVisibleTreasures=nsv
    @nSpecificHiddenTreasures=nsh
  end
  
  def isEmpty
      empty=false
      if(@levels==0&&@nSpecificHiddenTreasures.length==0&&@nSpecificVisibleTreasures.length==0)
        empty=true
      end
      return empty
    end
  
  def substractVisibleTreasure(t)
      if !@nSpecificVisibleTreasures.empty? or @nSpecificVisibleTreasures != nil
                if @nSpecificVisibleTreasures.include?(t.type)
                    @nSpecificVisibleTreasures.delete(t.type)
                end
            end
    end
    
    def substractHiddenTreasure(t)
    if (!@nSpecificHiddenTreasures.empty? or @nSpecificHiddenTreasures != nil)
                if (@nSpecificHiddenTreasures.include?(t.type))
                    @nSpecificHiddenTreasures.delete(t.type)
                end
            end
    end
end
