import java.io.Serializable;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Membership implements Serializable {
    private String name;
    private String gender;
    private String password;
    private int age;
    private int fit_choice;
    private static String fit_int[] = {"Powerlifting", "CrossFit", "Orange Theory", "Calisthenics", "Traditional Weighlifting"};
    private static double membership_price[] = {150, 80, 30};
    private static String gyms[] = {"Miami Iron Gym", "Paradise Gym", "Crunch"};
    private double monthly_price;
    private String gym;

    public void passwordCreator(String pass){
        this.password = pass;
    }
    public void Setter(String name_arg, String gender_arg, int age_arg, int fit_choice_arg, int gym_choice_arg, int mem_type_arg){
        name = name_arg;
        gender = gender_arg;
        age = age_arg; 
        fit_choice = fit_choice_arg - 1;
        monthly_price = membership_price[mem_type_arg - 1] / mem_type_arg;
        gym = gyms[gym_choice_arg-1];
    }
    public void DisplayAccount(){
        System.out.println("\nAccount Information");
        System.out.println("\nName: " + this.name + "\nAge: " + this.age + "\nGender: " + this.gender);
        System.out.println("Fitness Style: " + fit_int[fit_choice]);
        System.out.println("Gym: " + this.gym + "\nMonthly Price: $ " + this.monthly_price + "\n");
    }
    public void DisplayPerks(int choice){
        if(choice < 4){
            System.out.println("\n* GLOBAL ACCESS");
        }
        if(choice < 3){
            System.out.println("* VIP GUEST ACCESS");
            System.out.println("* ACCESS TO ALL CLASSESS");
        }
        if(choice < 2){
            System.out.println("* DISCOUNTED PERSONAL TRAINING");
            System.out.println("* 20% OFF ON RETAIL AND SUPPS");
        }
        System.out.println("\n");
    }
    public String getName(){return this.name;}
    @Override
    public String toString() {
        return "\nName: " + name + "\nAge: " + age + "\nGender: " + gender + "\nFitness Style: " + fit_int[fit_choice] + "\nGym: " + gym + "\nMonthly Price: " + monthly_price;
    }
  public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Membership newClient = new Membership();
        String name, gender;
        int age, fit_choice, gym_choice;
        int double_check;

        System.out.println("\nWelcome to your Gym Membership Sign Up");
        System.out.println("\nLet's Create Your Profile!!");
        do{
            System.out.println("\nEnter your name: ");
            name = input.nextLine();

            System.out.println("\nEnter your gender: ");
            gender = input.nextLine();
            do{
                System.out.println("\nEnter your age: ");
                age = input.nextInt();
                input.nextLine();
                if(age < 12)
                    System.out.println("\nYOU MUST BE AT LEAST 12 YEARS OLD TO GET A MEMBERSHIP");
            }while(age < 12);

            do{
                System.out.println("\nWhat kind of trainining are you interested on: \n");
                System.out.println("1. Powerlifting\n2. CrossFit\n3. Orange Theory");
                System.out.println("4. Calisthenics \n5. Traditional Weighlifting");
                System.out.println("\nChoice: ");
                fit_choice = input.nextInt(); 
                if(fit_choice > 5 || fit_choice < 1)
                    System.out.println("\nPlease enter a valid choice\n");
            }while(fit_choice > 5 || fit_choice < 1);
        
            do{
                System.out.println("\nHERE ARE SOME GYMS THAT MIGHT BE THE RIGHT FIT FOR YOU\n");
                System.out.println("1. Miami Iron Gym\n2. Paradise Gym\n3. Crunch\n");
                System.out.println("Choice: \n");
                gym_choice = input.nextInt();
                if(gym_choice > 3 || gym_choice < 1)
                    System.out.println("\nPlease enter a valid choice\n");
            }while(gym_choice > 3 || gym_choice < 1);
            int membership_type = 0;
            switch(gym_choice){
                case 1:
                    System.out.println("\n* * * Miami Iron Gym * * * \n");

                    do{
                        System.out.println("MEMBERSHIP LEVELS\n");
                        System.out.println("1. MONSTER\n2. BEAST\n3. SAVAGE\n");
                        System.out.println("ENTER A MEMBERSHIP TO DISPLAY ITS PERKS:");
                        membership_type = input.nextInt();
                        if(membership_type > 3 || membership_type < 1)
                            System.out.println("\nPlease enter a valid choice\n");
                    }while(membership_type> 3 || membership_type < 1);
                    newClient.DisplayPerks(membership_type);
                    break;

                case 2:
                    System.out.println("\n* * * PARADISE GYM * * * \n");
                
                    do{
                        System.out.println("MEMBERSHIP LEVELS\n");
                        System.out.println("1. ZEUS\n2. HADES\n3. HERCULES\n");
                        System.out.println("ENTER A MEMBERSHIP TO DISPLAY ITS PERKS:");
                        membership_type = input.nextInt();
                        if(membership_type > 3 || membership_type < 1)
                            System.out.println("\nPlease enter a valid choice\n");
                    }while(membership_type > 3 || membership_type < 1);
                    newClient.DisplayPerks(membership_type);
                    break;
                
                case 3:
                    System.out.println("\n* * * Crunch * * * \n");

                    do{
                        System.out.println("MEMBERSHIP LEVELS\n");
                        System.out.println("1. PREMIUM\n2. ADVANCED\n3. ACTIVE\n");
                        System.out.println("ENTER A MEMBERSHIP TO DISPLAY ITS PERKS:");
                        membership_type = input.nextInt();
                        if(membership_type > 3 || membership_type< 1)
                            System.out.println("\nPlease enter a valid choice\n");
                    }while(membership_type > 3 || membership_type < 1);
                    newClient.DisplayPerks(membership_type);
                    break;
            }
            newClient.Setter(name, gender, age, fit_choice, gym_choice, membership_type);
            newClient.DisplayAccount();
            do{
                System.out.println("\nSAVE ACCOUNT OR MAKE CHANGES\n\n1. SAVE\n2. MAKE CHANGES");
                System.out.println("\nCHOICE: ");
                double_check = input.nextInt();
                input.nextLine();
                if(double_check > 2 || double_check < 1)
                    System.out.println("ENTER A VALID OPTION");
                    if(double_check == 2)
                        System.out.println("\nLET'S ENTER THE INFORMATION ONE MORE TIME");

            }while(double_check > 2 || double_check < 1);

        }while(double_check == 2);
        String password;

        System.out.println("\nCREATE A PASSWORD FOR YOUR ACCOUNT: ");
        password = input.nextLine();
        newClient.passwordCreator(password);
        input.close();
         String filePath = newClient.getName() + "Account.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(newClient.toString());
            writer.close();

            System.out.println("Object written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }
}


  