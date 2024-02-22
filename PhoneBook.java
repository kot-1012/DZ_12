import java.util.*;
public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "555666777");
        addContact(phoneBook, "Иванов", "999000111");
        addContact(phoneBook, "Петров", "222333444");
        addContact(phoneBook, "Сидоров", "888888888");
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, Set<String>> entry : sortByNumPhones(phoneBook).entrySet()) {
            String name = entry.getKey();
            Set<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        phoneBook.get(name).add(phoneNumber);
    }
    public static Map<String, Set<String>> sortByNumPhones(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        Map<String, Set<String>> sortedPhoneBook = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : list) {
            sortedPhoneBook.put(entry.getKey(), entry.getValue());
        }
        return sortedPhoneBook;
    }
}
