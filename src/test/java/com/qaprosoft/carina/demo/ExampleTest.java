package com.qaprosoft.carina.demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ExampleTest {
    @Test
    public void
    lotto_resource_returns_200_with_expected_id_and_winners() {

        when().
                get("/lotto/{id}", 5).
                then().
                statusCode(200).
                body("lotto.lottoId", equalTo(5),
                        "lotto.winners.winnerId", hasItems(23, 54));

    }
}
