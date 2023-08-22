package lab

import scala.io.StdIn

object Q1 {
  class Rational(n:Int, d:Int){
    require(d != 0, "If denominator is 0,  n/d cannot be defined")

    val gcdNum = gcd(n.abs,d.abs)
    val newN: Int = n / gcdNum //Simplifies numerator
    val newD: Int = d / gcdNum //Simplifies denominator

    //Function to determine the GCD of numerator and denominator
    def gcd(n1:Int, n2:Int): Int = n2 match{
      case 1 => 1
      case n if n > n1 => gcd(n, n1)
      case _ => gcd(n, n1%n)
    }

    //Function to convert into negative
    def neg: Rational = new Rational(-newN, newD)

    override def toString: String = s"$newN / $newD"

  }

  def main(args:Array[String]): Unit = {
    //Get numerator and denominator as user input
    print("Enter numerator: ")
    val n = StdIn.readInt()
    print("Enter denominator: ")
    val d = StdIn.readInt()

    val x = new Rational(n, d)
    println("The initial rational number: " + x)
    val negX = x.neg
    println("The negative rational number: " + negX)
  }
}
