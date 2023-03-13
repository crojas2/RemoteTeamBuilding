package mainWebsite.dynamoDB.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "games")
public class Game {
    public String id;
    public String name;
    public int numPlayers;
    public int timeToPlay;

    @DynamoDBHashKey(attributeName="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "numPlayers")
    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    @DynamoDBAttribute(attributeName = "timeToPlay")
    public int getTimeToPlay() {
        return timeToPlay;
    }

    public void setTimeToPlay(int timeToPlay) {
        this.timeToPlay = timeToPlay;
    }
}
