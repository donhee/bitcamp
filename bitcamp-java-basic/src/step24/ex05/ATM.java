package step24.ex05;

public class ATM extends Thread {
    Account account;
    
    public ATM(String name, Account account) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
         
        long money = 0; // 
        long sum = 0;
        
        while (true) { // 돈을 찾았으면
            money = account.withdraw(100); //100원씩 찾는다
            if(money <= 0) // 못찾았으면
                break;
            sum +=money; 
        }
        System.out.printf("%s가 찾은 돈: %d원\n", this.getName(), sum);
    }
    
    
}
