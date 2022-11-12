package mini.springboard.service;

import lombok.RequiredArgsConstructor;
import mini.springboard.domain.Question;
import mini.springboard.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
}
