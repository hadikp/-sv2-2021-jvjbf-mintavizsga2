package exams;

import java.util.ArrayList;
import java.util.List;

public class PracticeExam extends Exam {

    private List<Integer> list;

    public PracticeExam(long studentId, String topic, int maxPoints, List<Integer> list) {
        super(studentId, topic, maxPoints);
        this.list = new ArrayList<>();
    }

    @Override
    public void calculateExamResult(int actualPoints) {

    }
}
