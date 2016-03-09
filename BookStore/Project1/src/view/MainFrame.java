package view;

import controller.Controller;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private JButton btnAdminView = new JButton();
    private JButton btnCustomerView = new JButton();
    private Controller controller;

    public void setController(Controller controller){
        this.controller = controller;
    }

    public MainFrame(Controller controller) {
        try {
            this.controller = controller;
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize( new Dimension(400, 300) );
        btnAdminView.setText("Admin View");
        btnAdminView.setBounds(new Rectangle(80, 50, 235, 70));
        btnAdminView.setFont(new Font("Tahoma", 0, 17));
        btnAdminView.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAdminView_actionPerformed(e);
                }
            });
        btnCustomerView.setText("Customer View");
        btnCustomerView.setBounds(new Rectangle(80, 150, 235, 70));
        btnCustomerView.setFont(new Font("Tahoma", 0, 17));
        btnCustomerView.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnCustomerView_actionPerformed(e);
                }
            });
        this.getContentPane().add(btnCustomerView, null);
        this.getContentPane().add(btnAdminView, null);
    }

    private void btnAdminView_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new AdminFrame(controller).setVisible(true);
    }

    private void btnCustomerView_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new CustomerFrame(controller).setVisible(true);
    }
}
