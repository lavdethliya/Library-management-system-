package library.model;

import java.time.LocalDate;

/**
 * Represents a Book Issue / Return Record.
 */
public class IssueRecord {

    private int      recordId;
    private int      bookId;
    private int      memberId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean  returned;

    public IssueRecord(int recordId, int bookId, int memberId) {
        this.recordId   = recordId;
        this.bookId     = bookId;
        this.memberId   = memberId;
        this.issueDate  = LocalDate.now();
        this.returnDate = null;
        this.returned   = false;
    }

    // Getters
    public int       getRecordId()   { return recordId; }
    public int       getBookId()     { return bookId; }
    public int       getMemberId()   { return memberId; }
    public LocalDate getIssueDate()  { return issueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean   isReturned()    { return returned; }

    public void markReturned() {
        this.returned    = true;
        this.returnDate  = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("| %-8d | %-6d | %-8d | %-12s | %-12s | %-8s |",
                recordId, bookId, memberId, issueDate,
                returnDate != null ? returnDate.toString() : "Not Returned",
                returned ? "Returned" : "Active");
    }
}
