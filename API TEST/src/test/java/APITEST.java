import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITEST {

    private static final String BASE_URL = "https://gorest.co.in/public/v2/users";
    private static final String TOKEN = "0af62bbfca8c03fcd7fa02a892cbcd2d8e143cd38885946e353a8131c2cbc904";

    private static String userId;
    private static String postId;

    @Test
    @Order(1)
    void createUser() {
        String userBody = "{ \"name\": \"John Doe\", \"gender\": \"male\", \"email\": \"batman984@example.com\", \"status\": \"active\" }";
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(userBody)
                .when()
                .post(BASE_URL);


        response.then().statusCode(201);
        userId = response.jsonPath().getString("id");
        System.out.println("User ID: " + userId);


        Assertions.assertNotNull("User ID should not be null", userId);
    }


    @Test
    @Order(2)
    void createPost() {


        Assertions.assertNotNull(userId, "User ID should not be null after creating a user");


        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body("{ \"user_id\": " + userId + ", \"title\": \"My First Post\", \"body\": \"This is a test post.\" }")
                .when()
                .post("https://gorest.co.in/public/v2/posts");


        response.then().statusCode(201)
                .body("title", equalTo("My First Post"));


        postId = response.jsonPath().getString("id");
        System.out.println("Created Post ID: " + postId);
    }


    @Test
    @Order(3)
    void verifyPost() {
        Assertions.assertNotNull(postId, "Post ID should not be null after creating a post");

        given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(BASE_URL + "/" + userId + "/posts/")
                .then()
                .statusCode(200)
                .body("id[0]", equalTo(Integer.parseInt(postId)))
                .body("title[0]", equalTo("My First Post"));
    }

    @Test
    @Order(4)
    void deletePost() {
        Assertions.assertNotNull(postId, "Post ID should not be null before deletion");

        System.out.println("Attempting to delete Post ID: " + postId);

        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete("https://gorest.co.in/public/v2/posts/" + postId);

        System.out.println("Delete Response: " + response.asString());

        response.then().statusCode(204);
    }

    @Test
    @Order(5)
    void verifyPostDeletion() {
        Assertions.assertNotNull(postId, "Post ID should not be null before verification");

        Response response = given()
                .header("Authorization", "Bearer " + TOKEN)
                .get("https://gorest.co.in/public/v2/posts/" + postId);

        System.out.println("Verify Deletion Response: " + response.asString());

        if (response.statusCode() == 404) {
            System.out.println("Post successfully deleted.");
        } else {
            Assertions.fail("Post still exists, deletion failed.");
        }
    }
}


