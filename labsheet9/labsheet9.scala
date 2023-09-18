class RationalNumber(val value:Double):
    
    def neg:RationalNumber=RationalNumber((-1)*value)
    def sub(rightHand:RationalNumber)=RationalNumber(this.value-rightHand.value)
    override def toString(): String = this.value.toString() 

object Q1 extends App{
    val number=RationalNumber(5)
    println(number.neg)
}

object Q2 extends App{

    val x=RationalNumber(3.0/4.0)
    val y=RationalNumber(5.0/8.0)
    val z=RationalNumber(2.0/7.0)
    println(x.sub(y).sub(z))   

}

class Account(var amount:Double=0.0):
    
    def transfer(reciver:Account,amount:Double)={
        this.withdraw(amount)
        reciver.deposit(amount)
    }
    
    def deposit(amount:Double)=this.amount=this.amount+amount
    def withdraw(amount:Double)=this.amount=this.amount-amount
    
    def +(rightHand:Account)=Account(this.amount+rightHand.amount)

    
    override def toString(): String = this.amount.toString() 




object Q3 extends App{
    
    val account1=Account(1000.00)
    val account2=Account(100.00)

    account1.transfer(account2,500.00)
    
    println(account1)
    println(account2.amount)

}

object Q4 extends App{
    
    val bank=List(
        Account(1000),
        Account(0),
        Account(-50),
        Account(-20),
        Account(2000)
    )

    def getNegativeAccountList():List[Account]=bank.filter(account=>account.amount<0)

    def getTotalBankValue()=bank.reduce((account1,account2)=>account1+account2)

    def updateBankAccountList()=bank.map((account)=>{

        if (account.amount>0)
        account.amount+=account.amount*(0.05)
        else
        account.amount+=account.amount*(0.1)

    
    })

    println(getNegativeAccountList())
    println(getTotalBankValue())
    updateBankAccountList()
    println(bank)


}
