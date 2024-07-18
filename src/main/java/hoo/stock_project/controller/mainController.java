package hoo.stock_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MainPage API", description = "메인화면을 불러오는 API입니다.")
@RequestMapping("/v1/stock")
@Controller
public class mainController {
    
    @Operation(summary = "메인화면 조회", description = "메인화면을 조회합니다.")
    @GetMapping("/index")
    public String getIndexPage(){
        return "index";
    }
}
