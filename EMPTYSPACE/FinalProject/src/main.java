import java.util.List;
import java.util.Scanner;

public class main {
                                public static void main(String[] args) {
        Student smodel = new Student();
        StudentView sview = new StudentView();
        Professor pfmodel = new Professor();
        PFV pfview = new PFV();
        C thesisController = new C(); // Create an instance of ThesisController

        StudentController controller = new StudentController(smodel, sview);
        PFC pfcontroller = new PFC(pfmodel, pfview, thesisController); // Pass the thesis controller

        C Ccontroller = new C();
        V view = new V();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // เพิ่มปริญญานิพนธ์ตัวอย่าง
        Ccontroller.addThesis(new M("1", "Author A"));
        Ccontroller.addThesis(new M("2", "Author B"));

        System.out.println("------------- Information -------------");

        while (!exit) {
            System.out.println("1. นักศึกษา");
            System.out.println("2. อาจารย์");
            System.out.print("--> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            view.displayMessage("\t");

            switch (choice) {
                case 1:
                    System.out.print("Student ID : ");
                    String id = scanner.nextLine();
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    view.displayMessage("\t");

                    String[] currentUser = controller.login(id, password);
                    if (currentUser != null) {
                        System.out.println("Log In Success");
                        controller.updateView(currentUser);
                        view.displayMessage("\t");
                    } else {
                        System.out.println("Information is Invalid");
                    }

                    boolean studentMenu = true; // ใช้ตัวแปรควบคุมลูปย่อย
                    while (studentMenu) {
                        System.out.println("1. Borrow/Return Thesis");
                        System.out.println("2. View Borrowed Thesis Status");
                        System.out.println("3. View Borrowing Details");
                        System.out.println("3. Exit");
                        System.out.print("--> ");
                        int studentChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        view.displayMessage("\t");

                        switch (studentChoice) {
                            case 1:
                                view.displayThesisList(Ccontroller.getThesisList());
                                System.out.print("Enter 'borrow <title>' or 'return <title>': ");
                                String input = scanner.nextLine();
                                String[] parts = input.split(" ");
                                if (parts.length == 2) {
                                    String command = parts[0];
                                    String title = parts[1];
                                    if (command.equalsIgnoreCase("borrow")) {
                                        if (Ccontroller.borrowThesis(title, id)) {
                                            view.displayMessage("Please wait for confirmation.");
                                        } else {
                                            view.displayMessage("Thesis not available for borrowing.");
                                        }

                                    } else if (command.equalsIgnoreCase("return")) {
                                        if (Ccontroller.returnThesis(title)) {
                                            view.displayMessage("You have returned: " + title);
                                        } else {
                                            view.displayMessage("Thesis not found or not borrowed.");
                                        }
                                    }
                                } else {
                                    view.displayMessage("Invalid input.");
                                }
                                view.displayMessage("\t");

                                break;

                            case 2:
                                List<M> borrowedTheses = Ccontroller.getBorrowedByUser(id);
                                if (borrowedTheses.isEmpty()) {
                                    System.out.println("No borrowed theses.");
                                } else {
                                    System.out.println("Borrowed Theses:");
                                    for (M thesis : borrowedTheses) {
                                        System.out.println(thesis.getTitle() + " by " + thesis.getAuthor() +
                                                (thesis.isApproved() ? " (Approved)" : " (Waiting for approval)"));
                                        view.displayMessage("\t");
                                    }
                                }
                                break;

                            case 3:
                                System.out.print("Enter thesis title to view details: ");
                                String titleForDetails = scanner.nextLine();
                                String details = thesisController.getBorrowDetails(titleForDetails);
                                sview.displayBorrowDetails(details);
                                break;

                            case 4:
                                System.out.println("Exiting student menu...");
                                studentMenu = false; // ตั้งค่าสถานะเพื่อหยุดลูปย่อย
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    view.displayMessage("\t");
                    break;
                    
                    case 2:
                    System.out.print("Professor ID : ");
                    String pfid = scanner.nextLine();
                    System.out.print("Password : ");
                    String pfpassword = scanner.nextLine();

                    String[] pfcurrentUser = pfcontroller.login(pfid, pfpassword);
                    if (pfcurrentUser != null) {
                        System.out.println("Log In Success");
                        pfcontroller.updateView(pfcurrentUser);
                        view.displayMessage("\t");
                        view.displayThesisList(Ccontroller.getThesisList());
                        view.displayMessage("\t");

                        // Allow professor to approve thesis borrowing
                        System.out.print("Enter thesis title to approve borrowing: ");
                        String titleToApprove = scanner.nextLine();
                        view.displayMessage("\t");
                        pfcontroller.approveThesisBorrowing(titleToApprove);
                        view.displayMessage("\t");
                    } else {
                        System.out.println("Information is Invalid");
                    }

                    break;

                default:
                    System.out.println("Please Select The Choice Again");
            }
        }

        //view.displayThesisList(Ccontroller.getThesisList());

        scanner.close();
    }
}