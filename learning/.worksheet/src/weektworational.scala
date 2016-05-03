object weektworational {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(26); 
  val a=new rational(2,1);System.out.println("""a  : rational = """ + $show(a ));$skip(26); 
  val b=new rational(5,7);System.out.println("""b  : rational = """ + $show(b ));$skip(26); 
  val c=new rational(6,5);System.out.println("""c  : rational = """ + $show(c ));$skip(18); val res$0 = 
  a.add(b).add(c);System.out.println("""res0: rational = """ + $show(res$0));$skip(18); val res$1 = 
  a.sub(b).sub(c);System.out.println("""res1: rational = """ + $show(res$1))}
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
