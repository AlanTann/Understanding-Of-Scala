object Scala102 {
/*
•	A class defines some data and methods that's relevant to it.
	•	For example, a Vehicle class can have data like maxSpeed, numberOfPassengers, color etc.
	•	An object is a specific instance of a class. At the parking lot outside the office, there's about 20 "instances" of Vehicle.
	•	A class can be subclassed. The Vehicle class may have subclasses like Car, Motorcycle, Truck, etc.
	•	A subclass inherits all the properties of its superclass, and usually is given the chance to override it too.
	•	Each subclass can be subclassed, creating a object hierarchy.
	*/
	
//: In Scala, the `class` keyword is used to declare a new class.
	class Vehicle {
	    var maxPassengers: Int = 0
	    var currentSpeed: Double = 0.0
	    
	    def report() {
	        println(s"Vehicle is moving at $currentSpeed")
	    }
	}
	
	// Create an instance of a class
	var myCar: Vehicle = new Vehicle()        //> myCar  : Scala102.Vehicle = Scala102$Vehicle@15615099
	myCar.maxPassengers = 5
	myCar.currentSpeed = 50
	myCar.report()                            //> Vehicle is moving at 50.0



	//: Subclassing
	class Car(var color: String) extends Vehicle {
	    maxPassengers = 5
	    currentSpeed = 0.0
	    override def report() {
	        print(s"This $color car is cruising at $currentSpeed")
	    }

	}
	
	var myRedCar: Car = new Car(color= "Red") //> myRedCar  : Scala102.Car = Scala102$$anonfun$main$1$Car$1@4e04a765
	myRedCar.report()                         //> This Red car is cruising at 0.0
	
	var myBlueCar: Car = new Car(color= "Blue")
                                                  //> myBlueCar  : Scala102.Car = Scala102$$anonfun$main$1$Car$1@783e6358
	myBlueCar.report()                        //> This Blue car is cruising at 0.0
	
	println("End")                            //> End

	/*:
	# Enums
	- Enumerations are great for specifying a finite set of values
	- In Scala, we can do more than just specifying the values
	- They work great with the `match` statement
	*/

	object Gears extends Enumeration {
    type Gears = Value
    val Neutral, One, Two, Three, Four, Park, Reverse = Value
  }
	import Gears._
	
	var gear: Gears = Gears.Two               //> gear  : Scala102.Gears.Gears = Two
	
	gear match {
	  case Neutral => println("Neutral")
	  case Two => println("Two")

	}                                         //> Two
	/*
		Enums part 2 ( 2nd way )
	- They work great with the `match` statement, which checks that your switch cases are exhaustive (covers everything)
	*/
	
	
	sealed trait Gears2
	object Gears2 {
		case object Neutral2 extends Gears2
		case object One2 extends Gears2
		case object UnknownGears extends Gears2
	}
	import Gears2._
	
	var gear2: Gears2 = Neutral2              //> gear2  : Scala102.Gears2 = Neutral2
	
	gear2 match {
	  case Neutral2 => println("Neutral 2")
	  case One2 => println("One 2")
	}                                         //> Neutral 2
	
	/*
	  Trait
You can declare a trait, which is a set of member variables and methods either concreate or abstract that
need to be supported
Once you have the trait defined, classes, enums can declare support and adopt the trait
It's similar to subclassing, but there's no overriding, rather just implementing what's stated in the protocol
You can declare the trait that are adopted by a class right at the start
But usually, we use extends/with keyword to make a class adopt a trait. Side benefit is cleaner code organization.
	  
	  */
	  
	trait Rentable {
	    def rentalPrice: Double
	    def rent()
	}
	class Vehicle2(a: Int, b: Double) {
	    var maxPassengers: Int = a
	    var currentSpeed: Double = b

	    def report() {
	        print(s"Vehicle is moving at $currentSpeed")
	    }
	}
	class Car2( c: String) extends Vehicle2(5, 0.0) with Rentable {
	    var color: String = c

	    
	    override def report() {
	        println(s"This $color car is cruising at $currentSpeed")
	    }
	    
	    def rentalPrice = 100.0
	    
	    def rent() {
	    	println("Renting out this car now")
	    }
	}
	
//: You can use protocols in a collection, or as parameter type, etc.
	class House(a: Double, b:Double) extends Rentable {
	    var pricePerSquareMeter: Double = a
	    var size: Double = b
	    
	    def rentalPrice: Double = size * pricePerSquareMeter

	    def rent() {
	        print("Renting out this house now")
	    }
	}
	
	var rentalListing: Array[Rentable] = new Array(2)
                                                  //> rentalListing  : Array[Scala102.Rentable] = Array(null, null)
	
	var myCar2: Car2 = new Car2(c = "Red")    //> myCar2  : Scala102.Car2 = Scala102$$anonfun$main$1$Car2$1@523884b2
	var myHouse: House = new House(a= 50.0, b= 1000)
                                                  //> myHouse  : Scala102.House = Scala102$$anonfun$main$1$House$1@5b275dab
	
	rentalListing(0) = myCar2
	rentalListing(1) = myHouse
	

	
	for (i <- rentalListing)
	  println(i)                              //> Scala102$$anonfun$main$1$Car2$1@523884b2
                                                  //| Scala102$$anonfun$main$1$House$1@5b275dab
	println("End")                            //> End
}