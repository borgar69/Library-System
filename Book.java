public class Book {
    private String book_name;  
    private boolean status; 

    public Book (String book_name, boolean status){
        this.book_name = book_name; 
        this.status = status; 
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

}
