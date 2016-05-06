object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(52); 
val pouring = new Pouring(Vector(4,7));System.out.println("""pouring  : Pouring = """ + $show(pouring ));$skip(14); val res$0 = 
pouring.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with test.pouring.Move] = """ + $show(res$0))}
}
