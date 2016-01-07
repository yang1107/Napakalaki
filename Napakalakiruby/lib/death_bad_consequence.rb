# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "bad_consequence.rb"
require_relative "numeric_bad_consequence.rb"

class DeathBadConsequence<NumericBadConsequence
  attr_accessor:death
  
  def initialize(txt,lv,nv,nh,dth)
    super(txt,lv,nv,nh)
    @death=dth
  end
end
