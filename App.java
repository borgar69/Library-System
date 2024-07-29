public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("==== Library System ====");
        Library library = new Library();

        library.addBook("Your Story", true);
        library.addBook("Three Days of Happiness", true);
        library.addBook("Meditations", true);
        System.out.println("\n");
        
        library.removeBook("Meditations");
        System.out.println("\n");

        library.addMember("Ralph"); 
        library.addMember("Jaco"); 
        library.addMember("Nathan"); 
        System.out.println("\n");

        library.checkIfAvaliable("Your Story");
        System.out.println("\n");

        library.removeMember("Nathan"); 
        System.out.println("\n");

        library.borrowBook("Ralph", "Your Story"); 
        library.borrowBook("Jaco", "Your Story"); 
        System.out.println("\n");
        
        library.returnBook("Ralph", "Your Story"); 
    }
}



/* 
1. Create a library object 
2. Read the books.txt and members.txt and store them into books and members arrays 
3. Try to perform actions 
[A] Add Books
[B] Remove Books 
[C] Add a Member
[D] Remove a Member
[E] Check if book is available 
[F] Display Books 
[G] Borrow Book
[H] Return Book 
[I] Exit system 

4. Before exiting system, write updated info into their respective text files 
5. Exit the program. 
 * 
 */