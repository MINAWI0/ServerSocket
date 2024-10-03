package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        ObjectOutputStream output;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
            output = new ObjectOutputStream(clientSocket.getOutputStream());

            CalculationRequest request = (CalculationRequest) input.readObject();
            System.out.println("Received calculation request: " + request.getOperand1() + " " + request.getOperator() + " " + request.getOperand2());

            int result;
            switch (request.getOperator()) {
                case "+":
                    result = request.getOperand1() + request.getOperand2();
                    break;
                case "-":
                    result = request.getOperand1() - request.getOperand2();
                    break;
                case "*":
                    result = request.getOperand1() * request.getOperand2();
                    break;
                case "/":
                    result = request.getOperand1() / request.getOperand2();
                    break;
                default:
                    result = 0;
            }
            System.out.println("Sending result to client: " + result);
            output.writeObject(result);

            clientSocket.close();
        }

    }}

