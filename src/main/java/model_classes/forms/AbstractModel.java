package model_classes.forms;

import java.util.Map;

public class AbstractModel {

    protected String returnValue(Map<String, String> values, String key){
        if(values.containsKey(key)){
            return  (values.get(key) == null) ? "" : values.get(key).trim();
        }else {
            return null;
        }
    }

    protected boolean returnValueBoolean(Map<String, String> values, String key){
        if(values.containsKey(key)){
            return values.get(key) != null && Boolean.parseBoolean(values.get(key).trim());
        }else {
            return false;
        }
    }
}
