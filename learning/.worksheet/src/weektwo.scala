
object weektwo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
def abs(x:Double):Double = if(x<0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(45); 

  println("Welcome to the Scala worksheet");$skip(25); 
  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(79); 
  
  def isCloseEnough(x:Double,y:Double):Boolean=
  abs((x-y)/x/2)< tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(210); 
  
  def fixedPoint(f:Double=>Double)(firstguess:Double)={
  def iterate(guess:Double):Double={
  val next = f(guess)
  if(isCloseEnough(guess,next)) next
   else iterate(next)
  }
  iterate(firstguess)
  
  };System.out.println("""fixedPoint: (f: Double => Double)(firstguess: Double)Double""");$skip(60); 
  
  def averageDump(f:Double=>Double)(x:Double)=(x+f(x))/2;System.out.println("""averageDump: (f: Double => Double)(x: Double)Double""");$skip(58); 
  
 def sqrt(x:Double)=fixedPoint(averageDump(y=>x/y))(1);System.out.println("""sqrt: (x: Double)Double""");$skip(8); val res$0 = 
sqrt(2);System.out.println("""res0: Double = """ + $show(res$0))}

}
