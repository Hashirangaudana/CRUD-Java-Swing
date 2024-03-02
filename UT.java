import java.util.Hashtable;
import java.util.List;

public class UT {

        public static void main(String[] arg) {
                // unit test -1 ->GenderDao->getById()

                // Gender gen1 = GenderDao.getById(1);
                // System.out.print(gen1.getId()+" ");
                // System.out.print(gen1.getName()+"\n");

                // Gender gen2 = GenderDao.getById(2);
                // System.out.print(gen2.getId()+" ");
                // System.out.print(gen2.getName()+"\n");

                // Gender gen3 = GenderDao.getById(3);
                // System.out.print(gen3.getId()+" ");
                // System.out.print(gen3.getName());

                // unit test 2 ->

                /*
                 * for (Employee emp: employees){
                 * 
                 * System.out.print(emp.getId()+ "\t");
                 * System.out.print(emp.getName()+ "\t");
                 * System.out.print(emp.getNic()+ " ");
                 * System.out.println(emp.getgender().getName()+ "\n");}
                 * 
                 * //unit test - 3 -> EmployeeController ->
                 * 
                 * List<Employee> employee = EmployeeCntroller.get();
                 * 
                 * for (Employee emp1: employee){
                 * 
                 * System.out.print(emp1.getId()+ " ");
                 * System.out.print(emp1.getName()+ " ");
                 * System.out.print(emp1.getNic()+ " ");
                 * System.out.println(emp1.getgender().getName()+ "\n");
                 * 
                 * }
                 */

                // unit test -> 4 ->GenderDao->getAll()

                /*
                 * List<Gender> genders = GenderDao.getAll();
                 * 
                 * for (Gender gen : genders){
                 * 
                 * System.out.println(gen.getId()+ " ");
                 * System.out.println(gen.getName()+ " ");
                 * 
                 * 
                 * }
                 */
                // unit test - 5-> GenderCnroller->get()
                // List<Gender> genders = GenderCntroller.get();

                // for (Gender gen : genders) {

                // System.out.println(gen.getId() + " ");
                // System.out.println(gen.getName() + " ");

                // }
                // //unit test -6-> employeedao ->getallby()
                // List<Employee> employee = EmployeeDao.getAllBy("u");

                // for (Employee emp1: employee){
                // System.out.print(emp1.getId()+ " ");
                // System.out.print(emp1.getName()+ " ");
                // System.out.print(emp1.getNic()+ " ");
                // System.out.println(emp1.getgender().getName()+ "\n");

                // }
                // //enhast for loop using -> normal for loop
                // List<Employee> employee = EmployeeDao.getAllBy("u");

                // for (int i =0; i < employee.size();i ++){
                // System.out.println(employee.get(i).getId());
                // System.out.println(employee.get(i).getName());
                // }

                // unit test 7
                // Gender gen = GenderDao.getById(1);
                // List<Employee> employee = EmployeeDao.getAllByGender(gen);

                // for (Employee emp1: employee){
                // System.out.print(emp1.getId()+ " ");
                // System.out.print(emp1.getName()+ " ");
                // System.out.print(emp1.getNic()+ " ");
                // System.out.println(emp1.getgender().getName()+ "\n");
                // }
                // unit test ->8employeedao->getallbynameandgender

                //

                // Unit Test-9->EmployeeController.get()

                // =======Without Hashtable=======

                // List<Employee> employees = EmployeeController.get(null);

                // for (Employee emp : employees) {
                // System.out.print(emp.getId() + " ");
                // System.out.print(emp.getName() + " ");
                // System.out.print(emp.getNic() + " ");
                // System.out.println(emp.getGender().getName() + "\n");
                // }

                // =======Hashtable with Name=======

                // Hashtable<String, Object> ht = new Hashtable<>();
                // ht.put("name", "k");

                // List<Employee> employees = EmployeeController.get(ht);

                // for (Employee emp : employees) {
                // System.out.print(emp.getId() + " ");
                // System.out.print(emp.getName() + " ");
                // System.out.print(emp.getNic() + " ");
                // System.out.println(emp.getGender().getName() + "\n");
                // }

                // =======Hashtable with Gender-Male=======

                // Gender gender = GenderDao.getById(1);

                // Hashtable<String, Object> ht = new Hashtable<>();
                // ht.put("gender", gender);

                // List<Employee> employees = EmployeeController.get(ht);

                // for (Employee emp : employees) {
                // System.out.print(emp.getId() + " ");
                // System.out.print(emp.getName() + " ");
                // System.out.print(emp.getNic() + " ");
                // System.out.println(emp.getGender().getName() + "\n");
                // }

                // =======Hashtable with Gender-Female=======

                // Gender gender = GenderDao.getById(2);

                // Hashtable<String, Object> ht = new Hashtable<>();
                // ht.put("gender", gender);

                // List<Employee> employees = EmployeeController.get(ht);

                // for (Employee emp : employees) {
                // System.out.print(emp.getId() + " ");
                // System.out.print(emp.getName() + " ");
                // System.out.print(emp.getNic() + " ");
                // System.out.println(emp.getGender().getName() + "\n");
                // }

                // Hashtable with Name and Gender

                // Gender gender = GenderDao.getById(1);

                // Hashtable<String, Object> ht = new Hashtable<>();
                // ht.put("name", "k");
                // ht.put("gender", gender);

                // List<Employee> employees = EmployeeController.get(ht);

                // for (Employee emp : employees) {
                // System.out.print(emp.getId() + " ");
                // System.out.print(emp.getName() + " ");
                // System.out.print(emp.getNic() + " ");
                // System.out.println(emp.getGender().getName() + "\n");
                // }

                // unit test 10->EmployeeDao.save()
                // Employee employee = new Employee();
                // employee.setName("Hashi");
                // employee.setNic("12346788");
                // employee.setGender(GenderDao.getById(1));

                // String msg = EmployeeDao.save(employee);
                // System.out.println(msg);

                // Unit Test-11->EmployeDao.getByNic()

                // =====With Existing NIC======

                // Employee employee1 = EmployeeDao.getByNic("200107203561");

                // if (employee1 != null)
                // System.out.println("Exsist");
                // else
                // System.out.println("new NIC");

                // // ====With New Nic======

                // Employee employee2 = EmployeeDao.getByNic("123456789");

                // if (employee2 != null)
                // System.out.println("Nic is Exist");
                // else
                // System.out.println("New NIC");
                // Unit Test-12->Employee Controller.post()

                // =======With Existing NIC=======

                // Employee employee1 = new Employee();
                // employee1.setName("ashan");
                // employee1.setNic("200107203561");
                // employee1.setGender (GenderDao.getById(1));

                // String msg = EmployeeController.post(employee1);
                // System.out.println(msg);

                // // =======With New NIC==
                // Employee employee2 = new Employee();
                // employee2.setName("Boralu");
                // employee2.setNic ("185923781217");
                // employee2.setGender (GenderDao.getById(1));

                // String msg2 = EmployeeController.post(employee2);
                // System.out.println(msg2);
                        
                //unit test -13->EmployeeDao.update()

                // Employee employee = EmployeeDao.getByNic("378878778957");
                // employee.setName("abc");

                // String msg = EmployeeDao.update(employee);
                // System.out.println(msg);


                        //=====Update name========
                //unit test -14->EmployeeController.put()

                // Employee employee = EmployeeDao.getByNic("378878778957");
                // employee.setName("apple");

                // String msg = EmployeeDao.update(employee);
                // System.out.println(msg);

                        //=======update Exixting nic==========
                //unit test -15->Update -> Nic -> TO Exixting Nic ===

                // Employee employee = EmployeeDao.getByNic("200107203577");
                // employee.setNic("156784589V");

                // String msg = EmployeeController.put(employee);
                // System.out.println(msg);

                //============update -> nic to new nic ============
                //unit test -16->update 

                // Employee employee = EmployeeDao.getByNic("200107203577");
                // employee.setNic("20047849306V");

                // String msg = EmployeeController.put(employee);
                // System.out.println(msg);

                       // =========update -> gender ==========
                //unit test -17->Update ->

                // Employee employee = EmployeeDao.getByNic("20047849306V");
                // employee.setName("Sunimal");
                // employee.setGender(GenderDao.getById(1));


                // String msg = EmployeeController.put(employee);
                // System.out.println(msg);
                
                
        }
}