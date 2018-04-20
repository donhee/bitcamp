package step24.ex05;

public class Account {
    String accountId;
    long balance; // 잔액
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
     public synchronized long withdraw(long money) { // 인출
        long b = this.balance; // 현재잔액
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공, 시간 딜레이용
        
        b -= money;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공, 시간 딜레이용
        if (b < 0) // 잔액없으면
            return 0;
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공, 시간 딜레이용
        this.balance = b; // 현재잔액을 저장
        for (int i = 0; i < 1000; i++) Math.asin(45.765); // CPU를 뺏길 기회를 제공 ,시간 딜레이용
        
        return money;
    }
}
