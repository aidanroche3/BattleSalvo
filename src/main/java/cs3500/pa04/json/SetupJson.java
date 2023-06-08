package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetupJson(
    @JsonProperty("height") int height,
    @JsonProperty("width") int width,
    @JsonProperty("fleet-spec") FleetSpecJson fleetSpec) {
}
