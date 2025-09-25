package lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lab10 {

    // โจทย์ทำตาม: สร้าง List ของ String และเพิ่มชื่อคน 4 ชื่อเข้าไป
    // ให้สร้าง method ที่คืนค่า List<String> ที่มีชื่อ "Alice", "Bob", "Charlie",
    // "David"
    public static List<String> createNamesList() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        return names;
    }

    // โจทย์ทำตาม: สร้าง Set ของ String และเพิ่มชื่อ 3 ชื่อ โดยมีชื่อซ้ำกัน 1 ชื่อ
    // ให้สร้าง method ที่คืนค่า Set<String> ที่เพิ่มชื่อ "Alice", "Eve", "Alice"
    // (ซ้ำ)
    // ผลลัพธ์ควรมีแค่ 2 ชื่อใน Set เพราะ Set ไม่เก็บข้อมูลซ้ำ
    public static Set<String> createUniqueNamesSet() {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Eve");
        uniqueNames.add("Alice");
        return uniqueNames;
    }

    // โจทย์ทำเอง: สร้าง ArrayList ของ Integer และเพิ่มตัวเลข 5 ตัว
    // ให้สร้าง method ที่คืนค่า List<Integer> ที่มีตัวเลข 10, 20, 30, 40, 50
    public static List<Integer> createNumbersList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        return numbers;
    }

    // Optional: ใช้ Map เพื่อเก็บความถี่ของคำในประโยค
    // ให้สร้าง method ที่นับความถี่ของคำในประโยค "hello world hello java world"
    // ผลลัพธ์ควรเป็น: hello=2, world=2, java=1
    public static Map<String, Integer> countWordFrequency() {
        String sentence = "hello world hello java world";
        return countWords(sentence);
    }

    // Helper method สำหรับการนับคำ (สำหรับ Optional)
    public static Map<String, Integer> countWords(String sentence) {
    Map<String, Integer> wordCount = new HashMap<>();
    
    if (sentence == null || sentence.trim().isEmpty()) {
        return wordCount;
    }

    String[] words = sentence.toLowerCase().split("\\s+");
    for (String word : words) {
        if (!word.isEmpty()) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }
    return wordCount;
}

    public static void main(String[] args) {
        System.out.println("Lab10: Collections Exercise");

        // ทดสอบ method ต่างๆ
        System.out.println("Names List: " + createNamesList());
        System.out.println("Unique Names Set: " + createUniqueNamesSet());
        System.out.println("Numbers List: " + createNumbersList());
        System.out.println("Word Frequency: " + countWordFrequency());
    }
}
