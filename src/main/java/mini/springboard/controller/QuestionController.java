package mini.springboard.controller;

import lombok.RequiredArgsConstructor;
import mini.springboard.domain.AnswerForm;
import mini.springboard.domain.Question;
import mini.springboard.domain.QuestionForm;
import mini.springboard.domain.SiteUser;
import mini.springboard.repository.QuestionRepository;
import mini.springboard.service.QuestionService;
import mini.springboard.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @RequestMapping("")
    public String root() {
        return "redirect:/question/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

//    @GetMapping("/create")
//    public String questionCreate() {
//        return "question_form";
//    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

//    @PostMapping("/create")
//    public String questionCreate(@RequestParam String subject, @RequestParam String content) {
//        this.questionService.create(subject, content);
//        return "redirect:/question/list";
//    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
    }
}
