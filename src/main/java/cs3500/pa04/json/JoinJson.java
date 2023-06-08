package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JoinJson(
    @JsonProperty("name") String name,
    @JsonProperty("game-type") GameType type) {
}
