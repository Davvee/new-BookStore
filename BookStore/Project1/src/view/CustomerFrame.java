package view;

import controller.Controller;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Book;

public class CustomerFrame extends JFrame {
    private JLabel bookViewLabel = new JLabel();
    private JLabel bookViewLabel1 = new JLabel();
    private JTextField searchTextField = new JTextField();
    private JButton search = new JButton();
    private JTextField txtFieldTitle = new JTextField();
    private JButton addToBasket = new JButton();
    private JLabel bookViewLabel2 = new JLabel();
    private JButton buy = new JButton();
    private Controller controller;
    private JButton btnGetAllBooksInLibrary = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea txtAreaBookView = new JTextArea();
    private JButton btnBack = new JButton();
    private JLabel jLabel2 = new JLabel();
    private JSpinner spinnerQuantity = new JSpinner();
    private JTextField txtFieldAuthor = new JTextField();
    private JTextField txtFieldPrice = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JButton btnRemoveElement = new JButton();
    private DefaultListModel defaultListModelForBooksInBasket = new DefaultListModel();
    private JList jlistBooksInBasket = new JList(defaultListModelForBooksInBasket);
    private JLabel jLabel6 = new JLabel();
    private JTextField txtFieldTotalCost = new JTextField();
    private DefaultListModel defaultListModelForBoughtBooks = new DefaultListModel();
    private JList jlistBoughtBooks = new JList(defaultListModelForBoughtBooks);
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JScrollPane jScrollPane3 = new JScrollPane();

    public CustomerFrame(Controller controller) {
        try {
            this.controller = controller;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(931, 531));
        this.setFont(new Font("Dialog", 1, 20));
        bookViewLabel.setText("Book view");
        bookViewLabel.setBounds(new Rectangle(590, 5, 115, 45));
        bookViewLabel.setFont(new Font("Tahoma", 1, 17));
        bookViewLabel1.setText("Books you have bought:");
        bookViewLabel1.setBounds(new Rectangle(590, 320, 225, 25));
        bookViewLabel1.setFont(new Font("Tahoma", 1, 17));
        searchTextField.setBounds(new Rectangle(120, 65, 225, 20));
        search.setText("Search");
        search.setBounds(new Rectangle(360, 65, 115, 20));
        search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    search_actionPerformed(e);
                }
            });
        txtFieldTitle.setBounds(new Rectangle(120, 110, 100, 20));
        addToBasket.setText("Add to basket");
        addToBasket.setBounds(new Rectangle(120, 210, 115, 20));
        addToBasket.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addToBasket_actionPerformed(e);
                }
            });
        bookViewLabel2.setText("Books in basket:");
        bookViewLabel2.setBounds(new Rectangle(45, 240, 225, 45));
        bookViewLabel2.setFont(new Font("Tahoma", 1, 17));
        buy.setText("BUY");
        buy.setBounds(new Rectangle(200, 435, 100, 45));
        buy.setFont(new Font("Tahoma", 0, 16));
        buy.setBackground(new Color(0, 226, 0));
        buy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    buy_actionPerformed(e);
                }
            });
        btnGetAllBooksInLibrary.setText("Get all books in library");
        btnGetAllBooksInLibrary.setBounds(new Rectangle(695, 20, 155, 20));
        btnGetAllBooksInLibrary.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnGetAllBooksInLibrary_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(525, 50, 380, 260));
        btnBack.setText("Back");
        btnBack.setBounds(new Rectangle(15, 15, 75, 21));
        btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnBack_actionPerformed(e);
                }
            });
        jLabel2.setText("jLabel2");
        spinnerQuantity.setBounds(new Rectangle(120, 185, 100, 20));
        txtFieldAuthor.setBounds(new Rectangle(120, 135, 100, 20));
        txtFieldPrice.setBounds(new Rectangle(120, 160, 100, 20));
        jLabel1.setText("Title");
        jLabel1.setBounds(new Rectangle(65, 110, 34, 14));
        jLabel3.setText("Author");
        jLabel3.setBounds(new Rectangle(65, 135, 35, 15));
        jLabel4.setText("Price");
        jLabel4.setBounds(new Rectangle(65, 160, 35, 15));
        jLabel5.setText("Quantity");
        jLabel5.setBounds(new Rectangle(65, 185, 50, 15));
        btnRemoveElement.setText("Remove Element");
        btnRemoveElement.setBounds(new Rectangle(40, 435, 115, 20));
        btnRemoveElement.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnClearBasket_actionPerformed(e);
                }
            });
        jLabel6.setText("Total cost (kr):");
        jLabel6.setBounds(new Rectangle(320, 435, 75, 15));
        txtFieldTotalCost.setBounds(new Rectangle(395, 430, 90, 25));
        jScrollPane2.setBounds(new Rectangle(40, 280, 445, 145));
        jScrollPane3.setBounds(new Rectangle(525, 350, 380, 130));
        jScrollPane1.getViewport().add(txtAreaBookView, null);
        jScrollPane2.getViewport().add(jlistBooksInBasket, null);
        jScrollPane3.getViewport().add(jlistBoughtBooks, null);
        this.getContentPane().add(jScrollPane3, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(txtFieldTotalCost, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(btnRemoveElement, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(txtFieldPrice, null);
        this.getContentPane().add(txtFieldAuthor, null);
        this.getContentPane().add(spinnerQuantity, null);
        this.getContentPane().add(btnBack, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(btnGetAllBooksInLibrary, null);
        this.getContentPane().add(buy, null);
        this.getContentPane().add(bookViewLabel2, null);
        this.getContentPane().add(addToBasket, null);
        this.getContentPane().add(txtFieldTitle, null);
        this.getContentPane().add(search, null);
        this.getContentPane().add(searchTextField, null);
        this.getContentPane().add(bookViewLabel1, null);
        this.getContentPane().add(bookViewLabel, null);
    }

    private void search_actionPerformed(ActionEvent e) {
        String searchString = searchTextField.getText();
        Book[] searchedBooks = null;
        try{
            searchedBooks = controller.list(searchString);
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        for(Book b : searchedBooks){
            sb.append(b.getTitle() + ", " + b.getAuthor() + ", " + b.getPrice().toString() + "\n");
        }
        txtAreaBookView.setText(sb.toString());
    }

    private void btnGetAllBooksInLibrary_actionPerformed(ActionEvent e) {
        getBooksInLibrary();
    }

    private void addToBasket_actionPerformed(ActionEvent e) {
        int quantity = (Integer) spinnerQuantity.getValue();
        if(quantity != 0){
            String title = txtFieldTitle.getText(); 
            String author = txtFieldAuthor.getText();
            String stringPrice = txtFieldPrice.getText();
            BigDecimal price = convertStringToBigDecimal(stringPrice);
            BigDecimal totalCost = price.multiply(new BigDecimal(quantity));
            Book book = new Book(title, author, price);
            boolean success = false;
            try{
                success = controller.addToBasket(book, quantity);
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            if(success == false){
                JOptionPane.showMessageDialog(null, "This book doesn't exist in the library");
            }
            else{
                getAllBooksInBasket();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Quantity is 0");
        }
    }

    private void buy_actionPerformed(ActionEvent e) {
        if(!jlistBooksInBasket.isSelectionEmpty()){
            ArrayList<Book> books = new ArrayList<Book>();
            String book = jlistBooksInBasket.getSelectedValue().toString();
            String[] bookValues = book.split(", ");
            String title = bookValues[0]; 
            String author = bookValues[1];
            String stringPrice = bookValues[2];
            BigDecimal price = convertStringToBigDecimal(stringPrice);
            Book tmpBook = new Book(title, author, price);
            int quantity = Integer.parseInt(bookValues[3]);
        
            for(int i = 0; i<quantity; i++){
                books.add(tmpBook);
            }
        
            Book[] booksArr = new Book[books.size()];
            for (int i=0; i < booksArr.length; i++){
                booksArr[i] = books.get(i);
            }
            int[] status = null;
            try{
                status = controller.buy(booksArr);
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            if(status[2] == 1){
                JOptionPane.showMessageDialog(null, "Status (Does_Not_Exist): Book(s) does not exist in our store");
            }
        
            else if(status[1] == 1){
                JOptionPane.showMessageDialog(null, "Status (Not_In_Stock): Book(s) is not in stock");
            }
        
            else if(status[0] == 1){
                JOptionPane.showMessageDialog(null, "Status (OK): Thank you for buying book(s) in our store");
                Object key = jlistBooksInBasket.getSelectedValue();
                defaultListModelForBoughtBooks.addElement(key.toString());
                controller.removeElementInBasket(key.toString());
                getAllBooksInBasket();
                getBooksInLibrary();
            }
            else{
                JOptionPane.showMessageDialog(null, "Status (Error): Something is wrong with the program");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You must click on the book(s) you want in the basket");
        }
    }

    private void btnBack_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new MainFrame(controller).setVisible(true);
    }

    private void btnClearBasket_actionPerformed(ActionEvent e) {
        if(!jlistBooksInBasket.isSelectionEmpty()){
            Object key = jlistBooksInBasket.getSelectedValue();
            boolean removed = controller.removeElementInBasket(key.toString());
            if(removed){
                JOptionPane.showMessageDialog(null, "The book(s) have been removed");
                getAllBooksInBasket();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You must click on the book(s) you want to remove in the basket");
        }
    }
    
    private void clearBasket(){
        controller.clearBasket();
        defaultListModelForBooksInBasket.removeAllElements();
        txtFieldTotalCost.setText("");
    }
    
    private BigDecimal convertStringToBigDecimal(String value){
        BigDecimal bigDecimalValue = null;
        if(value.contains(",")){
            value = value.replaceAll(",", "");
        }
        try{
            bigDecimalValue = new BigDecimal(value);
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return bigDecimalValue;
    }
    
    private void getAllBooksInBasket(){
        defaultListModelForBooksInBasket.removeAllElements();
        try{
            for(Map.Entry<Book, Integer> book : controller.getAllBooksInBasket().entrySet()){
                defaultListModelForBooksInBasket.addElement(book.getKey().getTitle() + ", " + book.getKey().getAuthor() + ", " + book.getKey().getPrice().toString() + ", " + book.getValue());
            }
            txtFieldTotalCost.setText(controller.getTotalCostInBasket().toString());
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
    
    private void getBooksInLibrary(){
        try{
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Book, Integer> book : controller.getAllBooksInLibrary().entrySet()){
                sb.append(book.getKey().getTitle() + ", " + book.getKey().getAuthor() + ", " + book.getKey().getPrice().toString() + ", " + book.getValue() + "\n");
            }
            txtAreaBookView.setText(sb.toString());
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
