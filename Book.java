public class Book {
    private String book_name;  
    private boolean status; 
    private String borrower; 

    public Book (String book_name, boolean status, String borrower){
        this.book_name = book_name; 
        this.status = status; 
        this.borrower = borrower; 
    }

    public boolean isThisAvailable()
    {
        return status; 
    }

    public String getName()
    {
        return book_name; 
    }

    public void changeStatus()
    {
        status = !status; 
    }

    public boolean getStatus()
    {
        return status; 
    }

    public void setBorrower(String borrower)
    {
        this.borrower = borrower; 
    }
    
    public String getBorrower()
    {
        return borrower; 
    }

}
