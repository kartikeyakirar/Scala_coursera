object collection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def M =3                                        //> M: => Int
  def N = 5                                       //> N: => Int
  (1 to M) flatMap (x => (1 to N) map (y => (x, y)))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (1,4), (1,5), (2,1), (2,2), (2,3), (2,4), (2,5), (3,1), (3,2), (3,
                                                  //| 3), (3,4), (3,5))
 def isPrime(n: Int): Boolean= (2 until n).toList forall(x=> n%x != 0)
                                                  //> isPrime: (n: Int)Boolean
 isPrime(1254689)                                 //> res1: Boolean = true

(1 to 9) flatMap (x => (1 to x) map (y=> (x,y))) filter (x => isPrime(x._1+x._2))
                                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,1
                                                  //| ), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,
                                                  //| 2), (9,4), (9,8))
val x = (1 to 6).toSet                            //> x  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
x map (_/2)                                       //> res3: scala.collection.immutable.Set[Int] = Set(2, 0, 3, 1)

 
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
 }                                                //> queen: (n: Int)Set[List[Int]]


def issafe(col:Int ,q:List[Int]):Boolean={
val row = q.length
val qwidrow=row-1 to 0 by -1 zip q
qwidrow forall{case (r,c) => (col!=c && math.abs(c-col)!=row-r)}
}                                                 //> issafe: (col: Int, q: List[Int])Boolean

queen(8)                                          //> res4: Set[List[Int]] = Set(List(6, 3, 7, 2, 8, 5, 1, 4), List(3, 5, 8, 4, 1,
                                                  //|  7, 2, 6), List(2, 5, 7, 1, 3, 8, 6, 4), List(3, 5, 2, 8, 6, 4, 7, 1), List(
                                                  //| 6, 3, 1, 8, 4, 2, 7, 5), List(4, 7, 5, 3, 1, 6, 8, 2), List(6, 3, 7, 2, 4, 8
                                                  //| , 1, 5), List(5, 7, 4, 1, 3, 8, 6, 2), List(8, 3, 1, 6, 2, 5, 7, 4), List(5,
                                                  //|  7, 2, 6, 3, 1, 8, 4), List(5, 7, 2, 6, 3, 1, 4, 8), List(4, 1, 5, 8, 6, 3, 
                                                  //| 7, 2), List(2, 4, 6, 8, 3, 1, 7, 5), List(4, 2, 7, 5, 1, 8, 6, 3), List(5, 7
                                                  //| , 2, 4, 8, 1, 3, 6), List(6, 8, 2, 4, 1, 7, 5, 3), List(4, 2, 8, 5, 7, 1, 3,
                                                  //|  6), List(4, 6, 8, 3, 1, 7, 5, 2), List(5, 1, 8, 6, 3, 7, 2, 4), List(4, 6, 
                                                  //| 1, 5, 2, 8, 3, 7), List(6, 3, 1, 8, 5, 2, 4, 7), List(6, 4, 1, 5, 8, 2, 7, 3
                                                  //| ), List(2, 6, 1, 7, 4, 8, 3, 5), List(5, 3, 1, 7, 2, 8, 6, 4), List(4, 7, 3,
                                                  //|  8, 2, 5, 1, 6), List(4, 2, 5, 8, 6, 1, 3, 7), List(4, 8, 1, 3, 6, 2, 7, 5),
                                                  //|  List(4, 2, 7, 3, 6, 8, 5, 1), List(2, 7, 3, 6, 8, 5, 1, 4), List(4, 8, 1, 5
                                                  //| , 7, 2, 6, 3), List(4, 1
                                                  //| Output exceeds cutoff limit.
(1 until 10).flatMap(i =>
(1 until i).withFilter(j => isPrime(i+j))
.map(j => (i, j)))                                //> res5: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (9,
                                                  //| 4), (9,8))
val s="strrnng"                                   //> s  : String = strrnng

s groupBy(_.toChar) map (x=> (x._1,x._2))         //> res6: scala.collection.immutable.Map[Char,String] = Map(s -> s, n -> nn, t -
                                                  //| > t, g -> g, r -> rr)
}