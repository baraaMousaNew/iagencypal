package enums.product;

public enum Forms {

    SUBMITTED_DATE_TIME("Submitted Date & Time"),

    SUBMITTED_IP_ADDRESS("Submitted IP address"),

    SUBMITTED_SEND_DATE("Send Date"),

    SUBMITTED_SEND_DATE_REGEX("[0-9]{2}\\/(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\/[0-9]{4}\\s(?:[01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s\\(UTC\\)"),

    SUBMITTED_DATE_REGEX("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{1,2}"),

    SUBMITTED_TIME_REGEX("[0-9]{1,2}:[0-9]{1,2}\\s?(?:AM|PM)\\s\\(UTC\\)"),

    CONFIRMATION_ACA_DATE_TIME("^\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])T(?:[01]\\d|2[0-3]):[0-5]\\d$"),

    CONFIRMATION_TYPE("1"),

    CONFIRMATION_TYPE_LABEL("In person"),

    SUBMITTED_IP_REGEX("[0-9]+.[0-9]+.[0-9]+.[0-9]+"),

    SAVED_PHONE_NUMBER("Saved Phone Numbers"),

    SAVED_EMAIL_ADDRESS("Saved Email Address"),

    DEFAULT("Default"),

    SECONDARY("Secondary"),

    REMOVE("Remove");

    public final String label;

    Forms(String label){
        this.label = label;
    }
}
