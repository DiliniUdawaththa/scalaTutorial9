package lab

import scala.io.StdIn

object Q2 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "If denominator is 0,  n/d cannot be defined")

    val gcdNum = gcd(n.abs, d.abs)
    val newN: Int = n / gcdNum //Simplifies numerator
    val newD: Int = d / gcdNum //Simplifies denominator

    //Function to determine the GCD of numerator and denominator
    def gcd(n1: Int, n2: Int): Int = n2 match {
      case 1 => 1
      case n if n > n1 => gcd(n, n1)
      case _ => gcd(n, n1 % n)
    }

    //Function to do the subtraction
    def sub(num:Rational): Rational = {
      new Rational(newN * num.newD - num.newN * newD, newD * num.newD)
    }

    override def toString: String = s"$newN / $newD"

  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)
    println("The result of x-y-z is: " + result)

  }
}
