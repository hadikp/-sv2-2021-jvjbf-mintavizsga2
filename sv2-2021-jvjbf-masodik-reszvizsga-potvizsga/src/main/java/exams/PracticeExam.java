package exams;

import java.util.ArrayList;
import java.util.List;

public class PracticeExam extends Exam {

    private List<Integer> list;

    public PracticeExam(long studentId, String topic, List<Integer> list) {
        super(studentId, topic);
        setMaxPoints(countMaxPoint(list));

        if (!isMinAndMax(getMaxPoints())) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + getMaxPoints());
        }
        this.list = new ArrayList<>();
    }

    private int countMaxPoint(List<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }

    private boolean isMinAndMax(int sum) {
        if (sum > 10 && sum < 150) {
            return true;
        }
        return false;
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        double result = actualPointsPerMaxPoints(actualPoints);
        if (result >= 76) {
            setExamResult(ExamResult.PERFECT);
        } else if(result >= 51) {
            setExamResult(ExamResult.OK);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
