
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method her
        List<Member> members = new ArrayList<>();
        members.add(new Member("Mikael",182));
        members.add(new Member("Matti",187));
        members.add(new Member("Ada",184));
        members.stream()
                .forEach(System.out::println);
        System.out.println("-------------------------------------");
        members.stream()
                .sorted()
                .forEach(System.out::println);
        
       
        System.out.println("The above method is sorted via stream default sorting method which \n doesnt affect the original value cause the\n operation is performed in the stream elements not on the whole list element");
               members.stream()
                .forEach(System.out::println);
        
        Collections.sort(members);
          System.out.println("but the collections sort method will affect the whole value");
               members.stream()
                .forEach(System.out::println);
        
        
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Matti", 150000));
        humans.add(new Human("Merja", 500));
        humans.add(new Human("Pertti", 80));

        System.out.println(humans);
        
        Collections.sort(humans);

        System.out.println("After calling collections.sort method");

        
        System.out.println(humans);
        

    }

    
 public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();
        
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                
                if (line.isEmpty()) {
                    continue;
                }
                
                // Split into max 4 parts (protects titles with commas)
                String[] parts = line.split(",", 4);
                
                if (parts.length == 4) {
                    try {
                        String name        = parts[0].trim();
                        int publishingYear = Integer.parseInt(parts[1].trim());
                        int pageCount      = Integer.parseInt(parts[2].trim());
                        String author      = parts[3].trim();
                        
                        // Important: match your constructor parameter order
                        Book book = new Book(name, publishingYear, pageCount, author);
                        books.add(book);
                        
                    } catch (NumberFormatException e) {
                        // quietly skip invalid numbers (or log if you want)
                        // System.out.println("Bad number in line: " + line);
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        
        return books;
    }
}

