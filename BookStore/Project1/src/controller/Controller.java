package controller;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import java.util.TreeMap;

import model.Book;
import model.BookComparator;
import model.Register;

import view.CustomerFrame;
import view.MainFrame;

public class Controller {
    private Register register;
    private LoadValues loadValues;
    
    public Controller(Register register){
        this.register = register;
        loadValues = new LoadValues(register);
        loadValues.loadBooks();
    }
    
    public void clearBasket(){
        register.clearBasket();
    }
    
    public Book[] list(String searchString){
        Book[] tmpBook = null;
        tmpBook = register.list(searchString);
        return tmpBook;
    }
    
    public Map<Book, Integer> getAllBooksInLibrary(){
        Map<Book, Integer> getAllBooksInLibrary = new TreeMap<Book, Integer>(new BookComparator());
        for(Map.Entry<Book, Integer> book : register.getAllBooksInLibrary().entrySet()){
            getAllBooksInLibrary.put(book.getKey(), book.getValue());
        }
        return getAllBooksInLibrary;
    }
    
    public Map<Book, Integer> getAllBooksInBasket(){
        Map<Book, Integer> getAllBooksInBasket = new TreeMap<Book, Integer>(new BookComparator());
        for(Map.Entry<Book, Integer> book : register.getAllBooksInBasket().entrySet()){
            getAllBooksInBasket.put(book.getKey(), book.getValue());
        }
        return getAllBooksInBasket;
    }
    
    public boolean add(Book tmpBook, int amount){
        return register.add(tmpBook, amount);
    }
    
    public boolean addToBasket(Book tmpBook, int amount){
        return register.addToBasket(tmpBook, amount);
    }
    
    public BigDecimal getTotalCostInBasket(){
        return register.getTotalCostInBasket();
    }
    
    public boolean removeElementInBasket(String key){
        return register.removeElementInBasket(key);
    }
    
    public int[] buy(Book... books){
        ArrayList<Integer> buy = new ArrayList<Integer>();
        for(int i : register.buy(books)){
            buy.add(i);
        }
        int[] amountOfEachBookArr = new int[buy.size()];
        for (int i=0; i < amountOfEachBookArr.length; i++){
            amountOfEachBookArr[i] = buy.get(i).intValue();
        }
        return amountOfEachBookArr;
    }
}
