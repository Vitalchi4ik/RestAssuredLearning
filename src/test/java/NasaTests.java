import config.NasaConfig;
import config.NasaEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class NasaTests extends NasaConfig{

    @Test
    public void getAllResponse(){
        given().
                when().
                get(NasaEndpoints.curiosityRovers).
        then();
    }

    @Test
    public void extractUrlValueWithFind(){
        Response response = get(NasaEndpoints.curiosityRovers);
        String photoUrl = response.path("photos.find { it.id == 624666 }.img_src");
        System.out.println("Url is " + photoUrl);
    }
}
