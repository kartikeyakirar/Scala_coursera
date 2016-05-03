
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
      
    print(countChange(4,List(1, 2)))
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int ={
    if(c==0||c==r) 1 else pascal(c,r-1) +pascal(c-1,r-1)
  }

  /**
   * Exercise 2
   */
 
  def balance(chars:List[Char]):Boolean = {
    
    def checkBalance(x:Int,chars:List[Char]):Int={
      if(chars.isEmpty)  x
      else if (chars.head== '(') checkBalance(x+1,chars.tail) 
      else if (chars.head== ')') checkBalance(x-1,chars.tail)
      else checkBalance(x,chars.tail)
         
    }
    checkBalance(0,chars)==0
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]):Int = 
  { print(money ,coins)
    if(money==0) 1
    else if(money<0 || coins.isEmpty) 0
    else countChange(money-coins.head,coins) + countChange(money,coins.tail)
  }    
}
