package report;

import java.util.Base64;

public interface Reporter {

    void logToReport(String text);

    void logImageToReport(byte[] image);

}
