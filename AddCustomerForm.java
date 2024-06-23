import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddCustomerForm extends JFrame {
    private JButton btnAddCustomer;
    private JButton btnCancel;
    private JButton btnHome;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthday;
    public static int IDNum = 1;
    public String id;

    AddCustomerForm() {
        setSize(700, 600);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        id = IDGenerator(IDNum);

        JLabel titleLabel = new JLabel("ADD CUSTOMER FORM");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(42, 126, 171));
        titleLabel.setForeground(new Color(196, 196, 196));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonMainPanel = new JPanel();
        buttonMainPanel.setLayout(new BoxLayout(buttonMainPanel, BoxLayout.Y_AXIS));
        buttonMainPanel.setBackground(new Color(42, 126, 171));
        buttonMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, -370));

        JPanel buttonPanel = new JPanel();
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("", 1, 20));
        buttonPanel.setBackground(new Color(42, 126, 171));
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                id = IDGenerator(IDNum);

                String name = txtName.getText();
                String contactNumber = txtContactNumber.getText();
                String companyName = txtCompanyName.getText();
                double salary = Double.parseDouble(txtSalary.getText());
                String birthday = txtBirthday.getText();

                if (!Validator.phoneNoValidator(contactNumber)) {
                    JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter a valid phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Validator.salaryValidator(salary)) {
                    JOptionPane.showMessageDialog(null, "Invalid Salary. Please enter a valid Salary.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!Validator.birthdayValidator(birthday)) {
                    JOptionPane.showMessageDialog(null, "Invalid Birthday. Please enter a valid Birthday.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Contact contact = new Contact(id, name, contactNumber, companyName, salary, birthday);
                CustomerMainForm.contactlist.add(contact);

                IDNum++;

                JOptionPane.showMessageDialog(null, "Customer added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                String sid = IDGenerator(IDNum);
                txtId.setText(sid);
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompanyName.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
            }
        });
        buttonPanel.add(btnAddCustomer);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", 1, 20));
        buttonPanel.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        JPanel buttonHomePanel = new JPanel();
        btnHome = new JButton("Back to Home");
        btnHome.setFont(new Font("", 1, 20));
        buttonHomePanel.setBackground(new Color(42, 126, 171));
        buttonHomePanel.add(btnHome);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompanyName.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                dispose();
            }
        });

        buttonMainPanel.add(buttonPanel);
        buttonMainPanel.add(buttonHomePanel);

        add(buttonMainPanel, BorderLayout.SOUTH);

        JPanel labelPanel = new JPanel(new GridLayout(6, 1));
        labelPanel.setBackground(new Color(42, 126, 171));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 20));

        JLabel lblId = new JLabel("Contact ID");
        lblId.setFont(new Font("", 1, 20));
        lblId.setForeground(Color.WHITE);
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", 1, 20));
        lblName.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0));
        lblName.setForeground(Color.WHITE);
        labelPanel.add(lblName);

        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setFont(new Font("", 1, 20));
        lblContactNumber.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0));
        lblContactNumber.setForeground(Color.WHITE);
        labelPanel.add(lblContactNumber);

        JLabel lblCompanyName = new JLabel("Company Name");
        lblCompanyName.setFont(new Font("", 1, 20));
        lblCompanyName.setBorder(BorderFactory.createEmptyBorder(-6, 0, 0, 0));
        lblCompanyName.setForeground(Color.WHITE);
        labelPanel.add(lblCompanyName);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", 1, 20));
        lblSalary.setBorder(BorderFactory.createEmptyBorder(-8, 0, 0, 0));
        lblSalary.setForeground(Color.WHITE);
        labelPanel.add(lblSalary);

        JLabel lblBirthday = new JLabel("Birthday");
        lblBirthday.setFont(new Font("", 1, 20));
        lblBirthday.setBorder(BorderFactory.createEmptyBorder(-10, 0, 0, 0));
        lblBirthday.setForeground(Color.WHITE);
        labelPanel.add(lblBirthday);

        add(labelPanel, BorderLayout.WEST);

        JPanel textPanel = new JPanel(new GridLayout(6, 1));
        textPanel.setBackground(new Color(42, 126, 171)); // White background
        textPanel.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 145)); // Add some top padding

        txtId = new JTextField(id, 15);
        txtId.setFont(new Font("", 1, 20));
        txtId.setEditable(false);
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.setBackground(new Color(42, 126, 171));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);

        txtName = new JTextField(15);
        txtName.setFont(new Font("", 1, 20));
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.setBackground(new Color(42, 126, 171));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtContactNumber = new JTextField(15);
        txtContactNumber.setFont(new Font("", 1, 20));
        JPanel contactNumberTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contactNumberTextPanel.setBackground(new Color(42, 126, 171));
        contactNumberTextPanel.add(txtContactNumber);
        textPanel.add(contactNumberTextPanel);

        txtCompanyName = new JTextField(15);
        txtCompanyName.setFont(new Font("", 1, 20));
        JPanel companyNameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        companyNameTextPanel.setBackground(new Color(42, 126, 171));
        companyNameTextPanel.add(txtCompanyName);
        textPanel.add(companyNameTextPanel);

        txtSalary = new JTextField(15);
        txtSalary.setFont(new Font("", 1, 20));
        JPanel salaryTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.setBackground(new Color(42, 126, 171));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirthday = new JTextField(15);
        txtBirthday.setFont(new Font("", 1, 20));
        JPanel birthdayTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthdayTextPanel.setBackground(new Color(42, 126, 171));
        birthdayTextPanel.add(txtBirthday);
        textPanel.add(birthdayTextPanel);

        add(textPanel, BorderLayout.EAST);
    }

    public static String IDGenerator(int IDNum) {
        if (IDNum < 10) {
            return "C000" + IDNum;
        } else if (IDNum < 100 && IDNum >= 10) {
            return "C00" + IDNum;
        } else if (IDNum < 1000 && IDNum >= 100) {
            return "C0" + IDNum;
        } else {
            return "C" + IDNum;
        }
    }
}
