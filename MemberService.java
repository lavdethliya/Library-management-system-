package library.service;

import library.model.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all Member-related operations.
 */
public class MemberService {

    private List<Member> members = new ArrayList<>();
    private int nextId = 101;

    // Constructor: add sample members
    public MemberService() {
        registerMember("Rahul Sharma",  "rahul@email.com",  "9876543210");
        registerMember("Priya Singh",   "priya@email.com",  "9123456780");
        registerMember("Amit Verma",    "amit@email.com",   "9988776655");
    }

    public void registerMember(String name, String email, String phone) {
        members.add(new Member(nextId++, name, email, phone));
        System.out.println("  ✔  Member registered: " + name);
    }

    public Member findById(int id) {
        return members.stream()
                      .filter(m -> m.getMemberId() == id)
                      .findFirst()
                      .orElse(null);
    }

    public List<Member> getAllMembers() { return members; }

    public void displayAllMembers() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                        REGISTERED MEMBERS");
        System.out.println("=".repeat(80));
        System.out.printf("| %-6s | %-20s | %-25s | %-12s |%n",
                "ID", "Name", "Email", "Phone");
        System.out.println("-".repeat(80));
        if (members.isEmpty()) {
            System.out.println("  No members found.");
        } else {
            members.forEach(System.out::println);
        }
        System.out.println("=".repeat(80));
    }
}
