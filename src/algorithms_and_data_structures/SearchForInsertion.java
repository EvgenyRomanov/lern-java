package algorithms_and_data_structures;

/**
 * Бинарный поиск: поиск места для вставки.
 */
public class SearchForInsertion {
    static class Player {
        int rating;
        String nickName;

        public Player(int rating, String nickName) {
            this.rating = rating;
            this.nickName = nickName;
        }
    }

    static Player[] ratings = new Player[] {
             new Player(1100, "Test1"), // 0
             new Player(1200, "Test2"), // 1
             new Player(1600, "Test3"), // 2
             new Player(1600, "Test4"), // 3
             new Player(1600, "Test5"), // 4
             new Player(3000, "Test6"), // 5
             new Player(4000, "Test7"), // 6
    };

    /**
     * Поиск места для вставки нового игрока.
     */
    public static int findSpot(Player[] array, Player newPlayer) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;

            if (array[middle].rating < newPlayer.rating) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left; // Первый среди равных.
    }

    static void main(String[] args) {
        int spot1 = findSpot(ratings, new Player(1600, "QWERT")); // 2
        int spot2 = findSpot(ratings, new Player(1700, "QWERT")); // 5
        System.out.println(spot1 + " " + spot2);
    }
}
