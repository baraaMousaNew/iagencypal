package rest_assured;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BodyHelper {

    public static String imageToBase64(String imagePath){
        byte[] image;
        try {
            image = FileUtils.readFileToByteArray(new File(imagePath));
            Allure.addAttachment(imagePath, new ByteArrayInputStream(image));
        }catch (IOException e){
            throw new RuntimeException("Cannot load file of: " + imagePath);
        }
        return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(image);
    }

    public static void findInString(String value, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        if(!matcher.find()){
            throw new RuntimeException("Could not find the regex: " + regex + " in string");
        }
    }
}
