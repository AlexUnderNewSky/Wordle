package wordie;

import java.util.Scanner;

public class Wordle {
	public static void main(String[] args) {
		final String BG_GREEN = "\u001b[42m";
		final String BG_YELLOW = "\u001b[43m";
		final String RESET = "\u001b[0m";

		System.out.println("WORDLE!");
		
		String[] words = {"НЯКОЙ", "КАЗАХ", "МЯСТО", "МИСЛЯ", "ИСКАМ"};
		
		//Enter correct word to guess for a game | Въведете правилната дума, за да познаете за игра | Введіть правильне слово, щоб відгадати для гри
		int wIndex = (int)(Math.random() * words.length);
		String correct = words[wIndex];

		Scanner sc = new Scanner(System.in);
		String guess = "";

		// Loop for six guesses | Цикъл за шест предположения | Цикл для шести відгадок
		for (int attempt = 1; attempt < 6; attempt++) {
			System.out.print("Please guess. > ");

			guess = sc.nextLine().toUpperCase();

			// Create a loop to iterate through each letter | Създайте цикъл за итерация през всяка буква | Створіть цикл для повторення кожної літери
			for (int i = 0; i < 5; i++) {
				if (guess.substring(i, i + 1).equals(correct.substring(i, i + 1))) {
					// letter matches | съвпадения на буквите | літера відповідає
					System.out.print(BG_GREEN + guess.substring(i, i + 1) + RESET);
				} else if (correct.indexOf(guess.substring(i, i + 1)) > -1) // where a letter is in a different string |  където буква е в различен низ | де буква знаходиться в іншому рядку
					
																			
				{
					// letter is in word, but different location | буквата е в думата, но на различно място | літера є в слові, але в іншому місці
					
					System.out.print(BG_YELLOW + guess.substring(i, i + 1) + RESET);
				} else {
					// Not in word | Не в словото | Не в слові
					System.out.print(guess.substring(i, i + 1));
				}
			}
			System.out.println("");
			
			// If the guess is correct | Ако предположението е вярно | Якщо припущення вірне
			if(guess.equals(correct))
					{
						System.out.println("Correct! You win!");
						break;
					}
		}
		//Print correct answer if player loses
		if(!guess.equals(correct))
		{
			System.out.println("Wring! The correct word is " + correct + ".");
		}
	}
}