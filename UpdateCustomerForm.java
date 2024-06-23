import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateCustomerForm extends JFrame {
    private JButton btnAddCustomer;
    private JButton btnCancel;
    private JButton btnHome;
    private JButton btnSearch;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthday;
    private JTextField txtSearch;
    private JPanel labelPanel;
    private JPanel textPanel;
    private int index;

    public UpdateCustomerForm() {
        setSize(800, 600);
        setTitle("Update Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setBackground(new Color(42, 126, 171));

        JLabel titleLabel = new JLabel("UPDATE CUSTOMER FORM");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(new Color(42, 126, 171));
        titleLabel.setForeground(new Color(196, 196, 196));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 40, 0, 0));
        northPanel.add(titleLabel);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(new Color(42, 126, 171));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 10, 10));

        txtSearch = new JTextField(25);
        txtSearch.setFont(new Font("", 1, 20));
        searchPanel.add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", 1, 20));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String search = txtSearch.getText();
                index = SEARCHER(search);
                if (index != -1) {
                    Contact contact = CustomerMainForm.contactlist.getContactArray()[index];
                    txtId.setText(contact.getId());
                    txtName.setText(contact.getName());
                    txtContactNumber.setText(contact.getPhoneNumber());
                    txtCompanyName.setText(contact.getCompanyName());
                    txtSalary.setText(String.valueOf(contact.getSalary()));
                    txtBirthday.setText(contact.getBirthday());
                    // Make fields visible after successful search
                    setFieldsVisibility(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found");
                }
            }
        });
        searchPanel.add(btnSearch);

        northPanel.add(searchPanel);

        add(northPanel, BorderLayout.NORTH);

        JPanel buttonMainPanel = new JPanel();
        buttonMainPanel.setLayout(new BoxLayout(buttonMainPanel, BoxLayout.Y_AXIS));
        buttonMainPanel.setBackground(new Color(42, 126, 171));
        buttonMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 380, 20, 0));

        JPanel buttonPanel = new JPanel();
        btnAddCustomer = new JButton("Update Customer");
        btnAddCustomer.setFont(new Font("", 1, 20));
        buttonPanel.setBackground(new Color(42, 126, 171));
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (index != -1) {
                    String id = txtId.getText();
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
                        JOptionPane.showMessageDialog(null, "Invalid Birthday. Please enter a Birthday.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    CustomerMainForm.contactlist.getContactArray()[index].setId(id);
                    CustomerMainForm.contactlist.getContactArray()[index].setName(name);
                    CustomerMainForm.contactlist.getContactArray()[index].setPhoneNumber(contactNumber);
                    CustomerMainForm.contactlist.getContactArray()[index].setCompanyName(companyName);
                    CustomerMainForm.contactlist.getContactArray()[index].setSalary(salary);
                    CustomerMainForm.contactlist.getContactArray()[index].setBirthday(birthday);

                    JOptionPane.showMessageDialog(null, "Customer updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    txtSearch.setText("");
                    txtId.setText("");
                    txtName.setText("");
                    txtContactNumber.setText("");
                    txtCompanyName.setText("");
                    txtSalary.setText("");
                    txtBirthday.setText("");

                    // Hide fields again
                    setFieldsVisibility(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No customer selected for update.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
                txtSearch.setText("");
                setFieldsVisibility(false);
                dispose(); 
            }
        });

        buttonMainPanel.add(buttonPanel);
        buttonMainPanel.add(buttonHomePanel);

        add(buttonMainPanel, BorderLayout.SOUTH);

        labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 0));

        JLabel lblId = new JLabel("Contact ID");
        lblId.setFont(new Font("", 1, 20));
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", 1, 20));
        labelPanel.add(lblName);

        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setFont(new Font("", 1, 20));
        labelPanel.add(lblContactNumber);

        JLabel lblCompanyName = new JLabel("Company Name");
        lblCompanyName.setFont(new Font("", 1, 20));
        labelPanel.add(lblCompanyName);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", 1, 20));
        labelPanel.add(lblSalary);

        JLabel lblBirthday = new JLabel("Birthday");
        lblBirthday.setFont(new Font("", 1, 20));
        labelPanel.add(lblBirthday);

        add(labelPanel, BorderLayout.WEST);

        textPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        textPanel.setBorder(BorderFactory.createEmptyBorder(35, 0, 30, 150));

        txtId = new JTextField(15);
        txtId.setFont(new Font("", 1, 20));
        txtId.setEditable(false);
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);

        txtName = new JTextField(15);
        txtName.setFont(new Font("", 1, 20));
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtContactNumber = new JTextField(15);
        txtContactNumber.setFont(new Font("", 1, 20));
        JPanel contactNumberTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contactNumberTextPanel.add(txtContactNumber);
        textPanel.add(contactNumberTextPanel);

        txtCompanyName = new JTextField(15);
        txtCompanyName.setFont(new Font("", 1, 20));
        JPanel companyNameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        companyNameTextPanel.add(txtCompanyName);
        textPanel.add(companyNameTextPanel);

        txtSalary = new JTextField(15);
        txtSalary.setFont(new Font("", 1, 20));
        JPanel salaryTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirthday = new JTextField(15);
        txtBirthday.setFont(new Font("", 1, 20));
        JPanel birthdayTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthdayTextPanel.add(txtBirthday);
        textPanel.add(birthdayTextPanel);

        add(textPanel, BorderLayout.EAST);

        setFieldsVisibility(false);
    }

    private void setFieldsVisibility(boolean isVisible) {
        textPanel.setVisible(isVisible);
    }

    public static int SEARCHER(String search) {
        for (int i = 0; i < CustomerMainForm.contactlist.getNextIndex(); i++) {
            if (CustomerMainForm.contactlist.getContactArray()[i].getName().equalsIgnoreCase(search) ||
                CustomerMainForm.contactlist.getContactArray()[i].getPhoneNumber().equals(search)) {
                return i;
            }
        }
        return -1;
    }
	
}
