package Thursday_Practice;

public class Course {
    private String title;
    private String code;
    private int chs;

    public Course(String title, String code, int chs) {
        setTitle(title);
        setCode(code);
        setChs(chs);
    }

    public String toString() {
        return String.format("Title: %s, Code: %s, Chs: %d\n", title, code, chs);
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getChs() {
        return chs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setChs(int chs) {
        this.chs = chs;
    }
}
