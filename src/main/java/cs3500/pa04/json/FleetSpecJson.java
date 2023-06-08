package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FleetSpecJson(
    @JsonProperty("CARRIER") int numCarriers,
    @JsonProperty("BATTLESHIP") int numBattleships,
    @JsonProperty("DESTROYER") int numDestroyers,
    @JsonProperty("SUBMARINE") int numSubmarines) {
}
