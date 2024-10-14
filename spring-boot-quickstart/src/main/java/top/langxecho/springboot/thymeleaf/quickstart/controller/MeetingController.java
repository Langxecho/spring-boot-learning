package top.langxecho.springboot.thymeleaf.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.langxecho.springboot.thymeleaf.quickstart.entity.Meeting;
import top.langxecho.springboot.thymeleaf.quickstart.service.MeetingService;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 18:37
 */
@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Resource
    private MeetingService meetingService;

    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody Meeting meeting){
        if(meetingService.isRoomAvailable(meeting)){
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用");
        }else{
            return ResponseEntity.ok("会议室已被占用");
        }
    }
}
