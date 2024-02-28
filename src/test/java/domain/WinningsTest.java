package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningsTest {

    @DisplayName("보상의 개수와 사용자 이름의 개수가 다르면 예외를 발생한다.")
    @Test
    void winningsLengthTest() {
        Assertions.assertThatThrownBy(() -> new Winnings(List.of("1", "2", "3"), 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보상의 수는 이름의 수와 같아야 합니다.");
    }

    @DisplayName("갖고 있는 List를 방어적 복사로 반환한다.")
    @Test
    void getNamesFromList() {
        Winnings winnings = new Winnings(List.of("test1", "test2"), 2);
        Assertions.assertThat(winnings.getWinnings()
                        .stream()
                        .map(Name::getName)
                        .toList())
                .isEqualTo(List.of(new Name("test1").getName(), new Name("test2").getName()));
    }
}
