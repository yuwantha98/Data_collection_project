import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchCustomerForm extends JFrame {
    private JButton btnHome;
    private JButton btnSearch;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtContactNumber;
    private JTextField txtCompanyName;
    private JTextField txtSalary;
    private JTextField txtBirthday;
    private JTextField txtSearch;
    private JPanel textPanel;
    private int index;

    public SearchCustomerForm() {
        setSize(800, 600);
        setTitle("Search Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setBackground(new Color(42, 126, 171));

        JLabel titleLabel = new JLabel("SEARCH CUSTOMER FORM");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
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
                    setFieldsVisibility(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Contact not found");
                    setFieldsVisibility(false);
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

        JPanel buttonHomePanel = new JPanel();
        btnHome = new JButton("Back to Home");
        btnHome.setFont(new Font("", 1, 20));
        buttonHomePanel.setBackground(new Color(42, 126, 171));
        buttonHomePanel.add(btnHome);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtId.setText("");
                txtName.setText("");
                txtContactNumber.setText("");
                txtCompanyName.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                txtSearch.setText("");
                setFieldsVisibility(false);
                dispose();
            }
        });

        buttonMainPanel.add(buttonHomePanel);

        add(buttonMainPanel, BorderLayout.SOUTH);

        JPanel labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 0));

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
        textPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 20, 150));

        txtId = new JTextField(15);
        txtId.setFont(new Font("", 1, 20));
        txtId.setEditable(false);
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);

        txtName = new JTextField(15);
        txtName.setFont(new Font("", 1, 20));
        txtName.setEditable(false);
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtContactNumber = new JTextField(15);
        txtContactNumber.setFont(new Font("", 1, 20));
        txtContactNumber.setEditable(false);
        JPanel contactNumberTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contactNumberTextPanel.add(txtContactNumber);
        textPanel.add(contactNumberTextPanel);

        txtCompanyName = new JTextField(15);
        txtCompanyName.setFont(new Font("", 1, 20));
        txtCompanyName.setEditable(false);
        JPanel companyNameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        companyNameTextPanel.add(txtCompanyName);
        textPanel.add(companyNameTextPanel);

        txtSalary = new JTextField(15);
        txtSalary.setFont(new Font("", 1, 20));
        txtSalary.setEditable(false);
        JPanel salaryTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirthday = new JTextField(15);
        txtBirthday.setFont(new Font("", 1, 20));
        txtBirthday.setEditable(false);
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
