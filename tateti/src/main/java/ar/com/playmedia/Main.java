package ar.com.playmedia;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

  static ArrayList<String> board = new ArrayList<String>();
  static Integer humanMove = 0;
  static Integer computerMove = 0;
  static Scanner keyboard = new Scanner(System.in);
  static String winner = " ";
  static String move = "valid";
  static Integer turns = 0;

  private static int getRandomNumber(final int min, final int max) {
    final Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  public static void viewBoard() {
    System.out.println();
    System.out.print(board.get(0));
    System.out.print(board.get(1));
    System.out.println(board.get(2));
    System.out.print(board.get(3));
    System.out.print(board.get(4));
    System.out.println(board.get(5));
    System.out.print(board.get(6));
    System.out.print(board.get(7));
    System.out.println(board.get(8));
    System.out.println();
  }

  public static void playHuman() {
    System.out.print("Ingrese el casillero que desee completar (0-8): ");
    final Integer choice = Integer.parseInt(keyboard.nextLine());
    if (choice < 0 || choice > 8) {
      System.out.println("Ingrese un casillero dentro del rango solicitado: ");
      move = "invalid";
    } else if (board.get(choice) == "_ ") {
      board.set(choice, "x ");
      move = "valid";
    } else {
      System.out.println("Este casilleron ya ha sido utilizado.");
      move = "invalid";
    }
  }

  public static void playComputer() {
    computerMove = getRandomNumber(0, 8);
    if (board.get(computerMove) == "_ ") {
      board.set(computerMove, "o ");
      move = "valid";
    } else {
      move = "invalid";
    }
  }

  public static void checkForWinner() {
    if (board.get(0) == "x " && board.get(1) == "x " && board.get(2) == "x "
        || board.get(3) == "x " && board.get(4) == "x " && board.get(5) == "x "
        || board.get(6) == "x " && board.get(7) == "x " && board.get(8) == "x "
        || board.get(0) == "x " && board.get(3) == "x " && board.get(6) == "x "
        || board.get(1) == "x " && board.get(4) == "x " && board.get(7) == "x "
        || board.get(2) == "x " && board.get(5) == "x " && board.get(8) == "x "
        || board.get(0) == "x " && board.get(4) == "x " && board.get(8) == "x "
        || board.get(6) == "x " && board.get(4) == "x " && board.get(2) == "x ") {
      System.out.println("Ganaste!");
      winner = "valid";
    } else if (board.get(0) == "o " && board.get(1) == "o " && board.get(2) == "o "
        || board.get(3) == "o " && board.get(4) == "o " && board.get(5) == "o "
        || board.get(6) == "o " && board.get(7) == "o " && board.get(8) == "o "
        || board.get(0) == "o " && board.get(3) == "o " && board.get(6) == "o "
        || board.get(1) == "o " && board.get(4) == "o " && board.get(7) == "o "
        || board.get(2) == "o " && board.get(5) == "o " && board.get(8) == "o "
        || board.get(0) == "o " && board.get(4) == "o " && board.get(8) == "o "
        || board.get(6) == "o " && board.get(4) == "o " && board.get(2) == "o ") {
      winner = "valid";
      System.out.println("Perdiste");
    } else {
      winner = "invalid";
    }
  }

  public static void main(final String[] args) {

    for (int i = 0; i < 9; i++) {
      board.add("_ ");
    }

    viewBoard();

    do {
      do {
        playHuman();
        viewBoard();
      } while (move == "invalid");

      checkForWinner();
      if (winner == "valid") {
        break;
      }

      turns += 1;
      if (turns == 5) {
        System.out.println("Hubo un empate");
        break;
      }

      System.out.println(" Casillero escogido por la computadora: ");

      do {
        playComputer();
      } while (move == "invalid");

      viewBoard();

      checkForWinner();


    } while (winner == "invalid");

  }
}