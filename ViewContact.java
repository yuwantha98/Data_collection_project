import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewContact extends JFrame {

    private JButton btnListByName;
    private JButton btnListBySalary;
    private JButton btnListByBirthday;
    private JButton btnCancel;

    private ListByNameForm listByNameForm;
    private ListBySalaryForm listBySalaryForm;
    private ListByBirthdayForm listByBirthdayForm;

    ViewContact() {
        setSize(500, 400);
        setTitle("View Customer Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(42, 126, 171));

        JLabel titleLabel = new JLabel("CONTACT LIST");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titleLabel.setForeground(new Color(196, 196, 196));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.setBackground(new Color(42, 126, 171));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnListByName = new JButton("    List by Name     ");
        btnListByName.setFont(new Font("", 1, 20));
        btnListByName.setMargin(new Insets(5, 10, 5, 10));
        btnListByName.setHorizontalAlignment(SwingConstants.CENTER);
        btnListByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortContacts("name");
            }
        });

        JPanel nameBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        nameBtnPanel.setBackground(new Color(42, 126, 171));
        nameBtnPanel.add(btnListByName);
        buttonPanel.add(nameBtnPanel);

        btnListBySalary = new JButton("    List by Salary    ");
        btnListBySalary.setFont(new Font("", 1, 20));
        btnListBySalary.setMargin(new Insets(5, 10, 5, 10));
        btnListBySalary.setHorizontalAlignment(SwingConstants.CENTER);
        btnListBySalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortContacts("salary");
            }
        });

        JPanel salaryBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        salaryBtnPanel.setBackground(new Color(42, 126, 171));
        salaryBtnPanel.add(btnListBySalary);
        buttonPanel.add(salaryBtnPanel);

        btnListByBirthday = new JButton("  List by Birthday  ");
        btnListByBirthday.setFont(new Font("", 1, 20));
        btnListByBirthday.setMargin(new Insets(5, 10, 5, 10));
        btnListByBirthday.setHorizontalAlignment(SwingConstants.CENTER);
        btnListByBirthday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortContacts("birthday");
            }
        });

        JPanel birthdayBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        birthdayBtnPanel.setBackground(new Color(42, 126, 171));
        birthdayBtnPanel.add(btnListByBirthday);
        buttonPanel.add(birthdayBtnPanel);

        btnCancel = new JButton(" Cancel ");
        btnCancel.setFont(new Font("", 1, 20));
        btnCancel.setMargin(new Insets(5, 10, 5, 10));
        btnCancel.setHorizontalAlignment(SwingConstants.CENTER);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        JPanel cancelBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        cancelBtnPanel.setBackground(new Color(42, 126, 171));
        cancelBtnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
        cancelBtnPanel.add(btnCancel);
        buttonPanel.add(cancelBtnPanel);

        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        add(centerPanel);
    }

    private void sortContacts(String sort) {
        Contact[] contactsArray = CustomerMainForm.contactlist.getContactArray();
        switch (sort) {
            case "name":
                contactsArray = sortByName(contactsArray);
				if (listByNameForm == null) {
					listByNameForm = new ListByNameForm();
				}
                listByNameForm.updateTable(contactsArray);
				listByNameForm.setVisible(true);
				
                break;
                
            case "salary":
                contactsArray = sortBySalary(contactsArray);
                if (listBySalaryForm == null) {
					listBySalaryForm = new ListBySalaryForm();
				}
                listBySalaryForm.updateTable(contactsArray);
				listBySalaryForm.setVisible(true);
				
                break;
                
            case "birthday":
                contactsArray = sortByBirthday(contactsArray);
                if (listByBirthdayForm == null) {
					listByBirthdayForm = new ListByBirthdayForm();
				}
                listByBirthdayForm.updateTable(contactsArray);
				listByBirthdayForm.setVisible(true);
				
                break;
        }
    }
    
    private static Contact[] sortByName(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[CustomerMainForm.contactlist.getNextIndex()];

        for(int i=0; i<CustomerMainForm.contactlist.getNextIndex(); i++){
			tempContactArray[i]=contactArray[i];
        }

        for (int i = 0; i < CustomerMainForm.contactlist.getNextIndex() - 1; i++) {
            for (int j = i + 1; j < CustomerMainForm.contactlist.getNextIndex(); j++) {
                if (contactArray[i].getName().compareTo(contactArray[j].getName()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
                }
            }
        }
        return tempContactArray;
    }

    private static Contact[] sortBySalary(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[CustomerMainForm.contactlist.getNextIndex()];

        for(int i=0; i<CustomerMainForm.contactlist.getNextIndex(); i++){
			tempContactArray[i]=contactArray[i];
        }
        
        for (int i = 0; i < CustomerMainForm.contactlist.getNextIndex() - 1; i++) {
            for (int j = i + 1; j < CustomerMainForm.contactlist.getNextIndex(); j++) {
				if (Double.compare(contactArray[i].getSalary(), contactArray[j].getSalary()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
				}
            }
        }
        return tempContactArray;
    }

    private static Contact[] sortByBirthday(Contact[] contactArray) {
		Contact[] tempContactArray = new Contact[CustomerMainForm.contactlist.getNextIndex()];

        for(int i=0; i<CustomerMainForm.contactlist.getNextIndex(); i++){
			tempContactArray[i]=contactArray[i];
        }
        
        for (int i = 0; i < CustomerMainForm.contactlist.getNextIndex() - 1; i++) {
            for (int j = i + 1; j < CustomerMainForm.contactlist.getNextIndex(); j++) {
                if (contactArray[i].getBirthday().compareTo(contactArray[j].getBirthday()) > 0) {
					
					Contact tempContact = tempContactArray[i];
					tempContactArray[i]=tempContactArray[j];
					tempContactArray[j]=tempContact;
                }
            }
        }
        return tempContactArray;
    }
}
