import java.util.Random;

/** 
@author Dmitrii Khokhlov
@version 1.4
*/

public class subdivision {
    private int id_div;
    private String name_div;

    subdivision(String _sb_name){
        name_div = _sb_name;
        Random rand = new Random();
        id_div = rand.nextInt(1000000);
    }

    void println(){
        System.out.println("ID_SUBDIVISION: " + id_div);
        System.out.println("NAME_SUBDIVISION: " + name_div);
    }
}
