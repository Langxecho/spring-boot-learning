package top.langxecho.springboot.quickstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 16:48
 */
@Data
@AllArgsConstructor
public class Meeting {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isOverlapping(Meeting other){
        return this.date.equals(other.date) &&
                (this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime)) ;
    }
}
