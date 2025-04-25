# 📖 Codeo Library Management System

A simple console-based Java application to manage book checkouts and check-ins for a library.

![GitHub last commit](https://img.shields.io/github/last-commit/HeldanaG/workshop)

---

## 📜 Project Description

This Java console app allows users to:

- 📚 View available books  
- 📕 Check out a book by entering its ID  
- 📗 View checked out books  
- 📘 Check a book back in  
- 🔙 Return to the main menu at any time  

It uses arrays, classes, methods, and simple console input/output for interaction.

---

## 📦 Features

- 📖 View all available books
- ✅ Check out a book by ID
- 📋 View all checked-out books and who they’re checked out to
- 🔄 Check in a book by ID
- 📲 Return to the main menu after every action
- 🛑 Handle invalid inputs gracefully using try-catch

---

## 💡 How to Run

1. Clone or download the repository.
2. Open the project in your favorite Java IDE (like IntelliJ, Eclipse, or VS Code).
3. Run the `neighborhood-library` file.

---

## 📸 Screenshots

**Home Screen:**

![image](https://github.com/user-attachments/assets/1edbff98-9ddf-4568-ac1f-7ed18b9cf678)


**Available Books Screen:**

![image](https://github.com/user-attachments/assets/60b04be0-ad74-44bd-a66e-b75a9accbadf)

**Checked-Out Books Screen:**

![image](https://github.com/user-attachments/assets/d781c23a-5582-4e44-b99c-bfd533cc454f)

**Error Handling Example (Invalid Input):**

![image](https://github.com/user-attachments/assets/ecae73c8-a4c8-4c7b-99fa-68cfe9ad977d)

![image](https://github.com/user-attachments/assets/41daa105-b6d3-4e1f-84b0-3745c33d027c)



![image](https://github.com/user-attachments/assets/f84b5d21-daab-47a0-b707-5480f5c56778)

---

## 🔍 Interesting Code

```java
if (choice.equalsIgnoreCase("C")) {

                    // Prompt for book Id to check in
                    System.out.print("Enter book Id to check in: ");
                    int bookId = input.nextInt();
                    input.nextLine(); // Clear buffer

                    // Boolean to track if book is found
                    boolean found = false;

                    // Loop through books to find matching Id and check it in
                    for (Book book : books) {
                        if (book.getId() == bookId && book.isCheckedOut()) {
                            book.checkIn();
                            System.out.println("Book checked in successfully!");
                            found = true;
                            break;
                        }
                    }

                    // If no valid book is found
                    if (!found) {
                        System.out.println("Invalid book Id or book is not checked out.");
                    }

                } else if (choice.equalsIgnoreCase("X")) {
                    // Exit checked out books menu
                    appRunnig = false;
                } else {
                    // Handle invalid input if not c or x
                    System.out.println("Invalid input. Please enter C or X");
                }
                // catch  invalid input type
            } catch (InputMismatchException e) {
                System.out.print("Invalid input type! Please enter a number: ");
                input.nextLine();
                continue;
            }
        }
```
## 🎯 Why it matters

This conditional structure ensures users can easily check in a book by entering its ID, receive clear feedback if the book isn’t found or isn’t checked out, and gracefully choose whether to continue or exit. It improves user experience by handling invalid choices, guiding users with clear prompts, and preventing abrupt program exits or crashes from bad input — making the library menu smooth, predictable, and beginner-friendly.
