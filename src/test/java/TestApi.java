import org.junit.Test;
import rest.RestGet;

import java.util.ResourceBundle;

public class TestApi {

    String response;
    @Test
    public void t(){
        response= RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json");
        System.out.println(response);

    }

}
