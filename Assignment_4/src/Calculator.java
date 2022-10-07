import java.util.LinkedList;

public class Calculator {
    //private attributes
    private LinkedList<Double> maxScores;
    private LinkedList<Double> rowScores;
    private LinkedList<Double> percentages;
    private Double result;
    // constructor without parameters
    public Calculator() {
        maxScores = new LinkedList<>();
        rowScores = new LinkedList<>();
        percentages = new LinkedList<>();
        this.result = 0.0;
    }
    // constructor with reference parameters
    public Calculator(LinkedList<Double> maxScores, LinkedList<Double> rowScores, LinkedList<Double> percentages) {
        this.maxScores = maxScores;
        this.rowScores = rowScores;
        this.percentages = percentages;
        this.result = 0.0;
    }
    //calculate total weighted grades
    public void calculate() {
        for(int i = 0; i < maxScores.size(); i++) {
            this.result += (this.rowScores.get(i) / this.maxScores.get(i)) * this.percentages.get(i);
        }

    }
    // accessor method
    // get the size of private linkedlist
    public int sizeOfMaxScores() {return maxScores.size();}
    public int sizeOfRowScores() {return rowScores.size();}
    public int sizeOfPercentages() {return percentages.size();}

    // access the arrays
    public LinkedList<Double> getMaxScores() {
        return maxScores;
    }

    public LinkedList<Double> getRowScores() {
        return rowScores;
    }

    public LinkedList<Double> getPercentages() {
        return percentages;
    }
    // access the single element's value in arrays
    public Double getMaxScore(int i) {
        return maxScores.get(i);
    }

    public Double getRowScore(int i) {
        return rowScores.get(i);
    }

    public Double getPercentage(int i) {
        return percentages.get(i);
    }
    public Double getResult() {
        return result;
    }

    // mutator method
    // add elements to private attributes
    public void addMaxScores(Double maxScore) {
        maxScores.add(maxScore);
    }

    public void addRowScores(Double rowScore) {
        rowScores.add(rowScore);
    }

    public void addPercentages(Double percentage) {
        percentages.add(percentage);
    }

    // clear the private linkedlist
    public void clearMaxScores() {
        maxScores.clear();
    }

    public void clearRowScores() {
        rowScores.clear();
    }

    public void clearPercentages() {
        percentages.clear();
    }
    // set the single element's value in arrays
    public void setMaxScore(int i, Double maxScore) {
        maxScores.set(i, maxScore);
    }

    public void setRowScore(int i, Double rowScore) {
        rowScores.set(i, rowScore);
    }

    public void setPercentage(int i, Double percentage) {
        percentages.set(i, percentage);
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
