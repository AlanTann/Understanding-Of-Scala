object Scala101 {
 
 //variable declaration
 	val str: String = "hello, Merry"          //> str  : String = hello, Merry
 	var money: Double = 12.0                  //> money  : Double = 12.0
 	money = 10
 	
 	val a = 10                                //> a  : Int = 10
 	var b = 12.5                              //> b  : Double = 12.5
 	
	/*
	1. Simple Values
	
	You can work think of values broadly in 2 categories:
	
		1.	Values that change, also known as Variables
		2.	Values that don't change, also known as Constants
	Scala lets you deal with these types of values.
	
		•	Use val to declare a new constant
		•	Use var to declare a new variable
	Things to know:
	
		•	You cannot change the value of a constant
		•	You cannot change the value of a variable to a different type
	
	*/

	//: ## Declaring a constant
	
	val language: String = "Swift"            //> language  : String = Swift
	val appName: String = "MeTube"            //> appName  : String = MeTube
	
	//: ## Declaring a variable
	
	val pi: Double = 3.142                    //> pi  : Double = 3.142
	
	var name = "Jason"                        //> name  : String = Jason
	var videoTitle = "My Scala Video"         //> videoTitle  : String = My Scala Video
	videoTitle = "Scala Variables Video"

	/*
	2. Naming Conventions
	
	While it doesn't matter to the program how you name your constants and variables,
	it matters a LOT to you and me as humans that we do naming correctly from the start.
	Being good at naming will help you understand your own code,
	 as well as keep a clear mental model of what the program is doing.
	Your teammates will also love you more for it.
	
	Here are some things to remember when naming your constants and variables:
	
		•	Be clear about what the variable is for
		•	Be concise, but don't use shrtfrms
		•	CAPITAL_NAMES are for static constants
		•	lowercase for local constants and variables
		•	camelCasedName if your name needs to be more than one word
		•	Use the singular form for a single value
		•	Use the plural form for collection of values
		•	Avoid ambiguous naming, clarify the variable type if needed
	*/


	val PI: Double = 3.142                    //> PI  : Double = 3.142
	
	val SITE_NAME: String = "MeTube.com"      //> SITE_NAME  : String = MeTube.com
	
	var visitCount: Int = 32                  //> visitCount  : Int = 32
	visitCount = visitCount + 1
	
	val firstName = "Jason"                   //> firstName  : String = Jason
	
	val categories = Array("Music", "Trailers", "Funny", "Tutorials")
                                                  //> categories  : Array[String] = Array(Music, Trailers, Funny, Tutorials)
	val video = "Everest Trailer"             //> video  : String = Everest Trailer
	
	var title = video                         //> title  : String = Everest Trailer
		
	
	/*:
	3. Data Types
	Scala has a complete set of its own fundamental types, similar to
	the primitive Java data types.
	
	These include:
	- Int
	- Double and Float
	- Bool
	- String
	
	Things to remember about Scala data types:
	* You cannot mix different data types
	* A variable of a specific type cannot be changed to another
	* Use `s""` to include values and expressions into a string
	* Values cannot be nil (empty) at any point in time, unless they are `Optional`
	*/
	
	val language1 = "Swift"                   //> language1  : String = Swift
	val siteName1 = "MeTube"                  //> siteName1  : String = MeTube
	
	val videoLength = 10                      //> videoLength  : Int = 10
	val introLength = 3.5                     //> introLength  : Double = 3.5
	
	val videoIsDone = true                    //> videoIsDone  : Boolean = true
	
	// var totalLength = videoLength + introLength
	
	/*: ## Optionals
	If you have some variable that may be `nil`, you need to specifically state it as such.
	Encountering unexpected `nil` values have been a major cause of crashes in the past.
	
	Option is part of Scala's safety checks, use it to your benefit!
	* Don't make everything optional
	* If a value could be  `nil`, do try to handle those cases
	* Get used to writing code that looks "funny", like `for( name <= name)` (Optional binding)
	*/
	
	var firstName1 = "Jason"                  //> firstName1  : String = Jason
	var middleName1: Option[String] = None    //> middleName1  : Option[String] = None
	var lastName = "Khong"                    //> lastName  : String = Khong
	
	//middleName1 = Some("WS")
	//var name = firstName + middleName! + lastName
	middleName1 match {
	  case Some(middleName) =>
		 var name = firstName1 + middleName + lastName
		 println(name)
	  case None =>
	    var name = firstName + lastName
		println(name)
	}                                         //> JasonKhong
	// explicit retrieve optional values
	if (middleName1.isDefined) {
	  var name = firstName1 + middleName1.get + lastName
	  println(name)
	}
	for (middleName1 <- middleName1) {
		var name = firstName1 + middleName1 + lastName
	  println(name)
	}
	
	/*:
	
	4 Type Inference
	
	How does Scala know what the data type is? Well, it "infers" the data type based
	on the initial value you give when you first assign the constant or variable.
	
	Another is for you, the developer, to explicitly state the data type using
	"type annotation" when you first declare the constant or variable.
	* If you use type annotation, Scala will convert the data type (if possible) when you assign the value
	* An added benefit for using type annotation is that Ecipse will highlight if the value doesn't match the data type
	
	TIP: For the duration of this course (and until you and your team are very familiar with Scala language and
	the entire Scala framework), we strongly encourage you to use type annotation all the time.
	
	*/

	var videoName: String = "Scala Tutorial"  //> videoName  : String = Scala Tutorial
	var videoLength1: Double = 10             //> videoLength1  : Double = 10.0
	var video2Length1: Double = 3.7           //> video2Length1  : Double = 3.7
	
	var totalLength1: Double = videoLength1 + video2Length1
                                                  //> totalLength1  : Double = 13.7
	val r = scala.util.Random                 //> r  : util.Random.type = scala.util.Random$@90f6bfd
	var randomDecimal: Double = r.nextDouble  //> randomDecimal  : Double = 0.34326857135857325
	
	
	
	totalLength1 = videoLength1 + randomDecimal
	/*
	5. Collections
	
	Scala provides some handy data types to deal with collections:
	
		•	Array: Sorted list of values
		•	Set: Unsorted list of unique values
		•	Map: Key - value named pairs of values
	Choosing the correct type of collection will ease the work needed when you code later.
	
	Some things to remember:
	
		•	A collection is always for a group of values of the same type
		•	Use superclasses (AnyRef)  if dealing with similar values but different types
	Demo
	
		•	Declaring an array
		•	Adding values
		•	Removing values
		•	Joining 2 sets of collections
		*/
	var colorNames: Array[String] = Array("Red", "Green", "Blue")
                                                  //> colorNames  : Array[String] = Array(Red, Green, Blue)
	var fruitNames: Array[String] = Array("Apple", "Banana", "Orange")
                                                  //> fruitNames  : Array[String] = Array(Apple, Banana, Orange)
	var scores: Array[Int] = Array(42, 98, 73, 20)
                                                  //> scores  : Array[Int] = Array(42, 98, 73, 20)
	
	var combined = colorNames ++ fruitNames   //> combined  : Array[String] = Array(Red, Green, Blue, Apple, Banana, Orange)
	
	colorNames = combined ++ Array("Yellow")
	
	val removed = colorNames.drop(1)          //> removed  : Array[String] = Array(Green, Blue, Apple, Banana, Orange, Yellow
                                                  //| )
	println(s"Color array contains: ${removed.foldLeft("")((a, b) => a + " "+ b )}")
                                                  //> Color array contains:  Green Blue Apple Banana Orange Yellow
		
	println(s"Color array contains: ${removed.foldLeft("")(_ + " "+ _ )}")
                                                  //> Color array contains:  Green Blue Apple Banana Orange Yellow
	
	
/*:
	# 6. Control Flow
	
	Every language has some way to control the execution of an app. In Scala, we have:
	* `if` and `match` for conditionals
	* `for`, `while` for loops
	
	Reminder:
	* When dealing with `while` loops, you are responsible for conditions to end the loop, otherwise your program will run in an endless loop

*/


	// if conditionals
	var score: Int = 49                       //> score  : Int = 49
	
	if (score > 50) {
	    println("Pass")
	} else {
	    println("Fail")
	}                                         //> Fail
	
	// loops
	var colors: Array[String] = Array("Red", "Green", "Blue")
                                                  //> colors  : Array[String] = Array(Red, Green, Blue)
	for (i <- 0 to (colors.length - 1)) {
	    println(s"Let's paint the town ${colors(i)}")
                                                  //> Let's paint the town Red
                                                  //| Let's paint the town Green
                                                  //| Let's paint the town Blue
	}
	
	for (color <- colors) {
	    println(s"Let's paint the town $color")
                                                  //> Let's paint the town Red
                                                  //| Let's paint the town Green
                                                  //| Let's paint the town Blue
	}
	
	// While loop
	var videoCount = 0                        //> videoCount  : Int = 0
	while (videoCount < 3) {
	    println(s"Watched $videoCount videos")
	    videoCount = videoCount + 1
	}                                         //> Watched 0 videos
                                                  //| Watched 1 videos
                                                  //| Watched 2 videos


	
	/*:
	7 Functions
	
	You can and should organize your code into smaller, reusable units.
	Even in Playground, you can write functions using the
	 `def` keyword.
	
	Functions are first class types in Scala, so you can use them as
	parameters or returned values too.
	*/
	def doubleOrNothing(score: Int): Int = {
		  val r = new scala.util.Random()
	    val randomMood: Int = r.nextInt(8)
	    if (randomMood > 5) {
	        return score * 2
	    } else {
	        return 0
	    }
	}                                         //> doubleOrNothing: (score: Int)Int
	
	var testScore: Int = 33                   //> testScore  : Int = 33
	testScore = doubleOrNothing(testScore)
	testScore = doubleOrNothing(testScore)
	testScore = doubleOrNothing(testScore)
	
	def showVideo(video: String) {
	    // Start playing video
	    print(s"Start playing: $video")
	}                                         //> showVideo: (video: String)Unit
	
	def randomVideo(): String = {
	    // Find a random video...
	    return "Random Video"
	}                                         //> randomVideo: ()String
	
	
	showVideo("First Video")                  //> Start playing: First Video
	
	showVideo(randomVideo())                  //> Start playing: Random Video
	
	println("end")                            //> end
	
	





}