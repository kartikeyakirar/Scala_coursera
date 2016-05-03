

 abstract class Nat {
def isZero: Boolean
def predecessor: Nat
def successor: Nat= new Succ(this)
def + (that: Nat): Nat
def - (that: Nat): Nat
}
 
object zero extends Nat{
   
   def isZero= true
   def predecessor = throw  new NoSuchElementException
   def + (that:Nat):Nat = that
   def - (that:Nat): Nat=if(that.isZero) this else throw  new NoSuchElementException
 }

class Succ(n: Nat) extends Nat{
  
  def isZero= false
   def predecessor = n
   def + (that:Nat):Nat = new Succ(n + that)
   def - (that: Nat): Nat= if(that.isZero) n else n - that.predecessor
}