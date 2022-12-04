/** 
@author Dmitrii Khokhlov
@version 1.4
*/

public class human {
    private int id;
    private String name;
    private String sex;
    private subdivision sd;
    private double salary;
    private String birthday;

    human(int _id, String _name, String _sex, String _sdName, double _salary, String _bd){
        id = _id;
        name = _name;
        sex = _sex;
        sd = new subdivision(_sdName);
        salary = _salary;
        birthday = _bd;
    }

    void println(){
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("SEX: " + sex);
        System.out.println("SUBDIVISION: ");
        sd.println();
        System.out.println("SALARY: " + salary);
        System.out.println("BIRTHDAY: " + birthday);
    }
}
