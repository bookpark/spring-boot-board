package mini.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제 목 은  필 수 항 목 입 니 다 .")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내 용 은  필 수 항 목 입 니 다 .")
    private String content;
}
