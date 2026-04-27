package encapsulation;

import com.thread.Runnable.A;

public class Test {
    public static void main(String[] args){
        Student student = new Student();   // default constructors
        student.setAge(-1);
        student.setName("Ram");
        student.setRollNumber(12);
        System.out.println(student.getAge()+" "+ student.getName() + " " + student.getRollNumber());

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(12345);
        bankAccount.deposit(-10);
        bankAccount.withdraw(10);
        bankAccount.deposit(100);
        bankAccount.withdraw(10);
        System.out.println(bankAccount.getBalance());
    }
}
