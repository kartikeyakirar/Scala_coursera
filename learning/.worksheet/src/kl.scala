object kl {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  def abs(x:Double):Double = if(x<0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(348); 
 def sqroot(x: Double)={
 
 def sqrt(guess:Double):Double=
  	{
  		if(isGuessGoodEnough(guess)) guess
  		 else sqrt(improve(guess))
  	}
  
  def isGuessGoodEnough(guess:Double): Boolean=
  {
  		if(abs(guess*guess-x)/x<0.001) true else false
  }
  
   def improve(guess:Double):Double=
   {
   	    (guess + x/guess)/2
   }
   
   sqrt(1.0)
  };System.out.println("""sqroot: (x: Double)Double""");$skip(106); 
  
  def pascal(c: Int, r: Int): Int ={
    
    if(c==0||c==r) 1 else pascal(c-1,r-1)+ pascal(c,r-1)
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(113); 
   for (row <- 0 to 10) {
      for (col <-0 to row)
        print(pascal(col, row) + " ")
      println()
    };$skip(78); 
 
 def sumbetween(a:Int,b:Int):Int={
 if(a>b) 0 else a + sumbetween(a+1,b)
 };System.out.println("""sumbetween: (a: Int, b: Int)Int""");$skip(29); 
 
 def cube(x:Int):Int=x*x*x;System.out.println("""cube: (x: Int)Int""");$skip(313); 
 
 def sumcube(a:Int,b:Int) :Int={
 if(a>b) 0 else cube(a) +sumcube(a+1,b)
 
 def fact(a:Int):Int={
 if(a==0) 1
 else if(a==1) 1
 else a+fact(a-1)
 }
 
 def factsum(a:Int,b:Int):Int={
 if(a>b) 0 else fact(a) +factsum(a+1,b)
 }
 
 def sum (f:Int => Int ,a:Int,b:Int)
 {
 	if(a>b) 0 else f(a) +sum(a+1,b)
 }
 
 
 };System.out.println("""sumcube: (a: Int, b: Int)Int""")}
