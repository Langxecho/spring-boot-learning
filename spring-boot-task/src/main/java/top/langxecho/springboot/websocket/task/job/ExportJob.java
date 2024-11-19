package top.langxecho.springboot.websocket.task.job;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import top.langxecho.springboot.websocket.task.entity.Student;
import top.langxecho.springboot.websocket.task.mapper.StudentMapper;

import java.util.List;
import java.util.UUID;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/10/28 16:25
 */
@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    protected final StudentMapper studentMapper;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行导出任务");
        List<Student> students = studentMapper.selectList(null);
        String fileName = "C:\\Users\\19086\\Downloads\\" + UUID.randomUUID() + ".xlsx";
        EasyExcel.write(fileName, Student.class)
                .sheet("学生数据")
                .doWrite(() -> students);
    }
}
