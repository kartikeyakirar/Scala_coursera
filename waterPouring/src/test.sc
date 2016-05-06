object test {
val pouring = new Pouring(Vector(4,7))            //> pouring  : Pouring = Pouring@59a6e353
pouring.moves                                     //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with te
                                                  //| st.pouring.Move] = Vector(Empty(0), Empty(1), Empty(2), fill(0), fill(1), fil
                                                  //| l(2), pour(0,1), pour(0,2), pour(1,0), pour(1,2), pour(2,0), pour(2,1))
}