import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Currencies;
import models.Exchange;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.RestGet;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestApiModels {
    static Currencies currencies;
    static Exchange[] exchange;
    static Exchange ex1;

    @Parameterized.Parameters
    public static Collection options(){
        return Arrays.asList(Currencies.values());
    }

    public TestApiModels(Currencies currency) throws JsonProcessingException {
        currencies = currency;
        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+currency.getCurrency()+"&json");
        ObjectMapper om = new ObjectMapper();
        exchange = om.readValue(response, Exchange[].class);
        ex1 = exchange[0];
    }

//    @BeforeClass
//    public static void bb() throws JsonProcessingException {
//        String response = RestGet.Get("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+currencies.getCurrency()+"&json");
//        ObjectMapper om = new ObjectMapper();
//        exchange = om.readValue(response, Exchange[].class);
//        ex1 = exchange[0];
//    }

    @Test
    public void rateCheck() {
        Assert.assertNotNull(ex1.rate);
        System.out.println("rate = "+ex1.rate);
    }
    @Test
    public void r030Check(){
        Assert.assertNotNull(ex1.r030);
        System.out.println("r030 = "+ex1.r030);
    }
    @Test
    public void txtCheck(){
        Assert.assertNotNull(ex1.txt);
        System.out.println("txt = "+ex1.txt);
    }
    @Test
    public void ccCheck(){
        Assert.assertNotNull(ex1.cc);
        System.out.println("cc = "+ex1.cc);
    }
    @Test
    public void exchangedateCheck(){
        Assert.assertNotNull(ex1.exchangedate);
        System.out.println("exchangedate = "+ex1.exchangedate);
    }

}
