import java.util.Scanner; 

public class App {
    boolean condition = true; 

    static void mainMenu(Library library, App app)
    {
        System.out.println("==== Library System ====");
        System.out.println("[A] Add Books");
        System.out.println("[B] Remove Books");
        System.out.println("[C] Add a Member");
        System.out.println("[D] Remove a Member");
        System.out.println("[E] Check if book is available");
        System.out.println("[F] Display Books");
        System.out.println("[G] Borrow Book");
        System.out.println("[H] Return Book");
        System.out.println("[I] Exit system");

        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter choice: ");

        String input = scanner.nextLine(); 
        String member_name; 
        String book_name; 
        System.out.println("");
        switch (input) {
            case "A":
                System.out.println("Enter book name: ");
                library.addBook(scanner.nextLine(), true);
                break;
            
            case "B": 
                System.out.println("Enter book name: ");
                library.removeBook(scanner.nextLine());
                break; 

            case "C": 
                System.out.println("Enter member name: ");
                library.addMember(scanner.nextLine()); 
                break; 

            case "D": 
                System.out.println("Enter member name: ");
                library.removeMember(scanner.nextLine()); 
                break; 

            case "E": 
                System.out.println("Enter book name: ");
                library.checkIfAvaliable(scanner.nextLine()); 
                break; 

            case "F": 
                System.out.println("Feature not yet available");
                // TO DO: Add implementation 
                break; 
            
            case "G": 
                System.out.println("Enter book name: "); 
                book_name = scanner.nextLine(); 

                System.out.println("Enter name of book borrower: ");
                member_name = scanner.nextLine(); 

                library.borrowBook(member_name, book_name); 
                break; 

            case "H": 
                System.out.println("Enter book name: "); 
                book_name = scanner.nextLine(); 

                System.out.println("Enter name of book borrower: ");
                member_name = scanner.nextLine(); 

                library.returnBook(member_name, book_name); 
                break; 

            case "I": 
                // TO DO: Add implementation for writing info in txt files. 
                System.out.println("Thank you for using the library system!");
                app.condition = false; 

            default:
                break;
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        Library library = new Library();
        App app = new App(); 
        while (app.condition == true)
        {
            mainMenu(library, app); 
        }
        
    }
}

/* 
1. Create a library object 
2. Read the books.txt and members.txt and store them into books and members arrays 
3. Try to perform actions 
4. Before exiting system, write updated info into their respective text files 
5. Exit the program. 
 */