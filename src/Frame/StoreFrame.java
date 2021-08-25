package Frame;

import Model.Store;
import Modify.StoreModify;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;


public class StoreFrame extends javax.swing.JFrame {
    DefaultTableModel tableModel;

    List<Store> storeList = new ArrayList<>();

    public static int parseWithDefault(String s, int def) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
            return def;
        }
    }

    public static double parseWithDefaultDouble(String s, double def) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
            return def;
        }
    }

    public StoreFrame() {
        initComponents();

        tableModel = (DefaultTableModel) tblStore.getModel();

        showStore();
    }

    private void showStore() { // tao mot list de lay du lieu tu database
        storeList = StoreModify.findAll();

        tableModel.setRowCount(0);

        storeList.forEach((store) -> {
            tableModel.addRow(new Object[]{store.getFood_id(),
                    store.getFood_name(), store.getFood_kind(), store.getFood_number(), store.getFood_price(), store.getFood_dateInput(), store.getFood_dayMade(), store.getFood_expired(), store.getFood_origin()});
        });
        cal();
    }

    public void date() {
        try {
            df = new MaskFormatter("##/##/####");
            //df.setPlaceholderCharacter('-');
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    public void cal() {
        float total = 0;
        for (int i = 0; i < tblStore.getRowCount(); i++) {

            float price = Float.parseFloat(tblStore.getValueAt(i, 4).toString());

            float amount = Float.parseFloat(tblStore.getValueAt(i, 3).toString());
            total += (price * amount);

        }

        txtMoney.setText(fmt(total));
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().setForeground(Color.RED);
        frame.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showStore();
            }
        });
        frame.setBounds(100, 100, 1297, 546);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        date();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                showStore();
            }
        });
        scrollPane.setBounds(529, 0, 770, 509);

        tblStore = new JTable(tableModel);
        tblStore.setAutoCreateRowSorter(true);
        tblStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModel = (DefaultTableModel) tblStore.getModel();
                String id = tableModel.getValueAt(tblStore.getSelectedRow(), 0).toString();
                String name = tableModel.getValueAt(tblStore.getSelectedRow(), 1).toString();
                String kind = tableModel.getValueAt(tblStore.getSelectedRow(), 2).toString();
                String number = tableModel.getValueAt(tblStore.getSelectedRow(), 3).toString();
                String price = tableModel.getValueAt(tblStore.getSelectedRow(), 4).toString();
                String inputDay = tableModel.getValueAt(tblStore.getSelectedRow(), 5).toString();
                String dayMade = tableModel.getValueAt(tblStore.getSelectedRow(), 6).toString();
                String expired = tableModel.getValueAt(tblStore.getSelectedRow(), 7).toString();
                String origin = tableModel.getValueAt(tblStore.getSelectedRow(), 8).toString();

                txMaSP.setText(id);
                txName.setText(name);
                for (int i = 0; i < txtkind.getItemCount(); i++) {
                    if (txtkind.getItemAt(i).toString().equalsIgnoreCase(kind)) {
                        txtkind.setSelectedIndex(i);
                    }
                }
                txNumber.setText(number);
                txPrice.setText(price);
                txDateInput.setText(inputDay);
                txDayMade.setText(dayMade);
                txExpired.setText(expired);
                txOrigin.setText(origin);


            }
        });

        tblStore.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Loai s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 c\u1EA3", "Ng\u00E0y nh\u1EADp", "Ng\u00E0y SX", "H\u1EA1n SD", "Xu\u1EA5t x\u1EE9"
                }
        ));
        tblStore.getColumnModel().getColumn(0).setPreferredWidth(84);
        tblStore.getColumnModel().getColumn(1).setPreferredWidth(80);
        scrollPane.setViewportView(tblStore);
        frame.getContentPane().add(scrollPane);

        JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD S\u1EA2N PH\u1EA8M C\u1EE6A C\u1EECA H\u00C0NG");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 11, 233, 39);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
        lblNewLabel_1.setBounds(20, 76, 78, 27);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
        lblNewLabel_1_1.setBounds(20, 114, 88, 27);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng\r\n");
        lblNewLabel_1_2.setBounds(20, 153, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Gi\u00E1 c\u1EA3\r\n");
        lblNewLabel_1_3.setBounds(20, 188, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_5 = new JLabel("Ng\u00E0y nh\u1EADp");
        lblNewLabel_1_5.setBounds(277, 74, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t\r\n");
        lblNewLabel_1_6.setBounds(277, 112, 92, 27);
        frame.getContentPane().add(lblNewLabel_1_6);

        JLabel lblNewLabel_1_7 = new JLabel("H\u1EA1n s\u1EED d\u1EE5ng");
        lblNewLabel_1_7.setBounds(277, 150, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_7);

        JLabel lblNewLabel_1_8 = new JLabel("Xu\u1EA5t x\u1EE9");
        lblNewLabel_1_8.setBounds(277, 188, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_8);

        txMaSP = new JTextField();

        txMaSP.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String s = txMaSP.getText().trim();
                char[] ch= s.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    if(ch[i] >='a' && ch[i] <='z'){
                        JOptionPane.showMessageDialog(null,"Mã sản phẩm chỉ nhận số xin mời nhập lại");
                        txMaSP.setText("");
                        break;
                    }

                }

            }
        });

        txMaSP.setBounds(108, 77, 96, 27);
        frame.getContentPane().add(txMaSP);
        txMaSP.setColumns(10);

        txName = new JTextField();
        txName.setColumns(10);
        txName.setBounds(108, 115, 96, 26);
        frame.getContentPane().add(txName);

        txNumber = new JTextField();
        txNumber.setColumns(10);
        txNumber.setBounds(108, 153, 96, 27);
        frame.getContentPane().add(txNumber);

        txPrice = new JTextField();
        txPrice.setColumns(10);
        txPrice.setBounds(108, 188, 96, 27);
        frame.getContentPane().add(txPrice);


        txDateInput = new JFormattedTextField(df);

        txDateInput.setColumns(10);
        txDateInput.setBounds(379, 77, 96, 26);
        frame.getContentPane().add(txDateInput);

        txDayMade = new JFormattedTextField(df);

        txDayMade.setColumns(10);
        txDayMade.setBounds(379, 115, 96, 26);
        frame.getContentPane().add(txDayMade);

        txExpired = new JFormattedTextField(df);

        txExpired.setColumns(10);
        txExpired.setBounds(379, 153, 96, 27);
        frame.getContentPane().add(txExpired);

        txOrigin = new JTextField();
        txOrigin.setColumns(10);
        txOrigin.setBounds(379, 191, 96, 24);
        frame.getContentPane().add(txOrigin);

        txtkind = new JComboBox();
        txtkind.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtkind.setModel(new DefaultComboBoxModel(new String[]{"Chọn", "Tráng miệng", "Hải sản","Cá", "Rau ", "Hoa Qủa", "Thịt","Nước uống","Kẹo","Bánh"}));
        txtkind.setBounds(108, 238, 96, 34);
        frame.getContentPane().add(txtkind);

        JLabel lblNewLabel_1_3_1 = new JLabel("Lo\u1EA1i th\u1EE9c \u0103n");
        lblNewLabel_1_3_1.setBounds(20, 243, 78, 27);
        frame.getContentPane().add(lblNewLabel_1_3_1);

        btnNewButton = new JButton("Th\u00EAm s\u1EA3n ph\u1EA9m \r\n");
        btnNewButton.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/plus.png")));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setBounds(98, 338, 145, 32);
        frame.getContentPane().add(btnNewButton);

        JButton btnXaSnPhm = new JButton("x\u00F3a s\u1EA3n ph\u1EA9m\r\n");
        btnXaSnPhm.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/delete.png")));
        btnXaSnPhm.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnXaSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnXaSnPhm.setBackground(Color.RED);
        btnXaSnPhm.setBounds(10, 395, 135, 32);
        frame.getContentPane().add(btnXaSnPhm);

        JButton btntLi = new JButton("\u0110\u1EB7t l\u1EA1i");
        btntLi.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/reload.png")));
        btntLi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txMaSP.setText("");
                txName.setText("");
                txNumber.setText("");
                txPrice.setText("");
                txDateInput.setValue(null);
                txDayMade.setValue(null);
                txExpired.setValue(null);
                txOrigin.setText("");

                txtkind.setSelectedIndex(0);
            }
        });
        btntLi.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btntLi.setBackground(new Color(0, 191, 255));
        btntLi.setBounds(297, 337, 145, 32);
        frame.getContentPane().add(btntLi);

        JButton btnNewButton_1 = new JButton("Exit");

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(frame, "Bạn có muốn thoát", "Chương trình quản lý cửa hàng thưc phẩm", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_NO_OPTION)
                    frame.dispose();
            }
        });
        btnNewButton_1.setBounds(441, 475, 78, 23);
        frame.getContentPane().add(btnNewButton_1);

        textField = new JTextField();
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                showStore();
            }
        });
        textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        textField.setBackground(new Color(255, 255, 255));
        textField.setBounds(118, 299, 357, 27);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton_2 = new JButton("Tìm");
        btnNewButton_2.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/search.png")));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setBounds(19, 299, 95, 23);
        frame.getContentPane().add(btnNewButton_2);

        JLabel Tien = new JLabel("Tổng tiền:");
        Tien.setBounds(252, 246, 88, 20);
        frame.getContentPane().add(Tien);

        txtMoney = new JTextField();

        txtMoney.setForeground(Color.RED);
        txtMoney.setBackground(Color.LIGHT_GRAY);
        txtMoney.setEditable(false);
        txtMoney.setBounds(350, 243, 125, 32);
        frame.getContentPane().add(txtMoney);
        txtMoney.setColumns(10);

        JButton btnNewButton_3 = new JButton("Danh sách nhân viên");
        btnNewButton_3.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/personnel.png")));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(StoreFrame.class.getResource("/assets/icons8-question-mark-64.png"));
                int n = JOptionPane.showOptionDialog(new JFrame(), "Bạn có muốn rời trang này",
                        "Chương trình quản lý cửa hàng thực phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        icon, new Object[]{"Yes", "No"}, JOptionPane.YES_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    EmployeeFrame employee = new EmployeeFrame();

                    employee.setVisible(true);
                } else if (n == JOptionPane.NO_OPTION) {
                    return;
                } else if (n == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Closed by hitting the cross");
                }

            }
        });
        btnNewButton_3.setBounds(175, 387, 185, 50);
        frame.getContentPane().add(btnNewButton_3);
        btnNewButton_4 = new JButton();
        btnNewButton_4.setText("Update");
        btnNewButton_4.setIcon(new ImageIcon(StoreFrame.class.getResource("/assets/icons8-support-26.png")));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton_4.setBackground(Color.CYAN);
        btnNewButton_4.setBounds(384, 393, 135, 36);
        frame.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Return");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageIcon icon = new ImageIcon(StoreFrame.class.getResource("/assets/icons8-question-mark-64.png"));
                int n = JOptionPane.showOptionDialog(new JFrame(), "Bạn có muốn rời trang này",
                        "Chương trình quản lý cửa hàng thực phẩm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        icon, new Object[]{"Yes", "No"}, JOptionPane.YES_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    Login login = new Login();
                    login.setUndecorated(true);
                    login.setVisible(true);

                } else if (n == JOptionPane.NO_OPTION) {
                    return;
                } else if (n == JOptionPane.CLOSED_OPTION) {
                    System.out.println("Closed by hitting the cross");
                }
            }
        });
        btnNewButton_5.setBounds(10, 475, 89, 23);
        frame.getContentPane().add(btnNewButton_5);

        frame.setVisible(true);

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int food_id = parseWithDefault(txMaSP.getText().trim(), 0);

        int food_number = parseWithDefault(txNumber.getText().trim(), 0);
        double food_price = parseWithDefaultDouble(txPrice.getText().trim(), 0);
        String food_name = txName.getText();
        String food_kind = txtkind.getSelectedItem().toString();

        String food_dateInput = txDateInput.getText();
        String food_dayMade = txDayMade.getText();
        String food_expired = txExpired.getText();
        String food_origin = txOrigin.getText();
        Store std = new Store(food_id, food_name, food_kind, food_number, food_price, food_dateInput, food_dayMade, food_expired, food_origin);
        if (txName.getText().isEmpty() || txDateInput.getText().isEmpty() || txDayMade.getText().isEmpty() || txExpired.getText().isEmpty() || txOrigin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không được để trống dòng ", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
        } else {
            int row = tblStore.getRowCount();
            String[] id = new String[row];
            String[] name = new String[row];
            int[] number = new int[row];
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                String ob = tblStore.getModel().getValueAt(i, 0).toString().trim();
                String bo = tblStore.getModel().getValueAt(i,1).toString().trim();
                String o = tblStore.getModel().getValueAt(i,3).toString().trim();
                id[i] = ob;//id sản phẩm
                name[i] = bo;//tên sản phẩm
                number[i] =Integer.parseInt(o.trim());//số lượng sản phẩm
            }
            for (int i = 0; i < id.length; i++) {            // Hàm tìm xem có bị trùng id và tên ở đâu không//
                if (id[i].equals(txMaSP.getText().trim()) && name[i].equalsIgnoreCase(txName.getText().trim())) {
                    int x = JOptionPane.showConfirmDialog(this, "Tên và id đã có bạn có muốn cập nhật lại số lượng sản phẩm này trong cửa hàng?");
                    if(x ==0){
                        try{
                            int numbers = food_number + number[i];
                            Store store1 = new Store(food_id,food_name,food_kind,numbers,food_price, food_dateInput, food_dayMade, food_expired, food_origin);
                            StoreModify.update(store1);
                            JOptionPane.showMessageDialog(this,"Sửa dữ liệu thành công");
                            showStore();

                            flag = false;
                            break;
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(this, "Error in updating edit fields");
                        }
                    }
                }
                if(id[i].equals(txMaSP.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Số ID đã có trong dữ liệu vui lòng nhập lại", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
                    flag = false;
                    break;
                }
                if(name[i].equalsIgnoreCase(txName.getText().trim())){
                    JOptionPane.showMessageDialog(null, "Tên đã có trong dữ liệu vui lòng nhập lại", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
                    flag = false;
                    break;
                }

            }
            if (flag == true){
                JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
                StoreModify.insert(std);
                showStore();

            }

        }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int selectedIndex = tblStore.getSelectedRow();
        int food_number = parseWithDefault(txNumber.getText().trim(), 0);
        if (selectedIndex >= 0) {
            Store std = storeList.get(selectedIndex);

            String input = JOptionPane.showInputDialog(this, "Nhập số lượng hàng để xóa :");
            int number = parseWithDefault(input.trim(), 0);
            if (food_number == number) {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phầm này ra khỏi kho hàng");
                System.out.println("option : " + option);

                if (option == 0) {
                    StoreModify.delete(std.getFood_id());
                    showStore();
                    txMaSP.setText("");
                    txName.setText("");
                    txNumber.setText("");
                    txPrice.setText("");
                    txDateInput.setValue(null);
                    txDayMade.setValue(null);
                    txExpired.setValue(null);
                    txOrigin.setText("");
                    txtkind.setSelectedIndex(0);

                }
            } else {
                if (food_number > number) {
                    int du = food_number - number;
                    int food_id = parseWithDefault(txMaSP.getText().trim(), 0);
                    double food_price = parseWithDefaultDouble(txPrice.getText().trim(), 0);
                    String food_name = txName.getText();
                    String food_kind = txtkind.getSelectedItem().toString();
                    String food_dateInput = txDateInput.getText();
                    String food_dayMade = txDayMade.getText();
                    String food_expired = txExpired.getText();
                    String food_origin = txOrigin.getText();
                    Store store = new Store(food_id, food_name, food_kind, du, food_price, food_dateInput, food_dayMade, food_expired, food_origin);
                    StoreModify.update(store);
                    JOptionPane.showMessageDialog(this,"Xóa sản phẩm thành công");
                    txMaSP.setText("");
                    txName.setText("");
                    txNumber.setText("");
                    txPrice.setText("");
                    txDateInput.setValue(null);
                    txDayMade.setValue(null);
                    txExpired.setValue(null);
                    txOrigin.setText("");
                    txtkind.setSelectedIndex(0);
                    showStore();

                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng hàng muốn xóa lớn hơn số hàng trong kho xin mời nhập lại ");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Chọn sản phẩm để xóa", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
        }
    }


    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String input = textField.getText();
        if (input.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống dòng ", "Chương trình quản ly sản phẩm", JOptionPane.YES_OPTION);
        } else {

            if (input != null && input.length() > 0) {
                storeList = StoreModify.findByID(input);

                tableModel.setRowCount(0);

                storeList.forEach((store) -> {
                    tableModel.addRow(new Object[]{store.getFood_id(),
                            store.getFood_name(), store.getFood_kind(), store.getFood_number(), store.getFood_price(), store.getFood_dateInput(), store.getFood_dayMade(), store.getFood_expired(), store.getFood_origin()});
                });
            } else {
                showStore();
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id = txMaSP.getText();
        tableModel = (DefaultTableModel) tblStore.getModel();
        if (tblStore.getSelectedRow() >= 0) {

            int food_id = parseWithDefault(txMaSP.getText().trim(), 0);
            int food_number = parseWithDefault(txNumber.getText().trim(), 0);
            double food_price = parseWithDefaultDouble(txPrice.getText().trim(), 0);
            String food_name = txName.getText();
            String food_kind = txtkind.getSelectedItem().toString();

            String food_dateInput = txDateInput.getText();
            String food_dayMade = txDayMade.getText();
            String food_expired = txExpired.getText();
            String food_origin = txOrigin.getText();
            Store std = new Store(food_id, food_name, food_kind, food_number, food_price, food_dateInput, food_dayMade, food_expired, food_origin);

            int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa? Dữ liệu sẽ bị mất");
            if (x == 0) {
                try {

                    StoreModify.update(std);

                    JOptionPane.showMessageDialog(this,"Sửa dữ liệu thành công");
                    showStore();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(this, "Error in updating edit fields");
                }
            }
        }
        else{
            if (tblStore.getRowCount() == 0){
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
            java.util.logging.Logger.getLogger(StoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreFrame().setVisible(true);
            }
        });
    }
    static JFrame frame = new JFrame("Manager");
    private JTextField txMaSP;
    private JTextField txName;
    private JTextField txNumber;
    private JTextField txPrice;
    private JFormattedTextField txDateInput;
    private JFormattedTextField txDayMade;
    private JFormattedTextField txExpired;
    private JTextField txOrigin;
    private JComboBox txtkind;
    private javax.swing.JTable tblStore;
    static MaskFormatter df;
    private JTextField textField;
    private JTextField txtMoney;
    private JButton btnNewButton;
    private JButton btnNewButton_4;
}



