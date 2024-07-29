import java.util.ArrayList;

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

    public String GetName()
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


}
