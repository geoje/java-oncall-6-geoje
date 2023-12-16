package oncall.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class WorkersTest {
    @Test
    @DisplayName("생성자를 통한 생성")
    void newWithConstructor() {
        assertThatCode(() -> {
            new Workers(List.of(
                    new Worker("경호"),
                    new Worker("수빈"),
                    new Worker("진서")
            ));
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("문자열을 통한 생성")
    @ValueSource(strings = {"경호,수빈,진서"})
    void from(String workers) {
        assertThatCode(() -> Workers.from(workers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("사원이 중복될 경우 예외")
    @ValueSource(strings = {"경호,수빈,진서,수빈"})
    void validateDuplicate(String workers) {
        assertThatCode(() -> Workers.from(workers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사원 이름이 너무 길 경우 예외")
    @ValueSource(strings = {"코딩하는경호,수빈,진서,수빈"})
    void validateNameLength(String workers) {
        assertThatCode(() -> Workers.from(workers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사원이 너무 많을 경우 예외")
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m"})
    void validateCount(String workers) {
        assertThatCode(() -> Workers.from(workers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
