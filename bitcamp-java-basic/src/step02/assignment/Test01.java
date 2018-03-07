package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;

        java.util.Scanner keyScan = new java.util.Scanner(keyboard);
        
        String s;
        int la;
        int english;
        int math;
        int sum = 0;
        double avg = 0;
        
        System.out.print("이름? ");
        s = keyScan.nextLine();

        System.out.print("국어? ");
        la = keyScan.nextInt(); 
        //Integer.parseInt(keyScan.nextLine());

        System.out.print("영어? ");
        english = keyScan.nextInt();
        //Integer.parseInt(keyScan.nextLine());
        
        System.out.print("수학? ");
        math = keyScan.nextInt();
        //Integer.parseInt(keyScan.nextLine());

        sum = la + english + math;
        avg = sum / 3;

        System.out.println(s+" "+la+" "+english+" "+math+" "+sum+" "+avg);
    }
}