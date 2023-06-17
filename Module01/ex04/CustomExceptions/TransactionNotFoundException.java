package CustomExceptions;

class TransactionNotFoundException extends Exception {
    TransactionNotFoundException(String message){
        super(message);
    }
}