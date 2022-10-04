public class Calculator {
    //private attributes
    private Double[] maxScores;
    private Double[] rowScores;
    private Double[] percentages;
    private Double result;
    // constructor without parameters
    public Calculator () {
        maxScores = new Double[8];
        rowScores = new Double[8];
        percentages = new Double[8];
        this.result = 0.0;
    }
    // constructor with reference parameters
    public Calculator (Double[] maxScores, Double[] rowScores, Double[] percentages) {
        this.maxScores = maxScores;
        this.rowScores = rowScores;
        this.percentages = percentages;
        this.result = 0.0;
    }
    //calculate total weighted grades
    public void calculate() {
        for(int i = 0; i < maxScores.length; i++) {
            this.result += (this.rowScores[i] / this.maxScores[i]) * this.percentages[i];
        }

    }
    // accessor method
    // access the arrays
    public Double[] getMaxScores() {
        return maxScores;
    }

    public Double[] getRowScores() {
        return rowScores;
    }

    public Double[] getPercentages() {
        return percentages;
    }
    // access the single element's value in arrays
    public Double getMaxScore(int i) {
        return maxScores[i];
    }

    public Double getRowScore(int i) {
        return rowScores[i];
    }

    public Double getPercentage(int i) {
        return percentages[i];
    }
    public Double getResult() {
        return result;
    }

    //mutator method
    // set the single element's value in arrays
    public void setMaxScore(int i, Double maxScore) {
        maxScores[i] = maxScore;
    }

    public void setRowScore(int i, Double rowScore) {
        rowScores[i] = rowScore;
    }

    public void setPercentage(int i, Double percentage) {
        percentages[i] = percentage;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
