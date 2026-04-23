package library.util;

/**
 * Utility class for console display helpers.
 */
public class ConsoleUtil {

    public static void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════╗");
        System.out.println("  ║        LIBRARY MANAGEMENT SYSTEM  v1.0          ║");
        System.out.println("  ║          Developed using Core Java OOP           ║");
        System.out.println("  ╚══════════════════════════════════════════════════╝");
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("\n  ┌─────────────────────────────────┐");
        System.out.println("  │           MAIN MENU             │");
        System.out.println("  ├─────────────────────────────────┤");
        System.out.println("  │  1. View All Books              │");
        System.out.println("  │  2. Add a New Book              │");
        System.out.println("  │  3. Search Book by Title        │");
        System.out.println("  │  4. Search Book by Author       │");
        System.out.println("  │  5. View All Members            │");
        System.out.println("  │  6. Register New Member         │");
        System.out.println("  │  7. Issue a Book                │");
        System.out.println("  │  8. Return a Book               │");
        System.out.println("  │  9. View Issue/Return Records   │");
        System.out.println("  │  0. Exit                        │");
        System.out.println("  └─────────────────────────────────┘");
        System.out.print("  Enter your choice: ");
    }

    public static void printDivider() {
        System.out.println("  " + "─".repeat(60));
    }
}
