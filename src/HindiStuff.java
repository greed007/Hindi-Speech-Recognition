
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import javafx.util.Pair;

public class HindiStuff {

    Vector dict = new Vector();
    Map<String, String> conversion = new HashMap<String, String>();

    void initdict() throws FileNotFoundException, IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Hindi/etc/hindi.dic"));
            String line;
            while ((line = br.readLine()) != null) {
                int tab = line.indexOf('\t');
                if (tab == -1) {
                    tab = line.indexOf(' ');
                }
                String wordindic = line.substring(0, tab);
                dict.add(wordindic);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Here it is: " + e);
        }

    }

    void initConversion() throws FileNotFoundException, IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("phonemeCompactToHindi.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                //       System.out.println(line);
                int tab = line.indexOf('\t');
                if (tab == -1) {
                    tab = line.indexOf(' ');
                }
                //     System.out.println("Tab: " + tab);
                String phonemeCompact = line.substring(0, tab);
                String hindi = line.substring(tab + 1);
                conversion.put(phonemeCompact, hindi);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Haha " + e);
        }
    }

    private Pair<String, String> getIt(String hindiWord) {
        int len = hindiWord.length();
        String tmp_phone = "";
        for (int i = 0; i < len; i++) {
            char e = hindiWord.charAt(i);
            if (e == 'अ') {
                tmp_phone = tmp_phone + ' ' + "A";
            } else if ((e == 'आ') || (e == 'ा')) {
                tmp_phone = tmp_phone + ' ' + "AA";
            } else if ((e == 'इ') || (e == 'ि')) {
                tmp_phone = tmp_phone + ' ' + "I";
            } else if ((e == 'ई') || (e == 'ी')) {
                tmp_phone = tmp_phone + ' ' + "II";
            } else if ((e == 'उ') || (e == 'ु')) {
                tmp_phone = tmp_phone + ' ' + "U";
            } else if ((e == 'ऊ') || (e == 'ू')) {
                tmp_phone = tmp_phone + ' ' + "UU";
            } else if ((e == 'ए') || (e == 'े')) {
                tmp_phone = tmp_phone + ' ' + "E";
            } else if ((e == 'ऐ') || (e == 'ै')) {
                tmp_phone = tmp_phone + ' ' + "EE";
            } else if ((e == 'ओ') || (e == 'ो')) {
                tmp_phone = tmp_phone + ' ' + "O";
            } else if ((e == 'औ') || (e == 'ौ')) {
                tmp_phone = tmp_phone + ' ' + "OO";
            } else if ((e == 'ं') || (e == 'ँ')) {
                tmp_phone = tmp_phone + ' ' + "MN";
            } else if (e == 'क') {
                tmp_phone = tmp_phone + ' ' + "K";
            } else if (e == 'ख') {
                tmp_phone = tmp_phone + ' ' + "KH";
            } else if (e == 'ग') {
                tmp_phone = tmp_phone + ' ' + "G";
            } else if (e == 'घ') {
                tmp_phone = tmp_phone + ' ' + "GH";
            } else if (e == 'ङ') {
                tmp_phone = tmp_phone + ' ' + "WN";
            } else if (e == 'च') {
                tmp_phone = tmp_phone + ' ' + "CH";
            } else if (e == 'छ') {
                tmp_phone = tmp_phone + ' ' + "CHH";
            } else if (e == 'ज') {
                tmp_phone = tmp_phone + ' ' + "J";
            } else if (e == 'झ') {
                tmp_phone = tmp_phone + ' ' + "JH";
            } else if (e == 'ञ') {
                tmp_phone = tmp_phone + ' ' + "ZN";
            } else if (e == 'ट') {
                tmp_phone = tmp_phone + ' ' + "TT";
            } else if (e == 'ठ') {
                tmp_phone = tmp_phone + ' ' + "TTH";
            } else if (e == 'ड') {
                tmp_phone = tmp_phone + ' ' + "DD";
            } else if (e == 'ढ') {
                tmp_phone = tmp_phone + ' ' + "DDH";
            } else if (e == 'ण') {
                tmp_phone = tmp_phone + ' ' + "AN";
            } else if (e == 'त') {
                tmp_phone = tmp_phone + ' ' + "T";
            } else if (e == 'थ') {
                tmp_phone = tmp_phone + ' ' + "TH";
            } else if (e == 'द') {
                tmp_phone = tmp_phone + ' ' + "D";
            } else if (e == 'ध') {
                tmp_phone = tmp_phone + ' ' + "DH";
            } else if (e == 'न') {
                tmp_phone = tmp_phone + ' ' + "N";
            } else if (e == 'प') {
                tmp_phone = tmp_phone + ' ' + "P";
            } else if (e == 'फ') {
                tmp_phone = tmp_phone + ' ' + "PH";
            } else if (e == 'ब') {
                tmp_phone = tmp_phone + ' ' + "B";
            } else if (e == 'भ') {
                tmp_phone = tmp_phone + ' ' + "BH";
            } else if (e == 'म') {
                tmp_phone = tmp_phone + ' ' + "M";
            } else if (e == 'य') {
                tmp_phone = tmp_phone + ' ' + "Y";
            } else if (e == 'र') {
                tmp_phone = tmp_phone + ' ' + "R";
            } else if (e == 'ल') {
                tmp_phone = tmp_phone + ' ' + "L";
            } else if (e == 'व') {
                tmp_phone = tmp_phone + ' ' + "V";
            } else if (e == 'श') {
                tmp_phone = tmp_phone + ' ' + "SH";
            } else if (e == 'ष') {
                tmp_phone = tmp_phone + ' ' + "SHH";
            } else if (e == 'स') {
                tmp_phone = tmp_phone + ' ' + "S";
            } else if (e == 'ह') {
                tmp_phone = tmp_phone + ' ' + "H";
            }
        }
        String compacted = tmp_phone;
        while (compacted.contains(" ")) {
            compacted = compacted.replace(" ", "");
        }
        return (new Pair(compacted, tmp_phone));
    }

    void manageTextForTraining(String line, int number) throws IOException {
        System.out.println("Got Line: " + line);
        StringTokenizer st = new StringTokenizer(line, " \t\r\n");
        String sentence = "<s>";

        BufferedWriter bw1 = new BufferedWriter(new FileWriter("Hindi/etc/hindi.dic", true));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("phonemeCompactToHindi.txt", true));

        while (st.hasMoreTokens()) {
            String tmp_phone, phonemeCompacted, hindiWord = st.nextToken();
            Pair<String, String> p = getIt(hindiWord);
            phonemeCompacted = p.getKey();
            tmp_phone = p.getValue();
            sentence = sentence + " " + phonemeCompacted;

            if (!dict.contains(phonemeCompacted)) {
                dict.add(phonemeCompacted);
                conversion.put(phonemeCompacted, hindiWord);

                bw1.write(phonemeCompacted + "\t" + tmp_phone.substring(1) + "\r\n");
                bw2.write(phonemeCompacted + "\t" + hindiWord + "\r\n");
            }
        }
        bw1.close();
        bw2.close();

        BufferedWriter bw3 = new BufferedWriter(new FileWriter("Hindi/etc/hindi_train.transcription", true));
        BufferedWriter bw4 = new BufferedWriter(new FileWriter("hindi.txt", true));

        sentence = sentence + " </s>";
        System.out.println("Made sentence: " + sentence);

        bw3.write(sentence + " (file" + number + ")\r\n");
        bw4.write(sentence + "\r\n");

        bw3.close();
        bw4.close();

        BufferedWriter bw5 = new BufferedWriter(new FileWriter("Hindi/etc/hindi_train.fileids", true));
        bw5.write("FilestoTrain/file" + number + "\r\n");
        bw5.close();
    }

    String manageForRecording(int number) throws IOException {
        File f = new File("/home/sanjay/NetBeansProjects/SoundRecorder/Hindi/Audio_files/testHere/test" + number +".wav");
        Recognizer obj = new Recognizer(f);
        String compacted = obj.phonemeCompacted;
        String hindi = "";

        StringTokenizer st = new StringTokenizer(compacted, " \t\r\n");
        while (st.hasMoreTokens()) {
            hindi = hindi + " " + conversion.get(st.nextToken());
        }
        /*
        if (hindi.length() != 0) {
            BufferedWriter bw3 = new BufferedWriter(new FileWriter("hindi/etc/hindi_test.transcription", true));
            bw3.write(compacted.substring(1) + " (file" + number + ")\r\n");
            bw3.close();

            BufferedWriter bw5 = new BufferedWriter(new FileWriter("hindi/etc/hindi_test.fileids", true));
            bw5.write("toTest/file" + number + "\r\n");
            bw5.close();
        }*/
        return hindi;
    }

    String testRecording(File f) throws IOException {
        Recognizer obj = new Recognizer(f);
        String compacted = obj.phonemeCompacted;
        String hindi = "";

        StringTokenizer st = new StringTokenizer(compacted, " \t\r\n");
        while (st.hasMoreTokens()) {
            hindi = hindi + " " + conversion.get(st.nextToken());
        }
        return hindi;
    }
}
