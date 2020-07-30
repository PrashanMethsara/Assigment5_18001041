object Q4 extends App{
	
	class Account(id: String, num: Int, bal: Double){
		 private val nic: String = id;
		 private val accNum: Int = num;
		 private var accBalance: Double = bal;
		 
		 def getNIC = this.nic;
		 def getAccNum = this.accNum;
		 def getAccBalance = this.accBalance;
		 
		 def deposit(am: Double) = this.accBalance = this.accBalance + am;
		 def withdraw(am: Double) = this.accBalance = this.accBalance - am;
		 def transfer(that: Account, am: Double) = {this.withdraw(am); that.deposit(am);}
		 override def toString = nic + " : " + accNum.toString + " : Rs." + accBalance.toString;
		
	
	}

	
		var bank:List[Account] = List(
			new Account("s222", 11, 500.50),
			new Account("s459", 5, 5982.75),
			new Account("s167", 60, -389.75),
			new Account("s777", 24, 940032.20),
			new Account("s321", 268, -800.83),
			new Account("s984", 330, 56548.00), 
                        new Account("s175", 605, -3.75),
			new Account("s798", 294, 6932.20),
			new Account("s310", 275, -88.83)
		);
		
		val overdraft = (b: List[Account]) => b.filter(x => x.getAccBalance < 0);
		val balanceSum = (b: List[Account]) => b.reduce((x, y) => new Account("Total Balance", 0000, x.getAccBalance + y.getAccBalance));
		val interest = (b: List[Account]) => b.map(x => if (x.getAccBalance < 0) new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.1)) else new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.05)));
		
		printf("\n4.1 Overdraft accounts;\n\t%s\n", overdraft(bank).mkString("\n\t"));
		printf("\n4.2 Total balance;\n\t%s\n", balanceSum(bank).toString);		
		printf("\n4.3 Interest;\n\t%s\n", interest(bank).mkString("\n\t"));
		
	

}