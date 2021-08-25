package Frame;

import Database.DBConnection;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    static JFrame frame = new JFrame("Frame.Login");
    int xx,xy;


    public Login() {

        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 729, 476);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 346, 490);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Buy More");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(new Color(240, 248, 255));
        lblNewLabel.setBounds(139, 305, 84, 27);
        panel.add(lblNewLabel);

        JLabel label = new JLabel("");

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                xx = e.getX();
                xy = e.getY();
            }
        });
        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {

                int x = arg0.getXOnScreen();
                int y = arg0.getYOnScreen();
                Login.this.setLocation(x - xx, y - xy);
            }
        });
        label.setBounds(-38, 0, 420, 275);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setIcon(new ImageIcon(Login.class.getResource("/assets/supermarket.jpg")));
        panel.add(label);





        JLabel lblWeGotYou = new JLabel("....We got you....");
        lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
        lblWeGotYou.setForeground(new Color(240, 248, 255));
        lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblWeGotYou.setBounds(111, 343, 141, 27);
        panel.add(lblWeGotYou);

        Button button = new Button("SignUp");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (textField_1.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Bạn chưa nhập thông tin người dùng","Chương trình quản ly sản phẩm",JOptionPane.YES_OPTION);
                } else {
                    try {
                        Connection connection = (Connection) DBConnection.getConnection();
                        Statement stmt = connection.createStatement();
                        String sql = "Select * from tbl_employee where employee_gmail  ='" + textField_1.getText() + "'and employee_password = '" + passwordField.getText().toString() + "'";
                        ResultSet rs = stmt.executeQuery(sql);
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                            dispose();
                            StoreFrame store = new StoreFrame();
                            store.setVisible(true);

                        } else
                            JOptionPane.showConfirmDialog(null, "Mật khẩu hoặc tên đăng nhập không đúng");
                        connection.close();
                    } catch (Exception e) {
                        System.out.print(e);
                    }
                }
            }
        });
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(241, 57, 83));
        button.setBounds(395, 363, 283, 36);
        contentPane.add(button);

        JLabel lblUsername = new JLabel("   HỆ THỐNG QUẢN LÝ CỬA HÀNG THỰC PHẨM");
        lblUsername.setFont(new Font("SansSerif Bold", Font.BOLD, 13));
        lblUsername.setBounds(371, 69, 334, 52);
        contentPane.add(lblUsername);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(395, 132, 54, 14);
        contentPane.add(lblEmail);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(395, 157, 283, 36);
        contentPane.add(textField_1);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(395, 204, 96, 14);
        contentPane.add(lblPassword);

        JLabel lblRepeatPassword = new JLabel("REPEAT PASSWORD");
        lblRepeatPassword.setBounds(395, 275, 133, 14);
        contentPane.add(lblRepeatPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(395, 229, 283, 36);
        contentPane.add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(395, 293, 283, 36);
        contentPane.add(passwordField_1);

        JLabel lbl_close = new JLabel("X");
        lbl_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                System.exit(0);
            }
        });
        lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_close.setForeground(new Color(241, 57, 83));
        lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_close.setBounds(691, 0, 37, 27);
        contentPane.add(lbl_close);

    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login frame = new Login();
                frame.setUndecorated(true);
                frame.setVisible(true);
            }
        });
    }
}

