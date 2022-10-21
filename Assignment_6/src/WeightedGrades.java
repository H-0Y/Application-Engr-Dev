public class WeightedGrades {
    private double totalPoints;
    private double earnedPoints;
    private double assignmentPercentage;
    private double total_weighted_grades;

    public WeightedGrades (double a, double b, double c) {
        totalPoints = a;
        earnedPoints = b;
        assignmentPercentage = c;
    }
    public  WeightedGrades () {
        totalPoints = 0;
        earnedPoints = 0;
        assignmentPercentage = 0;
    }
    // calculate total weighted grades
    public void calculate() {
        this.total_weighted_grades = this.earnedPoints / this.totalPoints * this.assignmentPercentage;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(double assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public double getTotal_weighted_grades() {
        return total_weighted_grades;
    }

    public void setTotal_weighted_grades(double total_weighted_grades) {
        this.total_weighted_grades = total_weighted_grades;
    }
}

