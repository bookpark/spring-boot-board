package mini.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내 용 은  필 수 항 목 입 니 다 .")
    private String content;
}
