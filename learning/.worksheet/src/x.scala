import scala.io.Source
object x {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(72); 
  
val in = Source.fromFile("/home/kartikeya/Downloads/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(74); 
val words = in.getLines.toList.filter(word=> word forall(x=> x.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(133); 
val man=Map(
		'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
		'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
	);System.out.println("""man  : scala.collection.immutable.Map[Char,String] = """ + $show(man ));$skip(72); 
	
	val wordnum :Map[Char,Char]= for{
	(x,y) <- man
	l<-y
	} yield (l,x);System.out.println("""wordnum  : Map[Char,Char] = """ + $show(wordnum ));$skip(82); 
	 
          
 val wordnumm:Map[Char,Char]= man flatMap(x=>x._2.map(l=>(l,x._1)));System.out.println("""wordnumm  : Map[Char,Char] = """ + $show(wordnumm ));$skip(64); 
 
 
 def wordcode(word:String)=
 word.toUpperCase map(wordnumm);System.out.println("""wordcode: (word: String)String""");$skip(88); 

val wordnumber:Map[String ,Seq[String]]= words groupBy wordcode withDefaultValue Seq();System.out.println("""wordnumber  : Map[String,Seq[String]] = """ + $show(wordnumber ));$skip(194); 


def encode(str:String):Set[List[String]]=
if (str.isEmpty) Set(List())
else {
	for {
		split<-1 to str.length
		z<-wordnumber(str take split)
		y<-encode(str drop split)
		}yield z::y
}.toSet



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
  type Occurrences = List[(Char, Int)];System.out.println("""encode: (str: String)Set[List[String]]""");$skip(874); 

  /** The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
  val dictionary: List[Word] = words;System.out.println("""dictionary  : List[x.Word] = """ + $show(dictionary ));$skip(432); 

  /** Converts the word into its character occurrence list.
   *
   *  Note: the uppercase and lowercase version of the character are treated as the
   *  same character, and are represented as a lowercase character in the occurrence list.
   *
   *  Note: you must use `groupBy` to implement this method!
   */
  def wordOccurrences(w: Word): Occurrences = (w.toLowerCase groupBy(x=>x) map (x=> (x._1,x._2.length))).toList.sorted;System.out.println("""wordOccurrences: (w: x.Word)x.Occurrences""");$skip(146); 

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence): Occurrences = s flatMap wordOccurrences;System.out.println("""sentenceOccurrences: (s: x.Sentence)x.Occurrences""");$skip(779); val res$0 = 

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
      .withDefault(_ => Nil);System.out.println("""res0: scala.collection.immutable.Map[x.Occurrences,List[x.Word]] = """ + $show(res$0));$skip(81); val res$1 = 
      
      
   dictionary.groupBy(wordOccurrences(_)).withDefaultValue(List());System.out.println("""res1: scala.collection.immutable.Map[x.Occurrences,List[x.Word]] = """ + $show(res$1));$skip(139); val res$2 = 
  //lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] =
  (dictionary map(r=>(wordOccurrences(r),r)) groupBy(x=>x._2)).toList;System.out.println("""res2: List[(x.Word, List[(x.Occurrences, x.Word)])] = """ + $show(res$2))}
}
