package OOPS3.Incapsulation;

public class Incapsulation {
    public static void main(Strings[],args){
        Employee em= new Employee();
        em.setId(3);
        int p=em.getId();
        System.out.println(p);
    }
}
class  Employee{
    private  int id ;
    private String name ;
    

    void setId(id){
        this.id=id;
    }

    int  getId(){
        return this.id;
    }
}

