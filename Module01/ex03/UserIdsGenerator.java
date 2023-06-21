package ex03;

class UserIdsGenerator{

    private static int generatedId = 0;
    private static UserIdsGenerator instance;
    private UserIdsGenerator() {}

    static UserIdsGenerator getInstance(){
        if (instance == null)
            return (new UserIdsGenerator());
        return (instance);
    }

    int getGeneratedId(){
        return (++generatedId);
    }
}