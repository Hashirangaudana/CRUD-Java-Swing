
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static List<Employee> get(String qry) {

        // define the employee list
        List<Employee> employees = new ArrayList();

        try {
            // 1.creat a database connection
            // url
            // username
            // password

            // define a query

            // get the resultset -> by executing the query

            ResultSet rslt = commenDao.get(qry);

            while (rslt.next()) {

                // int id = rslt.getInt("id");
                // String name = rslt.getString("name");
                // String nic = rslt.getString("nic");
                // String gender = rslt.getString("gender_id");

                // System.out.println(id + "\t" + name + "\t" + nic + "\t" + gender);
                Employee employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getString("name"));
                employee.setNic(rslt.getString("nic"));
                employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));

                employees.add(employee);
            }

        } catch (SQLException ex) {
            System.out.println("can't connect as" + ex.getMessage());
        }

        return employees;

    }

    public static List<Employee> getAll() {
        String qry = "select * from employee";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static List<Employee> getAllByName(String name) {

        String qry = "select * from employee where name like'" + name + "%'";
        // System.out.println(qry); we can check qury is ok
        List<Employee> employees = get(qry);

        return employees;
    }

    public static List<Employee> getAllByGender(Gender gender) {

        String qry = "select * from employee where gender_id = " + gender.getId();
        System.out.println(qry);
        // we can check qury is ok

        List<Employee> employees = get(qry);
        return employees;

    }

    public static List<Employee> getAllByNameAndGender(String name, Gender gender) {
        String qry = "SELECT * FROM employee where name Like '" + name + "%'AND gender_id =" + gender.getId();
        // select * from employee where name Like 'k%' and gender_id = 1;
        // System.out.println(qry);
        List<Employee> employees = get(qry);

        return employees;

    }

    public static Employee getByNic(String nic) {

        Employee employee = null;// his bucket ekk thiyene
        // Employee employee = new Employee(); //constracter method call karoth methana
        // default value ekk asign wenwa
        try {

            String qry = "SELECT * FROM employee WHERE nic = '" + nic + "'";

            ResultSet rslt = commenDao.get(qry);

            if (rslt.next() && rslt != null) {

                employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getString("name"));
                employee.setNic(rslt.getString("nic"));
                employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));

            }

        } catch (SQLException ex) {
        }

        return employee;
    }

    public static String save(Employee employee) {

        String msg = "";

        String qry = "Insert Into employee(name,nic,gender_id)values('"
                + employee.getName() + "','"
                + employee.getNic() + "',"
                + employee.getGender().getId() + ")";

        // Insert Into employee(name,nic,gender)values('
        // kamal','
        // 20043126740',
        // 1);

        msg = commenDao.modify(qry);
        return msg;

    }

    public static String update(Employee employee) {

        String msg = "can't connect database";

        String qry = "UPDATE employee SET name = '" +
                employee.getName() + "', nic = '" +
                employee.getNic() + "',gender_id = " +
                employee.getGender().getId() + " WHERE id = " + employee.getId();

        // System.out.println(qry);

        msg = commenDao.modify(qry);
        return msg;

    }

    public static String delete(Employee employee) {

        String msg = "Can't Connect Database";

        String qry = "DELETE FROM employee WHERE id=" + employee.getId();
        msg = commenDao.modify(qry);

        return msg;}
}