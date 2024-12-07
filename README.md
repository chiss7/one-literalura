# one-literalura

This is a simple console-based application for managing books and authors. The application allows you to search for books online, save them in a database, and perform various operations on saved books and authors.

## Features

- **Search Book by Title**  
  Fetch book information from the Gutendex API, including details about its author, and save it to the database.

- **Print Saved Books**  
  Display all books stored in the database.

- **Print Saved Authors**  
  Display all authors stored in the database.

- **Print Authors Alive in a Given Year**  
  List authors who were alive in a specified year.

- **Print Books by Language**  
  Display books stored in the database written in a specific language.

## Menu Options

When you run the program, you'll be presented with the following menu options:

### Option Details

1. **Search Book by Title**
    - Prompts the user to enter a book title.
    - Searches for the book using the [Gutendex API](https://gutendex.com/books/).
    - Saves the book and its author in the database (if not already saved).

2. **Print Saved Books**
    - Lists all books saved in the database.

3. **Print Saved Authors**
    - Lists all authors saved in the database.

4. **Print Authors Alive in a Given Year**
    - Prompts the user to enter a year.
    - Displays all authors who were alive in that year.

5. **Print Books by Language**
    - Prompts the user to enter a language abbreviation (e.g., `en` for English, `es` for Spanish).
    - Displays all books written in that language.

6. **Exit**
    - Closes the application.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/chiss7/one-literalura
   cd one-literalura
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Run docker compose:
   ```bash
   docker compose up -d
   ```   
4. Run the application:
   ```bash
   java -jar target/library-management.jar
   ```