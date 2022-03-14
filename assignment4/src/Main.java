import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Here we declare the files we need
        File donorsFile = new File("donors.txt");
        File recipientFile = new File("recipient.txt");

        // BELOW WE CREATE AN ARRAYLIST OF STRINGS WHICH CONTAIN NAMES OF PEOPLE AND THEIR BLOOD GROUP
        ArrayList<String[]> donors = new ArrayList<String[]>();
        ArrayList<String[]> recipients = new ArrayList<String[]>();

        //Array of valid blood groups to detect invalid blood groups
        String[] validBloodGroups = {"O-","O+","A-","A+","B-","B+","AB-","AB+"};

        // WE NEED A TRY CATCH EXCEPTION HANDLER TO USE A SCANNER TO READ A FILE
        try {
            //BELOW WE USE SCANNER TO READ OUR FILES
            Scanner scan = new Scanner(donorsFile);
            //BELOW WE USE A WHILE LOOP TO GO FROM ONE LINE TO THE NEXT UNTIL THERE ARE NO MORE LINERS
            while (scan.hasNextLine()) {
                //IF THERE IS A NEXT LINE, THE CODE BELOW GOES TO THE NEXT LINE AND SPLITS INTO TWO THINGS, the first half before the semicolon adn the second half after the semicolon, it stores these two in a sting array
                // as index 0 and 1.
                String[] donorArray = scan.nextLine().split(";");
                //For loop to detect invalid blood groups
                boolean valid = false;
                for (int i = 0; i < validBloodGroups.length; i++) {
                    if (donorArray[1].equals(validBloodGroups[i])) {
                        valid = true;
                    }
                }
                if (valid) {
                    //we add our string array to the array list
                    donors.add(donorArray);
                } else {
                    System.out.println("Invalid blood group");
                    System.out.println("This entry had a problem " + donorArray[0] + donorArray[1]);
                }
            }
        }
        catch(Exception e){
                e.printStackTrace();
            }

        try{
            Scanner sc = new Scanner(recipientFile);
            while(sc.hasNextLine()) {
                String[] recipientArray = sc.nextLine().split(";");
                boolean valid = false;
                for (int i = 0; i < validBloodGroups.length; i++) {
                    if (recipientArray[1].equals(validBloodGroups[i])) {
                        valid = true;
                    }
                }
                if (valid) {
                    //we add our string array to the array list
                    recipients.add(recipientArray);
                } else {
                    System.out.println("Invalid blood group");
                    System.out.println("This entry had a problem " + recipientArray[0] + recipientArray[1]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // we print out the items in our arraylist
        for (int i = 0; i < donors.size(); i++) {
                System.out.println(donors.get(i)[0] + donors.get(i)[1]);
            }
            System.out.println();
        for (int i = 0; i < recipients.size(); i++) {
                System.out.println(recipients.get(i)[0] + recipients.get(i)[1]);
            }
            System.out.println();

        // We use a hashmap to match each blood groups with other blood groups they can receive donations from
        HashMap<String, String[]> matches = new HashMap<String, String[]>();
        matches.put("O-", new String[]{"O-"});
        matches.put("O+", new String[]{"O-","O+"});
        matches.put("A-", new String[]{"O-", "A-"});
        matches.put("A+", new String[]{"O-","O+","A-","A+"});
        matches.put("B-", new String[]{"O-","B-"});
        matches.put("B+", new String[]{"O-","O+","B-","B+"});
        matches.put("AB-", new String[]{"O-","A-","B-","AB-"});
        matches.put("AB+", new String[]{"O-","O+","A-","A+","B-","B+","AB-","AB+"});

        // this hashmap stores the name of the donors and recipients that are a match
        HashMap<String, String> donorsAndRecipients = new HashMap<String, String>();

        //we go through each string in the recipients arrayalist
        for (String[] recipientBgAndName : recipients) {
            //we take the second index of each string and put it into our hashmap as the key to get a list of possible donors
            String[] possibleDonors = matches.get(recipientBgAndName[1]);

            // from our array of possible donorrs we check if each string is eqyal to one of our actual donors if yes put it into our hashmap which contains the names of donors and recipients that a match
            for(String canDonate : possibleDonors) {
                // we use iterator because for loop would not allow us to remove in the middle of the loop
                Iterator iterate = donors.iterator();
                // this while loop runs till there is are no more next strings
                while(iterate.hasNext())
                {
                    String[] donor = (String[])iterate.next();
                    if(canDonate.equals(donor[1])) {
                        donorsAndRecipients.put(donor[0], recipientBgAndName[0]);
                        //we remove the donor array from the arraylist because you can not donate more than once
                        iterate.remove();
                    }

                }
            }
        }

        // we print out our hashmap of names of donors and recipients
        for (HashMap.Entry<String, String> set : donorsAndRecipients.entrySet()){
            System.out.println(set.getKey() + " = " + set.getValue());
        }


        }
    }

