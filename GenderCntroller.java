import java.util.List;

public class GenderCntroller {
    public static List<Gender> get() {

        List<Gender> genders = GenderDao.getAll();
        return genders;

    }

}
