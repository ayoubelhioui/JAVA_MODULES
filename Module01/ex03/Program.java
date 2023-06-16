package ex02;

class Program{
    public static void main(String[] args){
        User Mike = new User("Mike", 400);
        User John = new User("John", 500);
        User Imad = new User("Imad", 5000);
        User Ilyass = new User("Ilyass", 2500);
        User Brahim = new User("Brahim", 5100);
        User chichmana = new User("Chichmana", 1999999);
        try{
            UsersArrayList usersArrayList = new UsersArrayList();
            usersArrayList.add(Mike);
            usersArrayList.add(John);
            usersArrayList.add(Imad);
            usersArrayList.add(Ilyass);
            usersArrayList.add(Brahim);
            usersArrayList.add(chichmana);
            User Nizar = new User("Nizar", 420);
            usersArrayList.add(Nizar);
            System.out.println(usersArrayList.getById(6).getName());
//            System.out.println(usersArrayList.getById(7).getName());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}