package exams;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if (actualPoints < 0 || actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Nem jó a pontszám!");
        }
        double result = 100.0 * actualPoints / getMaxPoints();
        if (result >= 51) {
            setExamResult(ExamResult.PASSED);
        }
        setExamResult(ExamResult.NOT_PASSED);
    }
}
