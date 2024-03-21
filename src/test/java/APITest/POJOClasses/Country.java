package APITest.POJOClasses;

import java.util.List;

public class Country {
    private String id;
    private String name;
    private String shortName;
    private String code;
    private List<String> translateName;
    private boolean hasState;

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", translateName=" + translateName +
                ", hasState=" + hasState +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getTranslateName() {
        return translateName;
    }

    public void setTranslateName(List<String> translateName) {
        this.translateName = translateName;
    }

    public boolean isHasState() {
        return hasState;
    }

    public void setHasState(boolean hasState) {
        this.hasState = hasState;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
