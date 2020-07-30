object Q3 extends App{
	
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
	
		val sandun = new Account("s104", 6,2000 );
		val nuvin = new Account("s106", 1, 5000);
		printf("sandun Account = %s\nnuvin Account = %s\n\n", sandun.toString, nuvin.toString);
		printf("Transfer Rs.1000 from nuvin to sandun:\n");
		nuvin.transfer(sandun, 1000);
		printf("\t%s\n\t%s\n", sandun.toString, nuvin.toString);
		
		val overdraft = (b: List[Account]) => b.filter(x => x.getAccBalance < 0);
		val balanceSum = (b: List[Account]) => b.reduce((x, y) => new Account("Total Balance", 999999, x.getAccBalance + y.getAccBalance));
		val interest = (b: List[Account]) => b.map(x => if (x.getAccBalance < 0) new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.1)) else new Account(x.getNIC, x.getAccNum, (x.getAccBalance * 1.05)));
	

}