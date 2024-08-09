import java.util.ArrayList;
import java.util.Collections;

public class Member {
    private String member_name; 
    private ArrayList<String> borrowed_books;  

    public Member(String member_name)
    {
        this.member_name = member_name; 
        borrowed_books = new ArrayList<>(); 
    }

    public void addBorrowedBook(String book_name)
    {
        borrowed_books.add(book_name); 
    }

    public void removeBorrowedBook(String book_name)
    {
        borrowed_books.remove(book_name); 
    }

    public void displayBorrowedBooks()
    {
        Collections.sort(borrowed_books); 
        for (String book: borrowed_books)
        {
            System.out.print(book);
            if (book != borrowed_books.get(borrowed_books.size()-1))
            {
                System.out.print(", ");
            }
        }
    }

    public String getName()
    {
        return member_name; 
    }

    public boolean BorrowedIsEmpty()
    {
        if (borrowed_books.isEmpty())
        {
            return true;
        }
        else 
        {
            return false; 
        }
    }

    public String toString()
    {
        if (borrowed_books.isEmpty())
        {
            return ""; 
        }
        
        StringBuilder line = new StringBuilder(); 
        for (String book : borrowed_books)
        {
            line.append(book).append(","); 
        }
        return line.substring(0, line.length() - 1); 
    }

}
