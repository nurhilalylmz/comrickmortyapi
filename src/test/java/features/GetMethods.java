package features;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GetMethods {

    @Test
    public static void GetMethodCharacter(Integer character){
        Response response=given().contentType(ContentType.JSON)
                .when().get(String.format(baseURI+"/character/"+character ))
                .then()
                .body("name",is("Morty Smith"))
                .statusCode(200).extract().response();
        JsonPath jp = new JsonPath(response.asString());
        System.out.println(jp.prettyPrint());
    }

/*    Senaryo 2:
    Karakter endpointe parametre alarak git
    Parametrede name=Rick ve status’u =alive olanları çağır
    Sonuçlardan ilkinin cinsiyetinin erkek ve türünün insan olduğu kontrol et
    Senaryo 3:
    Episode endpointine git
    Name eve episode isimli liste oluştur
    Liste sonuçlarında bölümünün “Get Schwifty” ve bölümün “S02E05” olduğunu kontrol et
    Senaryo 4:
    Lokasyon endpointine git
    Response’daki typeın “space” olmadığını kontrol et*/

//   --- If I add enum class , I will be create new class in BasePackage and I willl be add this function
//    public RequestSpecification GetCharacterSpesificationResponse(){
//        requestSpecification= given().contentType(JSON)
//                .param("name", "Rick")
//                .param("status", "alive");
//        return requestSpecification;
//    }

    public static void CharacterQueryParam(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("name","rick")
                .queryParam("status","alive").
        when()
                .get(String.format("https://rickandmortyapi.com/api/character")).then()
                .statusCode(200)
                .body("results[0].gender",equalTo("Male"))
                .body("results[0].species",equalTo("Human"))
                .body("results[0].id",equalTo(1));
    }
//
//    public String TestExample() {
//        List<String> deneme=null;
//       String value= deneme.add("Kalem");
//        return value;
//    }

    @Test
    public static void Episode(){
        List<String> names = when().get(String.format("https://rickandmortyapi.com/api/episode"))
                .then().extract().jsonPath()
                .getList("results.name");
        Assert.assertTrue(names.contains("Get Schwifty"));
        System.out.println(names.size());
        System.out.println(names);
        List<String> episodes = when().get(String.format("https://rickandmortyapi.com/api/episode"))
                .then().extract().jsonPath()
                .getList("results.episode");
        Assert.assertTrue(episodes.contains("S02E05"));
        System.out.println(episodes.size());
        System.out.println(episodes);
    }
    public static void Location(){
        when()
                .get(String.format("https://rickandmortyapi.com/api/location/3"))
                .then()
                .body("type", Matchers.not("Space")).statusCode(200);
    }
}
