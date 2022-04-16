package pl.mumanski.offertlyapi.timeSlotManagement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class TimeSlotController {
    @Operation(operationId = "createTimeSlot", summary = "Create TimeSlot", tags = {"TimeSlot"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "OK", content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TimeSlotDto.class)
                    )),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
            }
    )
    @RequestMapping(method = RequestMethod.POST, value = "/timeSlot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimeSlotDto> createTimeSlot(@RequestBody CreateTimeSlotDto createTimeSlotDto,
                                                      @RequestParam Long userId) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
