import java.util.*;

class App {
	static String userInput="";
	static Scanner s = new Scanner(System.in);
	static HashMap<String, Location> locs = new HashMap<>();
    static String[][] validInputs = {
                                    {"left", "right"}, //0. Start inputs
                                    {"follow", "no follow"}, //1. from left
                                    {"turn back", "go through"}, //2. from right
                                    {"accept", "deny"}, //3. from follow
                                    {"wake up", "sleep"}, //4. from accept, no follow
                                  };
  static String currentLocation = "wake up";

	public static void main(String[] args){
		
    //sets up the inputs that the user can do + descriptions for each "room"
	locs.put("sleep", new Location("Your eyes feel heavy, but you can feel the warmth of the sun.", validInputs[4]));
    locs.put("wake up", new Location("You wake up to the sun in your eyes. In front of you there is a left path and a right path.", validInputs[0]));

    locs.put("left", new Location("You hear a creature scuttle across the floor.", validInputs[1]));
        locs.put("follow", new Location("After following the creature for a bit, he notices. He decides to invite you to his hut.", validInputs[3]));
            locs.put("accept", new Location("His hut is nice and warm. The warmt tires you, and you fall asleep", validInputs[4]));

        locs.put("no follow", new Location("Without anything to do, you wander the forest. Eventually you feel tired and fall asleep when night falls", validInputs[4]));

    locs.put("right", new Location("You see an open field, with what seems to be landmines.", validInputs[2]));
        locs.put("turn back", new Location("Without anything to do, you wander the forest. Eventually you feel tired and fall asleep when night falls", validInputs[4]));

        locs.put("go through", new Location("", true));
    
    /*
    check to see whether or not the input is valid, if it's invalid then it says you can't
    
    once the while loop is done, print out "muerte"
    */
    while (!locs.get(currentLocation).isEnd){
      System.out.print(locs.get(currentLocation));
      userInput=s.nextLine();

      if (locs.get(currentLocation).checkInput(userInput)) {
        currentLocation = userInput;
      } else {
        System.out.println("can't go there, type in a valid input");
        //gotta have this do the gamer maneuver and call itself again so that user can try to reinput the thing
      }
    }
    System.out.println("After carefully manuevering through the field, you make it to your house.");
    }

    
}



// ere e ere e ere https://www.w3schools.com/java/java_hashmap.asp