package top.langxecho.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.quickstart.entity.Meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 18:32
 */
@Service
public class MeetingService {
    private final List<Meeting> meetings = new ArrayList<>();

    public boolean isRoomAvailable(Meeting newMeeting){
        return meetings.stream()
                .noneMatch(exitMeeting -> exitMeeting.isOverlapping(newMeeting));
    }

    public void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
}
