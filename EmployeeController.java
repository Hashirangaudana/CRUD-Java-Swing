
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Hashtable;
import java.util.List;

public class EmployeeController {
    public static List<Employee> get(Hashtable<String, Object> ht) {
        List<Employee> employees;

        if (ht == null) {
            employees = EmployeeDao.getAll();
        } else {
            String name = (String) ht.get("name");
            Gender gender = (Gender) ht.get("gender");

            if (gender == null)
                employees = EmployeeDao.getAllByName(name);
            else if (name == null)
                employees = EmployeeDao.getAllByGender(gender);
            else
                employees = EmployeeDao.getAllByNameAndGender(name, gender);
        }

        return employees;

    }

    public static String post(Employee employee) {

        String msg = "";
        String error = "";

        Employee emp = EmployeeDao.getByNic(employee.getNic());

        if (emp != null)
            error = error + "Existing Nic";

        if (error.isEmpty()) {
            String dberr = EmployeeDao.save(employee);
            if (dberr.equals("1"))
                msg = "1";

            else
                msg = dberr;

        } else {
            msg = "Data Error/n" + error;
        }
        return msg;
    }

    public static String put(Employee employee) {

        String msg = "";
        String error = "";

        Employee emp = EmployeeDao.getByNic(employee.getNic());

        if (emp != null && employee.getId() != emp.getId())
            error = error + "Existing Nic";

        if (error.isEmpty()) {
            String dberr = EmployeeDao.update(employee);
            if (dberr.equals("1"))
                msg = "1";

            else
                msg = dberr;

        } else {
            msg = "Data Error:" + error;
        }
        return msg;
    }

    public static String delete(Employee employee) {

        String errors = "";
        String msg = "";

        String sts = EmployeeDao.delete(employee);
        if (sts.equals("1")) {
            msg = sts;
        } else {
            errors = errors + sts;
            msg = errors;
        }

        return msg;
}

}
