

trait Intst [T]{
  def isEmpty:Boolean
  def head:T
  def tail: Intst[T]
}


class cons[T](val head : T , val tail:Intst[T]) extends Intst[T]
{
  def isEmpty= false
  
}

class nil[T] extends Intst[T]
{
 def isEmpty=true  
 def head= throw new NoSuchElementException("Nil.heaa")
 def tail= throw new NoSuchElementException("Nil.tail")
}