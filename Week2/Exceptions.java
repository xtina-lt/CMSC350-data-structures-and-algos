class InvalidCharException extends Exception {
    InvalidCharException() {
    }
}

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}