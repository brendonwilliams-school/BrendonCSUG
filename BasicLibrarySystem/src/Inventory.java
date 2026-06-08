import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    public Inventory() {
        mainInventory = new ArrayList<>();
        lendingInventory = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        if (findBookById(book.getId(), mainInventory) != null ||
            findBookById(book.getId(), lendingInventory) != null) {
            return false;
        }

        mainInventory.add(book);
        return true;
    }

    public boolean borrowBook(int id) {
        Book book = findBookById(id, mainInventory);

        if (book != null) {
            mainInventory.remove(book);
            lendingInventory.add(book);
            return true;
        }

        return false;
    }

    public boolean returnBook(int id) {
        Book book = findBookById(id, lendingInventory);

        if (book != null) {
            lendingInventory.remove(book);
            mainInventory.add(book);
            return true;
        }

        return false;
    }

    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books are currently available in the library.");
            return;
        }

        for (Book book : mainInventory) {
            book.printBookInfo();
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    public int getMainInventoryCount() {
        return mainInventory.size();
    }

    public int getLendingInventoryCount() {
        return lendingInventory.size();
    }

    private Book findBookById(int id, ArrayList<Book> list) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }
}