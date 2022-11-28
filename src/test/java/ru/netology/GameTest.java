package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    public void testIfPlayer1Stronger() {
        Player player1 = new Player(1, "Kolya", 100);
        Player player2 = new Player(2, "Misha", 90);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Kolya", "Misha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfPlayer2Stronger() {

        Player player1 = new Player(1, "Kolya", 100);
        Player player2 = new Player(2, "Misha", 120);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Kolya", "Misha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfDraw() {

        Player player1 = new Player(1, "Kolya", 100);
        Player player2 = new Player(2, "Misha", 100);

        game.register(player1);
        game.register(player2);


        int expected = 0;
        int actual = game.round("Kolya", "Misha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfFirstPlayerNotFound() {

        Player player1 = new Player(1, "Kolya", 100);
        Player player2 = new Player(2, "Misha", 90);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Kolya", "Valya"));
    }

    @Test
    public void testIfSecondPlayerNotFound() {

        Player player1 = new Player(1, "Kolya", 100);
        Player player2 = new Player(2, "Misha", 90);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Valya", "Misha"));
    }
}