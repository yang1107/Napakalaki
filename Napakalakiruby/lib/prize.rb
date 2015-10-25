# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Prize
   
  def initialize( trs,  lv)
    @treaures=trs
    @level=lv
  end
 
  def
    getTreasures
       @treasures
  end
  
  def
    getLevel
      @level
  end
  
  def
    to_s
    "Tesoros Ganados:#{@treasures}\n Niveles ganados :#{@level}\n"
  end
end
