public class Gender {
    int id;
    String name;

    Gender() {}

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

    public String toString(){
        return name;
    }

    public boolean equals(Gender obj){
        return obj.id == this.id;}
   
    }
