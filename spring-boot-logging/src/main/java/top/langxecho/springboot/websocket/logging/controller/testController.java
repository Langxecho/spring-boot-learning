package top.langxecho.springboot.websocket.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/9 16:27
 */
@RestController
@Slf4j
public class testController {
    private static final Logger logger = LoggerFactory.getLogger(testController.class);
    @GetMapping("/log")
    public String logDemo() {
        log.trace("This is a TRACE log");
        logger.debug("This is a DEBUG log");
        logger.info("This is a INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is a ERROR log");
        return "Logs have been generated!";
    }
}
