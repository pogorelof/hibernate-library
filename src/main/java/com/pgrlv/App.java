package com.pgrlv;

import com.pgrlv.model.Author;
import com.pgrlv.model.Book;
import com.pgrlv.service.LibraryService;
import com.pgrlv.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        LibraryService libraryService = new LibraryService(session);

        String menuText = """
                Выберите действие:
                1. Добавить автора
                2. Добавить книгу
                3. Регистрация читателя
                4. Выдача книги
                5. Возврат книги
                6. Список книг
                7. Список книг читателя
                8. Удаление книги
                9. Удаление читателя
                0. Выход
                """;

        boolean run = true;
        while (run){
            System.out.println(menuText);
            System.out.print("Выбор: ");
            String choose = scanner.nextLine();

            switch (choose){
                case "0":
                    run = false;
                    break;
                case "1":
                    System.out.print("Введите имя автора: ");
                    String name = scanner.nextLine();
                    libraryService.addAuthor(name);
                    break;
                case "2":
                    System.out.println("Введите название книги: ");
                    String title = scanner.nextLine();

                    System.out.println("Введите количество доступных книг: ");
                    Integer count = Integer.parseInt(scanner.nextLine());

                    System.out.println("Выберите автора:");
                    List<Author> authors = libraryService.getAllAuthors();
                    for (int i = 0; i < authors.size(); i++) {
                        int index = i + 1;
                        System.out.println(index + ". " + authors.get(i).getName());
                    }
                    System.out.print("Выбор: ");
                    int chooseAuthor = Integer.parseInt(scanner.nextLine()) - 1;

                    Book book = new Book();
                    book.setTitle(title);
                    book.setCount(count);
                    book.setAuthor(authors.get(chooseAuthor));

                    libraryService.addBook(book);
            }

        }
    }
}
