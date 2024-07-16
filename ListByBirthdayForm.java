import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ListByBirthdayForm extends JFrame {
    private JButton btnReload;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    ListByBirthdayForm() {
        setSize(800, 600);
        setTitle("View Customer Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(42, 126, 171));

        JLabel titleLabel = new JLabel("LIST CONTACT BY BIRTHDAY");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titleLabel.setForeground(new Color(196, 196, 196));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        northPanel.add(titleLabel);
        add(northPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnReload = new JButton("Back To Home");
        btnReload.setFont(new Font("", 1, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 25));
        buttonPanel.setBackground(new Color(42, 126, 171));
        buttonPanel.add(btnReload);
        btnReload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        
        add("South", buttonPanel);

        String[] columnNames = {"Customer ID", "Name", "Contact Number", "Company Name", "Salary", "Birthday"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        tablePane.setPreferredSize(new Dimension(720, 400)); 
        northPanel.add(tablePane);
        add("Center", northPanel);
       
    }

    public void updateTable(Contact[] contacts) {
        dtm.setRowCount(0);
        for (Contact contact : contacts) {
            Object[] rowData = {
                contact.getId(), contact.getName(), contact.getPhoneNumber(),
                contact.getCompanyName(), contact.getSalary(), contact.getBirthday()
            };
            dtm.addRow(rowData);
        }
    }
}
