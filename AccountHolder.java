package holders;

import accounts.Account;

public class AccountHolder implements Runnable{
    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
        makewithdrawal(50000);
            if(account.getBalance()<0){
                System.out.println("Alert!!"+Thread.currentThread().getName()+"is overdrawn!!!");
            }
        }
    }

    private synchronized void makewithdrawal(int withdrawamt){
        if(account.getBalance() >= withdrawamt){
            try{
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" is going to withdraw Rs"+withdrawamt);
            }catch (InterruptedException ex){

            }
            account.withdraw(withdrawamt);
            System.out.println(Thread.currentThread().getName()+" completes the withdrawal of Rs"+withdrawamt);
        }
        else{
            System.out.println("Sorry!");
            System.out.println("Not enough balance in "+Thread.currentThread().getName()+" to withdraw"+withdrawamt);
        }

    }


}

