import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

public class TestApiJson {
    static JSONArray jsonArray;
    static JSONObject jsonObject;

    @BeforeClass
    public static void beforeTests(){
        jsonArray = new JSONArray(RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&json"));
        System.out.println(jsonArray);
        jsonObject=jsonArray.getJSONObject(0);
        System.out.println(jsonObject);
    }
    @Test
    public void firstTest(){
        System.out.println("hello");
    }
}
