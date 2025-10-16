package org.workspace.learn.basic.exception_handling.custom_exception;

class InvalidScoreException extends Exception {
    public InvalidScoreException() {
        System.out.println("message");
    }
}

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    static void checkScore(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException();
        }
        System.out.println("Valid score: " + score);
    }

    static void productCheck(int weight) throws InvalidProductException {
        if (weight < 100) {
            throw new InvalidProductException("Self-reflection");
        }
        System.out.println("Valid weight: " + weight);
    }

    public static void main(String[] args) {
        try {
            checkScore(70);
            productCheck(50);
        } catch (InvalidScoreException e) {
            e.getMessage();
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }
}
