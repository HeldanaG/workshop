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

![image](https://github.com/user-attachments/assets/f66e7978-08a5-463d-9de3-a290150bd995)

**Checked-Out Books Screen:**

![image](https://github.com/user-attachments/assets/6c4bcc0e-85f0-424b-8c9e-5aee17e4247a)

**Error Handling Example (Invalid Input):**

![image](https://github.com/user-attachments/assets/96ca8ca5-b277-4cd1-a223-a0c68f31e9a0)

![image](https://github.com/user-attachments/assets/ea716b45-f642-44f4-bacb-df1f4f20463b)


![image](https://github.com/user-attachments/assets/d46a49c7-e1f5-4f4a-95eb-b1413b4bc982)

---

## 🔍 Interesting Code

```java
// Prompt for book Id to check in
System.out.print("Enter book Id to check in: ");
String bookIdInput = input.nextLine();
while (bookIdInput.isEmpty() || !bookIdInput.matches("\\d+")) {
    System.out.print("Invalid input. Please enter a valid number: ");
    bookIdInput = input.nextLine();
}
int bookId = Integer.parseInt(bookIdInput);

```
## 🎯 Why it matters

This input validation loop ensures users provide a proper numeric Book ID when checking in a book. It prevents errors from empty or invalid inputs, offers clear, direct feedback, and guides users to enter acceptable values before continuing. By filtering bad input early, the program stays stable and predictable, avoiding crashes or logic errors — making the library system beginner-friendly, reliable, and easier to maintain.
