/**
 * MTClient.java
 *
 * This program implements a simple multithreaded chat client.  It connects to the
 * server (assumed to be localhost on port 7654) and starts two threads:
 * one for listening for data sent from the server, and another that waits
 * for the user to type something in that will be sent to the server.
 * Anything sent to the server is broadcast to all clients.
 *
 * The MTClient uses a ClientListener whose code is in a separate file.
 * The ClientListener runs in a separate thread, recieves messages form the server,
 * and displays them on the screen.
 *
 * Data received is sent to the output screen, so it is possible that as
 * a user is typing in information a message from the server will be
 * inserted.
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

import java.util.Scanner;

public class MtClient {
  /**
   * main method.
   * @params not used.
   */
  public static void main(String[] args) {
    try {
      String hostname = "localhost";
      int port = 7654;

      System.out.println("Connecting to server on port " + port);
      Socket connectionSock = new Socket(hostname, port);

      DataOutputStream serverOutput = new DataOutputStream(connectionSock.getOutputStream());

      System.out.println("Connection made, congratualtions!. \n");

      // Start a thread to listen and display data sent by the server
      ClientListener listener = new ClientListener(connectionSock);
      Thread theThread = new Thread(listener);
      theThread.start();


      System.out.println("Welcome to (R)ock, (P)aper, (S)cissors!");
      System.out.println("To make a valid choice, please read between the brackets above!");
      System.out.println("If at anytime you wishe to (Q)uit");

      boolean game = true;
      Integer play = 1;

      while (play == true) {
        System.out.println("Round number" + play + "Take a guess!");
        Scanner keyboard = new Scanner(System.in);
        String info = keyboard.nextLine();

         if (!info.equals("R") ||  "P" || "S" || "Q") {
          System.out.println("Invalid input, remember: Choices are case sensitive!");
          info = keyboard.nextLine();
         }

         serverOutput.writeBytes(data + "\n");

          while(data.equals("Q")) {
          System.out.println("now exiting");
          System.out(0);
          break;

          String inputInfo = listener.dataTransfer();
         }
        if(dataTransfer.equals(inputInfo)) {

          System.out.println("Tie, Try again!");
        }

        else if (data.equals("R") && inputInfo.equals("S")) {

          System.out.println("Rock Wins!");
        }

        else if (data.equals("P") && inputInfo.equals("S")) {

          System.out.println("Paper Wins!");

        }

        else if (data.equals("R") && inputInfo.equals("P")) {

          System.out.println("Rock Wins!");
        }

        else if (data.equals("S") && inputInfo.equals("R")) {

          System.out.println("Scissors Wins!");
        }

        else if (data.equals("S") && inputInfo.equals("P")) {
         
          System.out.println("Scissors Wins!");

        }

        else if (data.equals("P") && inputInfo.equals("R")) {

          System.out.println("Paper Wins!");

        }
        ++play;
        System.out.println();
      }

      // Read input from the keyboard and send it to everyone else.
      // The only way to quit is to hit control-c, but a quit command
      // could easily be added.
      } catch(SocketException ex) {
        System.out.println("Closing socket");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
} // MtClient