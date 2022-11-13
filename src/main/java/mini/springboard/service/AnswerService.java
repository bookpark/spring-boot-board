package mini.springboard.service;

import lombok.RequiredArgsConstructor;
import mini.springboard.domain.Answer;
import mini.springboard.domain.Question;
import mini.springboard.domain.SiteUser;
import mini.springboard.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
    }
}
