import java.util.*;

public class HospitalExpertSystem {
    
    static Scanner sc = new Scanner(System.in);
    public static boolean askYesNoQuestion(String question) {
        System.out.print(question + " (y/n): ");
        char response = sc.next().charAt(0);
        return (response == 'y' || response == 'Y');
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Expert System!");
        System.out.println("Please answer the following questions to determine your diagnosis.");

        boolean fever = askYesNoQuestion("Do you have a fever?");
        boolean cough = askYesNoQuestion("Do you have a cough?");
        boolean soreThroat = askYesNoQuestion("Do you have a sore throat?");
        boolean runnyNose = askYesNoQuestion("Do you have a runny nose?");
        boolean headache = askYesNoQuestion("Do you have a headache?");
        boolean bodyAches = askYesNoQuestion("Do you have body aches?");
        boolean fatigue = askYesNoQuestion("Do you feel fatigue or weakness?");
        boolean shortnessOfBreath = askYesNoQuestion("Do you experience shortness of breath?");
        boolean chestPain = askYesNoQuestion("Do you have chest pain?");
        boolean vomiting = askYesNoQuestion("Are you experiencing vomiting or nausea?");
        boolean diarrhea = askYesNoQuestion("Do you have diarrhea?");
        boolean lossOfTasteOrSmell = askYesNoQuestion("Have you experienced loss of taste or smell?");

        // Diagnose based on symptoms
        if (fever && cough && soreThroat && runnyNose && headache && bodyAches && fatigue && shortnessOfBreath) {
            System.out.println("You may have COVID-19. Please get tested and self-isolate.");
        } else if (fever && cough && soreThroat && runnyNose && headache) {
            System.out.println("You may have a common cold. Rest and stay hydrated.");
        } else if (fever && cough && soreThroat && bodyAches && fatigue) {
            System.out.println("You may have the flu. Rest, stay hydrated, and consider antiviral medication.");
        } else if (fever && headache && vomiting && diarrhea) {
            System.out.println("You may have food poisoning. Drink plenty of fluids and rest.");
        } else if (chestPain && shortnessOfBreath) {
            System.out.println("You may be experiencing a heart attack. Seek emergency medical attention immediately.");
        } else if (fever && cough && shortnessOfBreath) {
            System.out.println("You may have pneumonia. Seek medical attention promptly.");
        } else if (headache && vomiting && lossOfTasteOrSmell) {
            System.out.println("You may have a sinus infection. Consult a doctor for treatment.");
        } else {
            System.out.println("Your symptoms are not specific enough for a diagnosis. Please consult a doctor.");
        }
    }
}
