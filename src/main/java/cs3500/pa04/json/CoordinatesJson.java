package cs3500.pa04.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CoordinatesJson(
    @JsonProperty("coordinates") CoordJson[] coords) {
}
