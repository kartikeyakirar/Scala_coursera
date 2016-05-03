

abstract class Intsett {
  def contains(elem : Int):Boolean
  def incl(elem: Int):Intsett
  def union(other : Intsett):Intsett
}

class empty extends Intsett
{
  def contains (elem:Int)=false
  def incl(elem : Int):Intsett=new notempty(elem,new empty ,new empty )
  def union(other:Intsett)= other
  override def toString = "{.}"
}

class notempty (x:Int ,left:Intsett,right:Intsett) extends Intsett{
  def contains(elem: Int):Boolean={
    if(x<elem) left.contains(elem)
    else if (x>elem) right.contains(elem)
    else true
    
  }
  
  def incl(elem :Int):Intsett={
    if(x<elem) new notempty(x,left incl elem ,right)
    else if (x>elem) new notempty(x,left,right incl elem)
    else this
  }
  
  def union(other:Intsett):Intsett=
    ((left union right) union other) incl x
    
   override def toString= "{"+right+","+x+","+left+"}" 
    
}

object Intset{
  
  def Main(args:List[String])=
  {
    val t1= new notempty(2,new empty,new empty)
       val t2= new notempty(5,new empty,new empty)
       val t3= new notempty(4,new empty,new empty)
    t3 contains 4
    t3 union t2
  }
}