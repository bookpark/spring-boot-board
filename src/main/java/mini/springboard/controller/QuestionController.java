package mini.springboard.controller;

import lombok.RequiredArgsConstructor;
import mini.springboard.domain.Question;
import mini.springboard.repository.QuestionRepository;
import mini.springboard.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
