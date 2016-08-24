
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Recognizer {
    String phonemeCompacted = "";
    
    public Recognizer(File f) throws IOException {
        Configuration configuration = new Configuration();
        
        configuration.setAcousticModelPath("/home/sanjay/NetBeansProjects/SoundRecorder/Hindi/model_parameters/hindi.cd_cont_200/");
        configuration.setDictionaryPath("/home/sanjay/NetBeansProjects/SoundRecorder/Hindi/etc/hindi.dic");
        configuration.setLanguageModelPath("/home/sanjay/NetBeansProjects/SoundRecorder/hindi.lm");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);

        InputStream stream = stream = new FileInputStream(f);
        
        recognizer.startRecognition(stream);
        
        SpeechResult result;
        
    
        while ((result = recognizer.getResult()) != null) {
            phonemeCompacted = phonemeCompacted + " " + result.getHypothesis();
        }
        recognizer.stopRecognition();
    }
}
