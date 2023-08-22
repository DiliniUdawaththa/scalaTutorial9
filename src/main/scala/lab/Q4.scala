package lab

object Q4 {
  class Account(val accountNo: String, var balance: Double)

  class Bank{
    var accounts: List[Account] = List()

    def addAccount(account: Account): Unit = {
      accounts = account :: accounts
    }

    def accountsWithNegativeBalance: List[Account] = {
      accounts.filter(_.balance<0)
    }

    def sumofBalance: Double = {
      accounts.map(_.balance).sum
    }

    def applyInterest(): Unit = {
      accounts.foreach { account =>
        if(account.balance > 0){
          account.balance += account.balance*0.05
        }
        else if(account.balance < 0){
          account.balance -= account.balance*0.1
        }
      }
    }

  }

  def main(args:Array[String]): Unit = {
    //Creating objects of the Account class
    val acc1 = new Account("ACC1",1000)
    val acc2 = new Account("ACC2", -200)
    val acc3 = new Account("ACC3", 2000)
    val acc4 = new Account("ACC4", -300)
    val acc5 = new Account("ACC5", 5000)

    //Creating an object of class Bank
    val bank = new Bank()
    bank.addAccount(acc1)
    bank.addAccount(acc2)
    bank.addAccount(acc3)
    bank.addAccount(acc4)
    bank.addAccount(acc5)
    
  }
}
