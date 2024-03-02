import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.util.Hashtable;
import java.util.List;

public class EmployeeUi extends JFrame {

    JTable tblEmployee;
    Vector columns;

    JComboBox<Object> cmbSearchGender;
    JTextField txtSearchName;
    JButton btnAdd;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnClear;

    JComboBox cmbGender;
    JTextField txtName;
    JTextField txtNic;

    Color valid;
    Color invalid;
    Color initial;
    Color update;

    List<Gender> genlist;
    List<Employee> emplist;
    Employee oldEmployee;
    Employee employee;

    EmployeeUi() {

        valid = new Color(200, 255, 200);
        invalid = Color.pink;
        initial = Color.white;
        update = Color.yellow;

        setTitle("Employee Detail Management");
        setSize(500, 500);
        setLocation(500, 600);

        JLabel lblName = new JLabel("Name");
        JLabel lblNic = new JLabel("NIC");
        JLabel lblGender = new JLabel("Gender");

        txtName = new JTextField(10);
        txtNic = new JTextField(10);

        cmbGender = new JComboBox();

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        JLabel lblSearchName = new JLabel("Search by Name");
        txtSearchName = new JTextField(10);
        JLabel lblSearchGender = new JLabel("Search by Gender");
        cmbSearchGender = new JComboBox();
        JButton btnSearch = new JButton("Search");
        JButton btnClearSearch = new JButton("Clear Search");

        columns = new Vector();
        columns.add("Name");
        columns.add("NIC");
        columns.add("Gender");

        Vector data = new Vector();

        tblEmployee = new JTable();
        DefaultTableModel tblModel = new DefaultTableModel(data, columns);
        tblEmployee.setModel(tblModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(450, 180));
        jspTable.setViewportView(tblEmployee);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        con.add(lblName);
        con.add(txtName);
        con.add(lblNic);
        con.add(txtNic);
        con.add(lblGender);
        con.add(cmbGender);

        con.add(btnAdd);
        con.add(btnClear);
        con.add(btnUpdate);
        con.add(btnDelete);

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchGender);
        con.add(cmbSearchGender);
        con.add(btnSearch);
        con.add(btnClearSearch);

        con.add(jspTable);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });

        btnClearSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearSearchAp(e);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddAp(e);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearAp(e);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnUpdateAp(e);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDeleteAp(e);
            }
        });

        tblEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tblEmployeeVc(e);
            }

        });

        txtName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                txtNameKR(e);
            }
        });
        txtNic.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                txtNicKR(e);
            }
        });

        cmbGender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmbGenderAP(e);
            }
        });

        initialize();

    }

    public void initialize() {
        loadView();
        loadForm();
    }

    public void loadView() {

        emplist = EmployeeController.get(null);
        fillTable(emplist);

        List<Gender> genlist = GenderCntroller.get();
        Vector<Object> genders = new Vector<Object>();
        genders.add("Select a Gender");

        for (Gender gen : genlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel<Object>(genders);
        cmbSearchGender.setModel(genModel);

    }

    public void loadForm() {
        employee = new Employee();
        genlist = GenderCntroller.get();
        Vector<Object> genders = new Vector<Object>();
        genders.add("Select a Gender");
        oldEmployee = null;
        for (Gender gen : genlist) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel<Object>(genders);
        cmbGender.setModel(genModel);

        txtName.setText("");
        txtNic.setText("");

        setStyle(initial);
        enbaleButtons(true, false, false);

    }

    public void setStyle(Color clr) {
        txtName.setBackground(clr);
        txtNic.setBackground(clr);
        cmbGender.setBackground(clr);
    }

    public void enbaleButtons(boolean add, boolean upd, boolean del) {
        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(upd);
        btnDelete.setEnabled(del);
    }

    public void fillTable(List<Employee> emplist) {

        Vector data = new Vector<>();

        for (Employee emp : emplist) {

            Vector row = new Vector<>();
            row.add(emp.getName());
            row.add(emp.getNic());
            row.add(emp.getGender());

            data.add(row);

        }

        DefaultTableModel tblModel = new DefaultTableModel(data, columns);
        tblEmployee.setModel(tblModel);

    }

    public void btnSearchAp(ActionEvent e) {

        // System.out.println("1111111");

        Gender gender = null;

        String name = txtSearchName.getText();
        Object sitem = cmbSearchGender.getSelectedItem();

        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("name", name);

        if (!sitem.equals("Select a Gender"))
            gender = (Gender) sitem;

        if (gender != null)
            ht.put("gender", gender);

        List<Employee> employees = EmployeeController.get(ht);
        fillTable(employees);

    }

    public void btnClearSearchAp(ActionEvent e) {

        // System.out.println("Test-Ok");

        int op = JOptionPane.showConfirmDialog(null, "Are you Sure to Clear this Search Details ?");

        if (op != 1) {
            txtSearchName.setText("");
            cmbSearchGender.setSelectedIndex(0);

            List<Employee> employees = EmployeeController.get(null);
            fillTable(employees);
        }

    }

    public void txtNameKR(KeyEvent e) {
        // System.out.println("TEST OK");

        String name = txtName.getText();
        if (name.matches("^[A-Z][a-z]{2,}$")) {
            employee.setName(name);
            txtName.setBackground(valid);
            if (oldEmployee != null) {
                if (!employee.getName().equals(oldEmployee.getName())) {
                    txtName.setBackground(update);
                }
            }
        } else {
            employee.setName(null);
            txtName.setBackground(invalid);

        }

    }

    public void txtNicKR(KeyEvent e) {
        // System.out.println("test ok");

        String nic = txtNic.getText();
        if (nic.matches("^[0-9]{9}V$")) {
            employee.setNic(nic);
            txtNic.setBackground(valid);
            if (oldEmployee != null) {
                if (!employee.getNic().equals(oldEmployee.getNic())) {
                    txtName.setBackground(update);
                }
            }
        } else {
            employee.setNic(null);
            txtNic.setBackground(invalid);
        }

    }

    public void cmbGenderAP(ActionEvent e) {
        int sitem = cmbGender.getSelectedIndex();
        if (sitem != 0) {
            employee.setGender((Gender) cmbGender.getSelectedItem());
            cmbGender.setBackground(valid);

            if (oldEmployee != null) {
                if (!employee.getGender().equals(oldEmployee.getGender())) {
                    txtName.setBackground(update);
                }
            } else {
                employee.setGender(null);
                cmbGender.setBackground(invalid);
            }
        }
    }

    public String getErrors() {

        String errors = "";

        if (employee.getName() == null) {
            errors = errors + "Invail Name";

        }

        if (employee.getNic() == null) {
            errors = errors + "Invail Nic";

        }
        if (employee.getGender() == null) {
            errors = errors + "Invail Gender";

        }
        return errors;
    }

    public String getUpdates() {

        String updates = "";
        System.out.println(employee.getName());

        if (!employee.getName().equals(oldEmployee.getName())) {
            updates = updates + "Name is Updated-" + employee.getName();
        }
        if (!employee.getNic().equals(oldEmployee.getNic())) {
            updates = updates + "Nic is Updated-" + employee.getNic();
        }
        if (!employee.getGender().equals(oldEmployee.getGender())) {
            updates = updates + "Gender is Updated-" + employee.getGender();
        }
        return updates;
    }

    public void btnAddAp(ActionEvent e) {

        // MEH THIYENNA CODE OKKOMA KAWDUWA WENA WENAMA
        // System.out.println("Test-OK");

        // String nic = txtNic.getText();
        // if (nic.matches("^[0-9]{9}V$")) {
        // employee.setNic(nic);
        // txtNic.setBackground(valid);
        // } else {
        // errors = errors + "\nInvalid NIC";
        // txtNic.setBackground(invalid);
        // }

        // int sitem = cmbGender.getSelectedIndex();
        // if (sitem != 0) {
        // employee.setGender((Gender) cmbGender.getSelectedItem());
        // cmbGender.setBackground(valid);
        // } else {
        // errors = errors + "\nInvalid Gender";
        // cmbGender.setBackground(invalid);
        // }

        String errors = getErrors();

        if (errors.isEmpty()) {

            String cnfmsg = "";

            cnfmsg = cnfmsg + "Name: " + employee.getName() + "\n";
            cnfmsg = cnfmsg + "NIC: " + employee.getNic() + "\n";
            cnfmsg = cnfmsg + "Gender: " + employee.getGender().getName();

            int op = JOptionPane.showConfirmDialog(null, "Are you Sure to Save Follwing Employee ?\n\n" + cnfmsg);

            if (op == 0) {

                String sts = EmployeeController.post(employee);
                if (sts.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Successfully Saved");
                    loadView();
                    loadForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Faild to Save as" + sts);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "You have Following Errors:\n" + errors);
        }
    }

    public void btnClearAp(ActionEvent e) {
        int op = JOptionPane.showConfirmDialog(null, "are you sure to clear this form?");

        if (op == 0) {
            loadForm();
        }
    }

    public void tblEmployeeVc(ListSelectionEvent e) {

        int row = tblEmployee.getSelectedRow();

        if (row > -1) {
            Employee employee = emplist.get(row);
            FillForm(employee);

        }

    }

    public void FillForm(Employee emp) {

        oldEmployee = emp;

        employee = new Employee();
        employee.setName(emp.getName());
        employee.setNic(emp.getNic());
        employee.setGender(emp.getGender());

        txtName.setText(emp.getName());
        txtNic.setText(emp.getNic());

        for (Gender gen : genlist) {
            if (gen.equals(emp.getGender())) {
                cmbGender.setSelectedItem(gen);
                break;
            }
        }

        enbaleButtons(false, true, true);
        setStyle(valid);
    }

    public void btnUpdateAp(ActionEvent e) {

        // System.out.println("Test-OK");

        String errors = getErrors();
        employee.setId(oldEmployee.getId());

        if (errors.isEmpty()) {
            String updates = getUpdates();
            if (!updates.isEmpty()) {

                int op = JOptionPane.showConfirmDialog(null,
                        "Are You Sure to Update Following Employee\n\n" + updates);
                if (op == 0) {
                    String sts = EmployeeController.put(employee);
                    if (sts.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Successfully Updated..!");
                        loadForm();
                        loadView();
                    } else {
                        JOptionPane.showMessageDialog(null, "Faild to Update as" + sts);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Nothing to Update");
            }

        } else {
            JOptionPane.showMessageDialog(null, "You have Following Errors" + errors);
        }

    }

    public void btnDeleteAp(ActionEvent e) {
        // System.out.println("Test-OK");

        int op = JOptionPane.showConfirmDialog(null,
                "Are You Sure to Delete Follwoing Employee\n\n?" + oldEmployee.getName());

        if (op == 0) {
            String sts = EmployeeController.delete(oldEmployee);
            if (sts.equals("1")) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                loadForm();
                loadView();
            } else {
                JOptionPane.showMessageDialog(null, "Faild to Delete as" + sts);
            }
        }

    }

}