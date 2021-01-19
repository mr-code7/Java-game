public class Game {
    int width;
    int height;
    char[][] griglia;
    int x;
    int y;
    boolean penna;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.griglia = new char[width][height];
        this.x = width / 2;
        this.y = height / 2;
        this.penna = false;
        pulisci();
    }

    public void pulisci() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                griglia[i][j] = ' ';
            }
        }
    }

    public void muovi(int x, int y) {
        System.out.println(x + ", " + this.x);
        if (this.penna) {
            if (x > 0) {
                for (int i = this.x; i < this.x + x && i < width; i++) {
                    this.griglia[i][this.y] = '*';
                }
            } else {
                for (int i = this.x; i > this.x + x && i > 0; i--) {
                    this.griglia[i][this.y] = '*';
                }
            }
            if (y > 0) {
                for (int i = this.y; i < this.y + y && i > height; i++) {
                    this.griglia[this.x][i] = '*';
                }
            } else {
                for (int i = this.y; i > this.y + y && i < 0; i--) {
                    this.griglia[this.x][i] = '*';
                }
            }
        }
        this.x += x;
        this.y += y;

        if (this.x > width) {
            this.x = width - 1;
        } else if (this.x < 0) {
            this.x = 0;
        }
        if (this.y > height) {
            this.y = height - 1;
        } else if (this.y < 0) {
            this.y = 0;
        }
    }

    public void penna(boolean stato) {
        this.penna = stato;
    }

    public void stampa() {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();

        for (int i = 0; i < height + 2; i++)
            System.out.print("*");

        System.out.println("");
        for (int i = 0; i < width; i++) {
            System.out.print("*");
            for (int j = 0; j < height; j++) {
                if (i == x && y == j) {
                    if (this.penna)
                        System.out.print("I");
                    else
                        System.out.print("O");
                } else
                    System.out.print(griglia[i][j]);
            }
            System.out.println("*");
        }

        for (int i = 0; i < height + 2; i++)
            System.out.print("*");

    }
}
