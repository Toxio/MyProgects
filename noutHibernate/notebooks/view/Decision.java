package Week3Day1.notebooks.view;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 2/10/13
 */
public enum Decision {
    CREATE_NOUT(1), SHOW_ALL_NOUTS(2), SHOW_VENDOR(3), EXIT(0);

    private int code;

    Decision(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Decision getByCode(int code) {
        for (Decision decision : Decision.values()) {
            if(decision.getCode() == code) {
                return decision;
            }
        }
        return null;
    }
}
