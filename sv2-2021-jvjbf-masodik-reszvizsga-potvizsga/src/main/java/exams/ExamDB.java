package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB{

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoint) {
        exam.calculateExamResult(actualPoint);
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        int count = 0;
        for (Exam e: exams) {
            if (e.getExamResult().equals(ExamResult.PASSED) || e.getExamResult().equals(ExamResult.OK) || e.getExamResult().equals(ExamResult.PERFECT)) {
                count++;
            }
        }
        return count;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> result = new ArrayList<>();
        for (Exam e: exams) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (Exam e: exams) {
            String[] topicSplit = e.getTopic().split(" ");
            if (topicSplit[0].equals(prefix)) {
                result.add(e.getTopic());
            }
        }
        return result;
    }
}
