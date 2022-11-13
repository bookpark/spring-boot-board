package mini.springboard;

import mini.springboard.domain.Answer;
import mini.springboard.domain.Question;
import mini.springboard.repository.AnswerRepository;
import mini.springboard.repository.QuestionRepository;
import mini.springboard.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBoardApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        // 데이터 저장하기
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);

        // 데이터 조회 (findAll)
//		List<Question> all = this.questionRepository.findAll();
//		Assertions.assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		Assertions.assertEquals("sbb가 무엇인가요?", q.getSubject());

        // findById
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if (oq.isPresent()) {
//			Question q = oq.get();
//			Assertions.assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}

        // findBySubject
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		Assertions.assertEquals(1, q.getId());

        // findBySubjectAndContent
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다"
//		);
//		Assertions.assertEquals(1, q.getId());

        // findBySubjectLike
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		Assertions.assertEquals("sbb가 무엇인가요?", q.getSubject());

        // 데이터 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		Assertions.assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);

        // 데이터 삭제
//		Assertions.assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		Assertions.assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		Assertions.assertEquals(1, this.questionRepository.count());

        // 답변 데이터 생성 후 저장하기
//		Optional<Question> oq = this.questionRepository.findById(2);
//		Assertions.assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

        // 답변 조회
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		Assertions.assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		Assertions.assertEquals(2, a.getQuestion().getId());

        // 질문에 달린 답변 찾기
//        Optional<Question> oq = this.questionRepository.findById(2);
//        Assertions.assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        Assertions.assertEquals(1, answerList.size());
//        Assertions.assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

        // 대량의 테스트 데이터 생성
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내 용 무";
            // author가 추가되어 오류 임시해결을 위해 null 추가
            this.questionService.create(subject, content, null);
        }
    }
}
