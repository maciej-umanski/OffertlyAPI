package pl.mumanski.offertlyapi.usermanagement.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class AvailabilityDto { // todo: walidacja żeby można było wrzucać tu tylko wartości 0 do 23
    @JsonProperty("Mon")
    private List<Integer> mon;
    @JsonProperty("Tue")
    private List<Integer> tue;
    @JsonProperty("Wed")
    private List<Integer> wed;
    @JsonProperty("Thu")
    private List<Integer> thu;
    @JsonProperty("Fri")
    private List<Integer> fri;
    @JsonProperty("Sat")
    private List<Integer> sat;
    @JsonProperty("Sun")
    private List<Integer> sun;
}
