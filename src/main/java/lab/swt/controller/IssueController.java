package lab.swt.controller;

/**
 * @auhtor antonio.caccamo on 2024-04-05 @ 15:53
 */
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

/**
 * @author antoniocaccamo on 21/04/2020
 */

@Controller("/issues")
public class IssueController {

    @Get("/{number}")
    public String issue(@PathVariable Integer number) {
        return "Issue # " + number + "!";
    }
}