package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab11 {
    
    // โจทย์ทำตาม: สร้าง method ชื่อว่า validateName 
    // โดยถ้า name = "XXX" จะ Throw InvalidNameException ออกมา
    // ถ้า name เป็น null หรือ empty string ก็ให้ throw InvalidNameException
    public static void validateName(String name) throws InvalidNameException {
        // TODO: เช็คว่า name เป็น "XXX", null, หรือ empty string แล้ว throw InvalidNameException
        if (name == null || name.trim().isEmpty()){
            throw new InvalidNameException("Name cannot be null or empty");
        }
        if (name.equals("XXX")){
            throw new InvalidNameException("Name cannot be 'XXX'");
        }
    }
    
    // โจทย์ทำเอง: สร้างเมธอดที่รับค่าจากผู้ใช้และใช้ try-catch จัดการ InputMismatchException
    // ให้สร้าง method ที่รับตัวเลข integer จากผู้ใช้ โดยใช้ Scanner
    // ถ้าผู้ใช้ใส่ข้อมูลที่ไม่ใช่ตัวเลข ให้จัดการด้วย try-catch
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter a valid integer.");
            return -1;
        }
    }
    
    // Optional: สร้าง method สำหรับถอนเงินจากบัญชี
    // ให้สร้าง method withdraw ที่รับพารามิเตอร์ balance และ amount
    // ถ้า amount > balance ให้ throw InsufficientFundsException
    public static double withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient to withdraw " + amount + " from balance " + balance);
        }
        return balance - amount;
    }
    
    public static void main(String[] args) {
        System.out.println("Lab11: Exception Handling");
        
        // ทดสอบ validateName method
        System.out.println("\n=== Testing validateName ===");
        testValidateName();
        
        // ทดสอบ getUserInput method
        System.out.println("\n=== Testing getUserInput ===");
        testGetUserInput();
        
        // ทดสอบ withdraw method (Optional)
        System.out.println("\n=== Testing withdraw ===");
        testWithdraw();
    }
    
    // Helper methods for testing
    public static void testValidateName() {
        try {
            validateName("John");
            System.out.println("Valid name accepted: John");
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            validateName("XXX");
            System.out.println("This should not print");
        } catch (InvalidNameException e) {
            System.out.println("Caught exception for XXX: " + e.getMessage());
        }
    }
    
    public static void testGetUserInput() {
        // เนื่องจากไม่สามารถ simulate user input ใน test ได้
        // จึงให้ comment ไว้เฉยๆ
        // int input = getUserInput();
        // System.out.println("User input: " + input);
    }
    
    public static void testWithdraw() {
        try {
            double result = withdraw(100.0, 50.0);
            System.out.println("Withdrawal successful. Remaining balance: " + result);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            double result = withdraw(100.0, 150.0);
            System.out.println("This should not print");
        } catch (InsufficientFundsException e) {
            System.out.println("Caught exception for insufficient funds: " + e.getMessage());
        }
    }
}


