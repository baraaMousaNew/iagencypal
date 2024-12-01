package properties;

import io.cucumber.java.hu.De;
import io.qameta.allure.Feature;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(value={"file:src/main/java/resources/Product.properties"})
public interface Product extends Config{

    @DefaultValue("ACA Enrolment")
    String acaForm();

    @DefaultValue("PII Form")
    String piiForm();

    @DefaultValue("Review Application")
    String reviewForm();

    @DefaultValue("")
    String agentUsername();

    @DefaultValue("")
    String agentPassword();

    @DefaultValue("")
    String brokerUsername();

    @DefaultValue("")
    String brokerPassword();

    @DefaultValue("")
    String agent();

    @DefaultValue("")
    String broker();

    @DefaultValue("")
    String cancelInProgressForms();

    @DefaultValue("")
    String deleteCreatedClients();

    @DefaultValue("")
    String deleteCreatedAgents();

    @DefaultValue("")
    String sqlConnection();

    @DefaultValue("")
    String agentName();

    @DefaultValue("")
    String creditCard();

    class ProductProps{

        static Product product = ConfigFactory.create(Product.class);

        public static String acaForm = product.acaForm();
        public static String piiForm = product.piiForm();
        public static String reviewForm = product.reviewForm();
        public static String agentUsername = product.agentUsername();
        public static String agentPassword = product.agentPassword();
        public static String brokerUsername = product.brokerUsername();
        public static String brokerPassword = product.brokerPassword();
        public static String agent = product.agent();
        public static String broker = product.broker();
        public static String cancelInProgressForms = product.cancelInProgressForms();
        public static String sqlConnection = product.sqlConnection();
        public static String agentName = product.agentName();
        public static String creditCard = product.creditCard();
        public static String deleteCreatedClients = product.deleteCreatedClients();
        public static String deleteCreatedAgents = product.deleteCreatedAgents();
    }
}
