# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Dice
  #include singleton
  
  def initialize
    
  end
  
  def nextNumber
    @a
    a=1+rand(6)
    a
  end
  
  puts nextNumber
end
