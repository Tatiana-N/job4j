package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
  public static void main(String[] args) throws IOException {
    try (ServerSocket server = new ServerSocket(9000)) {
      while (true) {
        Socket socket = server.accept();
        try (OutputStream out = socket.getOutputStream();
             BufferedReader in = new BufferedReader(
               new InputStreamReader(socket.getInputStream()))) {
          String answer = "";
          String str;
          while (!(str = in.readLine()).isEmpty()) {
            if (str.contains("msg")) {
              answer = str.substring(str.lastIndexOf("=") + 1, str.indexOf("HTTP") - 1);
            }
            if (str.contains("msg=Bye ")) {
              out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
              server.close();
              return;
            }
            System.out.println(str);
          }

          out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
          out.write(answer.getBytes());
          out.flush();
        }
      }
    }
  }
}