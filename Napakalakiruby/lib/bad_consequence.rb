# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  
  attr_accessor:text,:levels
  @@MAXTREASURE=10
  
#  def 
#    initialize( atext,  someLevels)
#        @text=atext
#        @levels=someLevels
#        @nVisibleTreasures=someVisibleTreasures
#        @nHiddenTreasures=someHiddenTreasures
#        @nSpecificVisibleTreasures=someSpecificVisibleTreasures
#        @nSpecificHiddenTreasures=someSpecificHiddenTreasures
#        @death=dh
#        
#  end

#  def
#      initialize( atext,  someLevels)
#        @text=atext
#        @levels=someLevels
#  end
#private_class_method:new
  
  def
     getText
        @text
  end

  def
    getLevels
      @levels
  end
  
   def isEmpty
      raiseNotImplementedError.new
    end
  
     def substractVisibleTreasure(t)
       raiseNotImplementedError.new
    end
    
    def substractHiddenTreasure(t)
      raiseNotImplementedError.new
    end
   
#  def
#     getnVisibleTreasures
#      @nVisibleTreasures
#  end
#  def
#    getnHiddenTreasures
#        @nHiddenTreasures
#  end
  
#  def
#  getDeath
#       @death
#  end
  
#  def
#    getnSpecificVisibleTreasures
#       @nSpecificVisibleTreasures
#  end
#  
#  def
#     getnSpecificHiddenTreasures
#       @nSpecificHiddenTreasures
#  end
#  
#  
#   def
#    BadConsequence.newLevelNumberOfTreasures(aText,someLevels,someVisibleTreasures,someHiddenTreasures)
#        new(aText, someLevels, someVisibleTreasures, someHiddenTreasures,0,0,false)
#  end
#  
#  def
#    BadConsequence.newLevelSpecificTreasures(aText,someLevels,someSpecificVisibleTreasures,someSpecificHiddenTreasures)
#       new(aText,someLevels,0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures,false)
#  end
#  
#  def
#    BadConsequence.newDeath(aText)
#     new(aText, 0, 0, 0, Array.new, Array.new, true)
#  end
#  
#  
#  private_class_method:new
  

    def to_s
      "Bad consequence: #{@text} \nPierdes: #{@levels} niveles."
    end
 
#    def isEmpty
#      empty=false
#      if(@levels==0&&@death==false&&@nHiddenTreasures==0&&@nVisibleTreasures==0
#          @nSpecificHiddenTreasures.length==0&&@nSpecificVisibleTreasures.length==0)
#        empty=true
#      end
#      return empty
#    end
    
#    def substractVisibleTreasure(t)
#      if(@nVisibleTreasures>0)
#        @nVisibleTreasures=@nVisibleTreasures-1
#      
#      elsif !@nSpecificVisibleTreasures.empty? or @nSpecificVisibleTreasures != nil
#                if @nSpecificVisibleTreasures.include?(t.type)
#                    @nSpecificVisibleTreasures.delete(t.type)
#                end
#            end
#    end
#    
#    def substractHiddenTreasure(t)
#      if(@nHiddenTreasures>0)
#        @nHiddenTreasures=@nHiddenTreasures-1
#        elsif (!@nSpecificHiddenTreasures.empty? or @nSpecificHiddenTreasures != nil)
#                if (@nSpecificHiddenTreasures.include?(t.type))
#                    @nSpecificHiddenTreasures.delete(t.type)
#                end
#            end
#    end
    
    def adjustToFitTreasureLists(v,h) 
      
#   resultado=nil
#  @levels=0   
#  if(@nSpecificVisibleTreasure.empty? && @nSpecificHiddenTreasures.empty?)
#    if(v.length>@nVisibleTreasures)
#           visibles=@nVisibleTreasures
#    else
#        visibles=v.length
#    end
#    if(h.length>@nHiddenTreasures)
#         ocultos=@nHiddenTreasures
#    else
#         ocultos=h.length
#    end
#    
#        resultado=BadConsequence.newLevelNumberOfTreasures(@text,@levels,visibles,ocultos)
#        
#      else if(!v.empty?||!h.empty?)
#          visiblesR=interseccion(v,@nSpecificVisibleTreasures)
#          ocultosR=interseccion(h,@nSpecificHiddenTreasures)
#          
#          resultado=BadConsequence.newLevelSpecificTreasures(@text,@levels,visiblesR,ocultosR)
#      end
#    
#        return resultado
#        
#  end
  
  
      
      
        t_visible = Array.new
        t_hidden = Array.new
        
       
        v.each do |t|
           
            if t_visible.index(t.type) == nil then
                t_visible << t.type
            end
        end
        
      
        h.each do |t|
        
            if t_hidden.index(t.type) == nil then
                t_hidden << t.type
            end
        end

         bs = NumericBadConsequence.new(@text, 0, t_visible, t_hidden)

        return bs

      
    end
    
#    def interseccion(tesoros,tipos)
#      interseccion = Array.new
#            tesoros.each do |t|
#                interseccion << t.type
#            end
#            tipos_comunes = interseccion & tipos
#            return tipos_comunes
#    end
#    
    
end
