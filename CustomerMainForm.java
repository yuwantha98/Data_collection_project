import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CustomerMainForm extends JFrame {

    //public static final ArrayList<Contact> contactlist = new ArrayList<>();
    public static final ContactList contactlist = new ContactList(100,50);

    private JButton btnAddCustomer;
    private JButton btnSearchCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnViewCustomer;
    private JButton btnExit;

    private AddCustomerForm addCustomerForm;
    private UpdateCustomerForm updateCustomerForm;
    private SearchCustomerForm searchCustomerForm;
    private DeleteCustomerForm deleteCustomerForm;
    private ViewContact viewContact;

    CustomerMainForm() {
        setSize(800, 600);
        setTitle("iFriend Contact Organizer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(400, getHeight()));
        leftPanel.setBackground(new Color(135, 206, 250));
        
        ImageIcon originalIcon = new ImageIcon("D:/ICET/yuwantha/OOP/week 4/Details/img/1.jpg");
        Image resizedImage = originalIcon.getImage().getScaledInstance(400, 440, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(imageLabel, BorderLayout.SOUTH);

        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));  

        JLabel yuwanthaLabel = new JLabel("iFriend");
        yuwanthaLabel.setFont(new Font("", 1, 40));
        yuwanthaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        yuwanthaLabel.setForeground(new Color(0,0,102));   

        JLabel contactManagerLabel = new JLabel("Contact Manager");
        contactManagerLabel.setFont(new Font("", 1, 30));
        contactManagerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  

        labelsPanel.add(yuwanthaLabel);
        labelsPanel.add(contactManagerLabel);
        
        labelsPanel.setBackground(new Color(135, 206, 250));
        
        leftPanel.add(labelsPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("HOME PAGE");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titleLabel.setForeground(new Color(255,255,255)); 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.setBackground(new Color(42,126,171));

        JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        buttonPanel.setBackground(new Color(42,126,171));

        btnAddCustomer = new JButton("  Add New Contacts  ");
        btnAddCustomer.setFont(new Font("", 1, 20));
        btnAddCustomer.setMargin(new Insets(5, 10, 5, 10));
        btnAddCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (addCustomerForm == null) {
                    addCustomerForm = new AddCustomerForm();
                }
                addCustomerForm.setVisible(true);
            }
        });

        JPanel addBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        addBtnPanel.setBackground(new Color(42,126,171));
        addBtnPanel.add(btnAddCustomer);
        buttonPanel.add(addBtnPanel);

        btnUpdateCustomer = new JButton("   Update Contacts    ");
        btnUpdateCustomer.setFont(new Font("", 1, 20));
        btnUpdateCustomer.setMargin(new Insets(5, 10, 5, 10));
        btnUpdateCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (updateCustomerForm == null) {
                    updateCustomerForm = new UpdateCustomerForm();
                }
                updateCustomerForm.setVisible(true);
			}
        });

        JPanel updateBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        updateBtnPanel.setBackground(new Color(42,126,171));
        updateBtnPanel.add(btnUpdateCustomer);
        buttonPanel.add(updateBtnPanel);

        btnSearchCustomer = new JButton("   Search Contacts    ");
        btnSearchCustomer.setFont(new Font("", 1, 20));
        btnSearchCustomer.setMargin(new Insets(5, 10, 5, 10));
        btnSearchCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnSearchCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (searchCustomerForm == null) {
                    searchCustomerForm = new SearchCustomerForm();
                }
                searchCustomerForm.setVisible(true);
			
            }
        });

        JPanel searchBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        searchBtnPanel.setBackground(new Color(42,126,171));
        searchBtnPanel.add(btnSearchCustomer);
        buttonPanel.add(searchBtnPanel);

        btnDeleteCustomer = new JButton("    Delete Contacts    ");
        btnDeleteCustomer.setFont(new Font("", 1, 20));
        btnDeleteCustomer.setMargin(new Insets(5, 10, 5, 10));
        btnDeleteCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnDeleteCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (deleteCustomerForm == null) {
                    deleteCustomerForm = new DeleteCustomerForm();
                }
                deleteCustomerForm.setVisible(true);
            }
        });

        JPanel deleteBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        deleteBtnPanel.setBackground(new Color(42,126,171));
        deleteBtnPanel.add(btnDeleteCustomer);
        buttonPanel.add(deleteBtnPanel);

        btnViewCustomer = new JButton("     View Contacts      ");
        btnViewCustomer.setFont(new Font("", 1, 20));
        btnViewCustomer.setMargin(new Insets(5, 10, 5, 10));
        btnViewCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnViewCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (viewContact == null) {
                    viewContact = new ViewContact(); 
                }
                viewContact.setVisible(true);
            }
        });

        JPanel viewBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        viewBtnPanel.setBackground(new Color(42,126,171));
        viewBtnPanel.add(btnViewCustomer);
        buttonPanel.add(viewBtnPanel);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("", 1, 20));
        btnExit.setMargin(new Insets(5, 10, 5, 10));
        btnExit.setHorizontalAlignment(SwingConstants.CENTER);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        JPanel exitBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        exitBtnPanel.setBackground(new Color(42,126,171));
        exitBtnPanel.add(btnExit);
        buttonPanel.add(exitBtnPanel);

        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);     
    }
}
