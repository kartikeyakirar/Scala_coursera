import scala.io.Source
object x {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
val in = Source.fromFile("/home/kartikeya/Downloads/linuxwords.txt")
                                                  //> in  : scala.io.BufferedSource = non-empty iterator
val words = in.getLines.toList.filter(word=> word forall(x=> x.isLetter))
                                                  //> words  : List[String] = List(Aarhus, Aaron, Ababa, aback, abaft, abandon, ab
                                                  //| andoned, abandoning, abandonment, abandons, abase, abased, abasement, abasem
                                                  //| ents, abases, abash, abashed, abashes, abashing, abasing, abate, abated, aba
                                                  //| tement, abatements, abater, abates, abating, Abba, abbe, abbey, abbeys, abbo
                                                  //| t, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbreviating, abbre
                                                  //| viation, abbreviations, Abby, abdomen, abdomens, abdominal, abduct, abducted
                                                  //| , abduction, abductions, abductor, abductors, abducts, Abe, abed, Abel, Abel
                                                  //| ian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberrations, abet, 
                                                  //| abets, abetted, abetter, abetting, abeyance, abhor, abhorred, abhorrent, abh
                                                  //| orrer, abhorring, abhors, abide, abided, abides, abiding, Abidjan, Abigail, 
                                                  //| Abilene, abilities, ability, abject, abjection, abjections, abjectly, abject
                                                  //| ness, abjure, abjured, abjures, abjuring, ablate, ablated, ablates, ablating
                                                  //| , ablation, ablative, ab
                                                  //| Output exceeds cutoff limit.
val man=Map(
		'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
		'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
	)                                         //> man  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -> GHI,
                                                  //|  9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
	
	val wordnum :Map[Char,Char]= for{
	(x,y) <- man
	l<-y
	} yield (l,x)                             //> wordnum  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J ->
                                                  //|  5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5, 
                                                  //| B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z ->
                                                  //|  9, S -> 7)
	 
          
 val wordnumm:Map[Char,Char]= man flatMap(x=>x._2.map(l=>(l,x._1)))
                                                  //> wordnumm  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J -
                                                  //| > 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5,
                                                  //|  B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z -
                                                  //| > 9, S -> 7)
 
 
 def wordcode(word:String)=
 word.toUpperCase map(wordnumm)                   //> wordcode: (word: String)String

val wordnumber:Map[String ,Seq[String]]= words groupBy wordcode withDefaultValue Seq()
                                                  //> wordnumber  : Map[String,Seq[String]] = Map(63972278 -> List(newscast), 2923
                                                  //| 7638427 -> List(cybernetics), 782754448 -> List(starlight), 2559464 -> List(
                                                  //| allying), 862532733 -> List(uncleared), 365692259 -> List(enjoyably), 868437
                                                  //|  -> List(unties), 33767833 -> List(deportee), 742533 -> List(picked), 336464
                                                  //| 6489 -> List(femininity), 3987267346279 -> List(extraordinary), 7855397 -> L
                                                  //| ist(pulleys), 67846493 -> List(optimize), 4723837 -> List(grafter), 386583 -
                                                  //| > List(evolve), 78475464 -> List(Stirling), 746459 -> List(singly), 847827 -
                                                  //| > List(vistas), 546637737 -> List(lionesses), 28754283 -> List(curlicue), 84
                                                  //| 863372658 -> List(thunderbolt), 46767833 -> List(imported), 26437464 -> List
                                                  //| (angering, cohering), 8872267 -> List(turbans), 77665377 -> List(spoolers), 
                                                  //| 46636233 -> List(homemade), 7446768759 -> List(rigorously), 74644647 -> List
                                                  //| (ringings), 633738 -> List(offset), 847825 -> List(visual), 772832 -> List(P
                                                  //| ravda), 4729378 -> List(
                                                  //| Output exceeds cutoff limit.


def encode(str:String):Set[List[String]]=
if (str.isEmpty) Set(List())
else {
	for {
		split<-1 to str.length
		z<-wordnumber(str take split)
		y<-encode(str drop split)
		}yield z::y
}.toSet                                           //> encode: (str: String)Set[List[String]]



  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /** `Occurrences` is a `List` of pairs of characters and positive integers saying
   *  how often the character appears.
   *  This list is sorted alphabetically w.r.t. to the character in each pair.
   *  All characters in the occurrence list are lowercase.
   *
   *  Any list of pairs of lowercase characters and their frequency which is not sorted
   *  is **not** an occurrence list.
   *
   *  Note: If the frequency of some character is zero, then that character should not be
   *  in the list.
   */
  type Occurrences = List[(Char, Int)]

  /** The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
  val dictionary: List[Word] = words              //> dictionary  : List[x.Word] = List(Aarhus, Aaron, Ababa, aback, abaft, aband
                                                  //| on, abandoned, abandoning, abandonment, abandons, abase, abased, abasement,
                                                  //|  abasements, abases, abash, abashed, abashes, abashing, abasing, abate, aba
                                                  //| ted, abatement, abatements, abater, abates, abating, Abba, abbe, abbey, abb
                                                  //| eys, abbot, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbreviat
                                                  //| ing, abbreviation, abbreviations, Abby, abdomen, abdomens, abdominal, abduc
                                                  //| t, abducted, abduction, abductions, abductor, abductors, abducts, Abe, abed
                                                  //| , Abel, Abelian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberra
                                                  //| tions, abet, abets, abetted, abetter, abetting, abeyance, abhor, abhorred, 
                                                  //| abhorrent, abhorrer, abhorring, abhors, abide, abided, abides, abiding, Abi
                                                  //| djan, Abigail, Abilene, abilities, ability, abject, abjection, abjections, 
                                                  //| abjectly, abjectness, abjure, abjured, abjures, abjuring, ablate, ablated, 
                                                  //| ablates, ablating, abla
                                                  //| Output exceeds cutoff limit.

  /** Converts the word into its character occurrence list.
   *
   *  Note: the uppercase and lowercase version of the character are treated as the
   *  same character, and are represented as a lowercase character in the occurrence list.
   *
   *  Note: you must use `groupBy` to implement this method!
   */
  def wordOccurrences(w: Word): Occurrences = (w.toLowerCase groupBy(x=>x) map (x=> (x._1,x._2.length))).toList.sorted
                                                  //> wordOccurrences: (w: x.Word)x.Occurrences

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence): Occurrences = s flatMap wordOccurrences
                                                  //> sentenceOccurrences: (s: x.Sentence)x.Occurrences

  /** The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all
   *  the words that have that occurrence count.
   *  This map serves as an easy way to obtain all the anagrams of a word given its occurrence list.
   *
   *  For example, the word "eat" has the following character occurrence list:
   *
   *     `List(('a', 1), ('e', 1), ('t', 1))`
   *
   *  Incidentally, so do the words "ate" and "tea".
   *
   *  This means that the `dictionaryByOccurrences` map will contain an entry:
   *
   *    List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
   *
   */
   
   
   
     dictionary
      .map(w => (w, wordOccurrences(w)))
      .groupBy(x => x._2)
      .map(x => (x._1, x._2.map(y => y._1)))
      .withDefault(_ => Nil)                      //> res0: scala.collection.immutable.Map[x.Occurrences,List[x.Word]] = Map(List
                                                  //| ((e,1), (i,1), (l,1), (r,1), (t,2)) -> List(litter), List((a,1), (d,1), (e,
                                                  //| 1), (g,2), (l,1), (r,1)) -> List(gargled), List((a,1), (e,1), (h,1), (i,1),
                                                  //|  (k,1), (n,1), (s,3)) -> List(shakiness), List((e,2), (g,1), (n,1)) -> List
                                                  //| (gene), List((a,2), (n,1), (t,1), (y,1)) -> List(Tanya), List((a,1), (d,1),
                                                  //|  (e,2), (h,1), (m,1), (n,2), (o,1), (s,3)) -> List(handsomeness), List((a,2
                                                  //| ), (c,1), (e,2), (k,1), (l,1), (m,1), (p,1), (r,1), (t,1)) -> List(marketpl
                                                  //| ace), List((a,1), (i,1), (l,2), (s,1), (v,1)) -> List(villas), List((d,2), 
                                                  //| (e,1), (h,2), (n,1), (r,1), (t,1), (u,1)) -> List(hundredth), List((a,3), (
                                                  //| b,1), (c,1), (h,1), (i,2), (l,1), (o,1), (p,2), (r,1), (t,1), (y,1)) -> Lis
                                                  //| t(approachability), List((d,1), (e,2), (l,1), (s,1), (t,2)) -> List(settled
                                                  //| ), List((a,1), (g,1), (i,3), (l,1), (n,2), (t,1), (z,1)) -> List(Latinizing
                                                  //| ), List((a,1), (m,1), (
                                                  //| Output exceeds cutoff limit.
      
      
   dictionary.groupBy(wordOccurrences(_)).withDefaultValue(List())
                                                  //> res1: scala.collection.immutable.Map[x.Occurrences,List[x.Word]] = Map(List
                                                  //| ((e,1), (i,1), (l,1), (r,1), (t,2)) -> List(litter), List((a,1), (d,1), (e,
                                                  //| 1), (g,2), (l,1), (r,1)) -> List(gargled), List((a,1), (e,1), (h,1), (i,1),
                                                  //|  (k,1), (n,1), (s,3)) -> List(shakiness), List((e,2), (g,1), (n,1)) -> List
                                                  //| (gene), List((a,2), (n,1), (t,1), (y,1)) -> List(Tanya), List((a,1), (d,1),
                                                  //|  (e,2), (h,1), (m,1), (n,2), (o,1), (s,3)) -> List(handsomeness), List((a,2
                                                  //| ), (c,1), (e,2), (k,1), (l,1), (m,1), (p,1), (r,1), (t,1)) -> List(marketpl
                                                  //| ace), List((a,1), (i,1), (l,2), (s,1), (v,1)) -> List(villas), List((d,2), 
                                                  //| (e,1), (h,2), (n,1), (r,1), (t,1), (u,1)) -> List(hundredth), List((a,3), (
                                                  //| b,1), (c,1), (h,1), (i,2), (l,1), (o,1), (p,2), (r,1), (t,1), (y,1)) -> Lis
                                                  //| t(approachability), List((d,1), (e,2), (l,1), (s,1), (t,2)) -> List(settled
                                                  //| ), List((a,1), (g,1), (i,3), (l,1), (n,2), (t,1), (z,1)) -> List(Latinizing
                                                  //| ), List((a,1), (m,1), (
                                                  //| Output exceeds cutoff limit.
  //lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  (dictionary map(r=>(wordOccurrences(r),r)) groupBy(x=>x._2)).toList
                                                  //> res2: List[(x.Word, List[(x.Occurrences, x.Word)])] = List((professed,List(
                                                  //| (List((d,1), (e,2), (f,1), (o,1), (p,1), (r,1), (s,2)),professed))), (purif
                                                  //| ies,List((List((e,1), (f,1), (i,2), (p,1), (r,1), (s,1), (u,1)),purifies)))
                                                  //| , (phosphates,List((List((a,1), (e,1), (h,2), (o,1), (p,2), (s,2), (t,1)),p
                                                  //| hosphates))), (quotient,List((List((e,1), (i,1), (n,1), (o,1), (q,1), (t,2)
                                                  //| , (u,1)),quotient))), (Sadler,List((List((a,1), (d,1), (e,1), (l,1), (r,1),
                                                  //|  (s,1)),Sadler))), (incident,List((List((c,1), (d,1), (e,1), (i,2), (n,2), 
                                                  //| (t,1)),incident))), (additivity,List((List((a,1), (d,2), (i,3), (t,2), (v,1
                                                  //| ), (y,1)),additivity))), (amphibiously,List((List((a,1), (b,1), (h,1), (i,2
                                                  //| ), (l,1), (m,1), (o,1), (p,1), (s,1), (u,1), (y,1)),amphibiously))), (unimp
                                                  //| lemented,List((List((d,1), (e,3), (i,1), (l,1), (m,2), (n,2), (p,1), (t,1),
                                                  //|  (u,1)),unimplemented))), (buns,List((List((b,1), (n,1), (s,1), (u,1)),buns
                                                  //| ))), (serious,List((Lis
                                                  //| Output exceeds cutoff limit.
}