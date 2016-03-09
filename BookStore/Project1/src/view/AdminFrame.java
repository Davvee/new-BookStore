package view;

import controller.Controller;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigDecimal;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

import model.Book;

public class AdminFrame extends JFrame {
    private JLabel jLabel1 = new JLabel();
    private JButton btnAddBook = new JButton();
    private JTextField txtFieldBookTitle = new JTextField();
    private JSpinner spinnerAmountOfBooks = new JSpinner();
    private Controller controller;
    private JTextField txtFieldAuthor = new JTextField();
    private JTextField txtFieldPrice = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel lblNotification = new JLabel();
    private JScrollPane scrollAllBooks = new JScrollPane();
    private JTextArea txtAreaAllBooks = new JTextArea();
    private JButton btnBack = new JButton();
    private JLabel lblAdditionalNotification = new JLabel();

    public AdminFrame(Controller controller) {
        try {
            this.controller = controller;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getAllBooksInLibrary();
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(749, 484));
        jLabel1.setText("All books in library:");
        jLabel1.setBounds(new Rectangle(330, 220, 160, 30));
        jLabel1.setFont(new Font("Tahoma", 0, 15));
        btnAddBook.setText("Add Book(s)");
        btnAddBook.setBounds(new Rectangle(160, 150, 115, 25));
        btnAddBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAddBook_actionPerformed(e);
                }
            });
        txtFieldBookTitle.setBounds(new Rectangle(160, 20, 270, 25));
        spinnerAmountOfBooks.setBounds(new Rectangle(160, 110, 100, 25));
        txtFieldAuthor.setBounds(new Rectangle(160, 50, 270, 25));
        txtFieldPrice.setBounds(new Rectangle(160, 80, 270, 25));
        jLabel2.setText("Title");
        jLabel2.setBounds(new Rectangle(115, 25, 45, 15));
        jLabel3.setText("Author");
        jLabel3.setBounds(new Rectangle(115, 55, 45, 15));
        jLabel4.setText("Price");
        jLabel4.setBounds(new Rectangle(115, 85, 45, 15));
        jLabel5.setText("Quantity");
        jLabel5.setBounds(new Rectangle(115, 115, 45, 15));
        lblNotification.setText("");
        lblNotification.setBounds(new Rectangle(440, 85, 160, 15));
        lblNotification.setForeground(new Color(82, 255, 82));
        scrollAllBooks.setBounds(new Rectangle(185, 255, 455, 145));
        btnBack.setText("Back");
        btnBack.setBounds(new Rectangle(10, 20, 60, 20));
        btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnBack_actionPerformed(e);
                }
            });
        lblAdditionalNotification.setText("");
        lblAdditionalNotification.setForeground(new Color(82, 255, 82));
        lblAdditionalNotification.setBounds(new Rectangle(225, 185, 160, 15));
        scrollAllBooks.getViewport().add(txtAreaAllBooks, null);
        this.getContentPane().add(lblAdditionalNotification, null);
        this.getContentPane().add(btnBack, null);
        this.getContentPane().add(scrollAllBooks, null);
        this.getContentPane().add(lblNotification, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(txtFieldPrice, null);
        this.getContentPane().add(txtFieldAuthor, null);
        this.getContentPane().add(spinnerAmountOfBooks, null);
        this.getContentPane().add(txtFieldBookTitle, null);
        this.getContentPane().add(btnAddBook, null);
        this.getContentPane().add(jLabel1, null);
    }

    private void btnAddBook_actionPerformed(ActionEvent e) {
        int quantity = (Integer) spinnerAmountOfBooks.getValue();
        String bookTitle = txtFieldBookTitle.getText();
        String bookAuthor = txtFieldAuthor.getText();
        String stringPrice = txtFieldPrice.getText();
        if(stringPrice.contains(",")){
            stringPrice = stringPrice.replaceAll(",", ".");
        }
        BigDecimal price = null;
        try{
            price = new BigDecimal(stringPrice);
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        Book tmpBook = new Book(bookTitle, bookAuthor, price);
        boolean success = false;
        try{
            success = controller.add(tmpBook, quantity); 
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        if (success){
            JOptionPane.showMessageDialog(null, "The book(s) has been added");
            getAllBooksInLibrary();
        }
        else{
            JOptionPane.showMessageDialog(null, "The book(s) could not be added");
        }
    }

    private void btnGetBooks_actionPerformed(ActionEvent e) {
        getAllBooksInLibrary();
    }
    
    private void getAllBooksInLibrary(){
        try{
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Book, Integer> book : controller.getAllBooksInLibrary().entrySet()){
                sb.append(book.getKey().getTitle() + ", " + book.getKey().getAuthor() + ", " + book.getKey().getPrice().toString() + ", " + book.getValue().toString() + "\n");
            }
            txtAreaAllBooks.setText(sb.toString());
        }
        catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
    
    private void btnBack_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new MainFrame(controller).setVisible(true);
    }
}
