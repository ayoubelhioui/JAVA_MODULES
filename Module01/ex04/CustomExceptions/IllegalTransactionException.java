package CustomExceptions;

class IllegalTransactionException extends Exception{
    IllegalTransactionException(String message) {
        super(message);
    }
}