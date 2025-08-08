import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryDAO dao = new LibraryDAO();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n📚 Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    dao.addBook(new Book(0, title, author, price));
                    break;
                case 2:
                    List<Book> books = dao.getAllBooks();
                    System.out.println("\n--- All Books ---");
                    books.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteBook(id);
                    break;
                case 4:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
