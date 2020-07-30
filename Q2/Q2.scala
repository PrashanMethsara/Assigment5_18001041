object Q2 extends App{
 
  class Rational(n: Int, d: Int){

    require(d>0, "Denominator should be positive!")

    val numer: Int = n/gcd(n,d)
    val denom: Int = d/gcd(n,d)
    
    def this(n: Int) = this(n,1)

    override def toString: String = this.numer.toString + "/" + this.denom.toString
    private def gcd(x: Int, y: Int): Int = if(y==0) x else if(x<0) gcd(y,(-x)%y) else gcd(y,x%y)
    def neg = new Rational(-this.numer,this.denom)
    def add(r: Rational) = new Rational(this.numer*r.denom+r.numer*this.denom,this.denom*r.denom)
    def sub(r: Rational): Rational = this.add(r.neg)

  }

  val x = new Rational(1,2)
  val y = new Rational(1,9)
  val z = new Rational(2,6)
  println(x.toString + " - " + y.toString + " - " + z.toString + " = " + x.sub(y).sub(z).toString);
  println()
}