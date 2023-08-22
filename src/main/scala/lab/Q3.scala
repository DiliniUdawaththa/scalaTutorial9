package lab

object Q3 {
  //A class is defined for Accounts
  class Account(val accountNo:String, var balance:Double){
    //Deposit function
    def deposit(amount:Double):Unit = {
      if(amount > 0){
        println("Balance before deposit is: " + balance)
        println("Deposit amount is: " + amount)
        balance += amount
        println("Balance after deposit is: " + balance)
      }
      println(" ")
    }

    //Withdrawal function
    def withdrawal(amount:Double): Unit={
      if(amount > 0 && balance >= amount){
        println("Balance before withdrawal is: " + balance)
        println("Withdraw amount is: " + amount)
        balance -= amount
        println("Balance after withdrawal is: " + balance)
      }
      else if(amount > 0 && balance < amount){
        println("Sorry!!! Insufficient balance....")
      }
      println(" ")
    }

    //Transfer function
    def transfer(amount:Double, toAccount:Account): Unit = {
      if(amount > 0 && balance >= amount){
        println("From account balance before transfer is: " + balance)
        println("Transfer amount is: " + amount)
        balance -= amount
        println("From account balance after transfer is: " + balance)

        println("To account balance before transfer is: " + balance)
        toAccount.balance += amount
        println("To account balance after transfer is: " + toAccount.balance)
      }
      else if(amount > 0 && balance < amount){
        println("Sorry!!! Insufficient balance....")
      }
    }
  }

  //main function
  def main(args:Array[String]): Unit = {
    val acc1 = new Account("ACC1", 1000.00)
    val acc2 = new Account("ACC2", 4000.00)

    //Deposit 500.00 in acc1
    acc1.deposit(500.00)

    //Withdraw 1500.00 from acc2
    acc2.withdrawal(1500.00)

    //Transfer 1000.00 from acc2 to acc1
    acc2.transfer(1000.00,acc1)
  }

}
