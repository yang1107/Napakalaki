# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "prize.rb"
require_relative "bad_consequence.rb"
require_relative "monster.rb"

monsters=Array.new
def elreyderosa
  prize=Prize.new(4,2)
  badConsequence=BadConsequence.newLevelNumberOfTreasures("pierdes 5 niveles y 3tesoros vidibles",5,3,0)
  m1=Monster.new("el rey de rosa",13,prize,badConsequence)
  puts m1
  
  #monsters << Monster.new("el rey de rosa",13,prize,badConsequence)
  
end

elreyderosa

#puts monsters[1].to_s

