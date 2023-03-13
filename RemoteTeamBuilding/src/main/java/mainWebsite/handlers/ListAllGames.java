package mainWebsite.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import mainWebsite.dynamoDB.dao.GameDao;
import mainWebsite.dynamoDB.model.Game;

/**
 * Handler for requests to Lambda function.
 */
public class ListAllGames implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final GameDao dao = new GameDao();

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);
        try {

            String output = "";
            List<Game> games = dao.getAllGames();
            for (Game g : games) {
                output += g.getName() + "\n";
            }

            return response
                    .withStatusCode(200)
                    .withBody(output);
        } catch (DynamoDBMappingException e) {
            return response
                    .withBody(e.getMessage())
                    .withStatusCode(500);
        }
    }
}
