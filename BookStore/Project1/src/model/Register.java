package model;

import java.awt.Color;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Register implements BookList {
    private Map<Book, Integer> booksInBasket = new TreeMap<Book, Integer>(new BookComparator());
    private Map<Book, Integer> booksInLibrary = new TreeMap<Book, Integer>(new BookComparator());

    private BigDecimal totalCostInBasket;
    
    public Map<Book, Integer> getAllBooksInLibrary() {
        Map<Book, Integer> getAllBooksInLibrary = new TreeMap<Book, Integer>(new BookComparator());
        for (Map.Entry<Book, Integer> book : booksInLibrary.entrySet()) {
            getAllBooksInLibrary.put(book.getKey(), book.getValue());
        }
        return getAllBooksInLibrary;
    }

    public void clearBasket(){
        booksInBasket.clear();
    }

    public boolean addToBasket(Book b, int quantity) {
        boolean added = false;
        try{
            booksInBasket.put(b, quantity);
            added = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return added;
    }

    public Map<Book, Integer> getAllBooksInBasket() {
        Map<Book, Integer> getAllBooksInBasket = new TreeMap<Book, Integer>(new BookComparator());
        int totalQuantity = 0;
        List<BigDecimal> prices = new ArrayList<BigDecimal>();
        for (Map.Entry<Book, Integer> book : booksInBasket.entrySet()) {
            getAllBooksInBasket.put(book.getKey(), book.getValue());
            prices.add(book.getKey().getPrice());
            totalQuantity += book.getValue(); 
        }
        BigDecimal totalPrices = BigDecimal.ZERO;
        for (int i = 0; i < prices.size(); i++) 
        {
            totalPrices = totalPrices.add(prices.get(i));
        }
        BigDecimal totalCost = totalPrices.multiply(new BigDecimal(String.valueOf(totalQuantity)));
        setTotalCostInBasket(totalCost);
        
        return getAllBooksInBasket;
    }
    
    public boolean removeElementInBasket(String stringKey){
        boolean removed = false;
        String[] keyValues = stringKey.split(", ");
        String title = keyValues[0];
        String author = keyValues[1];
        String price = keyValues[2];
        BigDecimal bigDecimalPrice = null;
        if(price.contains(",")){
            price = price.replaceAll(",", "");
        }
        try{
            bigDecimalPrice = new BigDecimal(price);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        Book key = new Book(title, author, bigDecimalPrice);
        try{
            booksInBasket.remove(key);
            removed = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return removed;
    }

    @Override
    public boolean add(Book tmpBook, int amount) {
        boolean added = false;
        for (Map.Entry<Book, Integer> book : booksInLibrary.entrySet()) {
            if (book.getKey() == tmpBook) {
                amount += book.getValue();
                book.setValue(amount);
                added = true;
            }
        }
        if (added == false) {
            booksInLibrary.put(tmpBook, amount);
            added = true;
        }
        return added;
    }

    @Override
    public Book[] list(String searchString) {
        List<Book> foundBooks = new ArrayList<Book>();
        Book b;
        for (Map.Entry<Book, Integer> book : booksInLibrary.entrySet()) {
            b = book.getKey();
            String bookString = b.getTitle() + ", " + b.getAuthor() + ", " + b.getPrice().toString();
            if (bookString.contains(searchString)) {
                foundBooks.add(b);
            }
        }
        Book[] foundBooksArr = new Book[foundBooks.size()];
        foundBooksArr = foundBooks.toArray(foundBooksArr);
        return foundBooksArr;
    }

    @Override
    public int[] buy(Book... books) {
        Map<Book, Integer> booksToBuy = new HashMap<Book, Integer>();
        int ok = 0;
        int notInStock = 0;
        int doesNotExist = 0;
        String bookInBasketString = null;

        for(Book b : books){
            bookInBasketString = b.getTitle() + ", " + b.getAuthor() + ", " + b.getPrice().toString();
            break;
        }
        for(Map.Entry<Book, Integer> bookInLibrary : booksInLibrary.entrySet()){
            String bookInLibraryString = bookInLibrary.getKey().getTitle() + ", " + bookInLibrary.getKey().getAuthor() + ", " + bookInLibrary.getKey().getPrice().toString();
            if(bookInBasketString.equalsIgnoreCase(bookInLibraryString)){
                if (books.length > bookInLibrary.getValue()) {
                    notInStock = 1;
                    break;
                }
                else {
                    for(Book book : books){
                        bookInLibrary.setValue(bookInLibrary.getValue() - books.length);
                        ok = 1;
                        break;
                    }
                }
            }
        }
        
        if(notInStock == 0 && ok == 0){
            doesNotExist = 1;
        }
        
        int[] status = new int[] {ok, notInStock, doesNotExist};

        return status;
    }

    public void setTotalCostInBasket(BigDecimal totalCostInBasket) {
        this.totalCostInBasket = totalCostInBasket;
    }

    public BigDecimal getTotalCostInBasket() {
        return totalCostInBasket;
    }
}