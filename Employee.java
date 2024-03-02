public class Employee {
    private int id;
    private String Nic;
    private String name;
    private Gender gender;

    Employee() {
    }

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return this.id;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    public void setNic(String Nic) {
        this.Nic = Nic;

    }

    public String getNic() {
        return this.Nic;

    }

    public void setGender(Gender gender) {
        this.gender = gender;

    }

    public Gender getGender() {
        return this.gender;

    }

}
