package view;

import controller.Controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import model.Register;

public class BookStoreApplication {
    MainFrame myFrame;
    Register bookLibrary = new Register();
    Controller controller = new Controller(bookLibrary);
    public BookStoreApplication() {
        myFrame = new MainFrame(controller);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = myFrame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        myFrame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        BookStoreApplication bookStoreApplication = new BookStoreApplication();
        bookStoreApplication.link(); //Metoden finns nedan!
    }
    
    private void link() {
        myFrame.setController(controller);
    }
}
