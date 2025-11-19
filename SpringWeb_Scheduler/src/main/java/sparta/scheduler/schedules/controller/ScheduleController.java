package sparta.scheduler.schedules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.scheduler.schedules.dto.*;
import sparta.scheduler.schedules.service.ScheduleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
// - Properties
    private final ScheduleService scheduleService;

// - Methods
    // - Create
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> create(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    // - Read
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(@RequestParam(required = false) String author) {
        List<GetScheduleResponse> result = scheduleService.getAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long Id) {
        GetScheduleResponse result = scheduleService.getOne(Id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // - Update
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> update(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = scheduleService.update(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // - Delete
    @DeleteMapping("/schedules/{scheduleId}")
    public String delete( @PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return "일정이 성공적으로 삭제되었습니다.";
    }
}
