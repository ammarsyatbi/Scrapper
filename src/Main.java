import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {


        Scanner scanner = new Scanner(new File("A:\\Codes\\Mars Java\\Scrapper\\jadual.csv"));
        scanner.useDelimiter(",|\\n");

        ArrayList<String> studentGroup = new ArrayList<>();
        ArrayList<String> lecturer = new ArrayList<>();
        ArrayList<String> day = new ArrayList<>();
        ArrayList<String> subjectList = new ArrayList<>();
        ArrayList<Subject> subclassList = new ArrayList<>();
        ArrayList<String> tracker = new ArrayList<>();
        ArrayList room = new ArrayList();

        PrintWriter pw = new PrintWriter(new File("groupSelected.csv"));
        PrintWriter lc = new PrintWriter(new File("lecturerSelected.csv"));
        PrintWriter sj = new PrintWriter(new File("subjectSelected.csv"));
        StringBuilder sb = new StringBuilder();

        String fac, hari, mula, tamat, subCode, subName, groupCode, bilik, lectName, lectNum, subType;

        Subject sub;

        while (scanner.hasNext()) {

            fac = scanner.next();
            hari = scanner.next();
            mula = scanner.next();
            tamat = scanner.next();
            subCode = scanner.next();
            subName = scanner.next();
            groupCode = scanner.next();
            bilik = scanner.next();
            lectName = scanner.next();
            lectNum = scanner.next();
            subType = scanner.next();


            if (!lecturer.contains(lectName)) {
                lecturer.add(lectName);
                //tracker.add(String.valueOf(x));
            }
            if (!studentGroup.contains(groupCode)) {
                studentGroup.add(groupCode);
                //tracker.add(String.valueOf(x));
            }
            if (!day.contains(hari)) {
                day.add(hari);
                //tracker.add(String.valueOf(x));
            }
            if (!subjectList.contains(subCode)) {
                subjectList.add(subCode);
                sub = new Subject();
                sub.setCode(subCode);
                sub.setName(subName);
                subclassList.add(sub);

                //tracker.add(String.valueOf(x));
            }
            //System.out.println(temp);
        }
        scanner.close();

        for (int i = 0; i < studentGroup.size(); i++) {
            // System.out.println("test");
           // System.out.println(studentGroup.get(i) + " - ");
        }

        for (int i = 0; i < day.size(); i++) {
            // System.out.println("test");
            //System.out.println(day.get(i) + " - ");
        }

        for (int i = 0; i < lecturer.size(); i++) {
            // System.out.println("test");
            //System.out.println(lecturer.get(i) + "  ");
            sb.append(lecturer.get(i));
            sb.append('\n');
        }
        lc.print(sb);
        lc.close();
        sb.setLength(0);



        System.out.println("first group size :  " + studentGroup.size());
        System.out.println(day.size());
        System.out.println(lecturer.size());


        scanner = new Scanner(new File("A:\\Codes\\Mars Java\\Scrapper\\jadual2.csv"));
        scanner.useDelimiter(",|\\n");

        String progCode2, progName2, subCode2, subName2, groupName2, groupSize;

        ArrayList<String> groupName = new ArrayList<>();
        int t = 0;

        while (scanner.hasNext()) {

            progCode2 = scanner.next();
            progName2 = scanner.next();
            subCode2 = scanner.next();
            subName2 = scanner.next();
            groupName2 = scanner.next();
            groupSize = scanner.next();

            if (!groupName.contains(groupName2)) {

                //System.out.println(groupName2);

                groupName.add(groupName2);

            }

        }
        scanner.close();

        sb.append("student group");
        sb.append('\n');

        System.out.println("second group size : " + groupName.size());
        int groupCount =0;
        for(int i =0; i < studentGroup.size(); i++){
            for(int x =0; x <groupName.size(); x++)
            {
                if(studentGroup.get(i).equalsIgnoreCase(groupName.get(x))){
                    //System.out.println(studentGroup.get(i) + " " + groupName.get(x));
                    groupCount++;

                sb.append('\n');
                sb.append(studentGroup.get(i));

                }
            }
        }

        System.out.println(groupCount);
        pw.print(sb.toString());
        pw.close();
        sb.setLength(0);

    //------------------------------------------------------------------------------------------


        scanner = new Scanner(new File("A:\\Codes\\Mars Java\\Scrapper\\jadual.csv"));
        scanner.useDelimiter(",|\\n");

        int q = 0;

        while(scanner.hasNext())
        {

            fac = scanner.next();
            hari = scanner.next();
            mula = scanner.next();
            tamat = scanner.next();
            subCode = scanner.next();
            subName = scanner.next();
            groupCode = scanner.next();
            bilik = scanner.next();
            lectName = scanner.next();
            lectNum = scanner.next();
            subType = scanner.next().trim();

            for(int i =0; i <subclassList.size(); i++)
            {
                sub = (Subject) subclassList.get(i);

                if(sub.getCode().equalsIgnoreCase(subCode))
                {
                    System.out.println(" --------------------------------------------------- " + subType);
                    if(subType.equalsIgnoreCase("M"))
                    {

                        if(sub.getM() == 0)
                        {
                            int start = Integer.parseInt(mula);
                            int finish = Integer.parseInt(tamat);
                            if(start> finish){finish +=12;}
                            int hourTeach =  finish - start;
                            sub.setM(hourTeach);
                        }
                    }
                    else if(subType.equalsIgnoreCase("T"))
                    {
                        if(sub.getT() == 0)
                        {
                            int start = Integer.parseInt(mula);
                            int finish = Integer.parseInt(tamat);
                            if(start> finish){finish +=12;}
                            int hourTeach =  finish - start;
                            sub.setT(hourTeach);
                        }
                    }
                    else if(subType.equalsIgnoreCase("S"))
                    {
                        if(sub.getS() == 0)
                        {
                            int start = Integer.parseInt(mula);
                            int finish = Integer.parseInt(tamat);
                            if(start> finish){finish +=12;}
                            int hourTeach =  finish - start;
                            sub.setS(hourTeach);
                        }
                    }
                    subclassList.set(i,sub);
                }

            }
            q++;
        }


        for (int i = 0; i < subclassList.size(); i++)
        {
            // System.out.println("test");

            sub = (Subject) subclassList.get(i);

            System.out.println(sub.getCode() + "  " + sub.getName() + " " + sub.getM() + " " + sub.getT() + " " + sub.getS());
            sb.append(sub.getCode()+ " ,");
            sb.append(sub.getName()+ " ,");
            sb.append(sub.getM()+ " ,");
            sb.append(sub.getT()+ " ,");
            sb.append(sub.getS()+ " ,");
            sb.append('\n');
        }
        sj.print(sb);
        sj.close();
        sb.setLength(0);

        System.out.println("subject list size : " + subclassList.size());
    }
}
