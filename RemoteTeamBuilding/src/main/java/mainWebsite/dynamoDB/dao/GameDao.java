package mainWebsite.dynamoDB.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import mainWebsite.dynamoDB.model.Game;

import java.util.List;

public class GameDao {
    private final DynamoDBMapper mapper;

    public GameDao() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        this.mapper = new DynamoDBMapper(client);
    }
    public GameDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }
    public List<Game> getAllGames() {
        DynamoDBScanExpression expression = new DynamoDBScanExpression().withLimit(10);
        List<Game> games = mapper.scan(Game.class, expression);
        return games;
    }
}
