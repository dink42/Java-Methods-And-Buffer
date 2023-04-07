import java.io.*;
import java.util.Scanner;


class UppgiftTolvEtt {
    public static void main(String[] args) throws IOException {
        //BufferedReader read = new BufferedReader(new FileReader(new File("Elever.txt")));
        String fileName = "Elever.txt";
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        //Takes in a file
        int col = 0;
        String[] Allnames = new String[5];
        int[][] resultat = new int[5][5];
        //Multidimensional array to compare the result with names
        int prov[] = new int[5];

        while (true) {
			String input = read.readLine();

			if (input == null)
                break;
            
            int total = 0;
            int average;

            Scanner inp = new Scanner(input);
            String names = inp.next();
            Allnames[col] = names;

            int x = input.indexOf(" ");
            String allaTal = input.substring(x);

            Scanner sc = new Scanner(allaTal);

            for(int i = 0; i<5;i++){
                resultat[col][i] = sc.nextInt();
                total = total + resultat[col][i];
            }
            average = total / 5;
            //Get the average result from students
            System.out.println(Allnames[col] + "s resultat:");
            System.out.println("Summa totalt:" +total);
            System.out.println("Genomsnitt:" + average);

            col++;

            sc.close();
            inp.close();    
        }

        for(int j = 0; j < 5; j++){
            for(int i = 0; i < Allnames.length; i++){
                prov[j] = prov[j] + resultat[i][j];
            }
        }
        //Result of all points avarage
        System.out.println("Klassgenomsnitt:");
        for(int j = 0; j < 5; j++){
            int genomsnitt = prov[j] / 5;
            System.out.println("Genomsnitt för prov "+ (j+1) + " är: " +genomsnitt);
        }
        read.close();
    }
}