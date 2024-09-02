package top.langxecho.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.langxecho.springboot.quickstart.enums.RequestType;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/2 16:15
 */
@Service
public class CustomService {
    public String handleRequest(RequestType requestType){
        return switch (requestType){
            case QUERY -> this.handleQuery();
            case COMPLAIN -> this.handleComplain();
            case SUGGESTION -> this.handleSuggestion();
        };

    }
    public String handleQuery(){
        return "询问请求";
    }
    public String handleComplain(){
        return "投诉请求";
    }
    public String handleSuggestion(){
        return "建议请求";
    }
}

