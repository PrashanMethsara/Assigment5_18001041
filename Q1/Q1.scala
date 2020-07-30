object Q1 extends App{
 
  class Rational(n: Int, d: Int)
{

    require(d>0, "Denominator should be positive!")

    val numer: Int = n/gcd(n,d)
    val denom: Int = d/gcd(n,d)
    
    def this(n: Int) = this(n,1)

    override def toString: String = this.numer.toString + "/" + this.denom.toString
    private def gcd(x: Int, y: Int): Int = if(y==0) x else if(x<0) gcd(y,(-x)%y) else gcd(y,x%y)
    def neg = new Rational(-this.numer,this.denom)
    def sub(r: Rational): Rational = this.add(r.neg)
    def add(r: Rational) = new Rational(this.numer*r.denom+r.numer*this.denom,this.denom*r.denom)

  }

  val r = new Rational(4,6)
  println("Negetive of " + r.toString + " is= " + r.neg.toString);
  println()
}