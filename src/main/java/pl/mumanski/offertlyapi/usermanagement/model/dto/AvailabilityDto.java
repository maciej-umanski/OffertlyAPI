package pl.mumanski.offertlyapi.usermanagement.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema
public class AvailabilityDto { // todo: walidacja żeby można było wrzucać tu tylko wartości 0 do 23
    private List<Integer> mon;
    private List<Integer> tue;
    private List<Integer> wed;
    private List<Integer> thu;
    private List<Integer> fri;
    private List<Integer> sat;
    private List<Integer> sun;
}
