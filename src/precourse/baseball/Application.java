package precourse.baseball;

public class Application {

   public static void main(String[] args) {
       Game game = new Game(new Computer(), new Validation());
       game.startGame();
   }
}
