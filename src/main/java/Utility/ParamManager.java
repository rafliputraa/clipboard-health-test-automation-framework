package Utility;

public class ParamManager {

    public void setParameter(String name) {
        String paramValue = System.getProperty(name);
        if (paramValue != null)
            ConstantVariables.browserName = paramValue;
    }
}
