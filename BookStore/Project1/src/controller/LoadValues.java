package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.text.DecimalFormat;

import java.text.DecimalFormatSymbols;

import java.text.ParseException;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import model.Book;
import model.Register;

public class LoadValues {

    private static Register register;

    public LoadValues(Register register) {
        this.register = register;
    }

    public static void main(String[] args) {
        register = new Register();
        File file = new File("textfile.txt");
        loadBooks();
        Controller controller = new Controller(register);
        
        for (Map.Entry<Book, Integer> bookInLibrary : register.getAllBooksInBasket().entrySet()) {
            System.out.println(bookInLibrary.getKey().getTitle() + ", " + bookInLibrary.getKey().getAuthor() + ", " + bookInLibrary.getKey()
                .getPrice().toString() + ", " + bookInLibrary.getValue());
        }
    }

    /**
     * loads all books
     */
    public static void loadBooks() {
        File file = new File("textfile.txt");
        String line;
        BufferedReader read;

        try {
            read = new BufferedReader(new FileReader(file));

            while ((line = read.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ";");

                String tmpTitle = token.nextToken();
                String tmpAuthor = token.nextToken();
                String stringPrice = token.nextToken();
                if (stringPrice.contains(",")) {
                    stringPrice = stringPrice.replaceAll(",", "");
                }
                BigDecimal tmpPrice = new BigDecimal(stringPrice);

                int tmpAmount = Integer.parseInt(token.nextToken());

                Book tmpBook = new Book(tmpTitle, tmpAuthor, tmpPrice);
                            
                register.add(tmpBook, tmpAmount);
            }
            read.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
