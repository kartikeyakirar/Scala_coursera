object collection {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(11); 
  def M =3;System.out.println("""M: => Int""");$skip(12); 
  def N = 5;System.out.println("""N: => Int""");$skip(53); val res$0 = 
  (1 to M) flatMap (x => (1 to N) map (y => (x, y)));System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(71); 
 def isPrime(n: Int): Boolean= (2 until n).toList forall(x=> n%x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(18); val res$1 = 
 isPrime(1254689);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(83); val res$2 = 

(1 to 9) flatMap (x => (1 to x) map (y=> (x,y))) filter (x => isPrime(x._1+x._2));System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(23); 
val x = (1 to 6).toSet;System.out.println("""x  : scala.collection.immutable.Set[Int] = """ + $show(x ));$skip(12); val res$3 = 
x map (_/2);System.out.println("""res3: scala.collection.immutable.Set[Int] = """ + $show(res$3));$skip(188); 

 
 def queen(n:Int)={
 def placeQueen(k:Int):Set[List[Int]]={
 if (k==0) Set(List())
 else for{
 q<-placeQueen(k-1)
 col<- 1 to n
 if issafe(col , q)}
 yield col :: q
}

placeQueen(n)
 };System.out.println("""queen: (n: Int)Set[List[Int]]""");$skip(166); 


def issafe(col:Int ,q:List[Int]):Boolean={
val row = q.length
val qwidrow=row-1 to 0 by -1 zip q
qwidrow forall{case (r,c) => (col!=c && math.abs(c-col)!=row-r)}
};System.out.println("""issafe: (col: Int, q: List[Int])Boolean""");$skip(10); val res$4 = 

queen(8);System.out.println("""res4: Set[List[Int]] = """ + $show(res$4));$skip(87); val res$5 = 
(1 until 10).flatMap(i =>
(1 until i).withFilter(j => isPrime(i+j))
.map(j => (i, j)));System.out.println("""res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$5));$skip(16); 
val s="strrnng";System.out.println("""s  : String = """ + $show(s ));$skip(43); val res$6 = 

s groupBy(_.toChar) map (x=> (x._1,x._2));System.out.println("""res6: scala.collection.immutable.Map[Char,String] = """ + $show(res$6))}
}
