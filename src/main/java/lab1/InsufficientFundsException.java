package lab1;

// Optional: สร้าง Custom Exception ชื่อ InsufficientFundsException 
// สำหรับกรณีที่พยายามถอนเงินจากบัญชีเกินจำนวนที่มีอยู่
public class InsufficientFundsException extends Exception {
    // TODO: สร้าง constructor ที่รับ message
    public InsufficientFundsException(String message) {
        super(message);
    }
}
