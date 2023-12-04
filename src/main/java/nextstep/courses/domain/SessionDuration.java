package nextstep.courses.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionDuration {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public SessionDuration(LocalDateTime startDate, LocalDateTime endDate) {
        validate(startDate, endDate);

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime startDate() {
        return startDate;
    }

    public LocalDateTime endDate() {
        return endDate;
    }

    private void validate(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("강의 시작 혹은 종료 날짜는 비어있을 수 없습니다.");
        }

        if (startDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("시작날짜는 현재시간보다 이전일 수 없습니다.");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("시작날짜는 종료날짜보다 이후일 수 없습니다.");
        }

        if (startDate.isEqual(endDate)) {
            throw new IllegalArgumentException("시작날짜와 종료날짜는 동일할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionDuration that = (SessionDuration) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}