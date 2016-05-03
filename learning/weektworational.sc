object weektworational {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val a=new rational(2,1)                         //> a  : rational = 2/1
  val b=new rational(5,7)                         //> b  : rational = 5/7
  val c=new rational(6,5)                         //> c  : rational = 6/5
  a.add(b).add(c)                                 //> res0: rational = 137/35
  a.sub(b).sub(c)                                 //> res1: rational = -6/5
}

class rational(a:Int,b:Int){
def numer = a
def denom = b
override def toString = (numer+"/" +denom)
def add(that:rational)=
new rational(numer*that.denom + denom*that.numer, denom*that.denom)

def neg=new rational(-numer,denom)

def sub(that:rational)= (that.neg)

}