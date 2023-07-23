package ex02;

class UserIdsGenerator{

    private int generatedId;
    private static UserIdsGenerator instance;
    private UserIdsGenerator() {
        this.generatedId = 1;
    }

    static UserIdsGenerator getInstance(){
        if (instance == null)
            return (new UserIdsGenerator());
        return (instance);
    }

    int getGeneratedId() {
        int newId = generatedId++;
        return (newId);
    }
}