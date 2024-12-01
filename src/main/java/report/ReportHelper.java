package report;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class ReportHelper implements Reporter{

    @Override
    public void logToReport(String text) {
        Allure.addAttachment("log", text);
    }

    @Override
    public void logImageToReport(byte[] image) {
        Allure.addAttachment("image", new ByteArrayInputStream(image));
    }

}
