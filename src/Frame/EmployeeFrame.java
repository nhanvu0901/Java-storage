package Frame;

import Model.Employee;
import Model.Store;
import Modify.EmployeeModify;
import Modify.StoreModify;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class EmployeeFrame extends javax.swing.JFrame {
    DefaultTableModel tableModel;

    List<Employee> EmployeeList = new ArrayList<>();

    /**
     * Creates new form Frame.EmployeeFrame
     */
    public EmployeeFrame() {
        initComponents();

        tableModel = (DefaultTableModel) tblEmployee.getModel();

        showEmployee();
    }
    public  static int parseWithDefault(String s, int def) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
            return def;
        }
    }
    public void date() {
        try {
            df = new MaskFormatter("##:##-##:##");
            //df.setPlaceholderCharacter('');
        }catch(ParseException e) {
            e.printStackTrace();
        }
    }//

    private void showEmployee() {
        EmployeeList = EmployeeModify.findAll();

        tableModel.setRowCount(0);

        EmployeeList.forEach((Employee) -> {
            tableModel.addRow(new Object[]{Employee.getEmployee_id(), Employee.getEmployee_name(),
                    Employee.getEmployee_gender(), Employee.getEmployee_gmail(), Employee.getEmployee_password(),Employee.getEmployee_job(),Employee.getEmployee_shift()});
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setBounds(100, 100, 946, 520);
        jPanel1 = new javax.swing.JPanel();
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showEmployee();
            }
        });
        jLabel1 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnNewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showEmployee();
            }
        });
        lblNewLabel = new javax.swing.JLabel();


        tblEmployee = new JTable(tableModel);
        tblEmployee.setAutoCreateRowSorter(true);
        tblEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModel = (DefaultTableModel) tblEmployee.getModel();
                String id = tableModel.getValueAt(tblEmployee.getSelectedRow(), 0).toString();
                String name = tableModel.getValueAt(tblEmployee.getSelectedRow(), 1).toString();
                String gender = tableModel.getValueAt(tblEmployee.getSelectedRow(), 2).toString();
                String email = tableModel.getValueAt(tblEmployee.getSelectedRow(), 3).toString();
                String password = tableModel.getValueAt(tblEmployee.getSelectedRow(), 4).toString();
                String job = tableModel.getValueAt(tblEmployee.getSelectedRow(), 5).toString();
                String shift = tableModel.getValueAt(tblEmployee.getSelectedRow(), 6).toString();


                textField_1.setText(id);
                txtFullname.setText(name);
                for (int i = 0; i < cbGender.getItemCount(); i++) {
                    if (cbGender.getItemAt(i).toString().equalsIgnoreCase(gender)) {
                        cbGender.setSelectedIndex(i);
                    }
                }
                txtEmail.setText(email);
                txtPassword.setText(password);
                for (int i = 0; i < comboBox_1.getItemCount(); i++) {
                    if (comboBox_1.getItemAt(i).toString().equalsIgnoreCase(job)) {
                        comboBox_1.setSelectedIndex(i);
                    }
                }
                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    if (comboBox.getItemAt(i).toString().equalsIgnoreCase(shift)) {
                        comboBox.setSelectedIndex(i);
                    }
                }


            }
        });
        tblEmployee.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Họ và tên", "Giới tính", "Email", "Password","Chức vụ","Ca làm việc"
                }
        ));
        jScrollPane1.setViewportView(tblEmployee);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin cho nhân viên"));

        jLabel1.setText("Họ và tên:");
        jLabel1.setHorizontalTextPosition(JLabel.LEFT);;
        jLabel1.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/employee-1.png")));

        jLabel2.setText("Giới tính: ");
        jLabel2.setHorizontalTextPosition(JLabel.LEFT);;
        jLabel2.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/gender.png")));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nam", "Nữ"}));

        jLabel4.setText("Email:");
        jLabel4.setHorizontalTextPosition(JLabel.LEFT);;
        jLabel4.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/icons8-send-email-24.png")));

        jLabel5.setText("Password:");
        jLabel5.setHorizontalTextPosition(JLabel.LEFT);;
        jLabel5.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/icons8-password-26.png")));

        btnSave.setText("Thêm");
        btnSave.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/plus.png")));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/icons8-process-24.png")));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/delete.png")));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Tìm");
        btnFind.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/search.png")));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnNewButton.setText("Edit");
        btnNewButton.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/edit.png")));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblNewLabel.setText("Chức vụ:");
        lblNewLabel.setHorizontalTextPosition(JLabel.LEFT);;
        lblNewLabel.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/job.png")));

        JLabel lblNewLabel_1 = new JLabel("ID");

        textField_1 = new JTextField();
        textField_1.setColumns(10);



        btnNewButton_1 = new JButton("Return");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageIcon icon = new ImageIcon(StoreFrame.class.getResource("/assets/icons8-question-mark-64.png"));
                int n = JOptionPane.showOptionDialog(new JFrame(), "Bạn có muốn rời trang này",
                        "Chương trình quản lý cửa hàng thực phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        icon, new Object[] {"Yes", "No"}, JOptionPane.YES_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    dispose();
                    StoreFrame storeFrame = new StoreFrame();


                } else if (n == JOptionPane.NO_OPTION) {
                    return;
                } else if (n == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Closed by hitting the cross");
                }
            }
        });

        JLabel lblNewLabel_2 = new JLabel("Ca làm việc");
        date();

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "07:00-11:00", "13:00-15:00", "15:00-18:00", "08:00-17:00", "15:00-21:00"}));

        comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Chọn", "Thu ngân", "Nhân Viên part time", "Quản lý", "Lao công", "Bảo vệ"}));


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(823, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                                .addGap(57))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                                        .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                                        .addComponent(txtFullname, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                                        .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(94)))
                                                .addGap(66))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9)
                                                .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                .addGap(45)
                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35)
                                                .addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2))
                                .addGap(18)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(15)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1))
                                .addGap(18)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(19)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1)
                                .addGap(20))
        );
        jPanel1.setLayout(jPanel1Layout);



        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 346, 490);

        panel.setLayout(null);


        JLabel label = new JLabel("");
        label.setBounds(0, 0, 313, 448);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setIcon(new ImageIcon(Login.class.getResource("/assets/employee.jpg")));
        panel.add(label);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        JLabel lblNewLabel_3 = new JLabel("Together we work");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(67, 459, 182, 48);
        panel.add(lblNewLabel_3);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txtFullname.setText("");
        cbGender.setSelectedIndex(0);
        comboBox_1.setSelectedIndex(0);
        comboBox.setSelectedIndex(0);
        txtEmail.setText("");
        txtPassword.setText("");

        textField_1.setText("");

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int id = parseWithDefault(textField_1.getText().trim(),0);
        String fullname = txtFullname.getText();
        String gender = cbGender.getSelectedItem().toString();

        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String job = comboBox_1.getSelectedItem().toString();
        String shift = comboBox.getSelectedItem().toString();

        Employee std = new Employee(id,fullname, gender, email, password,job,shift);


        if(fullname.equals("") || gender.equals("") || email.equals("") || password.equals("") || job.equals("")||shift.equals("")){
            JOptionPane.showMessageDialog(null, "Không được để trống dòng ","Chương trình quản ly sản phẩm",JOptionPane.YES_OPTION);
        }
        else{
            int row = tblEmployee.getRowCount();
            String[] checkId = new String[row];
            String[] checkName = new String[row];
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                String ob = tblEmployee.getModel().getValueAt(i,0).toString().trim();
                String bo = tblEmployee.getModel().getValueAt(i,1).toString().trim();
                checkId[i] =ob;
                checkName[i] = bo;
            }
            for (int i = 0; i < checkId.length; i++) {
                if (checkId[i].equals(textField_1.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Số ID đã có trong dữ liệu vui lòng nhập lại", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
                    flag = false;
                    break;
                }
                if(checkName[i].equals(txtFullname.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Tên đã có trong dữ liệu vui lòng nhập lại", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
                    flag = false;
                    break;
                }

            }
            if(flag == true){
                JOptionPane.showMessageDialog(null,"Thêm người thành công");
                EmployeeModify.insert(std);
                showEmployee();
            }
        }

    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int selectedIndex = tblEmployee.getSelectedRow();
        if (selectedIndex >= 0) {
            Employee std = EmployeeList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa người này?");
            System.out.println("option : " + option);

            if (option == 0) {
                EmployeeModify.delete(std.getEmployee_id());

                showEmployee();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Không có người để xóa","Chương trình quản ly sản phẩm",JOptionPane.YES_OPTION);
        }
    }

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "Gõ họ tên để tìm :");
        if (input != null && input.length() > 0) {
            EmployeeList = EmployeeModify.findByName(input);

            tableModel.setRowCount(0);

            EmployeeList.forEach((Employee) -> {
                tableModel.addRow(new Object[]{Employee.getEmployee_id(), Employee.getEmployee_name(),
                        Employee.getEmployee_gender(), Employee.getEmployee_gmail(), Employee.getEmployee_password(),Employee.getEmployee_job(),Employee.getEmployee_shift()});
            });
        } else {
            JOptionPane.showMessageDialog(null,"Không để trống dòng","Chương trình quản ly sản phẩm",JOptionPane.YES_OPTION);
            showEmployee();
        }
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        tableModel = (DefaultTableModel) tblEmployee.getModel();
        if (tblEmployee.getSelectedRow() >= 0) {
            int id = parseWithDefault(textField_1.getText().trim(), 0);
            String fullname = txtFullname.getText();
            String gender = cbGender.getSelectedItem().toString();

            String email = txtEmail.getText();
            String password = txtPassword.getText();
            String job = comboBox_1.getSelectedItem().toString();
            String shift = comboBox.getSelectedItem().toString();
            Employee std = new Employee(id, fullname, gender, email, password, job, shift);

            int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa? Dữ liệu sẽ bị mất");
            if (x == 0) {
                try {
                    EmployeeModify.update(std);
                    JOptionPane.showMessageDialog(this,"Sửa dữ liệu thành công");
                    showEmployee();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error in updating edit fields");
                }
            }
        }
        else{
            if (tblEmployee.getRowCount() == 0){
                JOptionPane.showMessageDialog(this,"Bảng dữ liệu đang trống");
            }
            else {
                JOptionPane.showMessageDialog(this, "Chọn vào hàng cần edit dữ liệu");
            }
        }
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
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    static JFrame frame = new JFrame("Employee");
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnNewButton;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JLabel lblNewLabel;
    private JTextField textField_1;
    private JButton btnNewButton_1;
    static MaskFormatter df;
    private JComboBox comboBox_1;
    private JComboBox comboBox;
}
