import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {
    private ArrayList<Book> booksList = new ArrayList<>(); 
    private ArrayList<Member> membersList = new ArrayList<>(); 

    public void readFromFile()
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader("members.txt")); 
            String line = reader.readLine(); 
            while (line != null)
            {
                String[] parts = line.split(","); 
                Member member = new Member(parts[0]); 
                

                for (int i = 1; i < parts.length; i++)
                {
                    member.addBorrowedBook(parts[i]); 
                }
                membersList.add(member); 
                line = reader.readLine(); 
            }
            reader.close(); 
        }

        catch (Exception e) 
        {
            e.getStackTrace(); 
        }

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader("books.txt")); 
            String line = reader.readLine(); 
            while (line != null)
            {
                String[] parts = line.split(","); 
                Book book = new Book(parts[0], Boolean.parseBoolean(parts[1]), parts[2]); 

                booksList.add(book); 
                line = reader.readLine(); 
            }
            reader.close();
        }

        catch (Exception e) 
        {
            e.getStackTrace(); 
        }

    }

    public void writeToFile()
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt"));
            for (Member member : membersList)
            {
                writer.write(member.GetName() + "," + member.toString()); 
                writer.newLine();
            }
            writer.close(); 
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"));
            for (Book book : booksList)
            {
                writer.write(book.getName() + ","); 
                writer.write(Boolean.toString(book.getStatus()) + ",");
                writer.write(book.getBorrower());
                writer.newLine();

            }
            writer.close(); 

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void addBook(String book_name, boolean status, String borrower) 
    {
        Book book = new Book(book_name, status, borrower); 
        booksList.add(book); 
        System.out.println(book.getName() + " has been added to the inventory");
    }

    public void removeBook(String book_name)
    {
        for (Book book : booksList) {
            if(book.getName().equalsIgnoreCase(book_name))
            {
                if(book.isThisAvailable()) 
                {
                    booksList.remove(book); 
                    System.out.println(book.getName() + " has been removed to the inventory");
                }

                else 
                {
                    System.out.println(book.getName() +" cannot be removed because it is borrowed by " + book.getBorrower());
                }
                return; 
            }

        } 
        System.out.println(book_name + " is not in the inventory.");
    
    }

    public void displayBooks()
    {
        booksList.sort((book1, book2) -> book1.getName().compareTo(book2.getName())); // Sorting book name in alphabetical order

        for (Book book: booksList)
        {
            System.out.println(book.getName());
            if (book.getStatus())
            {
                System.out.println("Status: Available");
            }
            else
            {
                System.out.println("Status: Borrowed");
            }
            System.out.println("Borrower: " + book.getBorrower() + "\n");
        }
    }

    public void addMember(String member_name)
    {
        Member member = new Member(member_name); 
        membersList.add(member); 
        System.out.println(member.GetName() + " has been registered to the library");
    }

    public void removeMember(String member_name)
    {
        for (Member member : membersList) {
            if(member.GetName().equalsIgnoreCase(member_name))
            {
                if (member.BorrowedIsEmpty())
                {
                    membersList.remove(member); 
                    System.out.println(member_name + " has been removed from the members list.");
                }
                else 
                {
                    System.out.println("Member still has books borrowed. Cannot be removed from system.");
                }
                return; 
            }

        } 
        
        
    }

    public void checkIfAvaliable(String book_name)
    {
        for (Book book : booksList) {
            if(book.getName().equalsIgnoreCase(book_name))
            {
                if(book.isThisAvailable()) 
                {
                    System.out.println(book.getName() + " is available.");
                }

                else 
                {
                    System.out.println(book.getName() + " is currently borrowed by " + book.getBorrower());
                }
                return; 
            }

        } 
        System.out.println(book_name + " is not in the inventory.");
    }

    public void borrowBook(String member_name, String book_name)
    {
        for (Book book : booksList) {
            if(book.getName().equalsIgnoreCase(book_name))
            {
                if(book.isThisAvailable()) 
                {
                    for (Member member : membersList)
                    {
                        if(member.GetName().equalsIgnoreCase(member_name))
                        {
                            member.addBorrowedBook(book.getName()); 
                            book.changeStatus();
                            book.setBorrower(member_name);
                            System.out.println(book.getName() + " is successfully borrowed by " + member_name);
                            return; 
                        }
                        System.out.println("Member name is not found in the system.");
                    }
                    
                }

                else 
                {
                    System.out.println(book.getName() + " is currently borrowed. Action cannot be performed.");
                }
                return; 
            }

        } 
        System.out.println("Book is not found in the system");
    
    }

    public void returnBook(String member_name, String book_name)
    {
        for (Book book : booksList) {
            if(book.getName().equalsIgnoreCase(book_name))
            {
                if(!book.isThisAvailable()) 
                {
                    for (Member member : membersList)
                    {
                        if(member.GetName().equalsIgnoreCase(member_name))
                        {
                            member.removeBorrowedBook(book_name);
                            book.changeStatus();
                            book.setBorrower(" ");
                            System.out.println(book.getName() + " is successfully returned by " + member_name);
                            return; 
                        }
                    }
                    System.out.println("Member name is not found in the system.");
                }

                else 
                {
                    System.out.println("Invalid action. " + book.getName() + "is still in inventory.");
                }
                return; 
            }

        } 
        System.out.println("Book not found in the system");
    }
}
