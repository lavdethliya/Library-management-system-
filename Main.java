import library.service.BookService;
import library.service.IssueService;
import library.service.MemberService;
import library.util.ConsoleUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * =========================================================
 *  Library Management System
 *  Author  : [Your Name]
 *  Date    : 2025
 *  Version : 1.0
 *
 *  Features:
 *    - Add / View / Search Books
 *    - Register / View Members
 *    - Issue and Return Books
 *    - View all Issue / Return records
 * =========================================================
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize services
        BookService   bookService   = new BookService();
        MemberService memberService = new MemberService();
        IssueService  issueService  = new IssueService(bookService, memberService);

        ConsoleUtil.printBanner();
        System.out.println("  Sample data loaded successfully!\n");

        boolean running = true;

        while (running) {
            ConsoleUtil.printMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.println();

                switch (choice) {

                    case 1:
                        bookService.displayAllBooks();
                        break;

                    case 2:
                        System.out.print("  Enter Title  : ");
                        String title = scanner.nextLine().trim();
                        System.out.print("  Enter Author : ");
                        String author = scanner.nextLine().trim();
                        System.out.print("  Enter Genre  : ");
                        String genre = scanner.nextLine().trim();
                        bookService.addBook(title, author, genre);
                        break;

                    case 3:
                        System.out.print("  Enter title keyword: ");
                        String titleKey = scanner.nextLine().trim();
                        var byTitle = bookService.searchByTitle(titleKey);
                        if (byTitle.isEmpty()) {
                            System.out.println("  No books found with keyword: " + titleKey);
                        } else {
                            System.out.println("\n  Results:");
                            byTitle.forEach(b -> System.out.println("  " + b));
                        }
                        break;

                    case 4:
                        System.out.print("  Enter author keyword: ");
                        String authorKey = scanner.nextLine().trim();
                        var byAuthor = bookService.searchByAuthor(authorKey);
                        if (byAuthor.isEmpty()) {
                            System.out.println("  No books found for author: " + authorKey);
                        } else {
                            System.out.println("\n  Results:");
                            byAuthor.forEach(b -> System.out.println("  " + b));
                        }
                        break;

                    case 5:
                        memberService.displayAllMembers();
                        break;

                    case 6:
                        System.out.print("  Enter Name  : ");
                        String name = scanner.nextLine().trim();
                        System.out.print("  Enter Email : ");
                        String email = scanner.nextLine().trim();
                        System.out.print("  Enter Phone : ");
                        String phone = scanner.nextLine().trim();
                        memberService.registerMember(name, email, phone);
                        break;

                    case 7:
                        System.out.print("  Enter Book ID   : ");
                        int issueBookId = scanner.nextInt();
                        System.out.print("  Enter Member ID : ");
                        int issueMembId = scanner.nextInt();
                        scanner.nextLine();
                        issueService.issueBook(issueBookId, issueMembId);
                        break;

                    case 8:
                        System.out.print("  Enter Book ID   : ");
                        int retBookId = scanner.nextInt();
                        System.out.print("  Enter Member ID : ");
                        int retMembId = scanner.nextInt();
                        scanner.nextLine();
                        issueService.returnBook(retBookId, retMembId);
                        break;

                    case 9:
                        issueService.displayAllRecords();
                        break;

                    case 0:
                        System.out.println("  Thank you for using Library Management System. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("  Invalid choice. Please enter 0-9.");
                }

            } catch (InputMismatchException e) {
                System.out.println("  ✘  Invalid input. Please enter a number.");
                scanner.nextLine();
            }

            ConsoleUtil.printDivider();
        }

        scanner.close();
    }
}
