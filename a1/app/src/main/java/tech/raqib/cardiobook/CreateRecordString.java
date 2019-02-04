package tech.raqib.cardiobook;

public class CreateRecordString {

    private String recordString;
    private String comment;

    public void CreateRecordString() {
        recordString = "";
    }

    public void checkComment(String comment) {
        if (comment.length() <= 20) {
            this.comment = comment;
        } else {
            // throw error
        }
    }

    public void setRecordString(String date, String time,
                                String systolic, String diastolic,
                                String hr, String comment) {

        recordString = date + "@" + time + ": Sp - " + systolic + " Dp - " + diastolic
                + " HR - " + hr + "Comment - " + comment;
    }

    @Override
    public String toString() {
        return recordString;
    }
}
