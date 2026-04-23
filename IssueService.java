package library.service;

import library.model.Book;
import library.model.IssueRecord;
import library.model.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles Book Issue and Return operations.
 */
public class IssueService {

    private List<IssueRecord> records = new ArrayList<>();
    private int nextRecordId = 1001;

    private BookService   bookService;
    private MemberService memberService;

    public IssueService(BookService bookService, MemberService memberService) {
        this.bookService   = bookService;
        this.memberService = memberService;
    }

    public boolean issueBook(int bookId, int memberId) {
        Book book = bookService.findById(bookId);
        Member member = memberService.findById(memberId);

        if (book == null) {
            System.out.println("  ✘  Book with ID " + bookId + " not found.");
            return false;
        }
        if (member == null) {
            System.out.println("  ✘  Member with ID " + memberId + " not found.");
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("  ✘  Book \"" + book.getTitle() + "\" is already issued.");
            return false;
        }

        book.setAvailable(false);
        records.add(new IssueRecord(nextRecordId++, bookId, memberId));
        System.out.println("  ✔  Book \"" + book.getTitle() + "\" issued to " + member.getName());
        return true;
    }

    public boolean returnBook(int bookId, int memberId) {
        Book book = bookService.findById(bookId);
        if (book == null) {
            System.out.println("  ✘  Book with ID " + bookId + " not found.");
            return false;
        }

        IssueRecord record = records.stream()
                .filter(r -> r.getBookId() == bookId
                          && r.getMemberId() == memberId
                          && !r.isReturned())
                .findFirst()
                .orElse(null);

        if (record == null) {
            System.out.println("  ✘  No active issue record found for this book and member.");
            return false;
        }

        record.markReturned();
        book.setAvailable(true);
        System.out.println("  ✔  Book \"" + book.getTitle() + "\" returned successfully.");
        return true;
    }

    public void displayAllRecords() {
        System.out.println("\n" + "=".repeat(85));
        System.out.println("                          ISSUE / RETURN RECORDS");
        System.out.println("=".repeat(85));
        System.out.printf("| %-8s | %-6s | %-8s | %-12s | %-12s | %-8s |%n",
                "Rec. ID", "BookID", "MembrID", "Issue Date", "Return Date", "Status");
        System.out.println("-".repeat(85));
        if (records.isEmpty()) {
            System.out.println("  No records found.");
        } else {
            records.forEach(System.out::println);
        }
        System.out.println("=".repeat(85));
    }
}
