public class Subject {

    String code;
    String name;
    int T,M,S;

    public Subject(){

    }

    public Subject(String code, String name, int t, int m, int s) {
        this.code = code;
        this.name = name;
        T = t;
        M = m;
        S = s;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }
}
