import br.com.lucasmuner.pooproject.interfaces.AudioInterface;
import br.com.lucasmuner.pooproject.models.Music;
import br.com.lucasmuner.pooproject.models.Podcast;
import br.com.lucasmuner.pooproject.models.User;

import static java.lang.IO.println;

void main() {
    try (Scanner scanner = new Scanner(System.in)) {
        User user = new User();
        Music sweetPee = new Music(
                1,
                "Sweet Pee",
                3.5,
                9,
                "System of a Down",
                "Nu Metal"
        );
        Podcast inutensilios = new Podcast(
                2,
                "Interviewing Dave Grohl - It's gonna be wild!",
                120,
                7.5,
                "Lucas Vinícius",
                "Dave Grohl"
        );

        println("Enter your username: ");
        user.setName(scanner.nextLine());

        int option = 0;
        while (option != 9) {
            println("***************************************");
            println(String.format("Hello, %s! Choose what you want to listen to:", user.getName()));

            // Details
            println(sweetPee.describe());
            println(inutensilios.describe());
            println(user.describe());

            println("(9) - Exit");

            try {
                option = Integer.parseInt(scanner.nextLine().trim());

                switch (option) {
                    case 1 -> listen(user, sweetPee, scanner);
                    case 2 -> listen(user, inutensilios, scanner);
                    case 9 -> println("Exiting...");
                    default -> println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                println("Please enter numbers only.");
            }
        }
    } catch (IllegalArgumentException e) {
        println("Error: " + e.getMessage());
    }
}

void listen(User user, AudioInterface audio, Scanner scanner) {
    println("Did you like the content? (Y/N)");
    boolean liked = scanner.nextLine().equalsIgnoreCase("Y");
    user.listen(audio, liked);
}